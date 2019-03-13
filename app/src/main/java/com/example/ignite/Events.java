package com.example.ignite;

import android.os.Parcel;
import android.os.Parcelable;

public class Events implements Parcelable {
    private String url;
    private String timeandvenue;
    private int openTo;
    private String title;
    private String info;
    private String reg;
    private String down;
    private String prize;

    //iitgn=1
    //all=0
    public Events(){

    }


    public Events(String down, int openTo,String prize, String reg,String info,String timeandvenue, String title, String url){
        this.down=down;
        this.url=url;
        this.info=info;
        this.timeandvenue=timeandvenue;
        this.openTo=openTo;
        this.prize=prize;
        this.title=title;
        this.reg=reg;
    }
//
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public void setUrl(String url){
        this.url=url;
    }
    public String getUrl(){
        return url;
    }
    public void setTimeandvenue(String timeandvenue){
        this.timeandvenue=timeandvenue;
    }
    public String getTimeandvenue(){
        return timeandvenue;
    }
    public void setOpenTo(int openTo){
        this.openTo=openTo;
    }
    public int getOpenTo(){
        return openTo;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }


    public void setReg(String reg) {
        this.reg = reg;
    }
    public String getReg() {
        return reg;
    }
    public void setPrize(String prize) {
        this.prize = prize;
    }
    public String getPrize() {
        return prize;
    }

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }

    // Parcelling part
    public Events(Parcel source) {
        down=source.readString();
        info=source.readString();
        openTo = source.readInt();
        prize=source.readString();
        reg=source.readString();
        timeandvenue = source.readString();
        title = source.readString();
        url = source.readString();
    }
    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(down);
        dest.writeString(info);
        dest.writeInt(openTo);
        dest.writeString(prize);
        dest.writeString(reg);
        dest.writeString(timeandvenue);
        dest.writeString(title);
        dest.writeString(url);
    }
    public static final Parcelable.Creator CREATOR = new Creator<Events>() {
        public Events createFromParcel(Parcel in) {
            return new Events(in);
        }

        @Override
        public Events[] newArray(int size) {
            return new Events[size];
        }
    };
}
