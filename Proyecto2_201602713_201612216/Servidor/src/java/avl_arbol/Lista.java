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
    public  Nodo_lista primero=null;
    public  Nodo_lista ultimo=null;
    public  Nodo_lista actual_co=null;
    public  Nodo_lista temps=null,temps2=null;
    public  int indice= 0; 
    
    public  void encolar(String direccion,int envio,int facturacion){
        System.out.println("direccion ingresada: "+direccion);
        if(ultimo==null){
            Nodo_lista nuevo= new Nodo_lista();
            nuevo.indice=indice;
            nuevo.direccion=direccion;
            nuevo.envio= envio;
            nuevo.facturacion=facturacion;
            nuevo.siguiente=null;
            ultimo=nuevo;
            primero=nuevo;
            indice++;
        }else{
            Nodo_lista nuevo= new Nodo_lista();
            nuevo.direccion=direccion;
            nuevo.envio= envio;
            nuevo.facturacion=facturacion;
            ultimo.siguiente=nuevo;
            nuevo.indice =indice;
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
    
    public void editar(int id,String direccion,int envio,int facturacion){
        if(primero!= null){
            temps= primero;
            while(temps!= null){
                if(temps.indice==id){
                    if(!direccion.equals("")){
                        temps.direccion=direccion;
                    }
                    temps.envio=envio;   
                    temps.facturacion=facturacion;
                }
                temps= temps.siguiente;
            }
        }
    }
    
    public void graficar(String cad,String nick){
        System.out.println("graficando");
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
                pw.println("Nodex[color=coral,label= \"Persona: "+nick+"\\nLista \\n Direcciones \"]");
                pw.print("Nodex -> ");
                if(actual_co.siguiente==null){
                    pw.println("Node"+actual_co.indice);
                    pw.println("Node"+actual_co.indice+"[label=\"Dirección: "+actual_co.direccion+"\\n"+"Envio: "+actual_co.envio+"\\n"+"Facturación: "+actual_co.facturacion+"\"];");
                }else{
                //actual_co=actual_co.siguiente;
                    while(actual_co.siguiente != null){
                        pw.println("Node"+actual_co.indice+" -> Node"+actual_co.siguiente.indice);
                        pw.println("Node"+actual_co.indice+"[label=\"Dirección: "+actual_co.direccion+"\\n"+"Envio: "+actual_co.envio+"\\n"+"Facturación: "+actual_co.facturacion+"\"];");
                        
                        actual_co=actual_co.siguiente; 
                    }
                    pw.println("Node"+actual_co.indice+"[label=\"Dirección: "+actual_co.direccion+"\\n"+"Envio: "+actual_co.envio+"\\n"+"Facturación: "+actual_co.facturacion+"\"];");
                }
            }else{
                pw.println("null");
            }
            System.out.println("graficando2");
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
