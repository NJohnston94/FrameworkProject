package com.sparta.nj.swapitestframework.dto;

import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface StarWarsAPIResource {
    boolean isValueNullOrEmpty(String string);
    boolean isValueNullOrEmpty(ArrayList<String> array);
    boolean doesResponseHaveAnyNullOrEmptyValues();
    ArrayList<String> getDTOStringDetails();
    ArrayList<ArrayList<String>> getDTOArrayDetails();
    JSONObject getJSONFromDTO();
}
