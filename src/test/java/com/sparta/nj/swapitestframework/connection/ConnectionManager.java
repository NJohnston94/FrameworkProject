package com.sparta.nj.swapitestframework.connection;

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

    public static Integer getStatusCode(Response response) {
        int statusCode = response.getStatusCode();
        System.out.println("Response returned with HTTP Status Code:: " + statusCode);

        return statusCode;
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
