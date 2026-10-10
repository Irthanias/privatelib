package org.example.util;

public class UserInvalidException extends Exception{
    public UserInvalidException(){
        super("Username or password is invalid");
    }
}
