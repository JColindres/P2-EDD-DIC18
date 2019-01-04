/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosWeb;

import avl_arbol.AVLtree;
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

    @WebMethod(operationName = "Cargar")
    public boolean Cargar(@WebParam(name = "url") String url) {
        avl.cargar_usuarios(url);
        return true;
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "InicioSesion")
    public boolean InicioSesion(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass) {
        int id = avl.obtener_id(user);
        return avl.logear_usuario(id, pass);
    }
}
