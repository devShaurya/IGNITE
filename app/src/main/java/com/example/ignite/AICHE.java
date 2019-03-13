package com.example.ignite;

public class AICHE {
    String title,info,img,reg,rule,title2;

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

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public AICHE(String title, String info, String img, String reg, String rule, String title2) {
        this.title = title;
        this.info = info;
        this.img = img;
        this.reg = reg;
        this.rule = rule;
        this.title2 = title2;
    }

    public AICHE() {
    }


}
