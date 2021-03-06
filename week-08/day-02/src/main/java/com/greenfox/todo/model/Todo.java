package com.greenfox.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String title;
    private boolean isUrgent;
    private boolean isDone;

    public Todo() {
    }

    public Todo(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
