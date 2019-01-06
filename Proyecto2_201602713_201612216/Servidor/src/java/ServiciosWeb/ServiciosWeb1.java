/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosWeb;

import avl_arbol.AVLtree;
import avl_arbol.Tabla_ash_productos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author pablo
 */
@WebService(serviceName = "WebService")
public class ServiciosWeb1 {

    AVLtree avl = new AVLtree();
    Tabla_ash_productos h = new Tabla_ash_productos(10);

    @WebMethod(operationName = "Cargar_Usuarios")
    public boolean Cargar_Usuarios(@WebParam(name = "url") String url) {
        avl.cargar_usuarios(url);
        return true;
    }
    
    @WebMethod(operationName = "Cargar_Direcciones")
    public boolean Cargar_Direcciones(@WebParam(name = "url") String url) {
        avl.cargar_direcciones(url);
        return true;
    }
    
    @WebMethod(operationName = "Cargar_Productos")
    public boolean Cargar_Productos(@WebParam(name = "url") String url) {
        h.cargar_productos(url);
        return true;
    }
    
    @WebMethod(operationName = "Cargar_PorComprar")
    public boolean Cargar_PorComprar(@WebParam(name = "url") String url) {
        avl.cargar_productos_a_comprar(url, h);
        return true;
    }

    @WebMethod(operationName = "Cargar_Carrito")
    public boolean Cargar_Carrito(@WebParam(name = "url") String url) {
        avl.cargar_carrito(url, h);
        return true;
    }
    
    @WebMethod(operationName = "Graficar_Usu")
    public boolean Graficar_Usu() {
        avl.graficar(avl.recorrido2(avl.raiz), "arbol");
        return true;
    }
    
    @WebMethod(operationName = "Graficar_Prod")
    public boolean Graficar_Prod() {
        h.graficar();
        return true;
    }
    
    @WebMethod(operationName = "InicioSesion")
    public boolean InicioSesion(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass) {
        int id = avl.obtener_id(user);
        return avl.logear_usuario(id, pass);
    }
}
