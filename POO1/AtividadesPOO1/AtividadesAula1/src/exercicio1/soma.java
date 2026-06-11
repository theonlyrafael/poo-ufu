package exercicio1;

import java.util.*;

public class soma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite dois números: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int soma = num1 + num2;
        System.out.println("O resultado é" + " = " + soma);
        
    }
    
}
