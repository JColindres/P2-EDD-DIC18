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
public class Cola {
    public  Nodo_cola primero=null;
    public  Nodo_cola ultimo=null;
    public  Nodo_cola actual_co=null;
    public  Nodo_cola temps=null,temps2=null;
    public  int indice= 0; 
    
    public  void encolar(int cantidad,Nodo_productos producto){
        System.out.println("a encolar");
        if(ultimo==null){
            Nodo_cola nuevo= new Nodo_cola();
            nuevo.cantidad=cantidad;
            nuevo.producto=producto;
            nuevo.indice=indice;
            nuevo.siguiente=null;
            
            ultimo=nuevo;
            primero=nuevo;
            indice++;
        }else{
            Nodo_cola nuevo= new Nodo_cola();
            ultimo.siguiente=nuevo;
            nuevo.indice =indice;
            nuevo.cantidad = cantidad;
            nuevo.producto=producto;
            ultimo=nuevo;
            indice++;
        }
    }
    
    public  void eliminar(int id){
        if(primero!=null){
            temps=primero;
            temps2=primero;
            //int id;
            boolean encontrado=false,activado=false;
            //System.out.println("Ingrese el id del nodo a Eliminar: ");
            //cin>>id;cout<<endl;
            if(temps.indice==id && temps.siguiente==null){
                primero=null;
                ultimo=null;
                temps.siguiente=null;
                encontrado=true;
            }else{
                do{
                    if(temps.indice==id){
                        if(temps==primero){
                            primero=temps.siguiente;
                            //ultimo.siguiente=primeros;
                            //free(temps);
                        }else if(temps==ultimo){
                            //cout<<"Si entra aca ";
                            ultimo=temps2;
                            temps2.siguiente=null;
                            temps=null;
                            //temps->siguiente=NULL;
                            //free(temps);
                        }else{
                            temps2.siguiente=temps.siguiente;
                            temps.siguiente=null;
                            //free(temps);
                        }
                        encontrado=true;
                        break;
                    }
                    temps2=temps2.siguiente;
                    if(!activado){
                        temps2=primero;
                        activado=true;
                    }
                    temps=temps.siguiente;
                }while(temps!=null);
            }
            if(!encontrado){
                System.out.println("No se encontraron coincidencias");
            }
        }else{
            System.out.println("La Lista Circular se encuentra vacía");
        }
    }
    
    public void editar(int id , int cantidad, Nodo_productos producto){
        if(primero!= null){
            temps= primero;
            while(temps!= null){
                if(temps.indice==id){
                    if(cantidad!=0){
                        temps.cantidad=cantidad;
                    }
                    if(producto!= null){
                        temps.producto=producto;
                    }
                }
                temps= temps.siguiente;
            }
        }
    }
    
    public  void graficar(String cad,String nick,String accion){
        //System.out.println("es validoad fadf");
        FileWriter fichero = null;
        PrintWriter pw = null;
        String nombre = cad;
        //String archivo = nombre + ".txt";
        String archivo = "C:\\Users\\Toshiba\\Documents\\NetBeansProjects\\AVL_arbol\\"+nombre + ".dot";
        try {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            pw.println("digraph G {node[shape=ellipse, style=filled]; edge[color=chartreuse3];rankdir=UD \n");
            if(primero !=null){
                actual_co=primero;
                pw.println("Nodex[color=coral,label=\"Persona: "+nick+"\\nCola\\n"+accion+"\"]");
                pw.print("Nodex -> ");
                if(actual_co.siguiente==null){
                    pw.println("Node"+actual_co.indice);
                    pw.println("Node"+actual_co.indice+"[label=\"Cantidad: "+actual_co.cantidad+"\\n"+"Producto: "+actual_co.producto.nombre+"\"];");         
                }else{
                    while(actual_co.siguiente != null){
                        pw.println("Node"+actual_co.indice+" -> "+"Node"+actual_co.siguiente.indice);
                        pw.println("Node"+actual_co.indice+"[label=\"Cantidad: "+actual_co.cantidad+"\\n"+"Producto: "+actual_co.producto.nombre+"\"];");
                        actual_co=actual_co.siguiente; 
                    }
                    pw.println("Node"+actual_co.indice+"[label=\"Cantidad: "+actual_co.cantidad+"\\n"+"Producto: "+actual_co.producto.nombre+"\"];");
                }
            }else{
                pw.println("null");
            }
            pw.println("\n}");
            fichero.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String cmd = "dot -Tpng " + "C:\\Users\\Toshiba\\Documents\\NetBeansProjects\\AVL_arbol\\"+nombre+ ".dot -o " +"C:\\Users\\Toshiba\\Documents\\NetBeansProjects\\AVL_arbol\\"+ nombre + ".png"; //Comando de apagado en linux
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
    
}
