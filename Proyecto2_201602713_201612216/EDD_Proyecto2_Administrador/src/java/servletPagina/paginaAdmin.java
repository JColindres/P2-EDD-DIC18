/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletPagina;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import serviciosweb.WebService;

/**
 *
 * @author pablo
 */
@WebServlet(name = "paginaAdmin", urlPatterns = {"/paginaAdmin"})
public class paginaAdmin extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Servidor/WebService.wsdl")
    private WebService service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet paginaAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet paginaAdmin at " + request.getContextPath() + "</h1>");
            if(request.getParameter("rutaUsu").equals("")){
                
            }
            else{
                out.println(cargar_us(request.getParameter("rutaUsu")));
            }
            if(request.getParameter("rutaDire").equals("")){
                
            }
            else{
                out.println(cargar_dir(request.getParameter("rutaDire")));
            }
            if(request.getParameter("rutaProd").equals("")){
                
            }
            else{
                out.println(cargar_pro(request.getParameter("rutaProd")));
            }
            if(request.getParameter("rutaProdComp").equals("")){
                
            }
            else{
                out.println(cargar_proXcom(request.getParameter("rutaProdComp")));
            }            
            if(request.getParameter("rutaCarrito").equals("")){
                
            }
            else{
                out.println(cargar_carr(request.getParameter("rutaCarrito")));
            }      
            if(request.getParameter("rutaVenta").equals("")){
                
            }
            else{
                out.println(cargarVentas(request.getParameter("rutaVenta")));
            }      
            if(request.getParameter("rutaDetalle").equals("")){
                
            }
            else{
                out.println(cargarDetalles(request.getParameter("rutaDetalle")));
            }    
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean cargar_us(java.lang.String url) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        serviciosweb.ServiciosWeb1 port = service.getServiciosWeb1Port();
        return port.cargarUsuarios(url);
    }
    
    private boolean cargar_dir(java.lang.String url) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        serviciosweb.ServiciosWeb1 port = service.getServiciosWeb1Port();
        return port.cargarDirecciones(url);
    }

    private boolean cargar_pro(java.lang.String url) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        serviciosweb.ServiciosWeb1 port = service.getServiciosWeb1Port();
        return port.cargarProductos(url);
    }
    
    private boolean cargar_proXcom(java.lang.String url) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        serviciosweb.ServiciosWeb1 port = service.getServiciosWeb1Port();
        return port.cargarPorComprar(url);
    }
    
    private boolean cargar_carr(java.lang.String url) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        serviciosweb.ServiciosWeb1 port = service.getServiciosWeb1Port();
        return port.cargarCarrito(url);
    }

    private boolean cargarVentas(java.lang.String url) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        serviciosweb.ServiciosWeb1 port = service.getServiciosWeb1Port();
        return port.cargarVentas(url);
    }

    private boolean cargarDetalles(java.lang.String url) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        serviciosweb.ServiciosWeb1 port = service.getServiciosWeb1Port();
        return port.cargarDetalles(url);
    }
}
