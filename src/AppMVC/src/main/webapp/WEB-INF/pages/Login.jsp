<%-- 
    Document           : Login.jsp
    Created on         : Oct 6, 2016
    Author             : J. Ayoub & M-H. Aghamahdi
    Object             : This is a login page. Through this page, a user can 
                         access the protected page, when he put his username and password.
    Information Source : www.openclassrooms.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

    <head>
        <link rel="stylesheet" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    
        <form method="post" action="login"> 
            <fieldset>
                <legend>Login</legend>
                <font color="green"> <strong> ${requestScope.succ_register} </strong> </font>
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
                <br />
                <input type="submit" 
                       value="Connect" 
                       class="sansLabel" />
                &nbsp; 
                &nbsp;
                <font color="red"> <strong> ${requestScope.err_login} <strong> </font>
                <font color="red"> <strong> ${requestScope.err_restricted} <strong> </font>
                <br />
                <a style = "font-size:x-small" href = "index.html"> Home Page</a>
                <br />
                <a style = "font-size:x-small" href = "register"> Not registered yet ?</a>
            </fieldset> 
        </form>