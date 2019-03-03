package com.example.ignite;

public class Pdf {
    private String url;
    private boolean available;

    public Pdf(){

    }
    public Pdf(boolean available, String url){
        this.available=available;
        this.url=url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
