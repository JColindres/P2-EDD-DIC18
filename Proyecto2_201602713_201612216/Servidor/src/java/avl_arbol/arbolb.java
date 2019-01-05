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
public class arbolb {

    pagina raiz;
    pagina pivote;

    public arbolb() {
        raiz = null;
    }

    public Boolean prestamolibro(int id, pagina pagina) {
        pagina pivote1 = pagina;
        for (int i = 0; i < pivote1.cantidad; i++) {
            if (pivote1.pagina[i].id == id) {
                if ((pivote1.pagina[i].ejemplar - pivote1.pagina[i].prestamo) > 0) {
                    pivote1.pagina[i].prestamo++;
                    return true;
                } else {
                    return false;
                }
            }
        }
        for (int j = 0; j < contar(pivote1.hijos); j++) {
            Boolean x = prestamolibro(id, pivote1.hijos[j]);
            if (x == true) {
                return true;
            }
        }
        return false;
    }

    public Boolean devolucionlibro(int id, pagina pagina) {
        pagina pivote1 = pagina;
        for (int i = 0; i < pivote1.cantidad; i++) {
            if (pivote1.pagina[i].id == id) {
                pivote1.pagina[i].prestamo--;
                return true;
            }
        }
        for (int j = 0; j < contar(pivote1.hijos); j++) {
            Boolean x = devolucionlibro(id, pivote1.hijos[j]);
            if (x == true) {
                return true;
            }
        }
        return false;
    }

    public void buscarpornombre(String nombre, pagina pagina) {
        pagina pivote1 = pagina;
        for (int i = 0; i < pivote1.cantidad; i++) {
            if (pivote1.pagina[i].titulo.contains(nombre) && (pivote1.pagina[i].ejemplar - pivote1.pagina[i].prestamo) > 0) {
//                JSONObject jo = new JSONObject();
//                jo.put("id", pivote1.pagina[i].id);
//                jo.put("titulo", pivote1.pagina[i].titulo);
//                jo.put("autor", pivote1.pagina[i].autor);
//                jo.put("pagina", pivote1.pagina[i].pagina);
//                jo.put("ejemplar", pivote1.pagina[i].ejemplar);
//                jo.put("prestamo", pivote1.pagina[i].prestamo);
//                ja.add(jo);
            }
        }
        for (int j = 0; j < contar(pivote1.hijos); j++) {
            buscarpornombre2(nombre, pivote1.hijos[j]);
        }
    }

    public void buscarpornombre2(String nombre, pagina pagina) {
        pagina pivote1 = pagina;
        for (int i = 0; i < pivote1.cantidad; i++) {
            if (pivote1.pagina[i].titulo.contains(nombre) && (pivote1.pagina[i].ejemplar - pivote1.pagina[i].prestamo) > 0) {
//                JSONObject jo = new JSONObject();
//                jo.put("id", pivote1.pagina[i].id);
//                jo.put("titulo", pivote1.pagina[i].titulo);
//                jo.put("autor", pivote1.pagina[i].autor);
//                jo.put("pagina", pivote1.pagina[i].pagina);
//                jo.put("ejemplar", pivote1.pagina[i].ejemplar);
//                jo.put("prestamo", pivote1.pagina[i].prestamo);
//                ja.add(jo);
            }
        }
        for (int j = 0; j < contar(pivote1.hijos); j++) {
            buscarpornombre2(nombre, pivote1.hijos[j]);
        }
    }

    public void ordenar(info pagina[], int cantidad) {
        info aux;
        for (int i = 0; i < cantidad; i++) {
            for (int j = 1; j < cantidad - i; j++) {
                if (pagina[j - 1].id > pagina[j].id) {
                    aux = pagina[j - 1];
                    pagina[j - 1] = pagina[j];
                    pagina[j] = aux;
                }
            }
        }
    }

    public int insertar(info valor) {
        int calibre = 0;
        int i = 0;
        pivote = raiz;
        if (pivote == null) {
            raiz = new pagina();
            pivote = raiz;
        } else {
            if (pivote.cantidad == 5) {
                ordenar(pivote.pagina, pivote.cantidad);
                split(pivote);
                pivote = raiz;
                while (contar(pivote.hijos) != 0) {
                    if (pivote.cantidad == 1) {
                        if (valor.id > pivote.pagina[0].id) {
                            i = 1;
                        } else if (valor.id < pivote.pagina[1].id) {
                            i = 0;
                        }
                    } else {
                        for (i = 0; i < pivote.cantidad; i++) {
                            if (valor.id > pivote.pagina[i].id && valor.id < pivote.pagina[i + 1].id) {
                                i++;
                                break;
                            } else if (valor.id < pivote.pagina[0].id) {
                                break;
                            }
                        }
                    }
                    if (pivote.cantidad == 5) {
                        split(pivote);
                    } else {
                        pivote = pivote.hijos[i];
                        calibre++;
                    }
                }
                if (pivote.cantidad == 5) {
                    split(pivote);
                }
            } else {
                while (contar(pivote.hijos) != 0) {
                    if (pivote.cantidad == 5) {
                        split(pivote);
                    }
                    if (pivote.cantidad == 1) {
                        if (valor.id > pivote.pagina[0].id) {
                            i = 1;
                        } else if (valor.id < pivote.pagina[1].id) {
                            i = 0;
                        }
                    } else {
                        for (i = 0; i < pivote.cantidad; i++) {
                            if (valor.id > pivote.pagina[i].id && valor.id < pivote.pagina[i + 1].id) {
                                i++;
                                break;
                            } else if (valor.id < pivote.pagina[0].id) {
                                break;
                            }
                        }
                    }
                    if (pivote.cantidad == 5) {
                        split(pivote);
                    } else {
                        pivote = pivote.hijos[i];
                        calibre++;
                    }
                }
                if (pivote.cantidad == 5) {
                    split(pivote);
                }
            }
        }
        pivote.pagina[pivote.cantidad] = valor;
        pivote.cantidad++;
        ordenar(pivote.pagina, pivote.cantidad);
        return calibre;
    }

