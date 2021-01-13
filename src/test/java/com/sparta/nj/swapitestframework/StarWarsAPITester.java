package com.sparta.nj.swapitestframework;

import com.sparta.nj.swapitestframework.dto.DTOFactory;
import com.sparta.nj.swapitestframework.dto.StarWarsAPIResource;

public class StarWarsAPITester {

    public StarWarsAPIResource getDTO(String url) {
        if(url.contains("people")) {
            return DTOFactory.getResourceDTO(0, url);
        } else if(url.contains("planets")) {
            return DTOFactory.getResourceDTO(1, url);
        } else if(url.contains("starships")) {
            return DTOFactory.getResourceDTO(2, url);
        } else if(url.contains("vehicles")) {
            return DTOFactory.getResourceDTO(3, url);
        } else if(url.contains("films")) {
            return DTOFactory.getResourceDTO(4, url);
        } else if(url.contains("species")) {
            return DTOFactory.getResourceDTO(5, url);
        } else {
            return null;
        }
    }
}
