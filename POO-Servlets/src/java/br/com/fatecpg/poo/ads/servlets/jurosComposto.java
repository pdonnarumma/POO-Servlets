
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
            out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">" +
                "<div class=\"collapse navbar-collapse\" id=\"navbarNav\">" +
                    "<ul class=\"navbar-nav\">" +
                    "<li class=\"nav-item active\"><a class=\"nav-link\" href=\"/POO-Servlets/home\">Home </a></li>" +
                    "<li class=\"nav-item\"><a class=\"nav-link\" href=\"/POO-Servlets/jurossimples\">Juros simples</a></li>"+
                    "<li class=\"nav-item\"><a class=\"nav-link\" href=\"/POO-Servlets/juroscomposto\">Juros composto</a></li>" +
                "</ul></div></nav>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
            "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>");            
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"_CSS/estilo.css\"/>");
            out.println("</head>");
            DecimalFormat df = new DecimalFormat("###,##0.00");
            out.println("<body>");
            
            out.println("<center><h1 class='teste'>Cálculo de Juros Composto</h1></center>");
            out.println("<hr>");
            
            out.println("<center><form><table style=\"text-align:right;\">");
            
            out.println("<center><form><table style='text-align:right;'>"
                    + "<tr><td>Valor:</td><td> <input type ='text' name='capital'/></td></tr>"
                    + "<tr><td>Taxa de juros:</td><td> <input type='text' name='taxaJuros'/></td></tr>"
                    + "<tr><td>Periodo:</td><td> <input type='text' name='periodo'/></td></tr>"
                    + "<tr><td colspan='2'><input type='submit' value='Calculo'/></td></tr>"
                    + "</form></table></center><hr>");
            
            out.println("</table></form></center><hr>");

            out.println("<hr>");
            out.println("<center><table width='30%' style='text-align:center;'>");
            out.println("<tr>"
                    + "<th>Valor </th>"
                    + "<th>Com juros</th>"
                    + "<th>Mês</th>"
                    + "</tr>");
            
            double taxaJuros = 100;
            double nj = 0;
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
            nj = capital;
            taxaJuros = taxaJuros/100;
            for(int i = 0; i < periodo; i++){
                
                nj = (taxaJuros * nj) + nj;
                
                out.println("<tr>"
                    + "<td>R$"+ df.format(capital) +"</td>" 
                    + "<td> R$" + df.format(nj) + "</td>" 
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
