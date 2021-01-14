package com.sparta.nj.exampletestbed;

import com.sparta.nj.swapitestframework.StarWarsAPITester;
import com.sparta.nj.swapitestframework.dto.StarWarsAPIResource;
import org.junit.jupiter.api.BeforeAll;

public class StarWarsAPITestFrameworkExamples {

    @BeforeAll
    static void setup() {
        String              lukeSkywalkerURL = "https://swapi.dev/api/people/1/";
        StarWarsAPIResource lukeSkywalkerDTO = StarWarsAPITester.DTO.getDTO(lukeSkywalkerURL);
        String              yodaURL = "https://swapi.dev/api/people/20/";
        StarWarsAPIResource yodaDTO          = StarWarsAPITester.DTO.getDTO(yodaURL);
        String              obiwanKenobiURL = "https://swapi.dev/api/people/10/";
        StarWarsAPIResource obiwanKenobiDTO  = StarWarsAPITester.DTO.getDTO(obiwanKenobiURL);
    }

}
