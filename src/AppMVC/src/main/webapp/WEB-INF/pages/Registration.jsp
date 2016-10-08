<%-- 
    Document           : Registration
    Created on         : Oct 6, 2016, 8:11:41 PM
    Author             : J. Ayoub & M-H. Aghamahdi
    Information Source : www.openclassrooms.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <form method="post" action = "register">
        <fieldset> <legend>Register</legend>
            
            <label for="username"> Username <span class="requis">*</span></label>
            <input type="text" name="username" required="true" size="20" maxlength="20" />
            
            <br />
            <label for="password"> Password <span class="requis">*</span></label>
            <input type="password" name="password" required="true" size="20" maxlength="20" />
            
            <br />
            <label for="confirmation">Confirm password <span class="requis">*</span></label>
            <input type="password" name="confirmation" required="true" size="20" maxlength="20" />
            
            <br />
            <input type="submit" value="submit" styleClass="sansLabel" />
            <br /> 
        </fieldset>
    </form>

</body>
</html>
