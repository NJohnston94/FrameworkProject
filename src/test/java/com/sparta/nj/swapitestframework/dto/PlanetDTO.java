package com.sparta.nj.swapitestframework.dto;

import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlanetDTO implements StarWarsAPIResource{

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
    public ArrayList<String> getDTOStringDetails() {
        return null;
    }

    @Override
    public ArrayList<ArrayList<String>> getDTOArrayDetails() {
        return null;
    }

    @Override
    public JSONObject getJSONFromDTO() {
        return null;
    }
}
