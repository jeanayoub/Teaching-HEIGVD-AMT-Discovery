/** 
 * Document           : RestConfig.java
 * Created on         : Oct 17, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Object             : This class allows to configure the "REST". 
 *                      It informs to the database that the data is as json.
 * Information Source : N/A
 */
 package ch.heigvd.ch.amt.appmvc.rest;

 import java.util.HashMap;   
 import java.util.Map;
 import javax.ws.rs.ApplicationPath;
 import javax.ws.rs.core.Application;


@ApplicationPath("/api")
public class RestConfig extends Application {
    
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.disableMoxyJson", true);
        return properties;
    }
}
