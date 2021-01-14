package com.sparta.nj.exampletestbed;

import com.sparta.nj.swapitestframework.StarWarsAPITester;
import com.sparta.nj.swapitestframework.dto.PeopleDTO;
import com.sparta.nj.swapitestframework.dto.StarWarsAPIResource;
import com.sparta.nj.swapitestframework.exceptions.BadStatusCodeException;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StarWarsAPITestFrameworkExamples {
    final String        lukeSkywalkerURL = "https://swapi.dev/api/people/1/";
    final String        yodaURL          = "https://swapi.dev/api/people/20/";
    final String        obiwanKenobiURL  = "https://swapi.dev/api/people/10/";

    final String        emptyURL         = "https://swapi.dev/api/people/100/";
    StarWarsAPIResource emptyDTO         = new PeopleDTO();

    @BeforeAll
    static void setup() {

    }

    @ParameterizedTest(name = "[{index}] Testing for value = {arguments}")
    @ValueSource(strings = {lukeSkywalkerURL, yodaURL, obiwanKenobiURL, emptyURL})
    @DisplayName("API Connection Tests with URL")
    void apiConnectionTestsURL(String url) {
        StarWarsAPITester.APIConnection.getResponse(url);
            System.out.println();
        StarWarsAPITester.APIConnection.testStatusCode(url);
            System.out.println();
        StarWarsAPITester.APIConnection.getResponseHeaders(url);
    }

    @ParameterizedTest(name = "[{index}] Testing for value = {arguments}")
    @ValueSource(strings = {lukeSkywalkerURL, yodaURL, obiwanKenobiURL, emptyURL})
    @DisplayName("API Connection Tests with Response")
    void apiConnectionTestsResponse(String url) {
        Response response = StarWarsAPITester.APIConnection.getResponse(url);
        StarWarsAPITester.APIConnection.testStatusCode(response);
            System.out.println();
        StarWarsAPITester.APIConnection.getResponseHeaders(response);
    }

    @ParameterizedTest
    @CsvSource({"Server, nginx/1.16.1, " + lukeSkywalkerURL,
                "Connection, keep-alive, " + yodaURL,
                "X-Frame-Options, SAMEORIGIN, " + obiwanKenobiURL,
                "Date, Thu 14 Jan 2021 15:41:37 GMT, " + emptyURL})
    @DisplayName("Header tests with URL")
    void headerTestsURL(String headerName, String headerValue, String url) {
        StarWarsAPITester.APIConnection.testResponseHeaders(headerName, headerValue, url);
    }

    @ParameterizedTest
    @CsvSource({"Server, nginx/1.16.1, " + lukeSkywalkerURL,
                "Connection, keep-alive, " + yodaURL,
                "X-Frame-Options, SAMEORIGIN, " + obiwanKenobiURL,
                "Date, Thu 14 Jan 2021 15:41:37 GMT, " + emptyURL})
    @DisplayName("Header tests with Response")
    void headerTestsResponse(String headerName, String headerValue, String url) {
        Response response = StarWarsAPITester.APIConnection.getResponse(url);
        StarWarsAPITester.APIConnection.testResponseHeaders(headerName, headerValue, response);
    }

    @ParameterizedTest
    @CsvSource({"Server, " + lukeSkywalkerURL,
                "Connection, " + yodaURL,
                "X-Frame-Options, " + obiwanKenobiURL,
                "Date, " + emptyURL})
    @DisplayName("Header values with URL")
    void headerValuesURL(String headerName, String url) {
        StarWarsAPITester.APIConnection.getHeaderValue(headerName, url);
    }

    @ParameterizedTest
    @CsvSource({"Server, " + lukeSkywalkerURL,
                "Connection, " + yodaURL,
                "X-Frame-Options, " + obiwanKenobiURL,
                "Date, " + emptyURL})
    @DisplayName("Header values with Response")
    void headerValuesResponse(String headerName, String url) {
        Response response = StarWarsAPITester.APIConnection.getResponse(url);
        StarWarsAPITester.APIConnection.getHeaderValue(headerName, response);
    }

}
