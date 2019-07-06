/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.mysql.jdbc.StringUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CRS
 */
@WebServlet(name = "SalesUser", urlPatterns = {"/SalesUser"})
public class SalesUser extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SalesUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SalesUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
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
        response.setContentType("text/html");
        response.setBufferSize(8192);

        PrintWriter out = response.getWriter();
        out.println("<html>" + "<head><title> Sales User Page </title></head>");

        // write the data of the response
        out.println(
                "<body  bgcolor=\"#ffffff\">"
                + "<h3>Insert the ID of the product for which you want to know the available amount</h3>"
                + "<form method=\"get\">"
                + "<input type=\"text\" name=\"productid\" size=\"22\">"
                + "<p></p>" + "<input type=\"submit\" value=\"Submit\">"
                + "<input type=\"reset\" value=\"Reset\">" + "</form>");

        out.println(
                "<body  bgcolor=\"#ffffff\">"
                + "<h3>Insert the ID of the product for which you want to know the number of total sales: </h3>"
                + "<form method=\"get\">"
                + "<input type=\"text\" name=\"productcountsl\" size=\"22\">"
                + "<p></p>" + "<input type=\"submit\" value=\"Submit\">"
                + "<input type=\"reset\" value=\"Reset\">" + "</form>");

        out.println(
                "<body  bgcolor=\"#ffffff\">"
                + "<h3>Insert the ID of the product for which you want to know the total sales over the last month: </h3>"
                + "<form method=\"get\">"
                + "<input type=\"text\" name=\"productcountmonth\" size=\"22\">"
                + "<p></p>" + "<input type=\"submit\" value=\"Submit\">"
                + "<input type=\"reset\" value=\"Reset\">" + "</form>");

          out.println(
                "<body  bgcolor=\"#ffffff\">"
                + "<h3>Insert time interval for which you want the total amount of sales: </h3>"
                + "<form method=\"get\">"
                + "<input type=\"date\" name=\"mindate\" size=\"22\">"
                + "<input type=\"date\" name=\"maxdate\" size=\"22\">"
                + "<p></p>" + "<input type=\"submit\" value=\"Submit\">"
                + "<input type=\"reset\" value=\"Reset\">" + "</form>");

        String productid = request.getParameter("productid");
        String productcountsl = request.getParameter("productcountsl");
        String productcountmonth = request.getParameter("productcountmonth");
        String mindate = request.getParameter("mindate");
        String maxdate = request.getParameter("maxdate");

        if (((productid != null) && (Integer.parseInt(productid) > 0) && (!productid.isEmpty()))
                || ((productcountsl != null) && (Integer.parseInt(productcountsl) > 0) && (!productcountsl.isEmpty()))
                || ((productcountmonth != null) && (Integer.parseInt(productcountmonth) > 0)
                && (!productcountmonth.isEmpty()))
                || ((mindate != null) && (!mindate.isEmpty()))
                || ((maxdate != null) && (!maxdate.isEmpty()))) {

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SalesServlet");
            if (dispatcher != null) {
                dispatcher.include(request, response);
            }
        } else {
            out.println("<h3>Please input valid values.</h3>");
        }

        out.println("</body></html>");
        out.close();
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
