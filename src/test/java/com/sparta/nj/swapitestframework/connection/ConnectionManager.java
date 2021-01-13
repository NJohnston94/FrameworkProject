package com.sparta.nj.swapitestframework.connection;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.List;

public class ConnectionManager {
    public ConnectionManager() {
    }

    public static Response connectToResource(String url) {
        return RestAssured.get(url);
    }

    public Integer getStatusCode(Response response) {
        return response.getStatusCode();
    }

    public List<Header> getResourceHeaders(Response response) {
        return response.getHeaders().asList();
    }
}
