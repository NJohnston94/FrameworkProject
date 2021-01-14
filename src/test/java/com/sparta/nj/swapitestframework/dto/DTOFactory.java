package com.sparta.nj.swapitestframework.dto;

import com.sparta.nj.swapitestframework.connection.Injector;

public class DTOFactory {
    public static StarWarsAPIResource getResourceDTO(int dtoNumber, String url) {
        StarWarsAPIResource resourceDTO;

        switch(dtoNumber) {
            case 0 :
                resourceDTO = Injector.requestResponseAsPeopleDTO(url);
            case 1 :
                return new PlanetDTO();
        }

        return null;
    }

    public int selectDTOFromURL()
}
