
package com.pluralsight.model;

import com.pluralsight.User;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // Tells browser that this is an XML element it can display. Solves MessageBodyWriter exception.
public class Activity 
{
    private String description, id;
    private int duration; 
    private User user;

    public void setUser(User user) 
    {
        this.user = user;
    }

    public User getUser() 
    {
        return user;
    }

    public String getId() 
    {
        return id;
    }

    @XmlElement(name="desc")
    public String getDescription() 
    {
        return description;
    }

    @XmlElement(name="dur")
    public int getDuration() 
    {
        return duration;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public void setDuration(int duration) 
    {
        this.duration = duration;
    }
}
