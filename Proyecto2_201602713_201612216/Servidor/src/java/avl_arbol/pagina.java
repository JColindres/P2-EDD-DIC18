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
public class pagina {

    info pagina[];
    int grado;
    pagina hijos[];
    int cantidad;
    boolean hoja;

    public pagina(int grado, boolean hoja) {
        this.grado = grado;
        this.hoja = hoja;

        pagina = new info[2 * grado - 1];
        hijos = new pagina[2 * grado];

        cantidad = 0;
    }

    public void insertNonFull(info k) {
        int i = cantidad - 1;
        if (hoja == true) {
            while (i >= 0 && pagina[i].numeroF > k.numeroF) {
                pagina[i + 1] = pagina[i];
                i--;
            }
            pagina[i + 1] = k;
            cantidad = cantidad + 1;
        } else {
            while (i >= 0 && pagina[i].numeroF > k.numeroF) {
                i--;
            }
            if (hijos[i + 1].cantidad == 2 * grado - 1) {
                splitChild(i + 1, hijos[i + 1]);
                if (pagina[i + 1].numeroF < k.numeroF) {
                    i++;
                }
            }
            hijos[i + 1].insertNonFull(k);
        }
    }

    public void splitChild(int i, pagina y) {
        pagina z = new pagina(y.grado, y.hoja);
        z.cantidad = grado - 1;
        for (int j = 0; j < grado - 1; j++) {
            z.pagina[j] = y.pagina[j + grado];
        }
        if (y.hoja == false) {
            for (int j = 0; j < grado; j++) {
                z.hijos[j] = y.hijos[j + grado];
            }
        }

        y.cantidad = grado - 1;

        for (int j = cantidad; j >= i + 1; j++) {
            hijos[j + 1] = hijos[j];
        }
        hijos[i + 1] = z;
        for (int j = cantidad - 1; j >= i; j--) {
            pagina[j + 1] = pagina[j];
        }
        pagina[i] = y.pagina[grado - 1];
        cantidad = cantidad + 1;
    }
}
