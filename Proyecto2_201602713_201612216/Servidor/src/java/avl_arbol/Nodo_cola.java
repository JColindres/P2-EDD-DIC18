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
public class Nodo_cola {
    public int indice;
    public int cantidad;
    public Nodo_cola siguiente;
    Nodo_productos producto;
    //apuntador a nodo hash
    
    public Nodo_cola(){
        this.indice=0;
        this.cantidad=0;
        this.siguiente=null;
    }
}
