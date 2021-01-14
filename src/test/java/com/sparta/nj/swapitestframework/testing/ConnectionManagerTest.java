package com.sparta.nj.swapitestframework.testing;

import com.sparta.nj.swapitestframework.StarWarsAPITester;
import com.sparta.nj.swapitestframework.connection.ConnectionManager;
import com.sparta.nj.swapitestframework.exceptions.BadStatusCodeException;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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
    @ValueSource(strings = "https://swapi.dev/api/people/100/") //page should return HTTP 404
    void doesHandleStatusCodes(String url) {
        Assertions.assertThrows(BadStatusCodeException.class,
                () -> {ConnectionManager.getStatusCode(url);
                });
    }
}
