/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.weather;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.MessageBodyWriter;

/**
 *
 * @author mshao
 */
@Path("weather")
@Produces(MediaType.APPLICATION_JSON)
public class weatherService implements MessageBodyWriter<weather> {
    
    @Path("test")
    @GET
    public String test(){
        return "success";
    }

    @Path("Toronto")
    @GET
    public String getTotnotoWeather(){
        Client client = ClientBuilder.newClient();
        WebTarget resource= client.target("http://api.openweathermap.org/data/2.5/weather?id=6167865&appid=026276b3f1eafbbf7597adcf1fd1820e");
        
        Builder request = resource.request();
        Response response = request.get();
        
        if(response.getStatus() == 200){
            String output = response.readEntity(String.class);

            return output;
        }else{
            return null;
        }  
    }
    @Path("city/{cityName}")
    @GET
    public String getWeatherByCity( @PathParam("cityName") String city){
        Client client = ClientBuilder.newClient();
        WebTarget resource= client.target("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=026276b3f1eafbbf7597adcf1fd1820e");
        
        Builder request = resource.request();
        Response response = request.get();
        
        if(response.getStatus() == 200){
            String output = response.readEntity(String.class);

            return output;
        }else{
            return null;
        }  
    }
    @Path("Toronto/tom")
    @GET
    public String getTotnotoWeatherTom(){
        Client client = ClientBuilder.newClient();
        WebTarget resource= client.target("http://api.openweathermap.org/data/2.5/forecast?q=toronto,ca&cnt=20&appid=026276b3f1eafbbf7597adcf1fd1820e");
        
        Builder request = resource.request();
        Response response = request.get();
        
        if(response.getStatus() == 200){
            String output = response.readEntity(String.class);

            return output;
        }else{
            return null;
        }  
    }
     @Path("city/tom/{cityName}")
    @GET
    public String getWeatherTomByCity( @PathParam("cityName") String city){
        Client client = ClientBuilder.newClient();
        WebTarget resource= client.target("http://api.openweathermap.org/data/2.5/forecast?q="
                + city
                + "&cnt=20&appid=026276b3f1eafbbf7597adcf1fd1820e");
        
        Builder request = resource.request();
        Response response = request.get();
        
        if(response.getStatus() == 200){
            String output = response.readEntity(String.class);

            return output;
        }else{
            return null;
        }  
    }
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getSize(weather t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeTo(weather t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
