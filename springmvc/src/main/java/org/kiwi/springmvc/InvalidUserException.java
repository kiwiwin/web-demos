package org.kiwi.springmvc;

public class InvalidUserException extends RuntimeException{
    @Override
    public String getMessage() {
        return "try to visit invalid user";
    }
}
