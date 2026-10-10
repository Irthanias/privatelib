package org.example.util;

public class DatabaseNotFoundException extends Exception{
    public DatabaseNotFoundException() {
        super("Database not found");
    }
}
