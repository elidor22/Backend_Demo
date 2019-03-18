package com.Backend_Aplication_Start.Backend_Demo.User_Controlling_Scripts;

public class UserNotFoundExpection extends RuntimeException {

    UserNotFoundExpection(Long id) {
        super("Could not find employee " + id);
    }
}
