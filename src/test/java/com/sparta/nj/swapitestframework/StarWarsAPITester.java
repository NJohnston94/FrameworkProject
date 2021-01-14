package com.sparta.nj.swapitestframework;

import com.sparta.nj.swapitestframework.connection.ConnectionManager;
import com.sparta.nj.swapitestframework.dto.DTOFactory;
import com.sparta.nj.swapitestframework.dto.StarWarsAPIResource;
import com.sparta.nj.swapitestframework.exceptions.BadStatusCodeException;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

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

        public static Integer getStatusCode(String url) throws BadStatusCodeException {
            return ConnectionManager.getStatusCode(url);
        }

        public static Integer getStatusCode(Response response) throws BadStatusCodeException {
            return ConnectionManager.getStatusCode(response);
        }

        public static List<Header> getResponseHeaders(String url) {
            return ConnectionManager.getResourceHeaders(getResponse(url));
        }

        public static List<Header> getResponseHeaders(Response response) {
            return ConnectionManager.getResourceHeaders(response);
        }
    }

    public static class DTO {
        public static StarWarsAPIResource getDTO(String url) {
            return DTOFactory.getResourceDTO(DTOFactory.selectDTOFromURL(url), url);
        }

        public static boolean doesDtoHaveNullValues(StarWarsAPIResource dto) {
            return dto.doesResponseHaveAnyNullOrEmptyValues();
        }

        public static JSONObject getJSON(StarWarsAPIResource dto) {
            return dto.getJSONFromDTO();
        }
    }

}
