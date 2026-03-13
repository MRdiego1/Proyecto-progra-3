/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicalab3;

import java.util.List;

public class Torneo {
    private int id_torneo;
    private String categoria;
    private String tipo_torneo;
    private String fase_actual;
    private String tiempo_ronda;
    private int rondas;
    private List<Participante> lista_participante;
    private List<Combate> historial_combates;
    
    //aca va el constructor 
    public Torneo(int id_torneo, String categoria, String tipo_torneo, String tiempo_ronda, int rondas){
        this.id_torneo = id_torneo;
        this.categoria = categoria;
        this.tipo_torneo = tipo_torneo;
        this.fase_actual = fase_actual;
        this.tiempo_ronda = tiempo_ronda;
        this.rondas = rondas;
        this.lista_participante = new ArrayList<>();
        this.historial_combates = new ArrayList<>();
        
    }
    
    
    //aca inician los metodos 
    public void claisifcarParticipantes(List<Participantes>){
        
    }
    
    public void actualizarReglaSegunFase(){
        
    }
    
    public List<Combate>emparejarParticipantes(){
        
    }
    
    public void procesarResultadoCombate(Participante ganador, Participante perdedor) {    
        
    }
    
    public boolean avanzarFase(){
        
    }
    
    public void generarFinalista(){
        
    }
    
    public void reintegrarPerdor (Torneo torneo_principal){
        
    }
    
    public List<Participante> obtenerParticipantesPorEstado(String estado){
        
    }
    
    public void registrarCombate (Combate combate){
        
    }
    
    public String obtenerEstadisticasTorneo(){
        
    }
    
    public boolean haySuficientesParticipantes(){
        
    }
    
    public void reiniciarTorneo(){
        
    }
    
    
}

