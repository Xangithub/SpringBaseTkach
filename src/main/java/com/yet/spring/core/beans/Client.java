package com.yet.spring.core.beans;

public class Client {
    private String id;
    private  String fullName;
    private String greeting;

    public Client(String s, String s1) {
        this.id=s;
       this.fullName=s1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }
}
