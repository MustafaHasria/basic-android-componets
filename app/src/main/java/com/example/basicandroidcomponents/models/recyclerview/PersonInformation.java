package com.example.basicandroidcomponents.models.recyclerview;

public class PersonInformation {

    //region Property
    private String title,content,data;
    private int userPhoto;
    //endregion

    //region Constructors
    public PersonInformation(String title, String content, String data, int userPhoto) {
        this.title = title;
        this.content = content;
        this.data = data;
        this.userPhoto = userPhoto;
    }

    public PersonInformation(String title, String content, int userPhoto) {
        this.title = title;
        this.content = content;
        this.userPhoto = userPhoto;
    }
    //endregion

    //region Getters & Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        content = content;
    }

    public String getDate() {
        return data;
    }

    public void setDate(String data) {
        data = data;
    }

    public int getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(int userPhoto) {
        this.userPhoto = userPhoto;
    }
    //endregion
}
