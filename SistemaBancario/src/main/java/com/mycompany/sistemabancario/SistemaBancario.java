

package com.mycompany.sistemabancario;
import java.util.Scanner;
public class SistemaBancario {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int op;
        do{
           System.out.println("Sistema Bancario");
        System.out.println("1 - Gestión de clientes");
        System.out.println("2 - Gestión de cuentas");
        System.out.println("3 - Gestión de transacciones");
        System.out.println("4 - Gestión de personas"); 
        System.out.println("0 - Salir del sistema"); 
         op=sc.nextInt();
        sc.nextLine();
        switch(op){
            case 1:
                
        }
        
        
        }while(op!=0);
        
        
    }
}
