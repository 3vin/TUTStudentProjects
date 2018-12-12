<%-- 
    Document   : AdminPortal
    Created on : 11-Mar-2018, 23:45:29
    Author     : Disaster
--%>

<%@page import="java.util.List"%>
<%@page import="wholesale.web.entity.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration Portal</title>
       
        <!-- Bootstrap core CSS -->
         <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/simple-sidebar.css" rel="stylesheet">
        
    </head>
    <%
       List<Item> items = (List<Item>)request.getAttribute("items");
       List<Item> sessItems = (List<Item>)session.getAttribute("items");
       String tabledata = "";
       if(items != null){
           
            for(int i=0; i<items.size();i++){
                
                int id = items.get(i).getId();
                String desc = items.get(i).getDescription();
                double price =items.get(i).getPrice();
                double qty = items.get(i).getQuantity();
                
                tabledata += "<tr>"
                           + "<td>"+id+"</td>"
                           + "<td>"+desc+"</td>"
                           + "<td>"+price+"</td>"
                           + "<td>"+qty+"</td>"
                           + "</tr>";
            }
            //tabledata+="</tr>";
        }else
            if(sessItems != null){
           
                for(int i=0; i<items.size();i++){
                
                    int id = sessItems.get(i).getId();
                    String desc = sessItems.get(i).getDescription();
                    double price =sessItems.get(i).getPrice();
                    double qty = sessItems.get(i).getQuantity();
                
                    tabledata += "<tr>"
                               + "<td>"+id+"</td>"
                               + "<td>"+desc+"</td>"
                              + "<td>"+price+"</td>"
                              + "<td>"+qty+"</td>"
                               + "</tr>";
                }
            //tabledata+="</tr>";
        }
       else{
           tabledata = "There are no items yet.";
       }
    %>
    <body>
     <div id="wrapper">
       <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li>
                    <a href="addItem.jsp">Add item(s)</a>
                </li>
                <li>
                    <a href="updateItem.jsp">Update item(s)</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->
        <h1>Administration Portal</h1></br>
        <h2>Items available :</h2>
        <table border="1" width="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <%=tabledata %>
            </tbody>
        </table>
            <h2>Enter ID to delete</h2>
            <form action="DeleteItemServlet.do" method="POST">
                <table>
                    <tr>
                        <td><input type="text>" name="id"></td>
                        <td><input type="submit" value="remove"</td>
                    </tr>
                </table>
            </form>
            </br><a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">View Menu</a>
      <!--</div>-->
    
      <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>
    </body>
</html>
