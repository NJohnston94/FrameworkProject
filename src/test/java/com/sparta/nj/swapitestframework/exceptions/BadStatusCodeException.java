package com.sparta.nj.swapitestframework.exceptions;

public class BadStatusCodeException extends Exception {

    public String toString(int statusCode) {
        return "Bad status code. Investigate HTTP Code " + statusCode;
    }

}
