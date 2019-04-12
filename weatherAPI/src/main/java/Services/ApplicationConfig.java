/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author mshao
 */
@ApplicationPath("api")
public class ApplicationConfig extends Application {
    
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(weatherService.class);
        return resources;
        
    }
}
