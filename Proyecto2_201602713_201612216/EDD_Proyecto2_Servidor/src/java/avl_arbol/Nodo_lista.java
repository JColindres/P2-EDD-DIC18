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
public class Nodo_lista {
    public int indice;
    public String direccion;
    public int facturacion;
    public int envio;
    public Nodo_lista siguiente;
    //apuntador a nodo hash
    
    public Nodo_lista(){
        this.indice=0;
        this.direccion="";
        this.facturacion=0;
        this.envio=0;
        this.siguiente=null;
    }
}
