/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl_arbol;

/**
 *
 * @author Toshiba
 */
public class Nodo_productos {
    public String codigo;
    public String nombre;
    public String marca;
    public double precio;
    public String ruta_imagen;
    
    public Nodo_productos( String codigo,String nombre, String marca, double precio, String ruta_imagen){
        this.codigo= codigo;
        this.nombre=nombre;
        this.marca=marca;
        this.precio=precio;
        this.ruta_imagen=ruta_imagen;
    }
    /*public Nodo_productos( String codigo,String nombre, String marca, double precio, String ruta_imagen){
        this.codigo= codigo;
        this.nombre=nombre;
        this.marca=marca;
        this.precio=precio;
        this.ruta_imagen=ruta_imagen;
    }*/
}
