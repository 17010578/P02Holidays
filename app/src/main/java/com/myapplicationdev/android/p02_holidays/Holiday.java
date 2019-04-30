package com.myapplicationdev.android.p02_holidays;

public class Holiday {

    private String name;
    private String date;
    private String img;

    public Holiday(String year,String date, String img) {
        this.name = year;
        this.img = img;
        this.date = date;

    }
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public String getImg() {
        return img;
    }

}
