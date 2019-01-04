/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl_arbol;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Toshiba
 */
public class Lista {

    public static Nodo_lista primero = null;
    public static Nodo_lista ultimo = null;
    public static Nodo_lista actual_co = null;
    public static Nodo_lista temps = null, temps2 = null;
    public static int indice = 0;

    public static void encolar(String direccion, int envio, int facturacion) {
        if (ultimo == null) {
            Nodo_lista nuevo = new Nodo_lista();
            nuevo.indice = indice;
            nuevo.direccion = direccion;
            nuevo.envio = envio;
            nuevo.facturacion = facturacion;
            nuevo.siguiente = null;
            ultimo = nuevo;
            primero = nuevo;
            indice++;
        } else {
            Nodo_lista nuevo = new Nodo_lista();
            ultimo.siguiente = nuevo;
            nuevo.indice = indice;
            ultimo = nuevo;
            indice++;
        }
    }

    public static void eliminar(int id) {
        if (primero != null) {
            temps = primero;
            temps2 = primero;
            //int id;
            boolean encontrado = false, activado = false;
            //System.out.println("Ingrese el id del nodo a Eliminar: ");
            //cin>>id;cout<<endl;
            if (temps.indice == id && temps.siguiente == null) {
                primero = null;
                ultimo = null;
                temps.siguiente = null;
                encontrado = true;
            } else {
                do {
                    if (temps.indice == id) {
                        if (temps == primero) {
                            primero = temps.siguiente;
                            //ultimo.siguiente=primeros;
                            //free(temps);
                        } else if (temps == ultimo) {
                            //cout<<"Si entra aca ";
                            ultimo = temps2;
                            temps2.siguiente = null;
                            temps = null;
                            //temps->siguiente=NULL;
                            //free(temps);
                        } else {
                            temps2.siguiente = temps.siguiente;
                            temps.siguiente = null;
                            //free(temps);
                        }
                        encontrado = true;
                        break;
                    }
                    temps2 = temps2.siguiente;
                    if (!activado) {
                        temps2 = primero;
                        activado = true;
                    }
                    temps = temps.siguiente;
                } while (temps != null);
            }
            if (!encontrado) {
                System.out.println("No se encontraron coincidencias");
            }
        } else {
            System.out.println("La Lista Circular se encuentra vacía");
        }
    }

    public void graficar(String cad) {
        //System.out.println("es validoad fadf");
        FileWriter fichero = null;
        PrintWriter pw = null;
        String nombre = cad;
        //String archivo = nombre + ".txt";
        String archivo = nombre + ".dot";
        try {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            pw.println("digraph G {node[shape=ellipse, style=filled]; edge[color=chartreuse3];rankdir=UD \n");
            if (primero != null) {
                actual_co = primero;
                if (actual_co.siguiente == null) {
                    pw.print("\"" + actual_co.indice + "." + actual_co.envio + "\"");
                }
                //actual_co=actual_co.siguiente;
                while (actual_co.siguiente != null) {
                    pw.println("\"" + actual_co.indice + "." + actual_co.envio + "\" ->  \"" + actual_co.siguiente.indice + "." + actual_co.siguiente.envio + "\"");
                    actual_co = actual_co.siguiente;
                }
            } else {
                pw.println("null");
            }
            pw.println("\n}");
            fichero.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String cmd = "dot -Tpng " + nombre + ".dot -o " + nombre + ".png"; //Comando de apagado en linux
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
