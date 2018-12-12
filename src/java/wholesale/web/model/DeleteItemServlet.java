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
import wholesale.web.ejb.ItemFacade;
import wholesale.web.ejb.ItemFacadeLocal;
import wholesale.web.entity.Item;

/**
 *
 * @author Disaster
 */
public class DeleteItemServlet extends HttpServlet {
@EJB
ItemFacadeLocal itemFacade;
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
        try{
            int itemID = Integer.parseInt(request.getParameter("id"));
            itemFacade.remove(new Item(itemID));
        }catch(NumberFormatException e){
            String message = "Please enter a valid number";
            String page ="adminPortal.jsp";
            request.setAttribute("message", message);
            RequestDispatcher disp = request.getRequestDispatcher(page);
            disp.forward(request, response);
        }
        
        List<Item> items = itemFacade.findAll();
        request.setAttribute("items", items);
        String page ="adminPortal.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(page);
        disp.forward(request, response);
    }

}
