package com.sparta.nj.swapitestframework.testing;

import com.sparta.nj.swapitestframework.dto.DTOFactory;
import com.sparta.nj.swapitestframework.dto.StarWarsAPIResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DTOFactoryTest {

    @ParameterizedTest
    @CsvSource({
            "0, https://swapi.dev/api/people/1/",
            "1, https://swapi.dev/api/planets/3/",
            "2, https://swapi.dev/api/starships/9/",
            "3, https://swapi.dev/api/vehicles/8/",
            "4, https://swapi.dev/api/films/6/",
            "5, https://swapi.dev/api/species/10/"
    })
    @DisplayName("Is a DTO initialised by DTOFactory?")
    void doesFactoryCreateDTO(int dtoType, String url) {
        StarWarsAPIResource peopleDTO = DTOFactory.getResourceDTO(dtoType, url);
        Assertions.assertNotNull(peopleDTO);
    }

}
