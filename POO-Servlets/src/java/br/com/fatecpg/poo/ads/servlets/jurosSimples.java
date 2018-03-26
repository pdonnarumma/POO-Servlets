
package br.com.fatecpg.poo.ads.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class jurosSimples extends HttpServlet {

    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            
           
            out.println("<title>Servlet jurosSimpless</title>");      
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>"
                    );
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +"style.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 class='teste'> Juros Simples</h1>");
            out.println("<form method='get'>"
                    + "<div class=\"form-group\">\n" +
"    <label for=\"exampleFormControlInput1\">Capital:</label>\n" +
"    <input type=\"text\" class=\"form-control\" id=\"exampleFormControlInput1\" placeholder=\"Informe o capital\" name='capital'>\n" +
"  </div>"
                    + "<div class=\"form-group\">\n" +
"    <label for=\"exampleFormControlInput1\">Taxa de Juros:</label>\n" +
"    <input type=\"text\" class=\"form-control\" id=\"exampleFormControlInput1\" placeholder=\"Informe a taxa de juros\" name='taxaJuros'>\n" +
"  </div>"
                    + "<div class=\"form-group\">\n" +
"    <label for=\"exampleFormControlInput1\">Periodo:</label>\n" +
"    <input type=\"text\" class=\"form-control\" id=\"exampleFormControlInput1\" placeholder=\"Informe o periodo em meses\" name='periodo'>\n" +
"  </div>"
                    + "<input type='submit' value='Calcular'> </form>");
            
            
            
            double capital = 0;
            double taxaJuros = 0;
            int periodo = 0;
            double montante = 0;
            double converteTaxa = 0;
            double juros = 0;
            
             capital = Double.parseDouble(request.getParameter("capital"));
             taxaJuros = Double.parseDouble(request.getParameter("taxaJuros"));
             periodo = Integer.parseInt(request.getParameter("periodo"));
             
            converteTaxa = (taxaJuros/100);
            juros = ((capital * converteTaxa)*periodo);
            montante = capital + juros;
            out.println("<hr>");
            out.println("<h1> Juros: "+juros + "</h1>");
            out.println("<h1>Montante: "+montante + "</h1>");
            out.println("");
            out.println("");
            out.println("");
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

}
