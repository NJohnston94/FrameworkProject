package com.sparta.nj.swapitestframework;

import com.sparta.nj.swapitestframework.connection.ConnectionManager;
import com.sparta.nj.swapitestframework.dto.DTOFactory;
import com.sparta.nj.swapitestframework.dto.StarWarsAPIResource;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import java.util.List;

public class StarWarsAPITester {

    public static class APIConnection {
        public static Response getResponse(String url) {
            return ConnectionManager.connectToResource(url);
        }

        public Integer getStatusCode(String url) {
            return ConnectionManager.getStatusCode(getResponse(url));
        }

        public Integer getStatusCode(Response response) {
            return ConnectionManager.getStatusCode(response);
        }

        public List<Header> getResponseHeaders(String url) {
            return ConnectionManager.getResourceHeaders(getResponse(url));
        }

        public List<Header> getResponseHeaders(Response response) {
            return ConnectionManager.getResourceHeaders(response);
        }
    }

    public StarWarsAPIResource getDTO(String url) {
        if(url.contains("people")) {
            return DTOFactory.getResourceDTO(0, url);
        } else if(url.contains("planets")) {
            return DTOFactory.getResourceDTO(1, url);
        } else if(url.contains("starships")) {
            return DTOFactory.getResourceDTO(2, url);
        } else if(url.contains("vehicles")) {
            return DTOFactory.getResourceDTO(3, url);
        } else if(url.contains("films")) {
            return DTOFactory.getResourceDTO(4, url);
        } else if(url.contains("species")) {
            return DTOFactory.getResourceDTO(5, url);
        } else {
            return null;
        }
    }

//    public StarWarsAPIResource getDTO(Response response) {
//        if(response.then().body("name", Matchers.equalTo())) {
//            return DTOFactory.getResourceDTO(0, url);
//        } else if(url.contains("planets")) {
//            return DTOFactory.getResourceDTO(1, url);
//        } else if(url.contains("starships")) {
//            return DTOFactory.getResourceDTO(2, url);
//        } else if(url.contains("vehicles")) {
//            return DTOFactory.getResourceDTO(3, url);
//        } else if(url.contains("films")) {
//            return DTOFactory.getResourceDTO(4, url);
//        } else if(url.contains("species")) {
//            return DTOFactory.getResourceDTO(5, url);
//        } else {
//            return null;
//        }
//    }
}
