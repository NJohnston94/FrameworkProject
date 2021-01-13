package com.sparta.nj.swapitestframework.swapitestframeworktesting;

import com.sparta.nj.swapitestframework.connection.Injector;
import com.sparta.nj.swapitestframework.dto.PeopleDTO;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InjectorTest {
    @ParameterizedTest
    @ValueSource(strings = "https://swapi.dev/api/people/1/")
    public void testPeopleDTOInjector(String url) {
        PeopleDTO lukeSkywalkerDTO = Injector.requestResponseAsPeopleDTO(url);
    }
}
