
import java.util.Scanner;

public class Programa {

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

        for (int i = 1; i <= n; i ++){

            for ( int k = i-1; k > 0; k--){


                

            }
            System.out.println ("1");

        }
        
    }
}