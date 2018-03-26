
package br.com.fatecpg.poo.ads.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "jurosComposto", urlPatterns = {"/jurosComposto"})
public class jurosComposto extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            
            out.println("<title>Juros Composto</title>");
            out.println("<title>Servlet jurosSimpless</title>");      
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>");            
            
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +"style.css'>");
            out.println("</head>");
            DecimalFormat df = new DecimalFormat("###,##0.00");
            out.println("<body>");
            
            out.println("<h1 class='teste'> Juros Composto</h1>");
            out.println("<center><form><table style= text-align:right;'>" +
                    "<form method='get'>"
                    + "<div class=\"form-group\">\n" +
"    <label for=\"exampleFormControlInput1\">Valor:</label>\n" +
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
                    + "<input type='submit' value='Calcular'> </form>" +
                    "</table></center>");

            out.println("<hr>");
            out.println("<center><table width='100%' style='text-align:center;'>");
            out.println("<tr>"
                    + "<th>Valor </th>"
                    + "<th>Com juros</th>"
                    + "<th>Mês</th>"
                    + "</tr>");
            
            double taxaJuros = 100;
            double cj=0;
            double capital = 0;
            int periodo = 0;
            try{
                taxaJuros = Double.parseDouble(request.getParameter("taxaJuros"));
                capital = Double.parseDouble(request.getParameter("capital"));
                periodo = Integer.parseInt(request.getParameter("periodo"));
            }
            catch(Exception ex)
            {
                
            }
            cj = capital;
            taxaJuros = taxaJuros/100;
            for(int i = 0; i < periodo; i++){
                
                cj = (taxaJuros * cj) + cj;
                
                out.println("<tr>"
                    + "<td>R$"+ df.format(capital) +"</td>" 
                    + "<td> R$" + df.format(cj) + "</td>" 
                    + "<td>" + (i+1) + "</td>" 
                    + "</tr>"); 
                
            }
            out.println("</table></center>");
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
