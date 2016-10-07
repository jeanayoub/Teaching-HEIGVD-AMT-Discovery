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
        <form method="post" action="connexion"> <fieldset>
                <legend>Connexion</legend>
                <p>Veuillez vous connecter afin d'acceder a la protected page.</p>
                <label for="nom">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20"
                       maxlength="60" />
                <span class="erreur">${form.erreurs['email']}</span>
                <br />
                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <br />
                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset> </form>
    </body>
</html>
