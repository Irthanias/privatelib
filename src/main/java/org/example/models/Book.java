package org.example.models;

public final class Book {
    private int id;
    private String title;
    private int publicationYear;
    private ReadingStatus readingStatus;
    private int authorId;
    private int genreId;
    private int shelfId;

    public int getId() {
        return id;
    }

    public void setId(int value){
        id=value;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String value){
        title=value;
    }

    public int getPublicationYear(){
        return publicationYear;
    }

    public void setPublicationYear(int value){
        publicationYear=value;
    }

    public ReadingStatus getReadingStatus(){
        return readingStatus;
    }

    public void setReadingStatus(ReadingStatus value){
        readingStatus=value;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int value){
        authorId=value;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int value){
        genreId=value;
    }

    public int getShelfId() {
        return shelfId;
    }

    public void setShelfId(int value){
        shelfId=value;
    }
}

