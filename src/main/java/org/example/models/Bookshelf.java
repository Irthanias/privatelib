package org.example.models;

public class Bookshelf {
    private int id;
    private String name;
    private String room;
    private Integer shelfNr;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int value){
        id=value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value){
        name=value;
    }

    public String getRoom(){
        return room;
    }

    public void setRoom(String value){
        room=value;
    }

    public Integer getShelfNr(){
        return shelfNr;
    }

    public void setShelfNr(Integer value){
        shelfNr=value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value){
        description=value;
    }
}
