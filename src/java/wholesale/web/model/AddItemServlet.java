/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wholesale.web.model;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wholesale.web.ejb.ItemFacadeLocal;
import wholesale.web.entity.Item;

/**
 *
 * @author Disaster
 */
public class AddItemServlet extends HttpServlet {
@EJB
private ItemFacadeLocal itemFacadeLocal;
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
        
        
       String description = request.getParameter("desc");
       if(description!=null){
           try{
            double price = Double.parseDouble(request.getParameter("price"));
            int qty = Integer.parseInt(request.getParameter("qty"));
            
            Item item = new Item(description, price, qty);
            itemFacadeLocal.create(item);
           }catch(NumberFormatException e){
                String page = "addItem.html";
                String message = "please fill in all spaces";
                request.setAttribute("message", message);
                RequestDispatcher disp = request.getRequestDispatcher(page);
                disp.forward(request, response);
           }
       }
        String message ="Item was succesfully Added.";
        request.setAttribute("message", message);
        String page = "addItem.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(page);
        disp.forward(request, response);
    }

    

}
