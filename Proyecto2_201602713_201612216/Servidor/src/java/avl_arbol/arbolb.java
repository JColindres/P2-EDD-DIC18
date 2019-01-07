/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl_arbol;

import static avl_arbol.AVLtree.raiz;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author pablo
 */
public class arbolb {

    pagina raiz;
    int contador;

    static String c = "";

    public arbolb() {
        contador = 0;
        raiz = null;
    }

    public boolean insertar(info dato) {
        pagina pivote;
        pivote = raiz;
        int bandera = 0;
        if (pivote == null) {
            contador++;
            raiz = new pagina();
            raiz.id = contador;
            raiz.pagina[raiz.cantidad] = dato;
            raiz.cantidad++;
            return true;
        } else {
            while (contar(pivote.hijos) != 0) {
                if (pivote.cantidad == 5) {
                    ordenar(pivote.pagina, pivote.cantidad);
                    pivote = split(pivote);
                }
                if (pivote.cantidad == 1) {
                    if (dato.numeroF == pivote.pagina[0].numeroF) {
                        return false;
                    } else if (dato.numeroF > pivote.pagina[0].numeroF) {
                        bandera = 1;
                    } else {
                        bandera = 0;
                    }
                } else {
                    if (dato.numeroF < pivote.pagina[0].numeroF) {
                        bandera = 0;
                    } else {
                        for (bandera = 0; bandera < pivote.cantidad; bandera++) {
                            if (dato.numeroF > pivote.pagina[bandera].numeroF && dato.numeroF < pivote.pagina[bandera + 1].numeroF) {
                                bandera++;
                                break;
                            } else if (dato.numeroF == pivote.pagina[bandera].numeroF) {
                                return false;
                            }
                        }
                    }
                }
                pivote = pivote.hijos[bandera];
            }
            if (pivote.cantidad == 5) {
                ordenar(pivote.pagina, pivote.cantidad);
                pivote = split(pivote);
            }
        }
        for (int z = 0; z < pivote.cantidad; z++) {
            if (pivote.pagina[z].numeroF == dato.numeroF) {
                return false;
            }
        }
        pivote.pagina[pivote.cantidad] = dato;
        pivote.cantidad++;
        ordenar(pivote.pagina, pivote.cantidad);
        if (pivote.cantidad == 5) {
            split(pivote);
        }
        return true;
    }

    public void ordenar(info pagina[], int cantidad) {
        info aux;
        for (int i = 0; i < cantidad; i++) {
            for (int j = 1; j < cantidad - i; j++) {
                if (pagina[j - 1].numeroF > pagina[j].numeroF) {
                    aux = pagina[j - 1];
                    pagina[j - 1] = pagina[j];
                    pagina[j] = aux;
                }
            }
        }
    }

