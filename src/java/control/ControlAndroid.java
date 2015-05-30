/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.Amigo;
import hibernate.Localizacion;
import hibernate.Persona;
import hibernate.Recado;
import modelo.ModeloAmigo;
import modelo.ModeloLocalizacion;
import modelo.ModeloPersona;
import modelo.ModeloRecado;

//import com.google.gson.Gson;

/**
 *
 * @author Mariangeles
 */
@WebServlet(name = "ControlAndroid", urlPatterns = {"/ControlAndroid"})
@MultipartConfig
public class ControlAndroid extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean error=true;
        
        response.setContentType("application/json;charset=UTF-8");
        
        String target = request.getParameter("target");
        String op = request.getParameter("op");
        String action = request.getParameter("action");
        
        /* INSERT */
        
        if(op.equals("insert")){
            if(target.equals("localizacion") && op.equals("insert") && action.equals("op")){
                Localizacion localizacion = getLocalizacion(request);
                error = false;
                ModeloLocalizacion.insert(localizacion);
            
            }else if(target.equals("amigo") && op.equals("insert") && action.equals("op")){
                Amigo amigo = getAmigo(request);
                error = false;
                ModeloAmigo.insert(amigo);

            }else if(target.equals("recado") && op.equals("insert") && action.equals("op")){
                Recado recado = getRecado(request);
                error = false;
                ModeloRecado.insert(recado);

            }else if(target.equals("persona") && op.equals("insert") && action.equals("op")){
                Persona persona = getPersona(request);
                error = false;
                ModeloPersona.insert(persona);
            }

            try (PrintWriter out = response.getWriter()) {
                if (error) {
                    out.println("{\"r\":0 Error Insert)}");
                } else {
                    out.println("{\"r\":1 OK Insert)}");
                }
            }
            
        /* DELETE */
            
        }else if(op.equals("delete")){
            
            if(target.equals("localizacion") && op.equals("delete") && action.equals("op")){
                Localizacion localizacion = getLocalizacion(request);
                error = false;
                ModeloLocalizacion.delete(localizacion.getId()+"");

            }else if(target.equals("amigo") && op.equals("delete") && action.equals("op")){
                Amigo amigo = getAmigo(request);
                error = false;
                ModeloAmigo.delete(amigo.getId()+"");

            }else if(target.equals("recado") && op.equals("delete") && action.equals("op")){
                Recado recado = getRecado(request);
                error = false;
                ModeloRecado.delete(recado.getId()+"");

            }else if(target.equals("persona") && op.equals("delete") && action.equals("op")){
                Persona persona = getPersona(request);
                error = false;
                ModeloPersona.delete(persona.getId()+"");

            }

            try (PrintWriter out = response.getWriter()) {
                if (error) {
                    out.println("{\"r\":0 Error Delete)}");
                } else {
                    out.println("{\"r\":1 OK Insert)}");
                }
            }
            
        /* SELECT */
            
        }else if(op.equals("select")){
            
            if(target.equals("localizacion") && op.equals("select") && action.equals("view")){
                                
                List<Localizacion> lista = ModeloLocalizacion.get();
                response.setContentType("application/json;charset=UTF-8");
            
                /*Gson gson= new Gson();
                PrintWriter pw=response.getWriter();
                pw.println( gson.toJson(lista));
                pw.close();*/

            }else if(target.equals("amigo") && op.equals("select") && action.equals("view")){
                                
                List<Amigo> lista = ModeloAmigo.get();
                response.setContentType("application/json;charset=UTF-8");
            
                /*Gson gson= new Gson();
                PrintWriter pw=response.getWriter();
                pw.println( gson.toJson(lista));
                pw.close();*/

            }else if(target.equals("persona") && op.equals("select") && action.equals("view")){
                                
                List<Persona> lista = ModeloPersona.get();
                response.setContentType("application/json;charset=UTF-8");
            
                /*Gson gson= new Gson();
                PrintWriter pw=response.getWriter();
                pw.println( gson.toJson(lista));
                pw.close();*/

            }else if(target.equals("recado") && op.equals("select") && action.equals("view")){
                                
                List<Recado> lista = ModeloRecado.get();
                response.setContentType("application/json;charset=UTF-8");
            
                /*Gson gson= new Gson();
                PrintWriter pw=response.getWriter();
                pw.println( gson.toJson(lista));
                pw.close();*/

            }
        }
    }
    
    private Amigo getAmigo(HttpServletRequest request){
        Amigo amigo = new Amigo();
        amigo.setUsuarioAcepta(request.getParameter("usuarioAcepta"));
        amigo.setUsuarioInvita(request.getParameter("usuarioInvita"));
        return amigo;
    }

    private Localizacion getLocalizacion(HttpServletRequest request){
        Localizacion localizacion = new Localizacion();
        localizacion.setUsuario(request.getParameter("usuario"));
        localizacion.setLocalizacion(request.getParameter("localizacion"));
        return localizacion;
    }

    private Persona getPersona(HttpServletRequest request){
        Persona persona = new Persona();
        persona.setNombre(request.getParameter("nombre"));
        persona.setApellidos(request.getParameter("apellidos"));
        persona.setNombreUsuario(request.getParameter("nombreUsuario"));
        persona.setClave(request.getParameter("clave"));
        persona.setFoto(request.getParameter("foto"));
        persona.setLocalizacion(request.getParameter("localizacion"));
        return persona;
    }

    private Recado getRecado(HttpServletRequest request){
        Recado recado = new Recado();
        recado.setTitulo(request.getParameter("titulo"));
        recado.setDescripcion(request.getParameter("descripcion"));
        recado.setUsuarioCreador(request.getParameter("usuarioCreador"));
        recado.setUsuarioReceptor(request.getParameter("usuarioReceptor"));
        return recado;
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

}
