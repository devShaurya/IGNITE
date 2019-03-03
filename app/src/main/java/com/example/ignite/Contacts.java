package com.example.ignite;

public class Contacts {

    private String url;
    private String name;
    private String number;
    private String email;
    private String position;
    private String contact;
    public Contacts(){

    }
    public Contacts(String email, String contact, String name, String number, String position,String url) {
        this.email = email;
        this.name = name;
        this.contact=contact;
        this.number = number;
        this.url = url;
        this.position = position;
    }
    //iitgn=1

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    //all=0

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
