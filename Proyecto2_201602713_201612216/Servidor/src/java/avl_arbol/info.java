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
    AVLtree usuario;

    public info(int numeroF, String fecha, int total) {
        this.numeroF = numeroF;
        this.fecha = fecha;
        this.total = total;
        this.usuario = null;
    }

    public info() {

    }
}
