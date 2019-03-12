package com.example.ignite;

public class LabTour {
    String title,info,img,register,labguide;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getLabguide() {
        return labguide;
    }

    public void setLabguide(String labguide) {
        this.labguide = labguide;
    }

    public LabTour(String title, String info, String img, String register, String labguide) {
        this.title = title;
        this.info = info;
        this.img = img;
        this.register = register;
        this.labguide = labguide;
    }

    public LabTour() {
    }


}
