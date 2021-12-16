package com.example.basicandroidcomponents.models.fragment.model;

public class PersonInformation {
    //region Property
    private String name;
    private String description;
    private int backgroundPictureProfile;
    private int pictureProfile;
    //endregion

    //region Constructors
    public PersonInformation(String name, String description, int backgroundPictureProfile, int pictureProfile) {
        this.name = name;
        this.description = description;
        this.backgroundPictureProfile = backgroundPictureProfile;
        this.pictureProfile = pictureProfile;
    }
    //endregion

    //region Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBackgroundPictureProfile() {
        return backgroundPictureProfile;
    }

    public void setBackgroundPictureProfile(int backgroundPictureProfile) {
        this.backgroundPictureProfile = backgroundPictureProfile;
    }

    public int getPictureProfile() {
        return pictureProfile;
    }

    public void setPictureProfile(int pictureProfile) {
        this.pictureProfile = pictureProfile;
    }
    //endregion
}
