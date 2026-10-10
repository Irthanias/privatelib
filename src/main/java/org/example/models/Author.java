package org.example.models;

public final class Author {
    private int id;
    private String firstName;
    private String lastName;


    public int getId() {
        return id;
    }

    public void setId(int value){
        id=value;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String value){
        firstName=value;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String value){
        lastName=value;
    }

}
