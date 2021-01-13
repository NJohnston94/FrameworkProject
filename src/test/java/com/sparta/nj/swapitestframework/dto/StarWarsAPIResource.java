package com.sparta.nj.swapitestframework.dto;

/**
 * Every entry of every resource type has an id number;
 * this parent class will link the resource type DTOs as its children.
 */
public abstract class StarWarsAPIResource {
    private Integer resourceID;
    private String  resourceName;

    public Integer getResourceID() {
        return resourceID;
    }

    public void setResourceID(Integer resourceID) {
        this.resourceID = resourceID;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
