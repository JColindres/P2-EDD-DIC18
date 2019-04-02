/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl_arbol;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Toshiba
 */
public class arbolAVL {

    public static Node raiz;

    public int obtener_id(String usuario) {
        int suma = 0;
        for (int l = 0; l < usuario.length(); l++) {
            suma += (int) usuario.charAt(l);
        }
        return suma;
    }

    public boolean logear_usuario(int usuario, String contraseña) {
        Node n = raiz;
        while (n != null) {
            if (n.id == usuario && contraseña.equals(n.contraseña)) {

                return true;
            }
            boolean irizq = n.id > usuario;
            n = irizq ? n.izquierda : n.derecha;
        }
        return false;
    }
    
    public Node usuario(int usuario) {
        Node n = raiz;
        while (n != null) {
            if (n.id == usuario) {

                return n;
            }
            boolean irizq = n.id > usuario;
            n = irizq ? n.izquierda : n.derecha;
        }
        return null;
    }

    //-------------------------------------------INGRESAR-----------------------------------------------
    public void ingresar_a_carrito(int usuario, int cantidad, Nodo_productos producto) {

        Node n = raiz;
        //J=raiz;
        while (n != null) {
            if (n.id == usuario) {
                System.out.println("ingresa a meodo");
                /*if(n.carrito_compras==null){
                    n.carrito_compras=new Cola();
                }*/
                n.carrito_compras.encolar(cantidad, producto);

                break;
            }
            boolean irizq = n.id > usuario;
            n = irizq ? n.izquierda : n.derecha;
        }
    }

    public void cargar_carrito(String url, Tabla_ash_productos h) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(url);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                String matriz[] = linea.split(",");
                int suma = 0;
                for (int l = 0; l < matriz[0].length(); l++) {
                    suma += (int) matriz[0].charAt(l);
                }

