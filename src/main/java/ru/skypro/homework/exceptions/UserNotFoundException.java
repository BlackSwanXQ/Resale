package ru.skypro.homework.exceptions;

public class UserNotFoundException extends RuntimeException{


    public UserNotFoundException(String str)  {
        super(str);
    }

//    @Override
//    public String getMessage() {
//        return "User with id = %s not found".formatted(getMes());
//    }
}