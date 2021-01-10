
package com.pluralsight;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class represents a User object and includes getters and setters to access instance variables. 
 * @author jackmorgan
 */
@XmlRootElement
public class User 
{
    private String name;
    private String id; 

    /**
     * Returns the users name.
     * @return 
     */
    public String getName() 
    {
        return name;
    }
    
    /**
     * Returns the users ID.
     * @return 
     */
    public String getId() 
    {
        return id;
    }

    /**
     * Sets the users name.
     * @param name 
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * Sets the users ID. 
     * @param id 
     */
    public void setId(String id) 
    {
        this.id = id;
    }
}
