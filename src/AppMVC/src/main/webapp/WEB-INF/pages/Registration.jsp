<%-- 
    Document           : Registration.jsp
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
        <title>Registration Page</title>
    </head>
    <body>
        <form method="post" action = "register">
        <fieldset> <legend>Register</legend>
            
            <label for="username"> Username <span class="requis">*</span></label>
            <input type="text" name="username" required="true" size="20" maxlength="20" />
            
            <br/>
            <label for="password"> Password <span class="requis">*</span></label>
            <input type="password" name="password" required="true" size="20" maxlength="20" />
            
            <br/>
            <label for="confirmation">Confirm password <span class="requis">*</span></label>
            <input type="password" name="confirmation" required="true" size="20" maxlength="20" />
            
            <br/>
            <br/>
            <input type="submit" value="submit" styleClass="sansLabel" />
            &nbsp; 
            &nbsp;
            <font color="red"> <strong> ${requestScope.err_register} <strong> </font>
            <br />
            <a style = "font-size:x-small" href = "index.html"> Home Page</a>
        </fieldset>
    </form>

</body>
</html>
