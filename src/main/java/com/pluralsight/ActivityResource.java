
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
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MultivaluedMap;

@Path("activities") // To access anything inside this class localhost:9090/exercise-services/webapi/activities 
public class ActivityResource
{
    private ActivityRepository activRepos = new ActivityRepositoryStub();
    
    // When a GET HTTP request is sent to:
    // localhost:9090/exercise-services/webapi/activities
    // @getAllActivities is called and a list of @Activity is returned to the client. 
    // Binding an object - bound to paramters we're sendingi in.
    // Better than sending in a String, parsing 
    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivity(Activity activity) 
    {
        return activity;
    }
    
    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivityParams(MultivaluedMap<String, String> formParams) 
    {
        System.out.println(formParams.getFirst("description"));
        System.out.println(formParams.getFirst("duration"));
        
        Activity act = new Activity();
        act.setDescription(formParams.getFirst("description"));
        act.setDuration(Integer.valueOf(formParams.getFirst("duration")));
        
        activRepos.create(act);
        
        return act;
    }
    
    //@Produces(MediaType.APPLICATION_XML)
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity> getAllActivities() 
    {
        return activRepos.findAllActivities();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}") // localhost:9090/exercise-services/webapi/activities/1234 -> We can extend the path to access specific objects/methods using @Path tag.
    public Activity getAllActivity(@PathParam ("activityID") String activityID) 
    {
        return activRepos.findActivity(activityID);
    }
    
    // End value on URL is argument. 
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{activityId}/user") 
    public User getActivityUser(@PathParam ("activityID") String activityID) 
    {
        return activRepos.findActivity(activityID).getUser();
    }
    
    // To retrieve a nested object (user in example). The following URL: 
    // localhost:9090/exercise-services/webapi/activities/1234/user
}
