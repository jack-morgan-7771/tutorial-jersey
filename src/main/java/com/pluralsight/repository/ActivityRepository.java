
package com.pluralsight.repository;

import com.pluralsight.model.Activity;
import com.pluralsight.model.ActivitySearch;
import java.util.List;

/**
 * Interface for repository stub.
 * @author jackmorgan
 */
public interface ActivityRepository 
{
    List<Activity> findAllActivities();   
    
    Activity findActivity(String activityId); 

    public void create(Activity act);

    public Activity update(Activity activity);

    public void delete(String activityId);
    
    public List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo);

    public List<Activity> findByConstraints(ActivitySearch search);
}
