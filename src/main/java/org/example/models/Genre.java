package org.example.models;

public final class Genre {
    private int id;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int value) {
        id = value;
    }

    public String getName(){
        return name;
    }

    public void setName(String value){
        name=value;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String value){
        description=value;
    }
}

