/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl_arbol;

/**
 *
 * @author pablo
 */
public class info {

    int numeroF;
    String fecha;
    int total;
    Node usuario;
    Nodo_cola detalle;

    public info(int numeroF, String fecha, int total, Node usuario) {
        this.numeroF = numeroF;
        this.fecha = fecha;
        this.total = total;
        this.usuario = usuario;
        detalle = null;
    }

    public info() {

    }
}
