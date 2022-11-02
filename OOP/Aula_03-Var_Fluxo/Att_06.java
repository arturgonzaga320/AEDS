
public class Att_06 {

  /* 
   * Imprima os primeiros numeros da
   * serie de Fibonacci ate passar de 100
   */

    public static void main (String args[]) {

        int ante = 0;
        int next = 1;

        System.out.println();

        for (int i = 0; ante+next < 100; i++){

            System.out.print( ante+next + "  ");

            if (i> 0){

                next += ante;
                ante = next - ante;
            }
            System.out.println();
        }
    }
}