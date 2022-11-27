// Trabalho Final de AEDS: Restaurante Buchinho Cheio
// Artur Gonzaga da Silva Gomes - 203A

import java.util.Scanner;

public class TesteRestaurante {

    static int clientes_por_mesa = 8;

    public static void main (String args[]){

        // Template de cardapio
        Produto preset[] = new Produto[5];
        preset[0] = new Produto("Água", 2.00, "Bebida");
        preset[1] = new Produto("Empada de Frango", 4.50, "Comida");
        preset[2] = new Produto("Kibe",3.50, "Comida");
        preset[3] = new Produto("Refresco", 0.80, "Bebida");
        preset[4] = new Produto("Picolé", 7.00, "Comida");

        String[] categs = new String[2];
        categs[0] = "Comida";
        categs[1] = "Bebida";


        Restaurante buchi = new Restaurante ("Buchinho_Cheio", "Av.AntonioCarlos - 265", 8);
        buchi.setCardapio(preset);
        buchi.setCategorias(categs);

        Scanner scan = new Scanner (System.in);
        int opcao;

        System.out.print("\u001B[34m");
        System.out.println("\n\nRESTAURANTE BUCHINHO CHEIO\u001B[37m");

        do {
            System.out.println ("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _\n");
            System.out.println ("1 - Reservar mesa");
            System.out.println ("2 - Realizar pedido");
            System.out.println ("3 - Pagar comanda");
            System.out.println ("4 - Ver reservas");

            // Orientação para sair
            System.out.println ("\u001B[33m");
            System.out.println ("* Digite '0' para sair\u001B[37m");

            System.out.print   ("> ");
            opcao = scan.nextInt();

            System.out.println ("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _\n");
            switch(opcao){

                case 1: 
                {
                    // Reservar mesa
                    opcao1(scan, buchi);
                    break;
                }
                case 2:
                {
                    // Realizar pedido
                    opcao2(scan, buchi);
                    break;
                }
                case 3:
                {
                    // Pagar comanda
                    opcao3(scan, buchi);
                    break;
                }
                case 4:
                {
                    // Ver reservas
                    opcao4(scan, buchi);
                    break;
                }
            }
        } while (opcao != 0);
        scan.close();
    }

    private static Data ler_Data(Scanner scan) {

        System.out.print ("> Dia: ");
        int dia = scan.nextInt();

        System.out.print ("> Mes: ");
        int mes = scan.nextInt();

        Data data_p = new Data (dia, mes, 2023);
        return data_p;
    }

    private static int maior_String(String[] v_sting) {

        int tam_ref = 0;
        for (int i = 0; i < v_sting.length; i++) {

            // Caso valor maior seja encontrado
            if (v_sting[i].length() > tam_ref) tam_ref = v_sting[i].length();
        }

        return tam_ref;
    }

    public static void opcao1(Scanner scanner, Restaurante buchi){

        System.out.print("\u001B[34m");
        System.out.println (">> Agendamento da reserva: DATA <<\u001B[37m");
        Data data_ref = ler_Data(scanner);

        System.out.println ("\nMesas disponíveis no dia " + data_ref.getData()+ ":" );

        for (int i = 0; i < buchi.getMesas().length; i++) {

            if (buchi.getMesas()[i].getReserva() == false) {

                System.out.print("> \u001B[32m");
                System.out.println("Mesa " + ( buchi.getMesas()[i].getNumeroMesa() + 1 ) + "\u001B[37m");
            }
            else {

                boolean rep = false;
                Data[] aux = buchi.getMesas()[i].getData();

                for (int j = 0; j < aux.length; j++) {

                    if (aux[j].comparar_Data(data_ref)) rep = true;
                }

                if (rep == false) {

                    System.out.print("> \u001B[32m");
                    System.out.println("Mesa " + ( buchi.getMesas()[i].getNumeroMesa() + 1 ) + "\u001B[37m");
                }
            }
        }

        System.out.print ("\nMesa que deseja reservar: ");
        int op_1 = scanner.nextInt();

        System.out.println ("\u001B[33m");
        System.out.println ("* Até " + clientes_por_mesa + " pessoas por mesa, digite '0' para sair\u001B[37m");

        int op_2;

        do {

            System.out.print ("Quantidade pessoas a serem cadastradas: ");
            op_2 = scanner.nextInt();

            if (op_2 == 0) return;
            else if (op_2 > clientes_por_mesa) {

                System.out.print   ("\u001B[31m");
                System.out.println ("Quantidade inválida\u001B[37m");
            }

        } while (op_2 > clientes_por_mesa);

        buchi.getMesas()[op_1 - 1].reservar(op_2,data_ref,buchi.getCategorias(),scanner);
    }

