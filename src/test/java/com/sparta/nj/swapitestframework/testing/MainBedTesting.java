package com.sparta.nj.swapitestframework.testing;

import com.sparta.nj.swapitestframework.StarWarsAPITester;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MainBedTesting {

    @ParameterizedTest
    @ValueSource(strings = "https://swapi.dev/api/people/1/")
    @DisplayName("What is actually being returned by these methods? See console (window)")
    void whatGetsReturned(String url) {
        System.out.println(StarWarsAPITester.APIConnection.getResponse(url));
        System.out.println();
        System.out.println();
        System.out.println(StarWarsAPITester.DTO.getDTO(url));
        System.out.println();
        System.out.println();
        System.out.println(StarWarsAPITester.DTO.getJSON(StarWarsAPITester.DTO.getDTO(url)).toJSONString());

    }
}
