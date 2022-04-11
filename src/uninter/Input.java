package uninter;

import java.util.Scanner;

public class Input {
    // Método para receber input, evita criar múltiplos Buffers no terminal 
    Scanner teclado = new Scanner(System.in);
    public String inputScan(String text){

        System.out.print(text);
        String str = teclado.nextLine();

        return str;
    }
}