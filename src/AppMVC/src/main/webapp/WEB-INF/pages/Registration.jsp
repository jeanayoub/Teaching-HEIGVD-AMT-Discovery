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
    <form>
        <fieldset> <legend>Inscription</legend>
            
            <label for="nom">Nom d'utilisateur <span class="requis">*</span></label>
            <input type="text" id="nom" value="${inscrireBean.utilisateur.nom}" required="true" size="20" maxlength="20" />
            
            <br />
            <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
            <input type="password" id="motdepasse" value="${inscrireBean.utilisateur.motDePasse}" required="true" size="20" maxlength="20" />
            
            <br />
            <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
            <input type="password" id="confirmation" value="${inscrireBean.utilisateur.motDePasse}" required="true" size="20" maxlength="20" />
            
            <br />
            <input type="submit" value="Inscription" action="${inscrireBean.inscrire}" styleClass="sansLabel" />
            <br /> 
        </fieldset>
    </form>

</body>
</html>
