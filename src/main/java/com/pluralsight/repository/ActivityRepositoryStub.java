
package com.pluralsight.repository;

import com.pluralsight.User;
import java.util.ArrayList;
import java.util.List;
import com.pluralsight.model.Activity;
import com.pluralsight.model.ActivitySearch;

/**
 * Class mimics database behaviour. Used to testing so we don't need to set up an
 * actual database.
 * @author jackmorgan
 */
public class ActivityRepositoryStub implements ActivityRepository 
{
    private List<Activity> activities = new ArrayList<Activity>();
    
    /**
     * Return a list of all activities stored in the database. 
     * @return 
     */
    @Override
    public List<Activity> findAllActivities() 
    {
        Activity activity1 = new Activity();
        activity1.setDescription("Swimming");
        activity1.setDuration(55);
        activities.add(activity1);
        
        Activity activity2 = new Activity();
        activity2.setDescription("Cycling");
        activity2.setDuration(120);
        activities.add(activity2);
        
        Activity activity3 = new Activity();
        activity3.setDescription("Running");
        activity3.setDuration(240);
        activities.add(activity3);
        
        return activities; 
    }

    /**
     * Return a specific ID from the database using its ID.
     * @param activityId
     * @return 
     */
    @Override
    public Activity findActivity(String activityId) 
    {
        if (activityId.equals("777"))
            return null;
        
        Activity activity1 = new Activity();
        activity1.setDescription("Swimming");
        activity1.setDuration(55);
        activity1.setId("1234");
       
        User user = new User();
        user.setId("3421");
        user.setName("Jack Morgan");
        
        activity1.setUser(user);
        
        return activity1;
    }

    /**
     * Adds an activity to the database. 
     * @param actvt 
     */
    @Override
    public void create(Activity actvt) 
    {
        activities.add(actvt);
    }

    /**
     * Finds and updates the specified Activity. 
     * @param activity
     * @return 
     */
    @Override
    public Activity update(Activity activity) 
    {
        return activity; 
    }

    /** 
     * Deletes an Activity from the database.
     * @param activityId 
     */
    @Override
    public void delete(String activityId) 
    {
        for (int i = 0; i < activities.size(); i += 1) 
            if (activities.get(i).getId().equals(activityId)) 
                activities.remove(activities.get(i));
    }

    /**
     * Returns a list of activities with a matching descriptions with durations between
     * @durationFrom and @durationTo.
     * @param descriptions
     * @param durationFrom
     * @param durationTo
     * @return 
     */
    @Override
    public List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo)
    {
        // Takes list of Strings and returns all activities that have a matching description.
        // SELECT * FROM activities WHERE description = X AND durationFrom etc.
        List<Activity> activities = new ArrayList<Activity>();
        
        Activity activity = new Activity();
        activity.setId("2345");
        activity.setDescription("swimming");
        activity.setDuration(55);
        
        activities.add(activity);
        return activities; 
    }

    /**
     * Returns a list of activities that match against the constraints set by the 
     * ActivitySearch passed. 
     * @param search
     * @return 
     */
    @Override
    public List<Activity> findByConstraints(ActivitySearch search) 
    {
        List<Activity> activities = new ArrayList<Activity>();
        
        Activity activity = new Activity();
        activity.setId("2345");
        activity.setDescription("swimming");
        activity.setDuration(55);
        
        activities.add(activity);
        
        return activities; 
    }
}
