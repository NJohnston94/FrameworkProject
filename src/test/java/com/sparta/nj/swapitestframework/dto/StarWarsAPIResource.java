package com.sparta.nj.swapitestframework.dto;

import com.sparta.nj.swapitestframework.exceptions.InvalidRequestToDTO;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public interface StarWarsAPIResource {
    boolean isValueNullOrEmpty(String string);
    boolean isValueNullOrEmpty(ArrayList<String> array);
    boolean doesResponseHaveAnyNullOrEmptyValues();
    boolean isNameCapitalised();
    boolean isNameCapitalised(String fullName);

    JSONObject getJSONFromDTO();

    String getName() throws InvalidRequestToDTO;
    String getBirthYear() throws InvalidRequestToDTO;
    String getEyeColour() throws InvalidRequestToDTO;
    String getGender() throws InvalidRequestToDTO;
    String getHairColour() throws InvalidRequestToDTO;
    String getHeight() throws InvalidRequestToDTO;
    String getMass() throws InvalidRequestToDTO;
    String getSkinColour() throws InvalidRequestToDTO;
    String getHomeWorld() throws InvalidRequestToDTO;
    String getUrl() throws InvalidRequestToDTO;
    ArrayList<String> getFilms() throws InvalidRequestToDTO;
    ArrayList<String> getSpecies() throws InvalidRequestToDTO;
    ArrayList<String> getStarships() throws InvalidRequestToDTO;
    ArrayList<String> getVehicles() throws InvalidRequestToDTO;
    String getCreatedOn() throws InvalidRequestToDTO;
    String getEditedOn() throws InvalidRequestToDTO;
    String getDiameter() throws InvalidRequestToDTO;

}
