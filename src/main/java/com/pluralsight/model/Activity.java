
package com.pluralsight.model;

import com.pluralsight.User;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents an Activity and includes getters and setters for instance variable access.
 * @author jackmorgan
 */
@XmlRootElement
public class Activity 
{
    private String description, id;
    private int duration; 
    private User user;

    /**
     * Sets the User for the activity.
     * @param user 
     */
    public void setUser(User user) 
    {
        this.user = user;
    }
    
    /**
     * Returns the User for the activity.
     * @return 
     */
    public User getUser() 
    {
        return user;
    }

    /**
     * Returns the ID for the activity.
     * @return 
     */
    public String getId() 
    {
        return id;
    }

    /**
     * Returns the description for the activity.
     * @return 
     */
    @XmlElement(name="desc")
    public String getDescription() 
    {
        return description;
    }

    /**
     * Returns the duration for the activity.
     * @return 
     */
    @XmlElement(name="dur")
    public int getDuration() 
    {
        return duration;
    }
    
    /**
     * Sets the ID for the activity.
     * @param id 
     */
    public void setId(String id) 
    {
        this.id = id;
    }

    /**
     * Sets the description for the activity.
     * @param description 
     */
    public void setDescription(String description) 
    {
        this.description = description;
    }
    
    /**
     * Sets the duration for the activity.
     * @param duration 
     */
    public void setDuration(int duration) 
    {
        this.duration = duration;
    }
}
