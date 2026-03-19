package practicalab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase que representa un peleador
 */
public class Peleador {
    //atributos públicos (accesibles desde otras clases)
    String nombre;
    int edad;
    char genero;
    String estado;
    public final int categoria; // 1=welter, 2=medio, 3=pesado
    
    //atributos privados
    private int victorias, derrotas;
    private final int id;
    private double peso;
    private List<Historial> historial = new ArrayList<>();
    
    //estáticos
    private static Scanner sc = new Scanner(System.in);
    private static final AtomicInteger contador = new AtomicInteger(0);

    //constructor - pide datos al usuario
    public Peleador() {
        System.out.print("\n Ingresa el nombre del peleador: ");
        this.nombre = sc.nextLine();
        
        System.out.print("\n Ingresa la edad del peleador: ");
        this.edad = sc.nextInt();
        sc.nextLine();
        
        System.out.print("\n Ingresa el genero del peleador [H or M]: ");
        this.genero = sc.next().toUpperCase().charAt(0);
        sc.nextLine();
        
        System.out.print("\n Ingresa el peso del peleador: ");
        this.peso = sc.nextDouble();
        sc.nextLine();
        
        this.categoria = obtenerCategoria();
        this.id = contador.incrementAndGet();
        this.victorias = 0;
        this.derrotas = 0;
        this.estado = "Activo";
    }

    //determina categoría según peso
    private int obtenerCategoria() {
        if (this.peso <= 77) {
            return 1; // Welter
        } else if (this.peso <= 93) {
            return 2; // Medio
        } else {
            return 3; // Pesado
        }
    }

    //getters y setters
    public void actualizarEstado(String state) {
        this.estado = state;
    }

    public void setVicorias(int vic) {
        this.victorias = vic;
    }

    public int getVicorias() {
        return this.victorias;
    }

    public void setDerrotas(int der) {
        this.derrotas = der;
    }

    public int getDerrotas() {
        return this.derrotas;
    }

    public int getId() {
        return this.id;
    }

    public void setHistorial(Historial rep) {
        this.historial.add(rep);
    }

    public List<Historial> getHistorial() {
        return this.historial;
    }

    //mostrar historial completo
    public void mostrarHistorial() {
        System.out.println("\n--- Historial de Combates de " + this.nombre + " ---");
        if (this.historial.isEmpty()) {
            System.out.println("No hay combates registrados.");
        } else {
            for (Historial h : this.historial) {
                h.mostrarInfo();
                System.out.println("----------------------------------");
            }
        }
    }

    //mostrar información básica + historial
    public void mostrarInformacion() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Género: " + this.genero);
        System.out.println("Victorias: " + this.victorias);
        System.out.println("Derrotas: " + this.derrotas);
        System.out.println("ID: " + this.id);
        System.out.println("Estado: " + this.estado);
        System.out.println("Categoría: " + this.categoria);
        mostrarHistorial();
    }
}