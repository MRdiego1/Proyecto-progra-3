package practicalab3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un torneo (principal o repechaje)
 */
public class Torneo {
    private int id_torneo;
    private String categoria;
    private String tipo_torneo;
    private String fase_actual;
    private String tiempo_ronda;
    private int rondas;
    private List<Peleador> lista_participantes;
    private List<Combate> historial_combates;

    public Torneo(int id_torneo, String categoria, String tipo_torneo) {
        this.id_torneo = id_torneo;
        this.categoria = categoria;
        this.tipo_torneo = tipo_torneo;
        this.fase_actual = "octavos";
        this.lista_participantes = new ArrayList<>();
        this.historial_combates = new ArrayList<>();
        actualizarReglasSegunFase();
    }

    //actualizar tiempo y rondas según fase
    public void actualizarReglasSegunFase() {
        switch (this.fase_actual.toLowerCase()) {
            case "octavos":
            case "cuartos":
                this.tiempo_ronda = "3 min";
                this.rondas = 3;
                break;
            case "semifinal":
                this.tiempo_ronda = "4 min";
                this.rondas = 3;
                break;
            case "final":
                this.tiempo_ronda = "5 min";
                this.rondas = 5;
                break;
        }
    }

    //emparejar participantes activos
    public List<Combate> emparejarParticipantes() {
        List<Combate> combates = new ArrayList<>();
        List<Peleador> disponibles = obtenerParticipantesPorEstado("activo");

        if (disponibles.size() % 2 != 0) {
            System.out.println("Advertencia: Número impar de participantes.");
        }

        for (int i = 0; i < disponibles.size() - 1; i += 2) {
            Peleador p1 = disponibles.get(i);
            Peleador p2 = disponibles.get(i + 1);
            combates.add(new Combate(p1, p2, this.fase_actual));
        }

        return combates;
    }

    //procesar resultado de un combate
    public void procesarResultadoCombate(Peleador ganador, Peleador perdedor) {
        ganador.setVicorias(ganador.getVicorias() + 1);
        perdedor.setDerrotas(perdedor.getDerrotas() + 1);

        if (this.fase_actual.equalsIgnoreCase("final")) {
            ganador.actualizarEstado("clasificado a final");
            if (tipo_torneo.equals("principal")) {
                perdedor.actualizarEstado("derrotado");
            } else {
                perdedor.actualizarEstado("eliminado");
            }
        } else {
            ganador.actualizarEstado("activo");
            if (tipo_torneo.equals("principal")) {
                perdedor.actualizarEstado("derrotado");
            } else {
                perdedor.actualizarEstado("eliminado");
            }
        }
    }

    //avanzar a la siguiente fase
    public boolean avanzarFase() {
        switch (this.fase_actual.toLowerCase()) {
            case "octavos":
                this.fase_actual = "cuartos";
                break;
            case "cuartos":
                this.fase_actual = "semifinal";
                break;
            case "semifinal":
                this.fase_actual = "final";
                break;
            case "final":
                return true; 
        }
        actualizarReglasSegunFase();
        return false;
    }

    //mostrar finalistas
    public void generarFinalistas() {
        List<Peleador> finalistas = obtenerParticipantesPorEstado("clasificado a final");
        if (finalistas.size() == 2) {
            System.out.println("Combate de gran final preparado entre: " + 
                               finalistas.get(0).nombre + " y " + finalistas.get(1).nombre);
        } else {
            System.out.println("Aún no hay suficientes finalistas clasificados.");
        }
    }

    //pasar perdedores del principal al repechaje
    public void reintegrarPerdedores(Torneo torneo_principal) {
        List<Peleador> derrotados = torneo_principal.obtenerParticipantesPorEstado("derrotado");
        for (Peleador p : derrotados) {
            p.actualizarEstado("activo");
            this.lista_participantes.add(p);
        }
    }

    //obtener participantes por estado
    public List<Peleador> obtenerParticipantesPorEstado(String estado) {
        List<Peleador> filtrados = new ArrayList<>();
        for (Peleador p : this.lista_participantes) {
            if (p.estado.equalsIgnoreCase(estado)) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }

    //registrar combate en historial del torneo y de cada peleador
    public void registrarCombate(Combate combate) {
        this.historial_combates.add(combate);
        
        Peleador p1 = combate.getPeleador1();
        Peleador p2 = combate.getPeleador2();
        
        Historial h1 = new Historial(historial_combates.size(), p2, false, this.fase_actual, this.tipo_torneo, LocalDateTime.now(), this.rondas);
        Historial h2 = new Historial(historial_combates.size(), p1, false, this.fase_actual, this.tipo_torneo, LocalDateTime.now(), this.rondas);
        
        p1.setHistorial(h1);
        p2.setHistorial(h2);
    }

    //obtener estadísticas del torneo
    public String obtenerEstadisticasTorneo() {
        return "Total participantes: " + this.lista_participantes.size() + 
               "\nCombates realizados: " + this.historial_combates.size() + 
               "\nFase actual: " + this.fase_actual + 
               "\nFinalistas: " + obtenerParticipantesPorEstado("clasificado a final").size();
    }

    //verificar si hay suficientes participantes activos
    public boolean haySuficientesParticipantes() {
        int activos = obtenerParticipantesPorEstado("activo").size();
        return activos >= 2;
    }

    //reiniciar torneo (sin borrar participantes)
    public void reiniciarTorneo() {
        for (Peleador p : lista_participantes) {
            p.actualizarEstado("Activo");
            p.setVicorias(0);
            p.setDerrotas(0);
        }
        this.historial_combates.clear();
        this.fase_actual = "octavos";
        actualizarReglasSegunFase();
    }

    //getters
    public int getId_torneo() {
        return id_torneo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getFase_actual() {
        return fase_actual;
    }

    public List<Peleador> getLista_participante() {
        return lista_participantes;
    }

    public List<Combate> getHistorial_combates() {
        return historial_combates;
    }
}