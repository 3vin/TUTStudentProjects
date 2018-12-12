<%-- 
    Document   : addItem
    Created on : 12-Mar-2018, 10:47:18
    Author     : Disaster
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Administrator portal - manage all store items</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/simple-sidebar.css" rel="stylesheet">

</head>
<%
    String message = (String)request.getAttribute("message");
    if(message == null){
        message = "";
    }
%>
 <body>
      <div id="wrapper">
          
           <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li>
                    <a href="adminPortal.jsp">Remove item(s)</a>
                </li>
                <li>
                    <a href="updateItem.jsp">Update item(s)</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->
          
        <h1>Add new items below: </h1>
        <form action="AddItemServlet.do" method="POST">
            <table>
                <tr>
                    <td>
                        Description :
                    </td>
                    <td><input type="text" name="desc">
                    </td>
                </tr>
                <tr>
                    <td>
                        Price :
                    </td>
                    <td><input type="text" name="price">
                    </td>
                </tr>
                <tr>
                    <td>
                        Quantity
                    </td>
                    <td><input type="text" name="qty">
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="add"></td>
                </tr>
            </table>
        </form>
        </br>
        <p><%=message %></p>       
        </br><a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">View Menu</a>
      </div>
        
         <!-- /#wrapper -->

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
