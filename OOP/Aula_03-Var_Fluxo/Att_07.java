public class Att_07 {

  /* 
   * Escreva um programa que, dada uma variável x com algum valor inteiro, 
   * temos um novo x de acordo com a seguinte regra:
   * -> se x é par, x = x / 2
   * -> se x é impar, x = 3 * x + 1
   */   

    public static void main (String args[]){
      
        int x = 17;

        while (x > 1) {
            
            if (eh_par(x) == true) x = x/2;
            else x = 3* x + 1;
            if (x > 1)System.out.print(x+" -> ");
        }
        System.out.println(x);
    }

    public static boolean eh_par (int number){

        if (number % 2 == 0) return true;    
        return false;        
    }

}
