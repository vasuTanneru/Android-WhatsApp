package com.example.mywhatsapp.Models;

public class ChatsModel {
    String proImage,Name,About;

    public ChatsModel(String proImage, String name, String about) {
        this.proImage = proImage;
        Name = name;
        About = about;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }
}
