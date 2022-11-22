package com.example.guessnumber.model;

import java.io.Serializable;

public class Request implements Serializable {
    String username;
    Integer guess;

    public Request(String username, Integer guess) {
        this.username = username;
        this.guess = guess;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGuess() {
        return guess;
    }

    public void setGuess(Integer guess) {
        this.guess = guess;
    }

    @Override
    public String toString() {
        return "Request{" +
                "username='" + username + '\'' +
                ", guess=" + guess +
                '}';
    }
}
