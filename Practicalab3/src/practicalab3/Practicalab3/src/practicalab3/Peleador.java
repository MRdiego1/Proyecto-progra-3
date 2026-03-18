/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicalab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author 186794
 */
public class Peleador {
    String nombre;
    int edad;
    char genero;
    private int victorias, derrotas;
    private final int id;
    String estado;
    private List<Historial> historial = new ArrayList<>();
    public final int categoria; // 1=welter, 2=medio, 3=pesado
    private double peso;
    private static Scanner sc = new Scanner(System.in);
    // contador para generar id unico
    private static final AtomicInteger contador = new AtomicInteger(0);

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
        this.id = contador.incrementAndGet(); // incrementar el contador y asignar numero como id
        this.victorias = 0;
        this.derrotas = 0;
        this.estado = "Activo";
    }

    private int obtenerCategoria() {
        if (this.peso <= 77) {
            return 1; // Welter
        } else if (this.peso <= 93) {
            return 2; // Medio
        } else {
            return 3; // Pesado
        }
    }

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

    public void mostrarInformacion() {
        System.out.print(this.nombre + "  " + this.genero + "  " + this.victorias + "  " + this.derrotas
                + "  " + this.id + "  " + this.estado);
        System.out.println("Categoria: " + this.categoria);
        mostrarHistorial();

    }
}