
package com.pluralsight.model;

import java.util.List;

/**
 * Represents a top-level search object. The client passes this object to the server 
 * when making a search request and the server uses the objects attributes to decide what should 
 * be returned. 
 * @author jackmorgan
 */
public class ActivitySearch 
{
    private int durationFrom; 
    private int durationTo;
    private List<String> descriptions;
    private ActivitySearchType searchType;

    /**
     * Sets the search type.
     * @param searchType 
     */
    public void setSearchType(ActivitySearchType searchType) 
    {
        this.searchType = searchType;
    }

    /**
     * Returns the search type. 
     * @return 
     */
    public ActivitySearchType getSearchType() 
    {
        return searchType;
    }
    
    /**
     * Returns the duration from.
     * @return 
     */
    public int getDurationFrom() 
    {
        return durationFrom;
    }

    /**
     * Returns the duration to. 
     * @return 
     */
    public int getDurationTo() 
    {
        return durationTo;
    }
    
    /**
     * Sets the duration from.
     * @param durationFrom 
     */
    public void setDurationFrom(int durationFrom) 
    {
        this.durationFrom = durationFrom;
    }

    /**
     * Sets the duration to.
     * @param durationTo 
     */
    public void setDurationTo(int durationTo) 
    {
        this.durationTo = durationTo;
    }
    
    /**
     * Sets the descriptions to. 
     * @param descriptions 
     */
    public void setDescriptions(List<String> descriptions) 
    {
        this.descriptions = descriptions;
    }

    /**
     * Returns the descriptions. 
     * @return 
     */
    public List<String> getDescriptions() 
    {
        return descriptions;
    }
}
