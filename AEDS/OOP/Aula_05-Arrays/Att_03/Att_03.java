import java.util.Scanner;

public class Att_03 {

    /* 
     * Utilize uma matriz quadrada de tamanho n para 
     * construir as n primeiras linhas do Triângulo de Pascal. 
    */

    public static void main (String args[]) {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
            
        System.out.print("Insira o valor de n: ");
        int n = scanner.nextInt();

        scanner.close();

        int[][] matriz = new int [n][n];

        for (int i = 0; i <= n; i ++){

            matriz [i][i] = 1;

            if ( i > 0 ) {

                matriz[i][0] = 1;
                System.out.print(matriz [i][0] + " ");

                for (int j= i - 1, k = 1; k < i; k++){

                    matriz [i][k] = matriz [j][k - 1] + matriz [j][k];
                    System.out.print(matriz [i][k] + " ");
                }
            }

            System.out.println(matriz [i][i]);
        }
    }
}
