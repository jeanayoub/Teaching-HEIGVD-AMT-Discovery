<%-- 
    Document           : ProtectedPage.jsp
    Created on         : Oct 6, 2016
    Author             : J. Ayoub & M-H. Aghamahdi
    Information Source : www.openclassrooms.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Protected Page</title>
    </head>
    <body>
        <strong> Protected Page!</strong>
        <br />
        <font color="blue">Welcome ${requestScope.conn_user.getUsername()} !</font>
        <form method="post" action="protected"> <fieldset>
                <br />
                <input type="submit" value="Logout" class="sansLabel" />
                <br />
            </fieldset> </form>
        
        
    </body>
</html>


