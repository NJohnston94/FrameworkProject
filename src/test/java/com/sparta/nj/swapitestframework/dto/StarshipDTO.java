package com.sparta.nj.swapitestframework.dto;

import com.sparta.nj.swapitestframework.exceptions.InvalidRequestToDTO;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class StarshipDTO implements StarWarsAPIResource{
    @Override
    public boolean isValueNullOrEmpty(String string) {
        return false;
    }

    @Override
    public boolean isValueNullOrEmpty(ArrayList<String> array) {
        return false;
    }

    @Override
    public boolean doesResponseHaveAnyNullOrEmptyValues() {
        return false;
    }

    @Override
    public JSONObject getJSONFromDTO() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getBirthYear() {
        return null;
    }

    @Override
    public String getEyeColour() {
        return null;
    }

    @Override
    public String getGender() {
        return null;
    }

    @Override
    public String getHairColour() {
        return null;
    }

    @Override
    public String getHeight() {
        return null;
    }

    @Override
    public String getMass() {
        return null;
    }

    @Override
    public String getSkinColour() {
        return null;
    }

    @Override
    public String getHomeWorld() {
        return null;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public ArrayList<String> getFilms() {
        return null;
    }

    @Override
    public ArrayList<String> getSpecies() {
        return null;
    }

    @Override
    public ArrayList<String> getStarships() {
        return null;
    }

    @Override
    public ArrayList<String> getVehicles() {
        return null;
    }

    @Override
    public String getCreatedOn() {
        return null;
    }

    @Override
    public String getEditedOn() {
        return null;
    }

    @Override
    public String getDiameter() throws InvalidRequestToDTO {
        return null;
    }

    @Override
    public boolean isNameCapitalised() {
        return false;
    }

    @Override
    public boolean isNameCapitalised(String fullName) {
        return false;
    }
}
