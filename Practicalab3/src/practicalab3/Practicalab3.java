/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicalab3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author Diego
 */
public class Practicalab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        boolean salir=false;
        int opc;
        ArrayList <Peleador> lista=new ArrayList<>();
        ArrayList <Peleador> listaHA=new ArrayList<>();
        ArrayList <Peleador> listaHJ=new ArrayList<>();
        ArrayList <Peleador> listaMA=new ArrayList<>();
        ArrayList <Peleador> listaMJ=new ArrayList<>();
        
        do{
            System.out.println("Bienvenido al programa de incripcion y visualizacion del torneo de esgrima");
            System.out.println("1-registrarse");
            System.out.println("2-ver peleadores");
            System.out.println("3-Iniciar clasificacion de torneo");
            System.out.println("4-salir");
            opc=entrada.nextInt();
            
            switch(opc){
                case 1:
                    Peleador nuevo=new Peleador();
                    lista.add(nuevo);
                    System.out.println("Un nuevo peleador se a registrado");
                    break;
                case 2:
                    Iterator <Peleador> luchador1= lista.iterator();
                        while(luchador1.hasNext()){
                            Peleador p=luchador1.next();
                            p.mostrarInformacion();
                            System.out.println("================================");
                        }
                    break;

                case 3:
                    Iterator <Peleador> luchador2= lista.iterator();
                    while(luchador2.hasNext()){
                        Peleador p = luchador2.next();

                        if(p.genero == 'H' && p.categoria == 1){
                            listaHA.add(p);
                        } else if(p.genero == 'H' && p.categoria == 2){
                            listaHJ.add(p);
                        } else if(p.genero == 'M' && p.categoria == 1){
                            listaMA.add(p);
                        } else if(p.genero == 'M' && p.categoria == 2){
                            listaMJ.add(p);
                        }
                    }
                    break;
                case 4: 
                    salir=true;
                    break;
            }
        }while(salir==false);
        System.out.println("Esperamos que la experiencia haya sido de su agrado");
    }
}