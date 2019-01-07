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
public class pagina {

    pagina padre;
    info pagina[];
    int grado;
    pagina hijos[];
    int cantidad;
    int id;

    public pagina()
    {
        id = 0;
        padre = null;
        pagina=new info[5];
        hijos=new pagina[6];
        cantidad=0;
        for(int i=0;i<5;i++)
        {
            pagina[i]=new info();
        }
    }   
    
}
