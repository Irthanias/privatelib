package org.example.models;

public final class Author {
    private int id;
    private String firstName;
    private String lastName;
    private String nationality;
    private int birthYear;

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

    public String getNationality(){
        return nationality;
    }

    public void setNationality(String value){
        nationality=value;
    }

    public int getBirthYear(){
        return birthYear;
    }

    public void setBirthYear(int value) {
        birthYear = value;
    }
}
