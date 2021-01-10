
package com.pluralsight;
import com.pluralsight.model.Activity;
import com.pluralsight.model.ActivitySearch;
import javax.ws.rs.Path;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response.Status;

/**
 * Server API class. Holds server methods. Methods are access by client via URL. 
 * URL to access method is specified by the @Path annotations. This means the actual method name does not matter for targeting. 
 * Example: localhost:9090/exercise-services/webapi/search/activities
 * @author jackmorgan
 */
@Path("search/activities")
public class ActivitySearchResource 
{
    private ActivityRepository activityRepository = new ActivityRepositoryStub();
    
    /**
     * Method accepts an ActivtySearch object in JSON or XML as an argument.
     * Conversion is implicit and returns a list of activities that fit the
     * supplied constraints. 
     * @param search
     * @return 
     */
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response searchForActivies(ActivitySearch search) 
    {
        List<Activity> activities = activityRepository.findByConstraints(search);
        
        if (activities == null || activities.size() <= 0)
            return Response.status(Status.NOT_FOUND).build();
        
        return Response.ok().entity(new GenericEntity<List<Activity>>(activities){}).build();
    }

    /**
     * Alternative to above. Instead method parameters are supplied via the URL. 
     * @param descriptions
     * @param durationFrom
     * @param durationTo
     * @return 
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response searchForActivities(@QueryParam(value = "description") List<String> descriptions, @QueryParam(value = "durationFrom") int durationFrom, @QueryParam(value = "durationTo") int durationTo) 
    {
        List<Activity> activities = activityRepository.findByDescription(descriptions, durationFrom, durationTo);
        
        if (activities == null || activities.size() <= 0)
            return Response.status(Status.NOT_FOUND).build();
        
        return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {}).build();
    }
}
