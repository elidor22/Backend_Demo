package com.Backend_Aplication_Start.Backend_Demo;

public class UserNotFoundExpection extends RuntimeException {

    public UserNotFoundExpection(Long id) {
        super("Could not find employee " + id);
    }
}
