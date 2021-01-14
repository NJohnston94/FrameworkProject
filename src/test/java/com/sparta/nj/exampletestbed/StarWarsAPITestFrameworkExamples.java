package com.sparta.nj.exampletestbed;

import com.sparta.nj.swapitestframework.StarWarsAPITester;
import com.sparta.nj.swapitestframework.dto.StarWarsAPIResource;
import com.sparta.nj.swapitestframework.exceptions.BadStatusCodeException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StarWarsAPITestFrameworkExamples {

    @BeforeAll
    static void setup() {
        String              lukeSkywalkerURL = "https://swapi.dev/api/people/1/";
        StarWarsAPIResource lukeSkywalkerDTO = StarWarsAPITester.DTO.getDTO(lukeSkywalkerURL);
        String              yodaURL          = "https://swapi.dev/api/people/20/";
        StarWarsAPIResource yodaDTO          = StarWarsAPITester.DTO.getDTO(yodaURL);
        String              obiwanKenobiURL  = "https://swapi.dev/api/people/10/";
        StarWarsAPIResource obiwanKenobiDTO  = StarWarsAPITester.DTO.getDTO(obiwanKenobiURL);

        String              emptyURL         = "https://swapi.dev/api/people/100/";
        //StarWarsAPIResource emptyDTO         = StarWarsAPITester.DTO.getDTO(emptyURL);
    }

    @ParameterizedTest(name = "[{index}] Testing for value = {arguments}")
    @CsvSource({"lukeSkywalkerURL",
                "yodaURL",
                "obiwanKenobiURL",
                "emptyURL"})
    @DisplayName("Does any HTTP status code other than 200 throw an exception?")
    void statusCodeURLExample(String url) throws BadStatusCodeException {
        StarWarsAPITester.APIConnection.testStatusCode(url);
    }

}