    public static void opcao2(Scanner scan, Restaurante buchi){
    
        System.out.print("\u001B[34m");
        System.out.println (">> Realizar pedido: DATA <<\u001B[37m");
        Data data_ref = ler_Data(scan);
        
        System.out.println ("\nMesas com reservas para " + data_ref.getData());
        Mesa[] aux = buchi.listar_Agendamentos(data_ref);

        if (aux.length == 0) {

            System.out.print   ("\u001B[31m");
            System.out.println ("Sem reservas\u001B[37m");
            return;
        }

        for (int i = 0; i < aux.length; i++) {

            System.out.print("> \u001B[32m");
            System.out.println("Mesa " + ( aux[i].getNumeroMesa() + 1 ) + "\u001B[37m");
        }

        System.out.print("\nMesa que realizará o pedido: ");
        int entrada = scan.nextInt();
        entrada --;

        // Listar cardarpio
        System.out.println ("\nCardapio do dia:");

        // Vetor para organizar espaços a serem feitos na próxima listagem
        String[] aux_spaces = new String [buchi.getCardapio().length];
        for (int i = 0; i < aux_spaces.length; i++) aux_spaces[i] = buchi.getCardapio()[i].getNome();

        int n_spaces = maior_String(aux_spaces);

        for (int i = 0; i < buchi.getCardapio().length; i++) {

            System.out.print ( i + 1+ "-" + buchi.getCardapio()[i].getNome());

            // Pular espaços para deixar alinhado
            for (int j = 0; j < n_spaces - buchi.getCardapio()[i].getNome().length(); j++) System.out.print (" ");

            System.out.print  ("\t................. R$ ");
            System.out.printf ("%.2f\n", buchi.getCardapio()[i].getValor());
        }

        // Orientação para sair
        System.out.println ("\u001B[33m");
        System.out.println ("* Digite '0' para sair\u001B[37m\n");

        int n_pedido;
        int n_reserva = 0;

        for (int i = 0; i < buchi.getMesas()[entrada].getData().length; i ++){

            // Encontra o  numero reserva
            if (buchi.getMesas()[entrada].getData()[i].comparar_Data(data_ref)) n_reserva = i; 
        }

        do {

            System.out.print("> Numero do pedido: ");
            n_pedido = scan.nextInt();

            if (n_pedido > 0) {

                n_pedido --;
                if (n_pedido >= buchi.getCardapio().length){

                    System.out.print   ("\u001B[31m");
                    System.out.println ("  Pedido inválido\u001B[37m");
                }
                else {

                    buchi.getMesas()[entrada].getData()[n_reserva].getConta().incrementar(buchi.getCardapio()[n_pedido]);
                    n_pedido ++;
                }
            }

        } while (n_pedido > 0);
    }

    public static void opcao3(Scanner scan, Restaurante buchi) {

        System.out.print("\u001B[34m");
        System.out.println(">> Efetuar pagamento: DATA <<\u001B[37m");
        Data data_ref = ler_Data(scan);

        System.out.println("\nMesas com reservas para " + data_ref.getData());
        Mesa[] aux = buchi.listar_Agendamentos(data_ref);

        if (aux.length == 0) {

            System.out.print   ("\u001B[31m");
            System.out.println ("Sem reservas\u001B[37m");
            return;
        }

        for (int i = 0; i < aux.length; i++) {

            System.out.print("> \u001B[32m");
            System.out.println("Mesa " + ( aux[i].getNumeroMesa() + 1 ) + "\u001B[37m");
        }

        System.out.print("\nMesa que deseja liberar: ");
        int entrada = scan.nextInt();
        entrada --;

        buchi.getMesas()[entrada].liberar_Reserva(data_ref,scan);
    }

    public static void opcao4(Scanner scan, Restaurante buchi) {

        Mesa[] aux_mesas = buchi.getMesas();

        for (int i = 0; i < aux_mesas.length; i++) {

            System.out.println("> Mesa " + ( aux_mesas[i].getNumeroMesa() + 1 ) );

            if (!aux_mesas[i].getReserva()) {

                System.out.print   ("\u001B[31m");
                System.out.println ("  Sem reservas\u001B[37m");
            }
            else {

                Data[] aux_datas = aux_mesas[i].getData();

                for (int j = 0; j < aux_datas.length; j++) {

                    System.out.print("\u001B[33m"); // Texto colorido
                    System.out.println("  " + aux_datas[j].getData() + " reservado para:\u001B[37m");

                    Cliente[] aux_clientes = aux_datas[j].getPessoas();

                    // Vetor para organizar espaços a serem feitos na próxima listagem
                    String[] aux_spaces = new String [aux_clientes.length];
                    for (int l = 0; l < aux_spaces.length; l++) aux_spaces[l] = aux_clientes[l].getNome();

                    int tam_ref = maior_String(aux_spaces);

                    for (int k = 0; k < aux_clientes.length; k++){


                        System.out.print   ("  -" + aux_clientes[k].getNome());

                        // Pular espaços para deixar alinhado
                        for (int m = 0; m < tam_ref - aux_clientes[k].getNome().length(); m++) System.out.print(" ");

                        System.out.println ("\t(" + aux_clientes[k].getEmail() + ")");
                    }
                }
            }
            System.out.println();
        }
    }
}