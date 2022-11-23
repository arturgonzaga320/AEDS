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

        Scanner scanner = new Scanner (System.in);
        Restaurante Buchinho_Cheio = new Restaurante ("Buchi", "Av.AntonioCarlos - 265", 8);
        Buchinho_Cheio.setCardapio(preset);
        int opcao;

        System.out.println("\n\nRESTAURANTE BUCHINHO CHEIO\n");

        do {
            System.out.println("Serviços:\u001B[31m");
            System.out.println("0 - Encerrar programa\u001B[37m");
            System.out.println("1 - Reservar mesa");
            System.out.println("2 - Realizar pedido");
            System.out.println("3 - Pagar comanda");

            System.out.print("> ");
            opcao = scanner.nextInt();
            System.out.println();

            switch(opcao){

                case 1: 
                {
                    // Reservar mesa
                    opcao1(scanner, Buchinho_Cheio);
                    // Falta fazer umas verifições para o usuario
                    // não digitar o que não devia, mas funciona em sintese
                    break;
                }
                case 2:
                {
                    // Realizar pedido
                    opcao2(scanner, Buchinho_Cheio);
                    break;
                }
                case 3:
                {
                    // Pagar comanda
                    System.out.println("Pedente");
                    break;
                }
            }
        } while (opcao != 0);
        scanner.close();
    }

    public static void opcao1(Scanner scanner, Restaurante buchi){

        System.out.println(">> Agendamento da reserva: DATA <<");

        System.out.print("> Mes: ");
        int mes = scanner.nextInt();

        System.out.print("> Dia: ");
        int dia = scanner.nextInt();

        Data data_ref = new Data (dia, mes, 2022);
        data_ref.validar_Data();

        System.out.println("\nMesas disponíveis no dia " + data_ref.getData()+ ":\n" );
        
        for (int i = 0; i < buchi.getMesas().length; i++){

            if ((buchi.getMesas()[i].getData().compararData(data_ref)) == false){

                System.out.println("> Mesa " + ( buchi.getMesas()[i].getNumeroMesa() + 1 ));
                System.out.println("  " + buchi.getMesas()[i].getClientes().length + " lugares disponíveis\n");
            }
        }

        System.out.print("Mesa deseja que reservar: ");
        int op_1 = scanner.nextInt();

        System.out.print("Quantidade pessoas a serem cadastradas: ");
        int op_2 = scanner.nextInt();

        buchi.getMesas()[op_1 - 1].reservar(op_2, data_ref,scanner);
    }

    public static void opcao2(Scanner scanner, Restaurante buchi){
    
        // Pedir numMesa
        System.out.print("> Numero da mesa: ");
        int num_mesa = scanner.nextInt();
        num_mesa = num_mesa - 1;

        // Listar cardarpio

        System.out.println("\nCardapio do dia:");

        for (int i = 0; i < buchi.getCardapio().length; i++){

           System.out.print ( i + 1+ "-" + buchi.getCardapio()[i].getNome());
           System.out.print ("\t\t................. R$ ");
           System.out.println (buchi.getCardapio()[i].getValor());
        }
        System.out.println ();
        // Criar loop while opcao !=0 { comanda.incrementar()}
    }
    public static void opcao3(Scanner scanner, Restaurante buchi){

        // Pedir numMesa

        // Saida de pagamento efetuado
        // liberar mesa (reserva == false)
    }
}