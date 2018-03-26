package br.com.fatecpg.poo.ads.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AnthonyRod93
 */

@WebServlet(name = "jurosSimpless", urlPatterns = {"/jurosSimples"})
public class jurosSimples extends HttpServlet {

    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Juros Simpless</title>");      
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">" +
                "<div class=\"collapse navbar-collapse\" id=\"navbarNav\">" +
                    "<ul class=\"navbar-nav\">" +
                    "<li class=\"nav-item active\"><a class=\"nav-link\" href=\"/POO-Servlets/home\">Home </a></li>" +
                    "<li class=\"nav-item\"><a class=\"nav-link\" href=\"/POO-Servlets/jurossimples\">Juros simples</a></li>"+
                    "<li class=\"nav-item\"><a class=\"nav-link\" href=\"/POO-Servlets/juroscomposto\">Juros composto</a></li>" +
                "</ul></div></nav>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
            "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>"
                    );
            out.println("<link rel='stylesheet' type='text/css' href='_CSS/estilo.css'/>");
            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align='center'>Cálculo de Juros Simples</h1>");
            out.println("<hr>");
            out.println("<hr>");
            out.println("<div>");
            
            out.println("<script type=\'text/javascript\'>");
            
            out.println("function calcular()" + "{"  
                    + "var num1 = Number(document.getElementById(\"num1\").value);"
                    + "var num2 = Number(document.getElementById(\"num2\").value);"
                    + "var num3 = Number(document.getElementById(\"num3\").value);"
            );
            
            out.println("var converteTaxa = (num2/100);\n" +
"            \n" +
"            var juros = ((num1 * converteTaxa)*num3);\n" +
"            \n" +
"            var montante = num1 + juros;" );
            
            out.println("var elemResult = document.getElementById(\"resultado\");\n" +
            "\n" +
            "if (elemResult.textContent === undefined) {\n" +
                "elemResult.textContent = \"Juros: \" + String(juros) + \".\";\n" +
            "}\n" +
            "else { // IE\n" +
                "elemResult.innerText = \"Juros: \" + String(juros) + \".\";\n" +
            "}\n" +
            "\n" +
                "var elemResult2 = document.getElementById(\"resultado2\");\n" +
            "\n" +
            "if (elemResult2.textContent === undefined) {\n" +
                "elemResult2.textContent = \"Montante: \" + String(montante) + \".\";\n" +
            "}\n" +
            "else { // IE\n" +
                "elemResult2.innerText = \"Montante: \" + String(montante) + \".\";\n" +
            "}\n" +
            "}" );
            
            out.println("</script>");
            
            out.println("<center><form><table style=\"text-align:right;\">");
            
            out.println("<tr><td>Capital:</td><td> <input type=\"text\" id=\"num1\" onblur=\"calcular();\" /></td></tr> \n" +
            "<tr><td>Taxa de Juros:</td><td> <input type=\"text\" id=\"num2\" onblur=\"calcular();\" /></td></tr>\n" +
            "<tr><td>Periodo:</td><td> <input type=\"text\" id=\"num3\" onblur=\"calcular();\" /></td></tr>" );
            
            out.println("</table></form></center><hr>");
            out.println("<center><span id=\"resultado\"></span></center> <hr> <hr>\n" +
            "<center><span id=\"resultado2\"></span></center>");
            
            out.println("</div>");
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
