package com.sparta.nj.swapitestframework.connection;

import com.sparta.nj.swapitestframework.dto.PeopleDTO;
import static io.restassured.RestAssured.given;

public class Injector {
    public static PeopleDTO requestResponseAsPeopleDTO(String url) {
        System.out.println("Populating StarWarsAPIResource.PeopleDTO object from " + url);
        return given().when().get(url).as(PeopleDTO.class);
    }
}
