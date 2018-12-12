/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wholesale.web.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import wholesale.web.ejb.ItemFacadeLocal;
import wholesale.web.entity.Item;

/**
 *
 * @author Disaster
 */
public class GetAllItemsServlet extends HttpServlet {
@EJB
ItemFacadeLocal itemFacadeLocal;

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
        //HttpSession sess = request.getSession();
        List<Item> items = itemFacadeLocal.findAll();
        request.setAttribute("items", items);
        String page="adminPortal.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(page);
        disp.forward(request, response);
    }


}
