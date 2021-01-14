package com.sparta.nj.swapitestframework.exceptions;

public class InvalidRequestToDTO extends Exception{
    @Override
    public String toString() {
        return "This DTO does not contain that value";
    }
}