    public void calibrar(info valor) {
        int i = 0;
        pivote = raiz;
        if (pivote == null) {
            raiz = new pagina();
            pivote = raiz;
        } else {
            if (pivote.cantidad == 5) {
                split(pivote);
                pivote = raiz;
                while (contar(pivote.hijos) != 0) {
                    if (pivote.cantidad == 1) {
                        if (valor.id > pivote.pagina[0].id) {
                            i = 1;
                        } else if (valor.id < pivote.pagina[1].id) {
                            i = 0;
                        }
                    } else {
                        for (i = 0; i < pivote.cantidad; i++) {
                            if (valor.id > pivote.pagina[i].id && valor.id < pivote.pagina[i + 1].id) {
                                i++;
                                break;
                            } else if (valor.id < pivote.pagina[0].id) {
                                break;
                            }
                        }
                    }
                    if (pivote.cantidad == 5) {
                        split(pivote);
                    } else {
                        pivote = pivote.hijos[i];
                    }
                }
                if (pivote.cantidad == 5) {
                    split(pivote);
                }
            } else {
                while (contar(pivote.hijos) != 0) {
                    if (pivote.cantidad == 5) {
                        split(pivote);
                    }
                    if (pivote.cantidad == 1) {
                        if (valor.id > pivote.pagina[0].id) {
                            i = 1;
                        } else if (valor.id < pivote.pagina[1].id) {
                            i = 0;
                        }
                    } else {
                        for (i = 0; i < pivote.cantidad; i++) {
                            if (valor.id > pivote.pagina[i].id && valor.id < pivote.pagina[i + 1].id) {
                                i++;
                                break;
                            } else if (valor.id < pivote.pagina[0].id) {
                                break;
                            }
                        }
                    }
                    if (pivote.cantidad == 5) {
                        split(pivote);
                    } else {
                        pivote = pivote.hijos[i];
                    }
                }
                if (pivote.cantidad == 5) {
                    split(pivote);
                }
            }
        }
    }

    public void split(pagina nodo) {
        if (nodo.padre == null) {
            info centro = nodo.pagina[2];
            nodo.pagina[2] = new info();
            nodo.cantidad--;
            pagina nodocabeza = new pagina();
            pagina nodohijo = new pagina();
            for (int j = 3; j < 5; j++) {
                nodohijo.pagina[j - 3] = nodo.pagina[j];
                if (nodo.hijos[j] != null) {
                    nodo.hijos[j].padre = nodohijo;
                }
                nodohijo.hijos[j - 3] = nodo.hijos[j];
                nodohijo.cantidad++;
                nodo.pagina[j] = new info();
                nodo.cantidad--;
            }
            if (nodo.hijos[5] != null) {
                nodo.hijos[5].padre = nodohijo;
            }
            nodohijo.hijos[2] = nodo.hijos[5];
            for (int j = 3; j < 6; j++) {
                nodo.hijos[j] = null;
            }
            nodocabeza.pagina[0] = centro;
            nodo.padre = nodocabeza;
            nodohijo.padre = nodocabeza;
            nodocabeza.hijos[0] = nodo;
            nodocabeza.hijos[1] = nodohijo;
            nodocabeza.cantidad++;
            ordenar(nodocabeza.pagina, nodocabeza.cantidad);
            raiz = nodocabeza;
        } else {
            info centro = nodo.pagina[2];
            nodo.pagina[2] = new info();
            nodo.cantidad--;
            pagina nodohijo = new pagina();
            for (int j = 3; j < 5; j++) {
                nodohijo.pagina[j - 3] = nodo.pagina[j];
                if (nodo.hijos[j] != null) {
                    nodo.hijos[j].padre = nodohijo;
                }
                nodohijo.hijos[j - 3] = nodo.hijos[j];
                nodohijo.cantidad++;
                nodo.pagina[j] = new info();
                nodo.cantidad--;
            }
            if (nodo.hijos[5] != null) {
                nodo.hijos[5].padre = nodohijo;
            }
            nodohijo.hijos[2] = nodo.hijos[5];
            for (int j = 3; j < 6; j++) {
                nodo.hijos[j] = null;
            }
            nodo.padre.pagina[nodo.padre.cantidad] = centro;
            nodo.padre.cantidad++;
            ordenar(nodo.padre.pagina, nodo.padre.cantidad);
            int cantidadhijos = contar(nodo.padre.hijos);
            if (nodo.padre.hijos[cantidadhijos - 1].pagina[nodo.padre.hijos[cantidadhijos - 1].cantidad - 1].id > nodohijo.pagina[0].id) {
                nodo.padre.hijos[cantidadhijos] = nodo.padre.hijos[cantidadhijos - 1];
                nodo.padre.hijos[cantidadhijos - 1] = nodohijo;
            } else {
                nodo.padre.hijos[cantidadhijos] = nodohijo;
            }
            nodohijo.padre = nodo.padre;
            pivote = nodohijo;
        }
    }

    public int contar(pagina[] nodo) {
        int cantidad = 0;
        for (int i = 0; i < nodo.length; i++) {
            if (nodo[i] != null) {
                cantidad++;
            }
        }
        return cantidad;
    }
}
