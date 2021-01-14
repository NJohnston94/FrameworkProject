package com.sparta.nj.swapitestframework;

import com.sparta.nj.swapitestframework.connection.ConnectionManager;
import com.sparta.nj.swapitestframework.dto.DTOFactory;
import com.sparta.nj.swapitestframework.dto.StarWarsAPIResource;
import com.sparta.nj.swapitestframework.exceptions.BadStatusCodeException;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

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

        public Integer getStatusCode(String url) throws BadStatusCodeException {
            return ConnectionManager.getStatusCode(url);
        }

        public Integer getStatusCode(Response response) throws BadStatusCodeException {
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
        return DTOFactory.getResourceDTO(DTOFactory.selectDTOFromURL(url), url);
    }
}
