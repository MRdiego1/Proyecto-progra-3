package practicalab3;

/**
 * Clase que representa un combate entre dos peleadores
 */
public class Combate {
    private Peleador peleador1;
    private Peleador peleador2;
    private String fase;

    public Combate(Peleador peleador1, Peleador peleador2, String fase) {
        this.peleador1 = peleador1;
        this.peleador2 = peleador2;
        this.fase = fase;
    }

    //getters y setters
    public Peleador getPeleador1() {
        return peleador1;
    }

    public void setPeleador1(Peleador peleador1) {
        this.peleador1 = peleador1;
    }

    public Peleador getPeleador2() {
        return peleador2;
    }

    public void setPeleador2(Peleador peleador2) {
        this.peleador2 = peleador2;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }
}