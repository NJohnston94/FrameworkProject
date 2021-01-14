package com.sparta.nj.swapitestframework.connection;

import com.sparta.nj.swapitestframework.exceptions.BadStatusCodeException;
import com.sparta.nj.swapitestframework.exceptions.HeaderNotFoundException;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

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

    public static List<Header> getResourceHeaders(String url) {
        Response response = connectToResource(url);
        List<Header> resourceHeaders = response.getHeaders().asList();
        System.out.println("Response returned with Headers::");
        for(Header header:resourceHeaders) {
            System.out.println("   " + header);
        }

        return resourceHeaders;
    }

    public static List<Header> getResourceHeaders(Response response) {
        List<Header> resourceHeaders = response.getHeaders().asList();
        System.out.println("Response returned with Headers::");
        for(Header header:resourceHeaders) {
            System.out.println("   " + header);
        }

        return resourceHeaders;
    }

    public static String getHeaderValue(String headerName, String url) throws HeaderNotFoundException {
        String headerValue = null;
        List<Header> resourceHeaders = getResourceHeaders(url);
        for(Header header:resourceHeaders) {
            if(header.toString().contains(headerName)) {
                headerValue = given().response().when().get(url).getHeader(headerName);
            }
        }  
        
        if(headerValue == null) {
            throw new HeaderNotFoundException();
        } else {
            return headerValue;
        }
    }

    public static String getHeaderValue(String headerName, Response response) throws HeaderNotFoundException {
        String headerValue = null;
        List<Header> resourceHeaders = getResourceHeaders(response);
        String url = response.then().extract().path("url").toString();
        for(Header header:resourceHeaders) {
            if(header.toString().contains(headerName)) {
                headerValue = given().response().when().get(url).getHeader(headerName);
            }
        }

        if(headerValue == null) {
            throw new HeaderNotFoundException();
        } else {
            return headerValue;
        }
    }

    public static boolean testResponseHeaders(String headerName, String headerValue, String url) {
        List<Header> resourceHeaders = getResourceHeaders(url);
        for(Header header:resourceHeaders) {
            if(header.toString().contains(headerName)) {
                System.out.println(headerName + " = " + headerValue + " is TRUE");
                return given().response().when().get(url).getHeader(headerName).equals(headerValue);
            }
        }
        System.out.println(headerName + " = " + headerValue + " is FALSE");
        return false;
    }

    public static boolean testResponseHeaders(String headerName, String headerValue, Response response) {
        List<Header> resourceHeaders = getResourceHeaders(response);
        String url = response.then().extract().path("url").toString();
        for(Header header:resourceHeaders) {
            if(header.toString().contains(headerName)) {
                return given().response().when().get(url).getHeader(headerName).equals(headerValue);
            }
        }
        return false;
    }
}
