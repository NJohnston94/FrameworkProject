package com.sparta.nj.swapitestframework.connection;

import com.sparta.nj.swapitestframework.exceptions.BadStatusCodeException;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.util.List;

public class ConnectionManager {
    public ConnectionManager() {
    }

    public static Response connectToResource(String url) {
        return RestAssured.get(url);
    }

    public static int getStatusCode(Response response) throws BadStatusCodeException {
        int statusCode = response.getStatusCode();
        System.out.println("Response returned with HTTP Status Code:: " + statusCode);

        if(statusCode != 200) {
            throw new BadStatusCodeException();
        } else {
            return statusCode;
        }
    }

    public static int getStatusCode(String url) throws BadStatusCodeException {
        int statusCode = RestAssured.get(url).getStatusCode();
        System.out.println("Response returned with HTTP Status Code:: " + statusCode);

        if(statusCode != 200) {
            throw new BadStatusCodeException();
        } else {
            return statusCode;
        }
    }

    public static int getStatusCodeNoException(String url) {
        return RestAssured.get(url).getStatusCode();
    }

    public static List<Header> getResourceHeaders(Response response) {
        List<Header> resourceHeaders = response.getHeaders().asList();
        System.out.println("Response returned with Headers::");
        for(Header header:resourceHeaders) {
            System.out.println("   " + header);
        }

        return resourceHeaders;
    }
}
