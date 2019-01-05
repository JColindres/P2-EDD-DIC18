/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl_arbol;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Toshiba
 */
public class AVL_arbol {

    /**
     * @param args the command line arguments
     */
    public static AVLtree tree = new AVLtree();
    public static Cola cola = new Cola();
    public static Tabla_ash_productos h = new Tabla_ash_productos(10);

    public static void main(String[] args) {
        int op, valor = 0;
        Scanner sc = new Scanner(System.in);
        //System.out.println(12341254623/23); 
        do {
            System.out.println("------Menú------");
            System.out.println("1.AVL");
            System.out.println("2.Cola");
            System.out.println("3.Tabla Hash");
            System.out.println("4.Salir\n\n");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    menu_avl();
                    break;
                case 2:
                    menu_cola();
                    break;
                case 3:
                    menu_tablahash();
                    break;

            }
        } while (op != 4);

    }

    public static void menu_avl() {
        int op = 3, valor = 0;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("------AVL------");
            System.out.println("1.Insertar");
            System.out.println("2.Eliminar");
            System.out.println("3.Graficar");
            System.out.println("4.cargar");
            System.out.println("5.Salir\n\n");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Ingrese id");
                    valor = sc.nextInt();
                    boolean h = tree.insertar(valor, "juan", "contraseña");
                    if (h) {
                        System.out.println("Agregado correctamente");
                    } else {
                        System.out.println("Este usuario ya existe");
                    }
                    tree.graficar(tree.recorrido(tree.raiz), "arbol");
                    break;
                case 2:
                    System.out.println("Ingrese id");
                    valor = sc.nextInt();
                    tree.eliminar(valor);
                    break;
                case 3:
                    tree.graficar(tree.recorrido(tree.raiz), "arbol");
                    break;

                case 4:
                    cargar_usuarios();
                    // tree.graficar();
                    break;

            }
        } while (op != 5);

    }

    public static void menu_tablahash() {
        int op = 3, valor = 0;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("------Tabla Hash------");
            System.out.println("1.Insertar");
            System.out.println("2.Eliminar");
            System.out.println("3.Graficar");
            System.out.println("4.cargar");
            System.out.println("5.Salir\n\n");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    //System.out.println("Ingrese id");
                    //valor= sc.nextInt();
                    h.funcionHash("4345", "arroz", "zully", 5.0, "imagen1");
                    /*h.funcionHash("4345","frijol","delmonte",15.0,"imagen2");
                    h.funcionHash("4345","audifonos","bose",2000.0,"imagen3");
                    h.funcionHash("4345","reloj","lacoste",500.0,"imagen4");
                    h.funcionHash("4345","Celular","Samsung",5000.0,"imagen5");*/
                    h.funcionHash("21521", "frijol", "delmonte", 15.0, "imagen2");
                    h.funcionHash("434571", "audifonos", "bose", 2000.0, "imagen3");
                    h.funcionHash("89981212", "reloj", "lacoste", 500.0, "imagen4");
                    h.funcionHash("2", "Celular", "Samsung", 5000.0, "imagen5");
                    h.funcionHash("6", "usb", "kingston", 150.0, "imagen6");
                    h.funcionHash("7", "lampara", "maglite", 250.0, "imagen7");
                    //h.funcionHash("5","calculadora","casio",115.0,"imagen8");
                    break;
                case 2:
                    System.out.println("Ingrese id");
                    valor = sc.nextInt();
                    tree.eliminar(valor);
                    break;
                case 3:
                    h.graficar();
                    break;

                case 4:
                    System.out.println("Ingrese id");
                    valor = sc.nextInt();
                    System.out.println(h.buscar_en_hash(String.valueOf(valor)));
                    break;

            }
        } while (op != 5);
    }

    public static void menu_cola() {
        int op = 0, num = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("----Cola-----");
            System.out.println("1.Encolar");
            System.out.println("2.Desencolar");
            System.out.println("3.Graficar");
            System.out.println("4.Salir");

            op = sc.nextInt();

            switch (op) {
                case 1:
                    //System.out.println("Ingrese cantidad del nodo: ");
                    //num=sc.nextInt();
                    //cola.encolar(num);
                    //cola.graficar("cola");
                    //cola.recorrer();
                    arbolb ab = new arbolb(3);
                    info valor = new info(1, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(2, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(3, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(4, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(5, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(6, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(7, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(8, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(9, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(10, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(11, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(12, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(13, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(14, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(15, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(16, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(17, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(18, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(19, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(20, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(21, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(22, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(23, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(24, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(25, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(26, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(27, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(28, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(29, "05/01/19", 100);
                    ab.insertar(valor);
                    valor = new info(30, "05/01/19", 100);
                    ab.insertar(valor);
                    ab.graficar();
                    break;

                case 2:
                    System.out.println("Ingrese cantidad del nodo: ");
                    num = sc.nextInt();
                    cola.eliminar(num);
                    cola.graficar("cola");
                    //recorrer();
                    break;

                case 3:
                    //System.out.println("Primer valor: "+primero.id);
                    break;

                default:
                    break;

            }

        } while (op != 4);
    }

    public static void cargar_usuarios() {
        /*String rutatotal="";
        FileDialog dialogoArchivo;
        String nombreArchivo="";String Tcapa="";
        dialogoArchivo = new FileDialog(this, "Lista de Archivos desde Frame",FileDialog.LOAD);
        dialogoArchivo.setVisible(true);
            if(dialogoArchivo.getFile()!=null){ // Validar que se haya Seleccionado un Archivo
                String directorio = dialogoArchivo.getDirectory();
                nombreArchivo =dialogoArchivo.getFile(); 
                rutatotal = directorio + nombreArchivo;
            }
            else
                System.out.println("No Seleccionó Archivo");
         */

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("usuarios1.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                String matriz[] = linea.split(",");
                int suma = 0;
                for (int l = 0; l < matriz[0].length(); l++) {
                    suma += (int) matriz[0].charAt(l);
                }
                boolean aver = tree.insertar(suma, matriz[0], matriz[1]);
                if (aver) {
                    System.out.println("Nodo ingresado correctamente");
                } else {
                    System.out.println("Este nick ya existe");
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

    public void cargar_direcciones() {

    }

}
