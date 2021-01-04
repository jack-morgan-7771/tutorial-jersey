
// Mimic database. 
package com.pluralsight.repository;

import com.pluralsight.User;
import java.util.ArrayList;
import java.util.List;
import com.pluralsight.model.Activity;

public class ActivityRepositoryStub implements ActivityRepository 
{
    @Override
    public List<Activity> findAllActivities() 
    {
        List<Activity> activities = new ArrayList<Activity>();
        
        Activity activity1 = new Activity();
        activity1.setDescription("Swimming");
        activity1.setDuration(55);
        
        activities.add(activity1);
        
        Activity activity2 = new Activity();
        activity2.setDescription("Cycling");
        activity2.setDuration(120);
        
        activities.add(activity2);
        
        return activities; 
    }

    @Override
    public Activity findActivity(String activityId) 
    {
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

    @Override
    public void create(Activity actvt) 
    {
        // Insert statement to DB goes here.
    }
}
