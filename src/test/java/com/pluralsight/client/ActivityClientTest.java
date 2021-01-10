
package com.pluralsight.client;

import com.pluralsight.model.Activity;
import com.pluralsight.model.ActivitySearch;
import com.pluralsight.model.ActivitySearchType;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * JUnit tests for object search, URL param search, delete, put, create, and get. 
 * @author jackmorgan
 */
public class ActivityClientTest 
{
    @Ignore
    @Test
    public void testSearchObject() 
    {
        ActivitySearchClient client = new ActivitySearchClient(); 
        List<String> searchValues = new ArrayList<String>();
        
        searchValues.add("biking");
        searchValues.add("running");
        
        ActivitySearch search = new ActivitySearch();
        search.setDescriptions(searchValues); 
        search.setDurationFrom(30);
        search.setDurationTo(55);
        
        search.setSearchType(ActivitySearchType.SEARCH_BY_DESCRIPTION);
        List<Activity> activities = client.search(search);
        assertNotNull(activities);
    }
    
    @Ignore
    @Test
    public void testSearch() 
    {
        ActivitySearchClient client = new ActivitySearchClient(); 
        
        String param = "description";
        List<String> searchValues = new ArrayList<String>();
        searchValues.add("swimming");
        searchValues.add("running");
        
        String secondParam = "durationFrom";
        int durationFrom = 30; 
        
        String thirdParam = "durationTwo";
        int durationTo = 55;
        
        List<Activity> actitives = client.search(param, searchValues, secondParam, durationFrom, thirdParam, durationTo);
        assertNotNull(actitives);
    }
    
    @Ignore
    @Test
    public void testDelete() 
    {
        ActivityClient client = new ActivityClient();
        client.delete("1234");
    } 

    /**
     * For PUT the server provides the ID. We add dummy arguments for testing. 
     */
    @Ignore
    @Test
    public void testPut() 
    {
        Activity activity = new Activity();
        activity.setId("3456");
        activity.setDescription("Bikram Yoga");
        activity.setDuration(90);

        ActivityClient client = new ActivityClient(); 
        activity = client.update(activity);
        
        assertNotNull(activity);
    }
    
    
    /**
     * ID should not be set for POST requests as this is determined by server.  I
     */
    @Ignore
    @Test
    public void testCreate() 
    {
        ActivityClient client = new ActivityClient();
        Activity activity = new Activity();
        activity.setDescription("Swimming");
        activity.setDuration(90);
       
        activity = client.create(activity);
        assertNotNull(activity);  
    }
    
    /**
     * Static import allows access to public static members of the class/package. 
     * If client object is NULL then the test has failed. 
     */
    @Ignore
    @Test
    public void testGet() 
    {
        ActivityClient client = new ActivityClient();
        Activity activity = client.get("1234"); 
        assertNotNull(activity); 
    }
    
    @Ignore
    @Test 
    public void testGetList() 
    {
        ActivityClient client  = new ActivityClient();
        List<Activity> myList = client.get();
        assertNotNull(myList);
    }
    
    /**
     * Example of a 'bad' test where the expected result is a RuntimeException. 
     * No activity should exist with the ID '000'.
     */
    @Ignore
    @Test(expected=RuntimeException.class)
    public void testGetWithBadRequest() 
    {
        ActivityClient client = new ActivityClient();
        Activity activity = client.get("000"); 
    }
    
    @Ignore
    @Test(expected=RuntimeException.class)
    public void testGetWithNotFound() 
    {
        ActivityClient client = new ActivityClient();
        Activity activity = client.get("777");
    }
}
