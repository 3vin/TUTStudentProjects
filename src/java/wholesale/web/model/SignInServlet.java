/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wholesale.web.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import wholesale.web.ejb.ItemFacadeLocal;
import wholesale.web.ejb.UserFacadeLocal;
import wholesale.web.entity.Item;
import wholesale.web.entity.User;

/**
 *
 * @author Disaster
 */
public class SignInServlet extends HttpServlet {
@EJB
private UserFacadeLocal userFacadeLocal;
private ItemFacadeLocal itemFacadeLocal;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        User admin = new User("admin", "password");
       // userFacadeLocal.create(admin);
        
        String name = request.getParameter("uname");
        String pass = request.getParameter("pass");
       
        if(name.equalsIgnoreCase(admin.getName()) && pass.equals(admin.getPassword())){
            String page = "addItem.jsp";
            RequestDispatcher disp = request.getRequestDispatcher(page);
            disp.forward(request, response);
        }
        /*List<Item> items = itemFacadeLocal.findAll();
        HttpSession sess = request.getSession();
        if(items.equals(null)){
            items = new ArrayList<Item>();
        }
        sess.setAttribute("items", items);
        */
        /*if(name != null || pass != null){
            String tempName = null;
            String tempPass = null;
            List<User> users = userFacadeLocal.findAll();
            
            for(int i=0 ; i<users.size() ; i++){
                if(name.equalsIgnoreCase(users.get(i).getName())){
                    tempName = name;
                } 
                if(pass.equals(users.get(i).getPassword())){
                    tempPass = name;
                }
            }
            if(name.equals(tempName) && pass.equals(tempPass)){
            
                page = "index.html";
                message = null;
                 request.setAttribute("message", message);
                RequestDispatcher disp = request.getRequestDispatcher(page);
                disp.forward(request, response);
            }
        }*/
        String message = "Invalid username and password combination, in case of forgotten credentials, please contact your Local Administrator.";
        request.setAttribute("message", message);
        String page = "login.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(page);
        disp.forward(request, response);
    }


}
