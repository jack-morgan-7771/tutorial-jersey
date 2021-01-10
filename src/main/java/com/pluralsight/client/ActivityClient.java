
package com.pluralsight.client;

import com.pluralsight.model.Activity;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Class represents a client with CRUD operations to manage Activity objects.
 * @author jackmorgan
 */
public class ActivityClient 
{
    private Client client;
    
    /**
     * Constructor to initialise Client.
     */
    public ActivityClient() 
    {
        client = ClientBuilder.newClient();
    }
    
    /**
     * Returns a single Activity using the Activities ID.
     * @param id
     * @return 
     */
    public Activity get(String id) 
    {  
        WebTarget target = client.target("http://localhost:9090/exercise-services/webapi/");
          
        // @Path method appends supplied String to Target path, makes a @GET request, and converts the JSON to a HTTP Response object..         
        Response resp = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Response.class); 
        
        if (resp.getStatus() != 200) 
            throw new RuntimeException(resp.getStatus() + ": there was an error on the server."); 

        return resp.readEntity(Activity.class);
    }
    
    /**
     * Returns a list of all Activities. 
     * @return 
     */
    public List<Activity> get() 
    {
        WebTarget target = client.target("http://localhost:9090/exercise-services/webapi/");
        
        // Need to wrap list in GET request in a GenericType object so it can be handled. 
        List<Activity> myList = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>(){});
        return myList;
    }

    
    /**
     * Adds an activity to the server. 
     * @param activity
     * @return 
     */
    public Activity create(Activity activity) 
    {
        WebTarget target = client.target("http://localhost:9090/exercise-services/webapi/");

        // Makes a @POST request. Activity is sent in JSON format.  
        Response resp = target.path("activities/activity").request().post(Entity.entity(activity, MediaType.APPLICATION_JSON)); 
        
        if (resp.getStatus() != 200) 
            throw new RuntimeException(resp.getStatus() + ": there was an error on the server."); 
        
        return resp.readEntity(Activity.class);
    }

    /**
     * Updates a pre-existing Activity on the server. 
     * @param activity
     * @return 
     */
    public Activity update(Activity activity) 
    {
        WebTarget target = client.target("http://localhost:9090/exercise-services/webapi/");
        Response resp = target.path("activities/activity" + activity.getId()).request().put(Entity.entity(activity, MediaType.APPLICATION_JSON));
        
        if (resp.getStatus() != 200) 
            throw new RuntimeException(resp.getStatus() + ": there was an error on the server."); 
        
        return resp.readEntity(Activity.class);
    }

    /**
     * Deletes a pre-existing Activity on the server. 
     * @param id      
     */
    public void delete(String activityId) 
    {
        WebTarget target = client.target("http://localhost:9090/exercise-services/webapi/");
        Response resp = target.path("activities/" + activityId).request(MediaType.APPLICATION_JSON).delete();

        if (resp.getStatus() != 200) 
            throw new RuntimeException(resp.getStatus() + ": there was an error on the server."); 
    }
}
