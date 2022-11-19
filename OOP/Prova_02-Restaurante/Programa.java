import java.util.Scanner;

public class Programa {
    
    public static void opcao1(Scanner scan){

        System.out.println("AGENDAMENTO DA RESERVA: Data");

        System.out.print("Mes: ");
        int mes = scan.nextInt();

        System.out.println("Dia: ");
        int dia = scan.nextInt();

        Data data_ref = new Data(dia, mes, 2022);

    }
    public static void main (String args[]){

        // Template de cardapio
        Produto[] card_preset = new Produto[5];

        card_preset[0].setNome("Água");
        card_preset[0].setValor(2.00);

        card_preset[1].setNome("Empada de Frango");
        card_preset[1].setValor(4.50);

        card_preset[2].setNome("Kibe");
        card_preset[2].setValor(3.50);

        card_preset[3].setNome("Refresco");
        card_preset[3].setValor(0.80);

        card_preset[4].setNome("Picolé");
        card_preset[4].setValor(7.00);

        Scanner scanner = new Scanner (System.in);
        Restaurante Buchinho_Cheio = new Restaurante ("Buchi", "Av.AntonioCarlos - 265", 8);
        Buchinho_Cheio.setCardapio(card_preset);
        int opcao;

        do {
            System.out.println("OPCOES:\n");
            System.out.println("1 - Reservar mesa");
            System.out.println("2 - Realizar pedido");
            System.out.println("3 - Pagar comanda\n");
            System.out.println("0 - Encerrar programa");

            System.out.print("> ");
            opcao = scanner.nextInt();
            System.out.println();

            switch(opcao){

                case 1:
                {
                    opcao1(scanner);
                    break;
                }
                case 2:
                case 3:
            }

        } while (opcao != 0);
        scanner.close();
    }
}
