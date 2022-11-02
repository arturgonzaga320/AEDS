public class Att_08 {

  /* Imprima a seguinte tabela, usando fors encadeados:
   * 1
   * 2 4
   * 3 6 9
   * 4 8 12 16
   * n n*2 n*3 .... n*n
   */
    public static void main (String args[]){

        int n = 6;
        
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) System.out.print(i*j + " ");
            System.out.printf("\n");
        }
    }
    
}
