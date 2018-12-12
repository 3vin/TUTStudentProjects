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
import wholesale.web.ejb.ItemFacadeLocal;
import wholesale.web.entity.Item;

/**
 *
 * @author Disaster
 */
public class UpdateItemServlet extends HttpServlet {
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
        Item item = new Item();
        int itemID = 0;
        String desc = null;
        double price = 0;
        int qty = 0;
        try{
            itemID = Integer.parseInt(request.getParameter("id"));
            desc = request.getParameter("desc");
            price = Double.parseDouble(request.getParameter("price"));
            qty = Integer.parseInt(request.getParameter("qty"));
            
            item = new Item(desc, price, qty);
        }catch(Exception e){
            
            String message = "Invalid entry detected, please ensure you have entered the correct entries.";
            String page ="updateItem.jsp";
            request.setAttribute("message", message);
            RequestDispatcher disp = request.getRequestDispatcher(page);
            disp.forward(request, response);
        }
       
        if(itemID > 0){
            item.setId(itemID);
            
             if (desc.equals(null) || desc.equals("")) {
                 item.setDescription(desc);
             }
             if (price < 1.0) {
                 item.setPrice(price);
             }
             if (qty < 1.0) {
                 item.setQuantity(itemID);
             }
             
             itemFacade.edit(item);
        }
       
                
        //itemFacade.edit(new Item(itemID));
        List<Item> items = itemFacade.findAll();
        request.setAttribute("items", items);
        String message = "Item was Successfully updated";
        String page ="updateItem.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(page);
        disp.forward(request, response);
    }

}
