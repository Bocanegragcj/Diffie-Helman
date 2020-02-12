
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bocanegragcj
 * @date 21/02/2019
 * @time 11:48:15 PM
 *
 */
public class main {

    public static long claves[] = null;
    public static long primo;
    public static long generador;
    public static long aPrivateKey;
    public static long bPrivateKey;
    public static long aPublicKey;
    public static long bPublicKey;
    public static long secretKey;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcMP = 0;
        do{
            opcMP = menuPrincipal();
            operations(opcMP);
            System.out.println("-----------------------------------------------------------");
        }while(opcMP != 4);
    }
    
    private static int menuPrincipal(){
        int opc = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------OPERATIONS------------------------");
        System.out.println("1) Generar Claves                     ");
        System.out.println("2) Cifrado                            ");
        System.out.println("3) Descifrado                         ");
        System.out.println("4) Salir                              ");
        System.out.println("--------------------------------------------------");
        System.out.print("Ingrese Opcion: ");
        opc = scanner.nextInt();
        return opc;
    }
    
    private static int menuSecundario(){
        int opc = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------OPERATIONS------------------------");
        System.out.println("1) Manual                               ");
        System.out.println("2) Aleatorio                            ");
        System.out.println("3) Salir                                ");
        System.out.println("--------------------------------------------------");
        System.out.print("Ingrese Opcion: ");
        opc = scanner.nextInt();
        return opc;
    }
    
    private static void operations(int opc){
        Scanner imput = new Scanner(System.in);
        switch(opc){
            case 1: 
            {
                int opcMS;
                do{
                    opcMS = menuSecundario();
                    operationsMS(opcMS);
                    System.out.println("-----------------------------------------------------------");
                }while(opcMS != 3);
            }
                break;
            case 2: 
            {
                try {
                    System.out.println("primo= " + primo);
                    System.out.println("generador= " + generador);
                } catch (Exception e) {
                    System.out.println("Error= "+e );
                }
                
            }
                break;
            case 3: 
            {
                try {
                    System.out.println("primo= " + primo);
                    System.out.println("generador= " + generador);
                } catch (Exception e) {
                    System.out.println("Error= "+e );
                }
                
            }
                break;
        }
    }
    
    private static void operationsMS(int opc){
        Scanner imput = new Scanner(System.in);
        switch(opc){
            case 1:
            {
                do {
                    System.out.println("Ingrese un Numero primo P : ");
                    primo = imput.nextLong();//VALIDAMOS QUE EL NUMERO INGRESADO P SEA PRIMO
                } while (Algoritmo.esPrimo(primo) == false);
                System.out.println("Ingrese G= ");
                generador = imput.nextLong();
                System.out.println("Privado A= ");
                aPrivateKey = imput.nextLong();
                System.out.println("Privado B= ");
                bPrivateKey = imput.nextLong();
                
                aPublicKey = Algoritmo.generatePublicKey(generador, aPrivateKey, primo);
                bPublicKey = Algoritmo.generatePublicKey(generador, bPrivateKey, primo);
                
                long aSecretKey = Algoritmo.generatePublicKey(bPublicKey, aPrivateKey, primo);
                long bSecretKey = Algoritmo.generatePublicKey(aPublicKey, bPrivateKey, primo);
                
                if(aSecretKey == bSecretKey)
                    secretKey = aSecretKey;
                else
                    secretKey = 0;
                
                System.out.println("--------------------------------------------");
                System.out.println("P= " + primo);
                System.out.println("G= " + generador);
                System.out.println("A= " + aPrivateKey);
                System.out.println("B= " + bPrivateKey);
                System.out.println("xA= " + aPublicKey);
                System.out.println("xB= " + bPublicKey);
                System.out.println("xA= " + aSecretKey);
                System.out.println("xB= " + bSecretKey);
                System.out.println("K= " + secretKey);
                System.out.println("--------------------------------------------");
            }
                break;
            case 2:
            {
                System.out.println("Aleatorio");
            }
                break;
        }
    }

}
