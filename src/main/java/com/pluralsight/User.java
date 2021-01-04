
package com.pluralsight;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User 
{
    private String name;
    private String id; 

    public String getName() 
    {
        return name;
    }

    public String getId() 
    {
        return id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setId(String id) 
    {
        this.id = id;
    }
}
