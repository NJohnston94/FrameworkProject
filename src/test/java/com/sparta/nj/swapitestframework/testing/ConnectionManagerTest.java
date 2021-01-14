package com.sparta.nj.swapitestframework.testing;

import com.sparta.nj.swapitestframework.StarWarsAPITester;
import com.sparta.nj.swapitestframework.connection.ConnectionManager;
import com.sparta.nj.swapitestframework.exceptions.BadStatusCodeException;
import com.sparta.nj.swapitestframework.exceptions.HeaderNotFoundException;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ConnectionManagerTest {
    static Response lukeSkywalkerAPI;

    @BeforeAll
    static void setup() {
        lukeSkywalkerAPI = ConnectionManager.connectToResource("https://swapi.dev/api/people/1/");
    }

    @Test
    @DisplayName("Does url have status code 200?")
    void testConnectionToURL() {
        Assertions.assertEquals(200, lukeSkywalkerAPI.getStatusCode());
    }

    @Test
    @DisplayName("Is status code an integer?")
    void isStatusCodeAnInteger() {
        lukeSkywalkerAPI.then().assertThat().statusCode(Matchers.isA(Integer.class));
    }

    @Test
    @DisplayName("Are the headers returned in a list?")
    void doesReturnHeaders() {
        List<Header> headers = ConnectionManager.getResourceHeaders(lukeSkywalkerAPI);
        Assertions.assertNotNull(headers);
    }

    @ParameterizedTest
    @ValueSource(strings = "https://swapi.dev/api/people/1/")
    void doesReturnTrueFor200(String url) throws BadStatusCodeException {
        Assertions.assertTrue(ConnectionManager.getStatusCode(url));
    }

    @ParameterizedTest
    @ValueSource(strings = "https://swapi.dev/api/people/100/") //page should return HTTP 404
    void doesHandleStatusCodes(String url) {
        Assertions.assertThrows(BadStatusCodeException.class,
                () -> {ConnectionManager.getStatusCode(url);
                });
    }

    @ParameterizedTest
    @CsvSource({"Server, nginx/1.16.1, https://swapi.dev/api/people/1/",
                "Connection, keep-alive, https://swapi.dev/api/people/1/",
                "X-Frame-Options, SAMEORIGIN, https://swapi.dev/api/people/1/",
                "Date, Thu 14 Jan 2021 15:41:37 GMT, https://swapi.dev/api/people/1/"})
    @DisplayName("Does method return true for correct values, false for incorrect values via URL?")
    void areIncorrectHeadersViaURLFlagged(String headerName, String headerValue, String url) {
        Assertions.assertTrue(ConnectionManager.testResponseHeaders(headerName, headerValue, url));
    }

    @ParameterizedTest
    @CsvSource({"Server, nginx/1.16.1, https://swapi.dev/api/people/1/",
            "Connection, keep-alive, https://swapi.dev/api/people/1/",
            "X-Frame-Options, SAMEORIGIN, https://swapi.dev/api/people/1/",
            "Date, Thu 14 Jan 2021 15:41:37 GMT, https://swapi.dev/api/people/1/"})
    @DisplayName("Does method return true for correct values, false for incorrect values via Response?")
    void areIncorrectHeadersViaResponseFlagged(String headerName, String headerValue, String url) {
        Response response = RestAssured.get(url);
        Assertions.assertTrue(ConnectionManager.testResponseHeaders(headerName, headerValue, response));

    }

    @ParameterizedTest
    @CsvSource({"Server, nginx/1.16.1, https://swapi.dev/api/people/1/",
            "Connection, keep-alive, https://swapi.dev/api/people/1/",
            "X-Frame-Options, SAMEORIGIN, https://swapi.dev/api/people/1/",
            "Date, Thu 14 Jan 2021 15:41:37 GMT, https://swapi.dev/api/people/1/"})
    @DisplayName("Does method return Header value via URL?")
    void areHeaderValuesReturnedViaURL(String headerName, String headerValueActual, String url) throws HeaderNotFoundException {
        assertThat(ConnectionManager.getHeaderValue(headerName, url), Matchers.equalTo(headerValueActual));
    }

    @ParameterizedTest
    @CsvSource({"Server, nginx/1.16.1, https://swapi.dev/api/people/1/",
            "Connection, keep-alive, https://swapi.dev/api/people/1/",
            "X-Frame-Options, SAMEORIGIN, https://swapi.dev/api/people/1/",
            "Date, Thu 14 Jan 2021 15:41:37 GMT, https://swapi.dev/api/people/1/"})
    @DisplayName("Does method return Header value via Response?")
    void areHeaderValuesReturnedViaResponse(String headerName, String headerValueActual, String url) throws HeaderNotFoundException {
        Response response = RestAssured.get(url);
        assertThat(ConnectionManager.getHeaderValue(headerName, url), Matchers.equalTo(headerValueActual));
    }

    @ParameterizedTest
    @CsvSource({"ServerName, https://swapi.dev/api/people/1/"})
    @DisplayName("Does a null header value throw an exception")
    void doesNullHeaderValueThrowExceptionViaURL(String headerName, String url) {
        Assertions.assertThrows(HeaderNotFoundException.class,
                () -> {ConnectionManager.getHeaderValue(headerName, url);
                });
    }

    @ParameterizedTest
    @CsvSource({"ServerName, https://swapi.dev/api/people/1/"})
    @DisplayName("Does a null header value throw an exception")
    void doesNullHeaderValueThrowExceptionViaResponse(String headerName, String url) {
        Response response = RestAssured.get(url);
        Assertions.assertThrows(HeaderNotFoundException.class,
                () -> {ConnectionManager.getHeaderValue(headerName, response);
                });
    }

}
