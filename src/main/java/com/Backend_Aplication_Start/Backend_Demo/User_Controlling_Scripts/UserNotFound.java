package com.Backend_Aplication_Start.Backend_Demo.User_Controlling_Scripts;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserNotFound {
@ResponseBody
@ExceptionHandler(UserNotFoundExpection.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
String UserNotFoundHandler(UserNotFoundExpection ex) {
    return ex.getMessage();
}

}
