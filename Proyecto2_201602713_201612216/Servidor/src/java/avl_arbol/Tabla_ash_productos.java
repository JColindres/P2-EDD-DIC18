/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl_arbol;

import static avl_arbol.AVLtree.raiz;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Toshiba
 */
public class Tabla_ash_productos {

    public static Nodo_productos[] tabla_de_productos;
    public static double porcentaje = 0.8, contador = 0.0, tamanio = 0.0;
    //public static int tamanio=0;

    public Tabla_ash_productos(int tam) {
        tamanio = tam;
        tabla_de_productos = new Nodo_productos[tam];
        for (int n = 0; n < tam; n++) {
            tabla_de_productos[n] = new Nodo_productos("-1", "", "", 0.0, "");
            //tabla_de_productos[n].codigo="-1";
        }
    }

    public static void inicializar(int tam) {
        tamanio = tam;
        tabla_de_productos = new Nodo_productos[tam];
        for (int n = 0; n < tam; n++) {
            tabla_de_productos[n] = new Nodo_productos("-1", "", "", 0.0, "");
            //tabla_de_productos[n].codigo="-1";
        }
    }

    public static void funcionHash(String codigo, String nombre, String marca, double precio, String ruta) {
        int num1 = codigo.length() % 2;
        int num_demas = 0;
        int suma = 0;
        if (num1 == 0) {
            int inicio = 0;
            for (int n = 2; n < codigo.length() + 1; n = n + 2) {
                suma += Integer.parseInt(codigo.substring(inicio, n));
                inicio = n;
            }
        } else {
            int inicio = 0;
            for (int n = 2; n < codigo.length() + 1; n = n + 2) {
                suma += Integer.parseInt(codigo.substring(inicio, n));
                inicio = n;
            }
            suma += Integer.parseInt(codigo.substring(codigo.length() - 1, codigo.length()));
        }
        System.out.println("La suma es: " + suma);
        int llave = (suma) % (int) tamanio;
        System.out.println("el indice es: " + llave);
        int k = 0;
        int clave = llave;
        boolean hacer = true;
        while (!tabla_de_productos[llave].codigo.equals("-1") && !(llave > tamanio)) {
            System.out.println("Ocurrión una colisión con: " + tabla_de_productos[llave].codigo);
            k++;
            llave = (llave + (k * k)) % (int) tamanio;
            System.out.println("nueva llave: " + llave);
            if (clave == llave) {
                rehashing();
                hacer = false;
                funcionHash(codigo, nombre, marca, precio, ruta);
                System.out.println("Se realizo rehashing ya que se ha ocupado los modulos de la cuadratica");
                break;
            }
            //break;
        }
        if (hacer) {
            tabla_de_productos[llave].codigo = codigo;
            tabla_de_productos[llave].precio = precio;
            tabla_de_productos[llave].nombre = nombre;
            tabla_de_productos[llave].marca = marca;
            tabla_de_productos[llave].ruta_imagen = ruta;
        }
        contador++;
        System.out.println("porcentaje de utilidad: " + porcentaje_utilidad());
        if (porcentaje_utilidad() >= porcentaje) {
            contador = 0;
            rehashing();
        }
    }

    public static String buscar_en_hash(String codigo) {
        int num1 = codigo.length() % 2;
        int suma = 0;
        if (num1 == 0) {
            int inicio = 0;
            for (int n = 2; n < codigo.length() + 1; n = n + 2) {
                suma += Integer.parseInt(codigo.substring(inicio, n));
                inicio = n;
            }
        } else {
            int inicio = 0;
            for (int n = 2; n < codigo.length() + 1; n = n + 2) {
                suma += Integer.parseInt(codigo.substring(inicio, n));
                inicio = n;
            }
            suma += Integer.parseInt(codigo.substring(codigo.length() - 1, codigo.length()));
        }
        int llave = (suma) % (int) tamanio;
        int k = 0;
        int clave = llave;
        boolean hacer = true;

        while (!tabla_de_productos[llave].codigo.equals("-1") && !(llave > tamanio)) {
            if (tabla_de_productos[llave].codigo.equals(codigo)) {
                return tabla_de_productos[llave].codigo + "," + tabla_de_productos[llave].nombre + "," + tabla_de_productos[llave].marca + "," + tabla_de_productos[llave].precio;
            }
            k++;
            llave = (llave + (k * k)) % (int) tamanio;

            if (clave == llave) {
                return "no se encontro";
            }
        }
        return "no se encontro";
    }

    public static double porcentaje_utilidad() {
        return contador / tamanio;
    }

    public void recorrer() {
        for (int l = 0; l < tamanio; l++) {
            System.out.print(tabla_de_productos[l].codigo + ",");

        }
    }

    public static void graficar() {
        System.out.println("es validoad fadf");
        FileWriter fichero = null;
        PrintWriter pw = null;
        //String archivo = nombre + ".txt";
        String archivo = "hash.dot";
        try {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            pw.println("digraph G {");
            pw.println("nodesep=.05;");
            pw.println("rankdir=LR;");
            pw.println("node [shape=record,width=.1,height=.1];");
            pw.print("node0 [label =\"");
            for (int j = 0; j < tamanio; j++) {
                pw.print("<f" + j + ">" + j);
                if ((tamanio - j) != 1) {
                    pw.print("|");
                }
            }
            pw.println("\",height=3.5];");
            pw.println("node [width = 1.5];");

            for (int j = 0; j < tamanio; j++) {
                if (!tabla_de_productos[j].codigo.equals("-1")) {
                    pw.println("node" + j + "[label = \"{<n> " + tabla_de_productos[j].codigo + "|" + tabla_de_productos[j].nombre + "|" + tabla_de_productos[j].marca + "|" + tabla_de_productos[j].precio + "|" + tabla_de_productos[j].ruta_imagen + "}\"];");
                }
            }
            for (int j = 0; j < tamanio; j++) {
                if (!tabla_de_productos[j].codigo.equals("-1")) {
                    pw.println("node0:f" + j + " -> node" + j + ":n;");
                }
            }

            pw.println("\n}");
            fichero.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String cmd = "dot -Tpng " + "hash" + ".dot -o " + "hash" + ".png"; //Comando de apagado en linux
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static void rehashing() {
        Nodo_productos[] temp = tabla_de_productos;
        tamanio = 2 * tamanio;
        inicializar((int) tamanio);

        for (int n = 0; n < temp.length; n++) {
            if (!temp[n].codigo.equals("-1")) {
                funcionHash(temp[n].codigo, temp[n].nombre, temp[n].marca, temp[n].precio, temp[n].ruta_imagen);
            }
        }

    }
}
