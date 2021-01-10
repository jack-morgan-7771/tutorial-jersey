
package com.pluralsight;

import com.pluralsight.model.Activity;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Server API class. Holds server methods. Methods are access by client via URL. 
 * URL to access method is specified by the @Path annotations. This means the actual method name does not matter for targeting. 
 * Example: localhost:9090/exercise-services/webapi/activities
 * @author jackmorgan
 */
@Path("activities") 
public class ActivityResource
{
    private ActivityRepository activRepos = new ActivityRepositoryStub();
    
    /**
     * Method accessed via URL: localhost:9090/exercise-services/webapi/activities/1234 where '1234' is the activity ID. 
     * Consumes annotation specifies the format the server is expecting the client to send.
     * Produces annotation specifies the format returned to the client by the server. 
     * You can have multiple return types in produces. If the initial fails we fall back to the next.
     * @param activityId
     * @return 
     */
    @DELETE
    @Path("{activityId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response delete(@PathParam("activityId") String activityId) 
    {
        activRepos.delete(activityId);   
        return Response.ok().build();
    }
    
    // Method name doesn't actually matter for any of these as methods are called through URL specified by @Path annotations. 
    @PUT
    @Path("{activityId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response update(Activity activity) 
    {
        activity = activRepos.update(activity);
        return Response.ok(activity).build();
    }

    /**
     * Here we're binding an object. The method accepts a POST request containing JSON representation of the 
     * Activity object and implicitly converts this JSON to the target object.
     * Much better than alternative (sending HashMap of Strings and parsing/casting them to build the object manually).
     */
    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivity(Activity activity) 
    {
        activRepos.create(activity);
        return activity;
    }
    
    /**
     * Here we're creating an activity using a form String instead of using a bound object.
     * This is deprecated. 
     */
    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivityParams(MultivaluedMap<String, String> formParams) 
    {  
        Activity act = new Activity();
        act.setDescription(formParams.getFirst("description"));
        act.setDuration(Integer.valueOf(formParams.getFirst("duration")));
        
        activRepos.create(act);
        return act;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity> getAllActivities() 
    {
        return activRepos.findAllActivities();
    }
    
    /**
     * Path tags can also be added to methods to access a specific method or nested object.
     * We can also return a HTTP response object to the client instead of simply returning the body of the response.
     * This means that we can tell the client if something has gone wrong and the client can response appropriately. 
     * @param activityID
     * @return 
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}")
    public Response getActivity(@PathParam ("activityId") String activityID) 
    {
        if (activityID == null || activityID.length() < 4) 
            return Response.status(Status.BAD_REQUEST).build();
        
        Activity activity = activRepos.findActivity(activityID);
        
        if (activity == null) 
            return Response.status(Status.NOT_FOUND).build();
        
        return Response.ok().entity(activRepos.findActivity(activityID)).build();
    }
    
    /**
     * Here we're retrieving a nested object. 
     * @param activityID
     * @return 
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}/user") 
    public User getActivityUser(@PathParam ("activityID") String activityID) 
    {
        return activRepos.findActivity(activityID).getUser();
    }
}
