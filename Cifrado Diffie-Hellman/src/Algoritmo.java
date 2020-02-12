
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bocanegragcj
 * @date 22/02/2019
 * @time 09:14:03 AM
 *
 */
public class Algoritmo {
    
    public static long generatePublicKey(long generador, long privateKey, long primo){
        return Exponenciacion(generador, privateKey, primo);
    }
    
    
    /**
     * 
     * @param numero
     * @return 
     */
    public static Boolean esPrimo(long numero){
        Boolean esPrimoActual = true;
        if(numero<2)
        {
            esPrimoActual = false;
        }
        else
        {
            for(int x=2; x*x<=numero; x++)
            {
                if( numero%x==0 ){esPrimoActual = false;break;}
            }
        }
        return esPrimoActual;
    }
    
    /**
     * Funciona para el calculo del la exponenciacion modular
     * @param a Base
     * @param k Exponente
     * @param n Valor del dividendo
     * @return Exponenciacion modular
     */
    public static long Exponenciacion(long a,long k, long n) {
        // n1= a, n2=k, n3=n
        ArrayList<Long> lista_k= new ArrayList<Long>();
        long rest, temp = k;
        while(temp>0){
            rest = mod(temp, 2);
            lista_k.add(rest);
            temp = temp/2;
        }
        
        long b,A;
        b=1;
        if(k==0){
            return(b);
        }
        A=a;
        if(lista_k.get(0)==1){
            b=a;
        }
        for (int i = 1; i <lista_k.size(); i++) {
            A= (A*A)% n;
            if(lista_k.get(i) == 1){
                b= (A*b)%n;
            }
        }
        //System.out.println("Resultado:"+a+"(^"+k+")"+"%"+n+"="+b);
        return(b);
    }
    
    /**
     * Funcion que calcula el modulo (a mod n) en base a la ecuacion de la division
     * @param num1
     * @param num2
     * @return 
     */
    public static long mod(long num1, long num2){
        long resto = num1 - ( num2 * ((int) Math.floor((double)num1/(double)num2)) );
        return resto;
    }
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("R= " + Exponenciacion(5,6,23));
    }

}
