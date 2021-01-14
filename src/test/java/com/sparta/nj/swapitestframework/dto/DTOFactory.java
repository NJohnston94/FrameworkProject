package com.sparta.nj.swapitestframework.dto;

import com.sparta.nj.swapitestframework.connection.Injector;

public class DTOFactory {
    public static StarWarsAPIResource getResourceDTO(int dtoNumber, String url) {
        switch(dtoNumber) {
            case 0 :
                return Injector.requestResponseAsPeopleDTO(url);
            case 1 :
                return new PlanetDTO();
        }

        return null;
    }

    public static int selectDTOFromURL(String url) {
        if(url.contains("people")) {
            return 0;
        } else if(url.contains("planets")) {
            return 1;
        } else if(url.contains("starships")) {
            return 2;
        } else if(url.contains("vehicles")) {
            return 3;
        } else if(url.contains("films")) {
            return 4;
        } else if(url.contains("species")) {
            return 5;
        } else {
            return 6;
        }
    }
}
