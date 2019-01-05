/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl_arbol;

/**
 *
 * @author Familia Corona
 */
public class pagina {

    pagina padre;
    info pagina[];
    pagina hijos[];
    int cantidad;

    public pagina() {
        padre = null;
        pagina = new info[5];
        hijos = new pagina[6];
        cantidad = 0;
        for (int i = 0; i < 5; i++) {
            pagina[i] = new info();
        }
    }
}
