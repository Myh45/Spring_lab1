package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private String author;
    private int year;
    private String publishing;
    private int pageCount;

    
    public Book(@JsonProperty("id") UUID id,
                @JsonProperty("title") String title,
                @JsonProperty("author") String author,
                @JsonProperty("year") int year,
                @JsonProperty("publishing") String publishing,
                @JsonProperty("pageCount") int pageCount){
        this.id=id;
        this.title=title;
        this.author=author;
        this.year=year;
        this.publishing=publishing;
        this.pageCount=pageCount;
        System.out.println(id+","+title+","+author);
    }

    public UUID getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear(){return  year;}

    public String getPublishing(){return publishing;}

    public int getPageCount(){return pageCount;}

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year){this.year=year;}

    public void setPublishing(String publishing){this.publishing=publishing;}

    public void setPageCount(int pageCount){this.pageCount=pageCount;}



}
