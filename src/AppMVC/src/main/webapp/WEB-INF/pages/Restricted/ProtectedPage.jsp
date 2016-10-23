<%-- 
    Document           : ProtectedPage.jsp
    Created on         : Oct 6, 2016
    Author             : J. Ayoub & M-H. Aghamahdi
    Object             : It's a protected page. Only authorized users can enter 
                         this page. 
                         In other-words, if a user has already made a 
                         registration and he enters a correct username and 
                         a correct password, he will be able to access this 
                         page.
    Information Source : www.openclassrooms.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="../style.css"/>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Protected Page</title>
    </head>
    <body>
        <strong> Protected Page!</strong>
        <br />
        <font color="yellow">Welcome ${sessionScope.username} !</font>
        <form method="post" 
              action="protected"> 
            <fieldset>
                <br />
                <input type="submit" 
                       value="Logout" 
                       class="sansLabel" />
                <br />
                <font color="red">${sessionScope.err_logout}</font>
                <br />
            <a style = "font-size:x-small" href = "../index.html"> Home Page</a>
            </fieldset> 
        </form>        
    </body>
</html>
