package com.parking.rest.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

public class Post  {

    private Long id;

    private Date date;

    private String title;

    private String content;

    private Account owner;

    public Post() {
//        this.date = new Date();
    }

    public Long getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        if (!id.equals(post.id)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("NewsEntry[%d, %s]", this.id, this.content);
    }

}