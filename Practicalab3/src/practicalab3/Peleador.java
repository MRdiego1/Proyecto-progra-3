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
    private static Scanner sc = new Scanner (System.in);
    //contador para generar id unico
    private static final AtomicInteger contador = new AtomicInteger(0);
    public Peleador(){
        System.out.print("\n Ingresa el nombre del peleador: ");
        this.nombre=sc.nextLine();
        System.out.print("\n Ingresa la edad del peleador: ");
        this.edad=sc.nextInt(); sc.nextLine();
        System.out.print("\n Ingresa el genero del peleador [H or M]: ");
        this.edad=sc.nextInt(); sc.nextLine();
        this.id=contador.incrementAndGet(); //incrementar el contador y asignar numero como id
        this.victorias=0;
        this.derrotas=0;
        this.estado="Activo";
    }
    public void setVicorias(int vic){
        this.victorias=vic;
    }
    public int getVicorias(){
        return this.victorias;
    }
    public void setDerrotas(int der){
        this.derrotas=der;
    }
    public int getDerrotas(){
        return this.derrotas;
    }
    public int getId(){
        return this.id;
    }
    public void setHistorial(Historial rep){
        this.historial.add(rep);
    }
    public List<Historial> getHistorial(){
        return this.historial;
    }
    public void mostrarInformacion(){
        System.out.print(this.nombre+"  "+this.genero+"  "+this.victorias+"  "+this.derrotas
        +"  "+this.id+"  "+this.estado);
        System.out.print("\n"+Historial);
    }
}