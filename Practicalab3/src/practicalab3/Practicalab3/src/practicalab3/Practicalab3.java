/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicalab3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class Practicalab3 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        int opc;
        
        //LISTAS DE ALMACENAMIENTO
        ArrayList<Peleador> lista = new ArrayList<>();                      //todos los peleadores registrados
        
        //listas para clasificación por género y categoría
        ArrayList<Peleador> listaHW = new ArrayList<>(); // Hombres Welter
        ArrayList<Peleador> listaHM = new ArrayList<>(); // Hombres Medio
        ArrayList<Peleador> listaHP = new ArrayList<>(); // Hombres Pesado
        ArrayList<Peleador> listaMW = new ArrayList<>(); // Mujeres Welter
        ArrayList<Peleador> listaMM = new ArrayList<>(); // Mujeres Medio
        ArrayList<Peleador> listaMP = new ArrayList<>(); // Mujeres Pesado
        
        //LISTAS DE TORNEOS
        ArrayList<Torneo> torneosPrincipales = new ArrayList<>();   //torneos de ganadores
        ArrayList<Torneo> torneosRepechaje = new ArrayList<>();     //torneos de perdedores

        do {
            //MENU PRINCIPAL
            System.out.println("Bienvenido al programa de incripcion y visualizacion del torneo de esgrima");
            System.out.println("1-Registrarse");
            System.out.println("2-Ver peleadores");
            System.out.println("3-Iniciar clasificacion de torneo");
            System.out.println("4-gestion de torneos");
            System.out.println("5-Salir");
            opc = entrada.nextInt();

            switch (opc) {
                //OPCION 1 - REGISTRAR PELEADOR
                case 1:
                    Peleador nuevo = new Peleador();           //crear nuevo peleador (pide datos internamente)
                    lista.add(nuevo);                           //agregar a lista general
                    System.out.println("Un nuevo peleador se a registrado");
                    break;
                    
                //OPCION 2 - VER PELEADORES
                case 2:
                    if (lista.isEmpty()) {
                        System.out.println("No hay peleadores registrados aún.");
                    } else {
                        Iterator<Peleador> luchador1 = lista.iterator();
                        while (luchador1.hasNext()) {
                            Peleador p = luchador1.next();
                            p.mostrarInformacion();                 //muestra datos + historial
                            System.out.println("================================");
                        }
                    }
                break;

                //OPCION 3 - CLASIFICAR PELEADORES EN CATEGORIAS
                case 3:
                    //limpiar listas de categorías
                    listaHW.clear(); listaHM.clear(); listaHP.clear();
                    listaMW.clear(); listaMM.clear(); listaMP.clear();
                    
                    //clasificar cada peleador según género y categoría
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
                    
                    //CREAR TORNEOS PRINCIPALES (solo si hay mínimo 8 participantes por categoría)
                    
                    //Hombres Welter
                    if (listaHW.size() >= 8) {
                        Torneo t = new Torneo(torneosPrincipales.size() + 1, "hombre_welter", "principal");
                        t.getLista_participante().addAll(listaHW);
                        torneosPrincipales.add(t);
                        System.out.println("Torneo creado: Hombre Welter con " + listaHW.size() + " participantes (ID: " + t.getId_torneo() + ")");
                    }
                    
                    //Hombres Medio
                    if (listaHM.size() >= 8) {
                        Torneo t = new Torneo(torneosPrincipales.size() + 1, "hombre_medio", "principal");
                        t.getLista_participante().addAll(listaHM);
                        torneosPrincipales.add(t);
                        System.out.println("Torneo creado: Hombre Medio con " + listaHM.size() + " participantes (ID: " + t.getId_torneo() + ")");
                    }
                    
                    //Hombres Pesado
                    if (listaHP.size() >= 8) {
                        Torneo t = new Torneo(torneosPrincipales.size() + 1, "hombre_pesado", "principal");
                        t.getLista_participante().addAll(listaHP);
                        torneosPrincipales.add(t);
                        System.out.println("Torneo creado: Hombre Pesado con " + listaHP.size() + " participantes (ID: " + t.getId_torneo() + ")");
                    }
                    
                    //Mujeres Welter
                    if (listaMW.size() >= 8) {
                        Torneo t = new Torneo(torneosPrincipales.size() + 1, "mujer_welter", "principal");
                        t.getLista_participante().addAll(listaMW);
                        torneosPrincipales.add(t);
                        System.out.println("Torneo creado: Mujer Welter con " + listaMW.size() + " participantes (ID: " + t.getId_torneo() + ")");
                    }
                    
                    //Mujeres Medio
                    if (listaMM.size() >= 8) {
                        Torneo t = new Torneo(torneosPrincipales.size() + 1, "mujer_medio", "principal");
                        t.getLista_participante().addAll(listaMM);
                        torneosPrincipales.add(t);
                        System.out.println("Torneo creado: Mujer Medio con " + listaMM.size() + " participantes (ID: " + t.getId_torneo() + ")");
                    }
                    
                    //Mujeres Pesado
                    if (listaMP.size() >= 8) {
                        Torneo t = new Torneo(torneosPrincipales.size() + 1, "mujer_pesado", "principal");
                        t.getLista_participante().addAll(listaMP);
                        torneosPrincipales.add(t);
                        System.out.println("Torneo creado: Mujer Pesado con " + listaMP.size() + " participantes (ID: " + t.getId_torneo() + ")");
                    }

                    //mensaje si no se crearon torneos
                    if (torneosPrincipales.isEmpty()) {
                        System.out.println("No hay suficientes peleadores (mínimo 8) en ninguna categoría para crear torneos.");
                    } else {
                        System.out.println("Se crearon " + torneosPrincipales.size() + " torneos principales.");
                    }
                    break;
                    
                //OPCION 4 - GESTION DE TORNEOS    
            case 4:
                if (torneosPrincipales.isEmpty()) {
                    System.out.println("Primero debes clasificar peleadores (opción 3)");
                } else {
                    //mostrar torneos disponibles
                    System.out.println("\n=== TORNEOS PRINCIPALES DISPONIBLES ===");
                    for (int i = 0; i < torneosPrincipales.size(); i++) {
                        Torneo t = torneosPrincipales.get(i);
                        System.out.println((i+1) + ". " + t.getCategoria() + 
                                           " | Fase: " + t.getFase_actual() +
                                           " | Participantes: " + t.getLista_participante().size());
                    }

                    //seleccionar torneo
                    System.out.println("\nSelecciona un torneo: ");
                    int seleccion = entrada.nextInt();

                    if (seleccion > 0 && seleccion <= torneosPrincipales.size()) {
                        Torneo t = torneosPrincipales.get(seleccion - 1);

                        //submenú de acciones para el torneo seleccionado
                        System.out.println("\n1-Ver estadísticas");
                        System.out.println("2-Simular ronda (combates automáticos)");
                        System.out.println("3-Reiniciar torneo");
                        int accion = entrada.nextInt();

                        //OPCION 4.1 - VER ESTADISTICAS
                        if (accion == 1) {
                            System.out.println("\n" + t.obtenerEstadisticasTorneo());

                        //OPCION 4.2 - SIMULAR RONDA (COMBATES AUTOMATICOS)    
                        } else if (accion == 2) {
                            if (!t.haySuficientesParticipantes()) {
                                System.out.println("No hay suficientes participantes activos para continuar.");
                            } else {
                                //INICIO DE SIMULACION
                                System.out.println("\n=== SIMULANDO RONDA: " + t.getFase_actual().toUpperCase() + " ===");

                                //emparejar participantes
                                List<Combate> combates = t.emparejarParticipantes();

                                //procesar cada combate con resultado aleatorio
                                for (Combate c : combates) {
                                    Peleador p1 = c.getPeleador1();
                                    Peleador p2 = c.getPeleador2();

                                    //decision aleatoria de ganador
                                    boolean ganaP1 = Math.random() < 0.5;
                                    Peleador ganador = ganaP1 ? p1 : p2;
                                    Peleador perdedor = ganaP1 ? p2 : p1;

                                    //registrar resultado en torneo y en historial
                                    t.procesarResultadoCombate(ganador, perdedor);
                                    t.registrarCombate(c);

                                    System.out.println("Combate: " + p1.nombre + " vs " + p2.nombre + 
                                                       " | GANADOR: " + ganador.nombre);
                                }

                                System.out.println("\nRonda completada. " + combates.size() + " combates realizados.");

                                //avanzar a siguiente fase
                                boolean esFinal = t.avanzarFase();

                                //SI TERMINO EL TORNEO PRINCIPAL
                                if (esFinal) {
                                    System.out.println("¡TORNEO PRINCIPAL FINALIZADO!");
                                    t.generarFinalistas();

                                    //CREAR TORNEO DE REPECHAJE
                                    Torneo repechaje = new Torneo(torneosRepechaje.size() + 1, t.getCategoria(), "perdedores");
                                    repechaje.reintegrarPerdedores(t);
                                    torneosRepechaje.add(repechaje);

                                    System.out.println("¡TORNEO DE REPECHAJE CREADO con " + 
                                                       repechaje.getLista_participante().size() + " participantes!");

                                    //SIMULAR REPECHAJE COMPLETO
                                    System.out.println("\n--- SIMULANDO REPECHAJE ---");

                                    while (!repechaje.avanzarFase()) {
                                        if (repechaje.haySuficientesParticipantes()) {
                                            List<Combate> combatesRepechaje = repechaje.emparejarParticipantes();

                                            for (Combate c : combatesRepechaje) {
                                                Peleador p1 = c.getPeleador1();
                                                Peleador p2 = c.getPeleador2();

                                                //decision aleatoria en repechaje
                                                boolean ganaP1 = Math.random() < 0.5;
                                                Peleador ganador = ganaP1 ? p1 : p2;
                                                Peleador perdedor = ganaP1 ? p2 : p1;

                                                repechaje.procesarResultadoCombate(ganador, perdedor);
                                                repechaje.registrarCombate(c);

                                                System.out.println("Repechaje: " + p1.nombre + " vs " + p2.nombre + 
                                                                   " | GANA: " + ganador.nombre);
                                            }
                                        }
                                    }

                                    System.out.println("¡REPECHAJE FINALIZADO!");
                                    repechaje.generarFinalistas();

                                    //GRAN FINAL (campeón principal vs campeón repechaje)
                                    System.out.println("\n=== GRAN FINAL ===");
                                    List<Peleador> finalistasPrincipales = t.obtenerParticipantesPorEstado("clasificado a final");
                                    List<Peleador> finalistasRepechaje = repechaje.obtenerParticipantesPorEstado("clasificado a final");

                                    if (!finalistasPrincipales.isEmpty() && !finalistasRepechaje.isEmpty()) {
                                        Peleador campeonPrincipal = finalistasPrincipales.get(0);
                                        Peleador campeonRepechaje = finalistasRepechaje.get(0);

                                        System.out.println("GRAN FINAL: " + campeonPrincipal.nombre + " vs " + campeonRepechaje.nombre);

                                        //simular gran final (mejor de 5)
                                        int victoriasP1 = 0, victoriasP2 = 0;
                                        for (int ronda = 1; ronda <= 5; ronda++) {
                                            boolean ganaP1 = Math.random() < 0.5;
                                            if (ganaP1) victoriasP1++; else victoriasP2++;

                                            System.out.println("Ronda " + ronda + ": " + (ganaP1 ? campeonPrincipal.nombre : campeonRepechaje.nombre));

                                            if (victoriasP1 == 3 || victoriasP2 == 3) break;
                                        }

                                        Peleador granCampeon = (victoriasP1 > victoriasP2) ? campeonPrincipal : campeonRepechaje;
                                        System.out.println("¡¡¡EL GRAN CAMPEÓN ES: " + granCampeon.nombre + "!!!");
                                    }
                                } else {
                                    System.out.println("Siguiente fase: " + t.getFase_actual());
                                }
                            }

                        //OPCION 4.3 - REINICIAR TORNEO
                        } else if (accion == 3) {
                            t.reiniciarTorneo();
                            System.out.println("Torneo reiniciado. Ahora está en fase: " + t.getFase_actual());
                        }
                    }
                }
                break;
                    
                //OPCION 5 - SALIR    
                case 5:
                    salir = true;
                    break;
            }
        } while (salir == false);
        System.out.println("Esperamos que la experiencia haya sido de su agrado");
    }
}