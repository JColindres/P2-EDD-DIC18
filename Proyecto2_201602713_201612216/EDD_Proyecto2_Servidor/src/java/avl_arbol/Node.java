/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl_arbol;

/**
 *
 * @author Toshiba
 */
public class Node {
        public int id;
        public String nickname;
        public String contraseña;
        public int balance;
        public int altura;
        public Node izquierda;
        public Node derecha;
        public Node padre;
        public Lista direcciones;
        public  Cola productos_por_comprar;
        public Cola carrito_compras;
        
 
       public Node(int key, Node parent,String nick,String contraseña) {
            this.id = key;
            this.padre = parent;
            this.nickname=nick;
            this.contraseña=contraseña;
            this.direcciones=new Lista();
            this.productos_por_comprar=new Cola();
            this.carrito_compras=new Cola();
        }
    
}
