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
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        int opc;
        ArrayList<Peleador> lista = new ArrayList<>();
        ArrayList<Peleador> listaHW = new ArrayList<>(); // Hombres Welter
        ArrayList<Peleador> listaHM = new ArrayList<>(); // Hombres Medio
        ArrayList<Peleador> listaHP = new ArrayList<>(); // Hombres Pesado
        ArrayList<Peleador> listaMW = new ArrayList<>(); // Mujeres Welter
        ArrayList<Peleador> listaMM = new ArrayList<>(); // Mujeres Medio
        ArrayList<Peleador> listaMP = new ArrayList<>(); // Mujeres Pesado

        do {
            System.out.println("Bienvenido al programa de incripcion y visualizacion del torneo de esgrima");
            System.out.println("1-Registrarse");
            System.out.println("2-Ver peleadores");
            System.out.println("3-Iniciar clasificacion de torneo");
            System.out.println("4-Salir");
            opc = entrada.nextInt();

            switch (opc) {
                case 1:
                    Peleador nuevo = new Peleador();
                    lista.add(nuevo);
                    System.out.println("Un nuevo peleador se a registrado");
                    break;
                case 2:
                    Iterator<Peleador> luchador1 = lista.iterator();
                    while (luchador1.hasNext()) {
                        Peleador p = luchador1.next();
                        p.mostrarInformacion();
                        System.out.println("================================");
                    }
                    break;

                case 3:
                    listaHW.clear(); listaHM.clear(); listaHP.clear();
                    listaMW.clear(); listaMM.clear(); listaMP.clear();
                    
                    Iterator<Peleador> luchador2 = lista.iterator();
                    while (luchador2.hasNext()) {
                        Peleador p = luchador2.next();

                        if (p.genero == 'H') {
                            if (p.categoria == 1) listaHW.add(p);
                            else if (p.categoria == 2) listaHM.add(p);
                            else if (p.categoria == 3) listaHP.add(p);
                        } else if (p.genero == 'M') {
                            if (p.categoria == 1) listaMW.add(p);
                            else if (p.categoria == 2) listaMM.add(p);
                            else if (p.categoria == 3) listaMP.add(p);
                        }
                    }
                    System.out.println("Los peleadores han sido clasificados en los respectivos torneos.");
                    break;
                case 4:
                    salir = true;
                    break;
            }
        } while (salir == false);
        System.out.println("Esperamos que la experiencia haya sido de su agrado");
    }
}