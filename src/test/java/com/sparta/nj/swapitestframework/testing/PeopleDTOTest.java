package com.sparta.nj.swapitestframework.testing;

import com.sparta.nj.swapitestframework.StarWarsAPITester;
import com.sparta.nj.swapitestframework.dto.PeopleDTO;
import com.sparta.nj.swapitestframework.dto.StarWarsAPIResource;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;

public class PeopleDTOTest {
    static StarWarsAPIResource lukeSkywalkerDTO = new PeopleDTO();

    @BeforeAll
    static void setup() {
        lukeSkywalkerDTO = StarWarsAPITester.DTO.getDTO("https://swapi.dev/api/people/1/");
    }

    @Test
    @DisplayName("Are DTO values added to a list?")
    void assertValuesAddedToList() {
        assertThat(lukeSkywalkerDTO.getDTOStringDetails(), Matchers.hasSize(12));
        assertThat(lukeSkywalkerDTO.getDTOArrayDetails(), Matchers.hasSize(4));
    }

    @ParameterizedTest
    @ValueSource(strings = "")
    @DisplayName("Do empty strings return true?")
    void isStringNullOrEmpty(String string) {
        assertThat(lukeSkywalkerDTO.isValueNullOrEmpty(string), Matchers.equalTo(true));
    }

    @Test
    @DisplayName("Do empty arrays return true?")
    void isArrayNullOrEmpty() {
        ArrayList<String> emptyArray = new ArrayList<>();
        assertThat(lukeSkywalkerDTO.isValueNullOrEmpty(emptyArray), Matchers.equalTo(true));
    }
}
