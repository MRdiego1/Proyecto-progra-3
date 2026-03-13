/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicalab3;
import java.util.Scanner;
/**
 *
 * @author Diego
 */
public class Participante {
    String Nombres,apellidos,ID;
    int edad,genero;
    
    public void registro(){
        Scanner entrada=new Scanner(System.in);
        System.out.println("Bienvenido a el registro de nuestro torneo 'tal'");
        System.out.println("Por favor ingrese sus Apellidos");
        apellidos=entrada.nextLine();
        
        System.out.println("Ahora indique sus Nombres");
        Nombres=entrada.nextLine();
        
        do{
            System.out.println("casi terminamos, dame tu Genero");
            System.out.println("1.-Hombre\n2.-Mujer");
            genero=entrada.nextInt();
            if(genero<3 && genero >0){
                System.out.println("Dato valido, por favor vuelva a elegir");
            }
        }while(genero<3 && genero >0);
        
        System.out.println("Para terminar solo ocupamos su edad, por favor proporcionenos el dato");
        edad=entrada.nextInt();
        
        System.out.println("Registro completo");
    }
    
    public void presentar (){
        System.out.println("Usted es "+Nombres+" con apellidos "+apellidos);
        System.out.println("Genero: "+genero);
        System.out.println("Edad: "+edad);
    }
    
}
