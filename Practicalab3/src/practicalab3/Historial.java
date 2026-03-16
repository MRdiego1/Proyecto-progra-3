/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicalab3;

import java.time.LocalDateTime;

/**
 * Clase que representa un combate individual en el historial de un peleador.
 * Cada objeto de esta clase almacena los detalles de una pelea específica.
 */
public class Historial {
    // Atributos
    private int id;                     // Id del combate
    private Peleador rival;              
    private boolean victoria;            // true si el peleador ganó, false si perdió
    private String fase;                 // Fase del torneo (octavos, cuartos, etc.)
    private String tipoTorneo;           // "principal" o "repesca"
    private LocalDateTime fecha;          // Fecha y hora del combate
    private int rondas;                   

    // Constructores
    public Historial() {
    }

    public Historial(int id, Peleador rival, boolean victoria, String fase, 
                     String tipoTorneo, LocalDateTime fecha, int rondas) {
        this.id = id;
        this.rival = rival;
        this.victoria = victoria;
        this.fase = fase;
        this.tipoTorneo = tipoTorneo;
        this.fecha = fecha;
        this.rondas = rondas;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Peleador getRival() {
        return rival;
    }

    public void setRival(Peleador rival) {
        this.rival = rival;
    }

    public boolean isVictoria() {
        return victoria;
    }

    public void setVictoria(boolean victoria) {
        this.victoria = victoria;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getTipoTorneo() {
        return tipoTorneo;
    }

    public void setTipoTorneo(String tipoTorneo) {
        this.tipoTorneo = tipoTorneo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }

    // Método para mostrar información resumida del combate
    public void mostrarInfo() {
        System.out.println("=== Combate ID: " + id + " ===");
        System.out.println("Fecha: " + fecha);
        System.out.println("Rival: " + (rival != null ? rival.nombre : "N/A"));
        System.out.println("Resultado: " + (victoria ? "Victoria" : "Derrota"));
        System.out.println("Fase: " + fase);
        System.out.println("Tipo de torneo: " + tipoTorneo);
        System.out.println("Rondas jugadas: " + rondas);
    }
}
