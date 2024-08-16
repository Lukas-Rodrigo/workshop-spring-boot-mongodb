package com.lucasteixeira.workshopmongodb.domain;

import com.lucasteixeira.workshopmongodb.dto.AuthorDTO;

import java.time.Instant;

public class Comment {

    private String comment;
    private Instant date;
    private AuthorDTO author;


    public Comment() {
    }

    public Comment(String comment, Instant date, AuthorDTO author) {
        this.comment = comment;
        this.date = date;
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
