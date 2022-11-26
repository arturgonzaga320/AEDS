import java.util.Scanner;

public class Programa {

    // main
    public static void main (String args[]){

        // Template de cardapio
        Produto preset[] = new Produto[5];
        for (int i = 0; i < 5; i ++) preset[i] = new Produto();

        preset[0].setNome("Água");
        preset[0].setValor(2.00);
        
        preset[1].setNome("Empada de Frango");
        preset[1].setValor(4.50);

        preset[2].setNome("Kibe");
        preset[2].setValor(3.50);

        preset[3].setNome("Refresco");
        preset[3].setValor(0.80);

        preset[4].setNome("Picolé");
        preset[4].setValor(7.00);

        Scanner scan = new Scanner (System.in);
        Restaurante Buchinho_Cheio = new Restaurante ("Buchi", "Av.AntonioCarlos - 265", 8);
        Buchinho_Cheio.setCardapio(preset);
        int opcao;

        System.out.println("\n\nRESTAURANTE BUCHINHO CHEIO");

        do {
            System.out.println("\nServiços:\u001B[31m");
            System.out.println("0 - Encerrar programa\u001B[37m");
            System.out.println("1 - Reservar mesa");
            System.out.println("2 - Realizar pedido");
            System.out.println("3 - Pagar comanda");
            System.out.println("4 - Ver reservas");

            System.out.print("> ");
            opcao = scan.nextInt();
            System.out.println();

            switch(opcao){

                case 1: 
                {
                    // Reservar mesa
                    opcao1(scan, Buchinho_Cheio);
                    break;
                }
                case 2:
                {
                    // Realizar pedido
                    opcao2(scan, Buchinho_Cheio);
                    break;
                }
                case 3:
                {
                    // Pagar comanda
                    opcao3(scan, Buchinho_Cheio);
                    break;
                }
                case 4:
                {
                    // Ver reservas
                    opcao4(scan, Buchinho_Cheio);
                    break;
                }
            }
        } while (opcao != 0);
        scan.close();
    }

    private static Data ler_data(Scanner scan) {


        System.out.print("> Mes: ");
        int mes = scan.nextInt();

        System.out.print("> Dia: ");
        int dia = scan.nextInt();

        Data data_p = new Data (dia, mes, 2023);
        data_p.validar_Data();

        return data_p;

    }

    private static int maior_string(Produto[] aux) {

        int tam_ref = 0;
        
        for (int i = 0; i < aux.length; i++) {

            if (aux[i].getNome().length() > tam_ref)
                tam_ref = aux[i].getNome().length();
        }

        return tam_ref;
    }

    public static void opcao1(Scanner scanner, Restaurante buchi){

        System.out.println(">> Agendamento da reserva: DATA <<");
        Data data_ref = ler_data(scanner);

        System.out.println("\nMesas disponíveis no dia " + data_ref.getData()+ ":\n" );
        
        for (int i = 0; i < buchi.getMesas().length; i++){

            if (buchi.getMesas()[i].getReserva() == false) {

                System.out.println("> Mesa " + ( buchi.getMesas()[i].getNumeroMesa() + 1 ));
            }
            else {

                Data[] aux = buchi.getMesas()[i].getData();
                for ( int j = 0; j < aux.length; j++){

                    if (aux[j].comparar_Data(data_ref) == false) {

                        System.out.println("> Mesa " + ( buchi.getMesas()[i].getNumeroMesa() + 1 ));
                    }
                }
            }
        }

        System.out.print("\nMesa que deseja reservar: ");
        int op_1 = scanner.nextInt();

        System.out.print("Quantidade pessoas a serem cadastradas: ");
        int op_2 = scanner.nextInt();

        buchi.getMesas()[op_1 - 1].reservar(op_2, data_ref,scanner);
    }

    public static void opcao2(Scanner scan, Restaurante buchi){
    
        System.out.println(">> Realizar pedido: DATA <<");
        Data data_ref = ler_data(scan);
        Mesa[] aux = buchi.listar_Agendamentos(data_ref);

        System.out.println("\nMesas com reservas para " + data_ref.getData());
        for (int i = 0; i < aux.length; i++)
            System.out.println("> Mesa " + ( aux[i].getNumeroMesa() + 1 ));

        System.out.print("\nMesa que realizará o pedido: ");
        int entrada = scan.nextInt();
        entrada -= 1;

        // buchi.getMesas()[entrada].liberar_Reserva(data_ref);

        // Listar cardarpio
        System.out.println("\nCardapio do dia:");
        int n_spaces = maior_string(buchi.getCardapio());

        for (int i = 0; i < buchi.getCardapio().length; i++) {

            System.out.print ( i + 1+ "-" + buchi.getCardapio()[i].getNome());

            for (int j = 0; j < n_spaces - buchi.getCardapio()[i].getNome().length(); j++)
                System.out.print (" ");

            System.out.print ("\t................. R$ ");
            System.out.println (buchi.getCardapio()[i].getValor());
        }

        System.out.print("\u001B[33m");
        System.out.println ("\n* Digite '0' para sair\u001B[37m\n");

        int n_pedido;
        int n_reserva = 0;

        for (int i = 0; i < buchi.getMesas()[entrada].getData().length; i ++){

            if (buchi.getMesas()[entrada].getData()[i].comparar_Data(data_ref))
               n_reserva = i; 
        }

        do {

            System.out.print("> Numero do pedido: ");
            n_pedido = scan.nextInt();

            if (n_pedido > 0) {

                n_pedido -= 1;
                buchi.getMesas()[entrada].getData()[n_reserva].getConta().incrementar(buchi.getCardapio()[n_pedido]);
                n_pedido ++;
            }

        } while (n_pedido > 0);
    }

    public static void opcao3(Scanner scan, Restaurante buchi) {

        System.out.println(">> Efetuar pagamento: DATA <<");
        Data data_ref = ler_data(scan);

        Mesa[] aux = buchi.listar_Agendamentos(data_ref);

        System.out.println("\nMesas com reservas para " + data_ref.getData());
        for (int i = 0; i < aux.length; i++)
            System.out.println("> Mesa " + ( aux[i].getNumeroMesa() + 1 ));

        System.out.print("\nMesa que deseja liberar: ");
        int entrada = scan.nextInt();
        entrada -= 1;

        buchi.getMesas()[entrada].liberar_Reserva(scan, data_ref);
    }

    public static void opcao4(Scanner scan, Restaurante buchi) {

        Mesa[] aux_mesas = buchi.getMesas();
        for (int i = 0; i < aux_mesas.length; i++) {

            System.out.println("> Mesa " + ( aux_mesas[i].getNumeroMesa() + 1 ) );

            if (!aux_mesas[i].getReserva())
                System.out.println("  \u001B[31mSem reservas\u001B[37m");

            else {

                Data[] aux_datas = aux_mesas[i].getData();
                for (int j = 0; j < aux_datas.length; j++) {

                    System.out.println("\u001B[33m");
                    System.out.println("  " + aux_datas[j].getData() + " reservado para:");
                    System.out.print("\u001B[37m");

                    Cliente[] aux_clientes = aux_datas[j].getPessoas();
                    for (int k = 0; k < aux_clientes.length; k++){

                        System.out.print("  -" + aux_clientes[k].getNome());
                        System.out.println(" (" + aux_clientes[k].getEmail() + ")");
                    }
                }
            }
            System.out.println();
        }
    }
}