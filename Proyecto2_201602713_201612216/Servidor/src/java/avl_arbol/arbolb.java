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
public class arbolb {

    public static pagina raiz;
    pagina pivote;
    int nom = 0;
    int grado;

    public arbolb(int grado) {
        raiz = null;
        this.grado = grado;
    }

    public void insertar(info k) {
        if (raiz == null) {
            raiz = new pagina(grado, true);
            raiz.pagina[0] = k;
            raiz.cantidad = 1;
        } else {
            if (raiz.cantidad == 2 * grado - 1) {
                pagina nuevo = new pagina(grado, false);
                nuevo.hijos[0] = raiz;
                nuevo.split(0, raiz);
                int i = 0;
                if (nuevo.pagina[0].numeroF < k.numeroF) {
                    i++;
                }
                nuevo.hijos[i].insercion(k);
                raiz = nuevo;
            } else {
                raiz.insercion(k);
            }
        }
    }

    public int contar(pagina[] nodo) {
        int cantidad = 0;
        for (int i = 0; i < nodo.length; i++) {
            if (nodo[i] != null) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public void graficar() {
        int j = 0;
        nom = 0;
        pivote = raiz;
        if (pivote == null) {
            System.out.println("Esta vacio");
        } else {
            System.out.print("Nodo" + nom + "[label=\"<P0>");
            for (j = 0; j < pivote.cantidad; j++) {
                if (pivote.pagina[j].numeroF != 0) {
                    System.out.print("|");
                    System.out.print(pivote.pagina[j].numeroF);
                    System.out.print("|<P" + (j + 1) + ">");
                }
            }
            System.out.println("\"];");
            if (j == pivote.cantidad) {
                graficar2(pivote, nom);
            }
        }
    }

    public void graficar2(pagina aux, int nombre) {
        int cont = 0;
        int j = 0;
        int i = contar(aux.hijos);
        nom = nom + 1;
        if (i != 0) {
            for (j = 0; j < aux.cantidad + 1; j++) {
                int L = 0;
                if (aux.hijos[j].hijos != null) {
                    if (L < aux.hijos[j].cantidad) {
                        System.out.print("Nodo" + nom + "[label=\"<P0>");
                        for (cont = 0; cont < aux.hijos[j].cantidad; cont++) {
                            if (aux.hijos[j].pagina[cont].numeroF != 0) {
                                System.out.print("|");
                                System.out.print(aux.hijos[j].pagina[cont].numeroF);
                                System.out.print("|<P" + (cont + 1) + ">");
                            }
                        }
                        System.out.println("\"];");
                        System.out.println("Nodo" + nombre + ":P" + j + "-> Nodo" + nom + ";");
                        graficar2(aux.hijos[j], nom);
                    }
                }
                L++;
            }
        }
    }
}
