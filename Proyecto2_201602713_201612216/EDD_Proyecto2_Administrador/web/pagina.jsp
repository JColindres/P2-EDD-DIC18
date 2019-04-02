<%-- 
    Document   : pagina
    Created on : 03-ene-2019, 21:59:25
    Author     : Toshiba
--%>

<%@page import="java.awt.FileDialog"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="css/estilos2.css">

    </head>
    
    <body>
       
    
        
        <div class="contenedor-form">
            <div class="toggle">
                Administrador
            </div>
            
            <div class="formulario">
                
                <h1 align="center">
                     Administrar Estructuras 
                </h1>
                
                
                
                <form action="paginaAdmin" method="post">
                    <table border="1">
                        <tr>
                            <td>
                                <h3>Cargas</h3>
                            </td>
                            <td>
                                <h3>Realizar Acciones</h3>
                            </td>
                            <th>
                                <h3> Seleccionar archivo</h3>
                            </th>
                        </tr>
                        <tr>
                            <td>
                                <h3>Usuarios</h3>
                            </td>
                            <th>
                                <input type="submit" name="BtnUsu" value="Cargar" >
                            </th>
                            <th>
                                <input type="file"  name="rutaUsu" accept=".csv"/>
                            </th>
    
                        </tr>
                        <tr>
                            <td>
                                <h3>Direcciones</h3>
                            </td>
                            <th>
                                <input type="submit" name="BtnDire" value="Cargar" >
                            </th>
                            <th>
                                <input type="file"  name="rutaDire" accept=".csv"/>
                            </th>
                        </tr>
                        
                        <tr>
                            <td>
                                <h3>Productos</h3>
                            </td>
                            <th>
                                <input type="submit" name="BtnProd" value=" Cargar" >
                            </th>
                            <th>
                                <input type="file"  name="rutaProd" accept=".csv"/>
                            </th>
                        </tr>
                        
                        <tr>
                            <td>
                                <h3>Productos</h3><bt>
                                <h3>por Comprar</h3>
                            </td>
                            <th>
                                <input type="submit" name="BtnProdComp" value=" Cargar" >
                            </th>
                            <th>
                                <input type="file"  name="rutaProdComp" accept=".csv"/>
                            </th>
                        </tr>
                        
                        <tr>
                            <td>
                                <h3>Carrito</h3><bt>
                                <h3>de Compras</h3>
                            </td>
                            <th>
                                <input type="submit" name="BtnCarrito" value=" Cargar" >
                            </th>
                            <th>
                                <input type="file"  name="rutaCarrito" accept=".csv"/>
                            </th>
                        </tr>
                        
                        <tr>
                            <td>
                                <h3>Ventas</h3>
                            </td>
                            <th>
                                <input type="submit" name="BtnVenta" value=" Cargar" >
                            </th>
                            <th>
                                <input type="file"  name="rutaVenta" accept=".csv"/>
                            </th>
                        </tr>
                        
                        <tr>
                            <td>
                                <h3>Detalles</h3>
                            </td>
                            <th>
                                <input type="submit" name="BtnDetalle" value=" Cargar" >
                            </th>
                            <th>
                                <input type="file"  name="rutaDetalle" accept=".csv"/>
                            </th>
                        </tr>
                        
                    </table>
                </form>
                <form action="graficaAdmin" method="post">
                    <table border="1">
                        <tr>
                            <td>
                                <h3>Graficas</h3>
                            </td>
                            <td>
                                <h3>Graficar EDD</h3>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h3>Usuarios</h3>
                            </td>
                            <th>
                                <input type="submit" name="BtnUsuGraf" value="Graficar" >
                            </th>
                            <th>
                                <input type="file"  name="rutaUsuGraf" accept=".txt"/>
                            </th>
    
                        </tr>
                        
                        <tr>
                            <td>
                                <h3>Productos</h3>
                            </td>
                            <th>
                                <input type="submit" name="BtnProdGraf" value="Graficar" >
                            </th>
                            <th>
                                <input type="file"  name="rutaProdGraf" accept=".txt"/>
                            </th>
                        </tr>
                        
                        <tr>
                            <td>
                                <h3>Ventas</h3>
                            </td>
                            <th>
                                <input type="submit" name="BtnVentaGraf" value="Graficar" >
                            </th>
                            <th>
                                <input type="file"  name="rutaVentaGraf" accept=".txt"/>
                            </th>
                        </tr>
                        
                    </table>
                </form>
            </div>
        </div>
        
</html>
