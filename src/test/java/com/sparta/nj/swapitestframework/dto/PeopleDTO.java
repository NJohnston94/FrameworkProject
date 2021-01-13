package com.sparta.nj.swapitestframework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class PeopleDTO implements StarWarsAPIResource {
    private Integer             resourceID;
    @JsonProperty("name")
    private String              name;
    @JsonProperty("birth_year")
    private String              birthYear;
    @JsonProperty("eye_color")
    private String              eyeColour;
    @JsonProperty("gender")
    private String              gender;
    @JsonProperty("hair_color")
    private String              hairColour;
    @JsonProperty("height")
    private String              height;
    @JsonProperty("mass")
    private String              mass;
    @JsonProperty("skin_color")
    private String              skinColour;
    @JsonProperty("homeworld")
    private String              homeWorld;
    @JsonProperty("url")
    private String              url;
    @JsonProperty("films")
    private ArrayList<String>   films;
    @JsonProperty("species")
    private ArrayList<String>   species;
    @JsonProperty("starships")
    private ArrayList<String>   starships;
    @JsonProperty("vehicles")
    private ArrayList<String>   vehicles;
    @JsonProperty("created")
    private String              createdOn;
    @JsonProperty("edited")
    private String              editedOn;

    public PeopleDTO() {
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getSkinColour() {
        return skinColour;
    }

    public void setSkinColour(String skinColour) {
        this.skinColour = skinColour;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public void setHomeWorld(String homeWorld) {
        this.homeWorld = homeWorld;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<String> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<String> films) {
        this.films = films;
    }

    public ArrayList<String> getSpecies() {
        return species;
    }

    public void setSpecies(ArrayList<String> species) {
        this.species = species;
    }

    public ArrayList<String> getStarships() {
        return starships;
    }

    public void setStarships(ArrayList<String> starships) {
        this.starships = starships;
    }

    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<String> vehicles) {
        this.vehicles = vehicles;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getEditedOn() {
        return editedOn;
    }

    public void setEditedOn(String editedOn) {
        this.editedOn = editedOn;
    }
}
