package com.sparta.nj.swapitestframework;

import com.sparta.nj.swapitestframework.connection.ConnectionManager;
import com.sparta.nj.swapitestframework.dto.DTOFactory;
import com.sparta.nj.swapitestframework.dto.StarWarsAPIResource;
import com.sparta.nj.swapitestframework.exceptions.BadStatusCodeException;
import com.sparta.nj.swapitestframework.exceptions.HeaderNotFoundException;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StarWarsAPITester {

    public static class APIConnection {
        public static Response getResponse(String url) {
            try {
                ConnectionManager.getStatusCode(url);
            } catch (BadStatusCodeException e) {
                System.out.println(e.toString(ConnectionManager.getStatusCodeNoException(url)));
            }
            return ConnectionManager.connectToResource(url);
        }

        public static boolean testStatusCode(String url) throws BadStatusCodeException {
            return ConnectionManager.getStatusCode(url);
        }

        public static boolean testStatusCode(Response response) throws BadStatusCodeException {
            return ConnectionManager.getStatusCode(response);
        }

        public static List<Header> getResponseHeaders(String url) {
            return ConnectionManager.getResourceHeaders(url);
        }

        public static List<Header> getResponseHeaders(Response response) {
            return ConnectionManager.getResourceHeaders(response);
        }

        public static String getHeaderValue(String headerName, String url) {
            try {
                return ConnectionManager.getHeaderValue(headerName, url);
            } catch (HeaderNotFoundException e) {
                e.toString();
            }
            System.out.println("getHeaderValue(" + headerName + ", " + url + ") returned NULL");
            return null;
        }

        public static String getHeaderValue(String headerName, Response response) {
            try {
                return ConnectionManager.getHeaderValue(headerName, response);
            } catch (HeaderNotFoundException e) {
                e.toString();
            }
            System.out.println("getHeaderValue(" + headerName + ", " + response.toString() + ") returned NULL");
            return null;
        }

        public static boolean testResponseHeaders(String headerName, String headerValue, String url) {
            return ConnectionManager.testResponseHeaders(headerName, headerValue, url);
        }

        public static boolean testResponseHeaders(String headerName, String headerValue, Response response) {
            return ConnectionManager.testResponseHeaders(headerName, headerValue, response);
        }
    }

    public static class DTO {
        public static StarWarsAPIResource getDTO(String url) {
            return DTOFactory.getResourceDTO(DTOFactory.selectDTOFromURL(url), url);
        }

        public static boolean isDtoValueNull(StarWarsAPIResource dto, String jsonObjectName) {
            return dto.isValueNullOrEmpty(jsonObjectName);
        }

        public static boolean isDtoValueNull(StarWarsAPIResource dto, ArrayList<String> jsonObjectName) {
            return dto.isValueNullOrEmpty(jsonObjectName);
        }

        public static boolean doesDtoHaveNullValues(StarWarsAPIResource dto) {
            return dto.doesResponseHaveAnyNullOrEmptyValues();
        }

        public static boolean isDtoNameCapitalised(StarWarsAPIResource dto) {
            return dto.isNameCapitalised();
        }

        public static boolean isDtoValueCapitalised(StarWarsAPIResource dto, String dtoValue) {
            return dto.isNameCapitalised(dtoValue);
        }

        public static JSONObject getJSON(StarWarsAPIResource dto) {
            return dto.getJSONFromDTO();
        }
    }

}
