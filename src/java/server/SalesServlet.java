/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import db.Products;
import db.Sales;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.xml.bind.DatatypeConverter.parseDate;

/**
 *
 * @author CRS
 */
@WebServlet(name = "SalesServlet", urlPatterns = {"/SalesServlet"})
public class SalesServlet extends HttpServlet {

    @PersistenceUnit
    EntityManagerFactory emf;

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
            out.println("<title>Servlet SalesServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SalesServlet at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();

        // then write the data of the response
        String productId = request.getParameter("productid");
        String productCountSales = request.getParameter("productcountsl");
        String productCountMonth = request.getParameter("productcountmonth");
        String minDate = request.getParameter("mindate");
        String maxDate = request.getParameter("maxdate");

        out.println("===========================================================================");

        if (productId != null) {
            Query nq = emf.createEntityManager().createNamedQuery("Products.findByProductid");
            nq.setParameter("productid", Integer.parseInt(productId));
            Products prod = (Products) nq.getResultList().get(0);
            List<Products> L = (List<Products>) nq.getResultList();
            String displayMsg;
            displayMsg = "<h3> The product with ID: " + prod.getProductid() + " and name: '" + prod.getProductname()
                    + "' has ";
            if (prod.getQuantityavl() == null)
                displayMsg += " 0 ";
            else
                displayMsg += prod.getQuantityavl();
            displayMsg += " items available.</h3>";
                   
            out.println(displayMsg);
        }

        if (productCountSales != null) {
            Query nq = emf.createEntityManager().createNamedQuery("Sales.findAll");
            List<Sales> L = (List<Sales>) nq.getResultList();
            int countItems = 0;
            for (int i = 0; i < L.size(); i++) {
                if (L.get(i).getProductid() == Integer.parseInt(productCountSales)) {
                    countItems++;
                }
            }
            out.println("<h3>There have been recorded " + countItems + " sales for the product with id "
                    + productCountSales + "</h3>");
        }

        if (productCountMonth != null) {
            Query nq = emf.createEntityManager().createNamedQuery("Sales.findAll");
            List<Sales> L = (List<Sales>) nq.getResultList();
            int countItems = 0;

            Date date = new Date();
            int month = date.getMonth();
//
//            out.println("<h2> current month is: " + month + "</h2>");
//            Calendar rightNow = Calendar.getInstance();
//            int month = rightNow.get(Calendar.MONTH);

            for (int i = 0; i < L.size(); i++) {
                if ((L.get(i).getProductid() == Integer.parseInt(productCountMonth))
                        && (L.get(i).getSalesdate().getMonth() == month)) {
                    countItems++;
                }
            }
            out.println("<h3>There have been recorded " + countItems + " sales for the product with id: "
                    + productCountMonth + " over the last month.</h3>");
        }

        if (minDate != null && maxDate != null) {
            try {
                Query nq = emf.createEntityManager().createNamedQuery("Sales.findAll");
                List<Sales> L = (List<Sales>) nq.getResultList();
                BigDecimal sum = new BigDecimal(0);

                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                Date dateMinDt = formatter.parse(minDate);
                Date dateMaxDt = formatter.parse(maxDate);

                for (int i = 0; i < L.size(); i++) {
                    if ((L.get(i).getSalesdate().after(dateMinDt)) && (L.get(i).getSalesdate().before(dateMaxDt))) {
                        sum = sum.add(L.get(i).getTotalamount());
                    }
                }
                out.println("<h3>Total amount of sales for the requested time interval is " + sum + ".</h3>");
            } catch (ParseException ex) {
                Logger.getLogger(SalesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

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
