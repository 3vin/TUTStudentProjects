<%-- 
    Document   : login
    Created on : 12-Mar-2018, 02:12:44
    Author     : Disaster
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user sign in</title>
        
         <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/simple-sidebar.css" rel="stylesheet">
        
    </head>
    <% 
        String message = (String)request.getAttribute("message");
        if(message == null){ message = " "; }
    %>
    <body>
      <div id="wrapper">
        <h1>Staff sign in:</h1>
        <form action="SignInServlet.do" method="POST">
        <table>
            <tr>
                <td>
                    Username
                </td>
                <td>
                    <input type="text" name="uname"> 
                </td>
            </tr>
            <tr>
                <td>
                    Password 
                </td>
                <td>
                    <input type="password" name="pass" length="8">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="sign in">
                </td>
            </tr>
        </table>
        </form>
        </br><p><%=message %></p>
      </div>
   </body>
</html>
