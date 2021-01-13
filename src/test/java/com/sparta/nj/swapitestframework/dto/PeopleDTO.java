package com.sparta.nj.swapitestframework.dto;

import java.util.ArrayList;

public class PeopleDTO extends StarWarsAPIResource implements StarWarsAPIBulkTesting{
    private String              birthYear;
    private String              eyeColour;
    private String              gender;
    private String              hairColour;
    private String              height;
    private String              mass;
    private String              skinColour;
    private String              homeWorld;
    private String              url;
    private ArrayList<String>   films;
    private ArrayList<String>   species;
    private ArrayList<String>   starships;
    private ArrayList<String>   vehicles;
    private String              createdOn;
    private String              editedOn;

}
