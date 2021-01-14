package com.sparta.nj.swapitestframework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.nj.swapitestframework.exceptions.InvalidRequestToDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class PeopleDTO implements StarWarsAPIResource {
    private Integer resourceID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("eye_color")
    private String eyeColour;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("hair_color")
    private String hairColour;
    @JsonProperty("height")
    private String height;
    @JsonProperty("mass")
    private String mass;
    @JsonProperty("skin_color")
    private String skinColour;
    @JsonProperty("homeworld")
    private String homeWorld;
    @JsonProperty("url")
    private String url;
    @JsonProperty("films")
    private ArrayList<String> films;
    @JsonProperty("species")
    private ArrayList<String> species;
    @JsonProperty("starships")
    private ArrayList<String> starships;
    @JsonProperty("vehicles")
    private ArrayList<String> vehicles;
    @JsonProperty("created")
    private String createdOn;
    @JsonProperty("edited")
    private String editedOn;

    public PeopleDTO() {
    }

    @Override
    public boolean isValueNullOrEmpty(String dtoString) {
        return dtoString.isEmpty();
    }

    @Override
    public boolean isValueNullOrEmpty(ArrayList<String> dtoArray) {
        return dtoArray.isEmpty();
    }

    @Override
    public boolean doesResponseHaveAnyNullOrEmptyValues() {
        for (String dtoDetail : getDTOStringDetails()) {
            if (isValueNullOrEmpty(dtoDetail)) {
                return false;
            }
        }

        for (ArrayList<String> dtoDetail : getDTOArrayDetails()) {
            if (isValueNullOrEmpty(dtoDetail)) {
                return false;
            }
        }
        return true;
    }

     private ArrayList<String> getDTOStringDetails() {
        ArrayList<String> dtoDetailsList = new ArrayList<>();

        dtoDetailsList.add(getName());
        dtoDetailsList.add(getBirthYear());
        dtoDetailsList.add(getEyeColour());
        dtoDetailsList.add(getGender());
        dtoDetailsList.add(getHairColour());
        dtoDetailsList.add(getHeight());
        dtoDetailsList.add(getMass());
        dtoDetailsList.add(getSkinColour());
        dtoDetailsList.add(getHomeWorld());
        dtoDetailsList.add(getUrl());
        dtoDetailsList.add(getCreatedOn());
        dtoDetailsList.add(getEditedOn());

        return dtoDetailsList;
    }

    private ArrayList<ArrayList<String>> getDTOArrayDetails() {
        ArrayList<ArrayList<String>> dtoDetailsList = new ArrayList<>();

        dtoDetailsList.add(getFilms());
        dtoDetailsList.add(getSpecies());
        dtoDetailsList.add(getStarships());
        dtoDetailsList.add(getVehicles());

        return dtoDetailsList;
    }

    @Override
    public JSONObject getJSONFromDTO() {
        JSONObject dtoJSON = new JSONObject();

        dtoJSON.put("Name", getName());
        dtoJSON.put("Birth Year", getBirthYear());
        dtoJSON.put("Eye Colour", getEyeColour());
        dtoJSON.put("Gender", getGender());
        dtoJSON.put("Hair Colour", getHairColour());
        dtoJSON.put("Height", getHeight());
        dtoJSON.put("Mass", getMass());
        dtoJSON.put("Skin Colour", getSkinColour());
        dtoJSON.put("Homeworld", getHomeWorld());
        dtoJSON.put("URL", getUrl());
        dtoJSON.put("Created", getCreatedOn());
        dtoJSON.put("Edited", getEditedOn());

        JSONArray films = new JSONArray();
        films.addAll(getFilms());
        dtoJSON.put("Films", films);

        JSONArray species = new JSONArray();
        species.addAll(getSpecies());
        dtoJSON.put("Species", species);

        JSONArray starships = new JSONArray();
        starships.addAll(getStarships());
        dtoJSON.put("Starships", starships);

        JSONArray vehicles = new JSONArray();
        vehicles.addAll(getVehicles());
        dtoJSON.put("Vehicles", vehicles);

        return dtoJSON;
    }

    @Override
    public boolean isNameCapitalised() {
        String[] names = getName().split(" ");
        for(String name : names){
            char firstLetterActual = name.charAt(0);
            char firstLetterExpected = name.toUpperCase().charAt(0);
            if(firstLetterActual != firstLetterExpected) {
                return false;
            }
        }
        return true;
    }

    public boolean isNameCapitalised(String fullName) {
        String[] names = fullName.split(" ");
        for(String name : names){
            char firstLetterActual = name.charAt(0);
            char firstLetterExpected = name.toUpperCase().charAt(0);
            if(firstLetterActual != firstLetterExpected) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public String getGender() {
        return gender;
    }

    public String getHairColour() {
        return hairColour;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }

    public String getSkinColour() {
        return skinColour;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<String> getFilms() {
        return films;
    }

    public ArrayList<String> getSpecies() {
        return species;
    }

    public ArrayList<String> getStarships() {
        return starships;
    }

    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getEditedOn() {
        return editedOn;
    }

    public String getDiameter() throws InvalidRequestToDTO {
        throw new InvalidRequestToDTO();
    }

}