    public pagina split(pagina pagina) {
        if (pagina.padre == null) {
            info centro = pagina.pagina[2];
            pagina.pagina[2] = new info();
            pagina.cantidad--;
            contador++;
            pagina padre = new pagina();
            padre.id = contador;
            contador++;
            pagina hijo = new pagina();
            hijo.id = contador;
            for (int i = 3; i < 5; i++) {
                hijo.pagina[i - 3] = pagina.pagina[i];
                if (pagina.hijos[i] != null) {
                    pagina.hijos[i].padre = hijo;
                    hijo.hijos[i - 3] = pagina.hijos[i];
                }
                hijo.cantidad++;
                pagina.pagina[i] = new info();
                pagina.cantidad--;
            }
            if (pagina.hijos[5] != null) {
                pagina.hijos[5].padre = hijo;
                hijo.hijos[2] = pagina.hijos[5];
            }
            for (int i = 3; i < 6; i++) {
                pagina.hijos[i] = null;
            }
            padre.pagina[0] = centro;
            padre.cantidad++;
            pagina.padre = padre;
            hijo.padre = padre;
            padre.hijos[0] = pagina;
            padre.hijos[1] = hijo;
            raiz = padre;
            return hijo;
        } else {
            info centro = pagina.pagina[2];
            pagina.pagina[2] = new info();
            pagina.cantidad--;
            contador++;
            pagina hijo = new pagina();
            hijo.id = contador;
            for (int i = 3; i < 5; i++) {
                hijo.pagina[i - 3] = pagina.pagina[i];
                if (pagina.hijos[i] != null) {
                    pagina.hijos[i].padre = hijo;
                    hijo.hijos[i - 3] = pagina.hijos[i];
                }
                hijo.cantidad++;
                pagina.pagina[i] = new info();
                pagina.cantidad--;
            }
            if (pagina.hijos[5] != null) {
                pagina.hijos[5].padre = hijo;
                hijo.hijos[2] = pagina.hijos[5];
            }
            for (int i = 3; i < 6; i++) {
                pagina.hijos[i] = null;
            }
            pagina.padre.pagina[pagina.padre.cantidad] = centro;
            pagina.padre.cantidad++;
            ordenar(pagina.padre.pagina, pagina.padre.cantidad);
            int cantidadhijos = contar(pagina.padre.hijos);
            pagina.padre.hijos[cantidadhijos] = hijo;
            hijo.padre = pagina.padre;
            if (pagina.padre.cantidad == 5) {
                split(pagina.padre);
            }
            return hijo;
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
        FileWriter fichero = null;
        PrintWriter pw = null;
        String archivo = "C:\\Users\\pablo\\Desktop\\P2-EDD-DIC18\\Proyecto2_201602713_201612216\\Servidor\\arbolb.dot";
        try {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            pw.println("digraph G {node[shape=record, style=filled]; edge[color=chartreuse3];\n");

            int j = 0;
            contador = 0;
            pagina pivote = raiz;
            c = "";
            if (pivote == null) {
                System.out.println("Esta vacio");
            } else {
                pw.print("Nodo" + contador + "[label=\"<P0>");
                for (j = 0; j < pivote.cantidad; j++) {
                    if (pivote.pagina[j].numeroF != 0) {
                        pw.print("|");
                        pw.print("<" + pivote.pagina[j].numeroF + ">" + pivote.pagina[j].numeroF);
                        pw.print("|<P" + (j + 1) + ">");
                    }
                }
                pw.println("\"];");
                for (j = 0; j < pivote.cantidad; j++) {
                    if (pivote.pagina[j].numeroF != 0 && pivote.pagina[j].detalle != null) {
                        Cola z = new Cola();
                        z.primero = pivote.pagina[j].detalle;
                        pw.println("Nodo" + contador + ":" + pivote.pagina[j].numeroF + "->" + z.regresa_cola(pivote.pagina[j].detalle.indice, "" + pivote.pagina[j].numeroF) + "\n");
                    }
                }
                if (j == pivote.cantidad) {
                    graficar2(pivote, contador);
                    pw.println(c);
                }
            }
            pw.println("\n}");
            fichero.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String cmd = "dot -Tpng " + "C:\\Users\\pablo\\Desktop\\P2-EDD-DIC18\\Proyecto2_201602713_201612216\\Servidor\\arbolb" + ".dot -o C:\\Users\\pablo\\Desktop\\P2-EDD-DIC18\\Proyecto2_201602713_201612216\\Servidor\\arbolb.png"; //Comando de apagado en linux
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void graficar2(pagina aux, int nombre) {
        int cont = 0;
        int j = 0;
        int i = contar(aux.hijos);
        contador = contador + 1;
        //this.c = c;
        if (i != 0) {
            for (j = 0; j < aux.cantidad + 1; j++) {
                //int L = 0;
                if (aux.hijos[j].hijos != null) {
                    //if (L < aux.hijos[j].cantidad) {
                    c = c + ("Nodo" + contador + "[label=\"<P0>");
                    for (cont = 0; cont < aux.hijos[j].cantidad + 1; cont++) {
                        if (aux.hijos[j].pagina[cont].numeroF != 0) {
                            c = c + ("|");
                            c = c + ("<" + aux.hijos[j].pagina[cont].numeroF + ">" + aux.hijos[j].pagina[cont].numeroF);
                            c = c + ("|<P" + (cont + 1) + ">");
                        }
                    }
                    c = c + ("\"];\n");
                    c = c + ("Nodo" + nombre + ":P" + j + "-> Nodo" + contador + ";\n");
                    for (cont = 0; cont < aux.hijos[j].cantidad + 1; cont++) {
                        if (aux.hijos[j].pagina[cont].numeroF != 0 && aux.hijos[j].pagina[cont].detalle != null) {
                            Cola z = new Cola();
                            z.primero = aux.hijos[j].pagina[cont].detalle;
                            c = c + "Nodo" + contador + ":" + aux.hijos[j].pagina[cont].numeroF + "->" + z.regresa_cola(aux.hijos[j].pagina[cont].detalle.indice, "" + aux.hijos[j].pagina[cont].numeroF) + "\n";
                        }
                    }
                    graficar2(aux.hijos[j], contador);
                    //}
                }
                //L++;
            }
        }
    }

    public void cargar_ventas(String url, AVLtree je) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(url);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                String matriz[] = linea.split(",");
                int id = je.obtener_id(matriz[3]);
                info valor = new info(Integer.parseInt(matriz[0]), matriz[1], Integer.parseInt(matriz[2]), je.usuario(id));
                boolean aver = insertar(valor);
                if (aver) {
                    System.out.println("Venta ingresado correctamente");
                } else {
                    System.out.println("No se pudo ingresar venta");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean detalle(int factura, int cantidad, double precio, String producto, Tabla_ash_productos je) {
        pagina pivote = raiz;
        for (int i = 0; i < pivote.cantidad; i++) {
            if (pivote == null) {
                return false;
            }
            if (factura < pivote.pagina[i].numeroF && i == 0) {
                pivote = pivote.hijos[0];
                if (pivote.hijos[0] == null) {
                    return false;
                }
                i = -1;
            } else if (factura > pivote.pagina[i].numeroF && i == pivote.cantidad - 1) {
                if (pivote.hijos[0] == null) {
                    return false;
                }
                pivote = pivote.hijos[contar(pivote.hijos) - 1];
                i = -1;
            } else if (factura < pivote.pagina[i].numeroF) {
                if (pivote.hijos[0] == null) {
                    return false;
                }
                pivote = pivote.hijos[i];
                i = -1;
            } else if (factura == pivote.pagina[i].numeroF) {
                Cola c = new Cola();
                Nodo_productos produ = je.recibir_producto(producto);
                if (produ != null) {
                    produ.precio = produ.precio * cantidad;
                    c.encolar(cantidad, produ);
                    pivote.pagina[i].detalle = c.primero;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void cargar_detalle(String url, Tabla_ash_productos je) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(url);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                String matriz[] = linea.split(",");
                boolean aver = detalle(Integer.parseInt(matriz[0]), Integer.parseInt(matriz[1]), Double.parseDouble(matriz[2]), matriz[3], je);
                if (aver) {
                    System.out.println("Detalle ingresado correctamente");
                } else {
                    System.out.println("No se pudo ingresar detalle");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
