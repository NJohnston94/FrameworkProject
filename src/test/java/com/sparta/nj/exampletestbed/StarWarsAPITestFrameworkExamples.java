package com.sparta.nj.exampletestbed;

import com.sparta.nj.swapitestframework.StarWarsAPITester;
import com.sparta.nj.swapitestframework.dto.StarWarsAPIResource;
import com.sparta.nj.swapitestframework.exceptions.InvalidRequestToDTO;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class StarWarsAPITestFrameworkExamples {
    static final String        lukeSkywalkerURL = "https://swapi.dev/api/people/1/";
    static final String        yodaURL          = "https://swapi.dev/api/people/20/";
    static final String        obiwanKenobiURL  = "https://swapi.dev/api/people/10/";
    static final String        emptyURL         = "https://swapi.dev/api/people/100/";

    static StarWarsAPIResource lukeSkywalkerDTO = StarWarsAPITester.DTO.getDTO(lukeSkywalkerURL);
    static StarWarsAPIResource yodaDTO          = StarWarsAPITester.DTO.getDTO(yodaURL);
    static StarWarsAPIResource obiwanKenobiDTO  = StarWarsAPITester.DTO.getDTO(obiwanKenobiURL);

    @Nested
    @Disabled
    @DisplayName("API Connections Testing")
    public class apiConnectionExampleTests {

        @ParameterizedTest(name = "[{index}] Testing for value = {arguments}")
        @ValueSource(strings = {lukeSkywalkerURL, yodaURL, obiwanKenobiURL, emptyURL})
        @DisplayName("Get a response from the API and get its HTTP status code")
        void apiConnectionTest(String url) {
            StarWarsAPITester.APIConnection.getResponse(url);
        }

        @ParameterizedTest(name = "[{index}] Testing for value = {arguments}")
        @ValueSource(strings = {lukeSkywalkerURL, yodaURL, obiwanKenobiURL, emptyURL})
        @DisplayName("Assert an HTTP status code to be 200")
        void assertStatusCodes(String url) {
            StarWarsAPITester.APIConnection.assertStatusCode(url);
        }

        @ParameterizedTest(name = "[{index}] Testing for value = {arguments}")
        @ValueSource(strings = {lukeSkywalkerURL, yodaURL, obiwanKenobiURL, emptyURL})
        @DisplayName("Test an HTTP status code against 200 and return as a boolean")
        void testStatusCodes(String url) {
            StarWarsAPITester.APIConnection.testStatusCode(url);
        }

        @ParameterizedTest(name = "[{index}] Testing for value = {arguments}")
        @ValueSource(strings = {lukeSkywalkerURL, yodaURL, obiwanKenobiURL, emptyURL})
        @DisplayName("Get the Headers from the response in a list")
        void getHeaders(String url) {
            StarWarsAPITester.APIConnection.getResponseHeaders(url);
        }

        @ParameterizedTest
        @CsvSource({"Server, nginx/1.16.1, " + lukeSkywalkerURL,
                    "Connection, keep-alive, " + yodaURL,
                    "X-Frame-Options, SAMEORIGIN, " + obiwanKenobiURL,
                    "Date, Thu 14 Jan 2021 15:41:37 GMT, " + emptyURL})
        @DisplayName("Assert Header values against a Header name")
        void assertHeaderValues(String headerName, String headerValue, String url) {
            StarWarsAPITester.APIConnection.assertResponseHeaders(headerName, headerValue, url);
        }

        @ParameterizedTest
        @CsvSource({"Server, nginx/1.16.1, " + lukeSkywalkerURL,
                    "Connection, keep-alive, " + yodaURL,
                    "X-Frame-Options, SAMEORIGIN, " + obiwanKenobiURL,
                    "Date, Thu 14 Jan 2021 15:41:37 GMT, " + emptyURL})
        @DisplayName("Test Header values against a Header name and return as boolean")
        void testHeaderValues(String headerName, String headerValue, String url) {
            StarWarsAPITester.APIConnection.testResponseHeaders(headerName, headerValue, url);
        }

        @ParameterizedTest
        @CsvSource({"Server, " + lukeSkywalkerURL,
                    "Connection, " + yodaURL,
                    "X-Frame-Options, " + obiwanKenobiURL,
                    "Date, " + emptyURL})
        @DisplayName("Get a named Header value as a String")
        void getHeaderValues(String headerName, String url) {
            StarWarsAPITester.APIConnection.getHeaderValue(headerName, url);
        }

    }



    @ParameterizedTest(name = "[{index}] Testing for value = {arguments}")
    @ValueSource(strings = {lukeSkywalkerURL, yodaURL, obiwanKenobiURL, emptyURL})
    @DisplayName("Get the DTO type from the URL, then populate the relevant DTO as a new object")
    void populateDTO(String url) {
        StarWarsAPITester.DTO.getDTO(url);
    }

    private static Stream<Arguments> dtoAsArgument() {
        return Stream.of(
                Arguments.arguments(lukeSkywalkerDTO),
                Arguments.arguments(yodaDTO),
                Arguments.arguments(obiwanKenobiDTO)
        );
    }

    @ParameterizedTest
    @MethodSource("dtoAsArgument")
    @DisplayName("Get a DTO and return a boolean: true for no null/empty values and false for any null/empty values")
    void testNullValues(StarWarsAPIResource characterDTO) {
        Assertions.assertTrue(StarWarsAPITester.DTO.doesDtoHaveNullValues(characterDTO));

    }

    @ParameterizedTest
    @MethodSource("dtoAsArgument")
    @DisplayName("Test that the DTO name is capitalised and return a boolean")
    void testNameCapitalisation(StarWarsAPIResource characterDTO) {
        Assertions.assertTrue(StarWarsAPITester.DTO.isDtoNameCapitalised(characterDTO));
    }

    @ParameterizedTest
    @MethodSource("dtoAsArgument")
    @DisplayName("Test that the DTO value is capitalised and return a boolean")
    void testValueCapitalisation(StarWarsAPIResource characterDTO) {
        Assertions.assertTrue(StarWarsAPITester.DTO.isDtoValueCapitalised(characterDTO, "homeworld"));
    }

    @ParameterizedTest
    @MethodSource("dtoAsArgument")
    @DisplayName("Return a JSONObject from the source DTO")
    void testGetJSON(StarWarsAPIResource characterDTO) {
        JSONObject characterJSON = characterDTO.getJSONFromDTO();
        System.out.println(characterJSON.toJSONString());
    }

    @Test
    @DisplayName("Return DTO values as String, values that belong to a different DTO type throw an Exception")
    void buildObjectsFromDTO() throws InvalidRequestToDTO {
        System.out.println("     Name: " + lukeSkywalkerDTO.getName());
        System.out.println("Homeworld: " + lukeSkywalkerDTO.getHomeWorld());
        System.out.println("    Films: " + lukeSkywalkerDTO.getFilms());
        System.out.println(" Diameter: " + lukeSkywalkerDTO.getDiameter()); //throws an exception from PeopleDTO
    }

}