                Nodo_productos producto = h.recibir_producto(matriz[2]);
                if (producto != null) {
                    ingresar_a_carrito(suma, Integer.parseInt(matriz[1]), producto);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void ingresar_direccion(int usuario, String direccion, int envio, int facturacion) {
        Node n = raiz;
        while (n != null) {
            if (n.id == usuario) {
                n.direcciones.encolar(direccion, envio, facturacion);
            }
            boolean irizq = n.id > usuario;
            n = irizq ? n.izquierda : n.derecha;
        }
    }

    public void cargar_direcciones(String url) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(url);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                String matriz[] = linea.split(",");
                int suma = 0;
                for (int l = 0; l < matriz[0].length(); l++) {
                    suma += (int) matriz[0].charAt(l);
                }
                ingresar_direccion(suma, matriz[1], Integer.parseInt(matriz[2]), Integer.parseInt(matriz[3]));
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

    public void ingresar_productos_comprar(int usuario, int cantidad, Nodo_productos producto) {
        Node n = raiz;
        while (n != null) {
            if (n.id == usuario) {
                System.out.println("ingresa a meodo");
                n.productos_por_comprar.encolar(cantidad, producto);
                break;
            }
            boolean irizq = n.id > usuario;
            n = irizq ? n.izquierda : n.derecha;
        }
    }

    public void cargar_productos_a_comprar(String url, Tabla_ash_productos h) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(url);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String matriz[] = linea.split(",");
                int suma = 0;
                for (int l = 0; l < matriz[0].length(); l++) {
                    suma += (int) matriz[0].charAt(l);
                }

                Nodo_productos producto = h.recibir_producto(matriz[2]);
                if (producto != null) {
                    ingresar_productos_comprar(suma, Integer.parseInt(matriz[1]), producto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //-------------------------------------------GRAFICAR-------------------------------------------------
    public void graficar_carrito(int usuario) {
        Node n = raiz;
        while (n != null) {
            if (n.id == usuario) {
                System.out.println("encuentra al usuario");
                n.carrito_compras.graficar("cola", n.nickname, "Carrito de compra");

                break;
            }
            boolean irizq = n.id > usuario;
            n = irizq ? n.izquierda : n.derecha;
        }
    }

    public void graficar_direcciones_usuario(int usuario) {
        Node n = raiz;
        while (n != null) {
            if (n.id == usuario) {
                n.direcciones.graficar("cola", n.nickname);
            }
            boolean irizq = n.id > usuario;
            n = irizq ? n.izquierda : n.derecha;
        }
    }

    public void graficar_productos_comprar(int usuario) {
        Node n = raiz;
        while (n != null) {
            if (n.id == usuario) {
                n.productos_por_comprar.graficar("cola", n.nickname, "Productos por Comprar");
            }
            boolean irizq = n.id > usuario;
            n = irizq ? n.izquierda : n.derecha;
        }
    }

    //-------------------------------------------ELIMINAR--------------------------------------------------
    public void eliminar_producto_carrito(int usuario, int nodo) {
        Node n = raiz;
        while (n != null) {
            if (n.id == usuario) {
                n.carrito_compras.eliminar(nodo);
            }
            boolean irizq = n.id > usuario;
            n = irizq ? n.izquierda : n.derecha;
        }
    }

    public void eliminar_direccion(int usuario, int nodo) {
        Node n = raiz;
        while (n != null) {
            if (n.id == usuario) {
                n.direcciones.eliminar(nodo);
            }
            boolean irizq = n.id > usuario;
            n = irizq ? n.izquierda : n.derecha;
        }
    }

    public void eliminar_productos_comprar(int usuario, int nodo) {
        Node n = raiz;
        while (n != null) {
            if (n.id == usuario) {
                n.productos_por_comprar.eliminar(nodo);
            }
            boolean irizq = n.id > usuario;
            n = irizq ? n.izquierda : n.derecha;
        }
    }

    //-------------------------------------------EDITAR------------------------------------------------------
    public void editar_carrito(int usuario, int nodo, int cantidad, Nodo_productos producto) {
        Node n = raiz;
        while (n != null) {
            if (n.id == usuario) {
                n.carrito_compras.editar(nodo, cantidad, producto);
            }
            boolean irizq = n.id > usuario;
            n = irizq ? n.izquierda : n.derecha;
        }
    }

    public void editar_direccion(int usuario, int nodo, String direccion, int envio, int facturacion) {
        Node n = raiz;
        while (n != null) {
            if (n.id == usuario) {
                n.direcciones.editar(nodo, direccion, envio, facturacion);
            }
            boolean irizq = n.id > usuario;
            n = irizq ? n.izquierda : n.derecha;
        }
    }

    public void editar_productos_comprar(int usuario, int nodo, int cantidad, Nodo_productos producto) {
        Node n = raiz;
        while (n != null) {
            if (n.id == usuario) {
                n.productos_por_comprar.editar(nodo, cantidad, producto);
            }
            boolean irizq = n.id > usuario;
            n = irizq ? n.izquierda : n.derecha;
        }
    }

    //--------------------------------------------El AVL--------------------------------------------------
    public boolean insertar(int id, String nick, String contraseña) {
        if (raiz == null) {
            raiz = new Node(id, null, nick, contraseña);
            return true;
        }

        Node n = raiz;
        while (true) {
            if (n.id == id) {
                return false;
            }

            Node padre = n;

            boolean irizq = n.id > id;
            n = irizq ? n.izquierda : n.derecha;

            if (n == null) {
                if (irizq) {
                    padre.izquierda = new Node(id, padre, nick, contraseña);
                } else {
                    padre.derecha = new Node(id, padre, nick, contraseña);
                }
                rebalance(padre);
                break;
            }
        }
        return true;
    }

    private void eliminar_nodo(Node node) {
        if (node.izquierda == null && node.derecha == null) {
            if (node.padre == null) {
                raiz = null;
            } else {
                Node padre = node.padre;
                if (padre.izquierda == node) {
                    padre.izquierda = null;
                } else {
                    padre.derecha = null;
                }
                rebalance(padre);
            }
            return;
        }

        if (node.izquierda != null) {
            Node hijo = node.izquierda;
            while (hijo.derecha != null) {
                hijo = hijo.derecha;
            }
            node.id = hijo.id;
            eliminar_nodo(hijo);
        } else {
            Node hijo = node.derecha;
            while (hijo.izquierda != null) {
                hijo = hijo.izquierda;
            }
            node.id = hijo.id;
            eliminar_nodo(hijo);
        }
    }

    public void eliminar(int delKey) {
        if (raiz == null) {
            return;
        }

        Node hijo = raiz;
        while (hijo != null) {
            Node node = hijo;
            hijo = delKey >= node.id ? node.derecha : node.izquierda;
            if (delKey == node.id) {
                eliminar_nodo(node);
                return;
            }
        }
    }

    private void rebalance(Node n) {
        establecer_balance(n);

        if (n.balance == -2) {
            if (altura(n.izquierda.izquierda) >= altura(n.izquierda.derecha)) {
                n = rotar_derecha(n);
            } else {
                n = rotar_izquierda_derecha(n);
            }

        } else if (n.balance == 2) {
            if (altura(n.derecha.derecha) >= altura(n.derecha.izquierda)) {
                n = rotar_izquierda(n);
            } else {
                n = rotar_derecha_izquierda(n);
            }
        }

        if (n.padre != null) {
            rebalance(n.padre);
        } else {
            raiz = n;
        }
    }

    private Node rotar_izquierda(Node a) {

        Node b = a.derecha;
        b.padre = a.padre;

        a.derecha = b.izquierda;

        if (a.derecha != null) {
            a.derecha.padre = a;
        }

        b.izquierda = a;
        a.padre = b;

        if (b.padre != null) {
            if (b.padre.derecha == a) {
                b.padre.derecha = b;
            } else {
                b.padre.izquierda = b;
            }
        }

        establecer_balance(a, b);

        return b;
    }

    private Node rotar_derecha(Node a) {

        Node b = a.izquierda;
        b.padre = a.padre;

        a.izquierda = b.derecha;

        if (a.izquierda != null) {
            a.izquierda.padre = a;
        }

        b.derecha = a;
        a.padre = b;

        if (b.padre != null) {
            if (b.padre.derecha == a) {
                b.padre.derecha = b;
            } else {
                b.padre.izquierda = b;
            }
        }

        establecer_balance(a, b);

        return b;
    }

    private Node rotar_izquierda_derecha(Node n) {
        n.izquierda = rotar_izquierda(n.izquierda);
        return rotar_derecha(n);
    }

    private Node rotar_derecha_izquierda(Node n) {
        n.derecha = rotar_derecha(n.derecha);
        return rotar_izquierda(n);
    }

    private int altura(Node n) {
        if (n == null) {
            return -1;
        }
        return n.altura;
    }

    private void establecer_balance(Node... nodes) {
        for (Node n : nodes) {
            altura2(n);
            n.balance = altura(n.derecha) - altura(n.izquierda);
        }
    }

    public void printBalance() {
        printBalance(raiz);
    }

    private void printBalance(Node n) {
        if (n != null) {
            printBalance(n.izquierda);
            System.out.printf("%s ", n.balance);
            printBalance(n.derecha);
        }
    }

    private void altura2(Node node) {
        if (node != null) {
            node.altura = 1 + Math.max(altura(node.izquierda), altura(node.derecha));
        }
    }

    public String recorrido(Node raiz) {
        String cuerpo = "";

        if (raiz.izquierda != null) {
            cuerpo += "\"" + raiz.id + "\"" + "->" + "\"" + raiz.izquierda.id + "\"\n";
            cuerpo += recorrido2(raiz.izquierda);
        }
        if (raiz.derecha != null) {
            cuerpo += "\"" + raiz.id + "\"" + "->" + "\"" + raiz.derecha.id + "\"\n";
            cuerpo += recorrido2(raiz.derecha);
        }
        return cuerpo;
    }

    public void graficar(String cadena, String cad) {
        System.out.println("es validoad fadf");
        FileWriter fichero = null;
        PrintWriter pw = null;
        String nombre = cad;
        String archivo = "C:\\Users\\pablo\\Desktop\\P2-EDD-DIC18\\Proyecto2_201602713_201612216\\Servidor\\" + nombre + ".dot";
        try {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            pw.println("digraph G {node[shape=ellipse, style=filled]; edge[color=chartreuse3];rankdir=UD \n");
            if (raiz.izquierda == null && raiz.derecha == null) {
                pw.println(raiz.id);
            } else {
                pw.println(cadena);
            }
            pw.println("\n}");
            fichero.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String cmd = "dot -Tpng " + "C:\\Users\\pablo\\Desktop\\P2-EDD-DIC18\\Proyecto2_201602713_201612216\\Servidor\\arbol" + ".dot -o C:\\Users\\pablo\\Desktop\\P2-EDD-DIC18\\Proyecto2_201602713_201612216\\Servidor\\" + cad + ".png"; //Comando de apagado en linux
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public  String recorrido2(Node raiz) {
        String cuerpo = "",ver="";
        
        cuerpo+="Node"+raiz.id+"[label=\""+raiz.id+"\\n"+raiz.nickname+"\\n"+raiz.contraseña+"\"];\n";
        
        
        if(raiz.izquierda!=null){
            cuerpo+= "Node"+raiz.id+" -> Node"+raiz.izquierda.id+"\n";
            cuerpo+=recorrido2(raiz.izquierda);
        }
        
        ver=raiz.direcciones.regresa_cola(raiz.id, "direccion");
        if(!ver.equals("")){
            cuerpo+="Node"+raiz.id+"->"+ver+"\n";
        }
        
        ver=raiz.productos_por_comprar.regresa_cola(raiz.id, "compras");
        if(!ver.equals("")){
            cuerpo+="Node"+raiz.id+"->"+ver+"\n";
        }
        
        ver=raiz.carrito_compras.regresa_cola(raiz.id, "carrito");
        if(!ver.equals("")){
            cuerpo+="Node"+raiz.id+"->"+ver+"\n";
        }
        
        if(raiz.derecha!=null){
            cuerpo+= "Node"+raiz.id+" -> Node"+raiz.derecha.id+"\n";
            cuerpo+=recorrido2(raiz.derecha);
        }
        return cuerpo;
    }
    
    public void cargar_usuarios(String url) {
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
                int suma = 0;
                for (int l = 0; l < matriz[0].length(); l++) {
                    suma += (int) matriz[0].charAt(l);
                }
                boolean aver = insertar(suma, matriz[0], matriz[1]);
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
}
