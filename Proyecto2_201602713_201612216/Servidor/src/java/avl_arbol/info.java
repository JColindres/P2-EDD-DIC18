/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl_arbol;

/**
 *
 * @author Familia Corona
 */
public class info {

    int id;
    String titulo;
    String autor;
    int pagina;
    int ejemplar;
    int prestamo;

    public info(int id, String titulo, String autor, int pagina, int ejemplar, int prestamo) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.pagina = pagina;
        this.ejemplar = ejemplar;
        this.prestamo = prestamo;
    }

    public info() {

    }
}
