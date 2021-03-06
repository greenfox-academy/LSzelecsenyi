package com.greenfox.foxclub.model;

public class Trick {
    private String name;

    public Trick() {
    }

    public Trick(String trickDescription) {
        this.name = trickDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrick(String trick) {
        this.name = trick;
    }

    public String getTrick() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
