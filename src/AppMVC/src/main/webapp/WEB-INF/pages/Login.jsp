<%-- 
    Document           : Login
    Created on         : Oct 6, 2016, 8:11:41 PM
    Author             : J. Ayoub & M-H. Aghamahdi
    Information Source : www.openclassrooms.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
        <form method="post" action="login"> <fieldset>
                <legend>Login</legend>
                <p>You need to connect in order to access the protected page.</p>
                <label for="username">Username <span class="requis">*</span></label>
                <input type="username" 
                       name="username" value="<c:out 
                       value="${utilisateur.email}"/>" size="20"
                       maxlength="60"/>
                <br />
                <label for="password">Password <span 
                       class="requis">*</span></label>
                <input type="password" 
                       name="password" 
                       value="" 
                       size="20" 
                       maxlength="20" />
                <br />
                <input type="submit" 
                       value="Connect" 
                       class="sansLabel" />
                <br />
            </fieldset> </form>
    </body>
</html>
