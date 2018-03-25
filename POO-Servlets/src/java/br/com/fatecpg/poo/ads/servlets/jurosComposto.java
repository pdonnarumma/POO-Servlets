
package br.com.fatecpg.poo.ads.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;


public class jurosComposto extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Juros Composto</title>");            
            out.println("</head>");
            out.println("<body>");
            DecimalFormat df = new DecimalFormat("###,##0.00");
            out.println("<center><form><table style='text-align:right;'>"
                    + "<tr><td>Taxa de Juros:</td><td> <input type'text' name='j'/></td></tr>"
                    + "<tr><td>Valor:</td><td> <input type='text' name='v'/></td></tr>"
                    + "<tr><td>Periodo:</td><td> <input type='text' name='p'/></td></tr>"
                    + "<tr><td colspan='2'><center><input type='submit' value='Calculo'/><center></td></tr>"
                    + "</form></table></center><hr>");
            out.println("<center><table width='100%' style='text-align:left;'>");
            out.println("<tr>"
                    + "<th>Valor </th>"
                    + "<th>Com juros</th>"
                    + "<th>Mês</th>"
                    + "</tr>");
            double j = 100;
            double cj=0;
            double v = 0;
            int p = 0;
            try{
                j = Double.parseDouble(request.getParameter("j"));
                v = Double.parseDouble(request.getParameter("v"));
                p = Integer.parseInt(request.getParameter("p"));
            }
            catch(Exception ex)
            {
                
            }
            cj = v;
            j = j/100;
            for(int i = 0; i < p; i++){
                
                cj = (j * cj) + cj;
                out.println("<tr>"
                    + "<td>R$"+ df.format(v) +"</td>"
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
