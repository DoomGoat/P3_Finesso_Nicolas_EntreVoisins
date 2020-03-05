package com.openclassrooms.entrevoisins.model;

import android.content.Intent;
import android.os.Bundle;

import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour {

    /** Identifier */
    private long id;

    /** Full name */
    private String name;

    /** Avatar */
    private String avatarUrl;

    /** Adress */
    private String address;

    /** Phone number */
    private String phoneNumber;

    /** About me */
    private String aboutMe;

    /** Favorite */
    private boolean favorite;



    /**
     * Constructor
     * @param id
     * @param name
     * @param avatarUrl
     */
    public Neighbour(long id, String name, String avatarUrl, String address,
                     String phoneNumber, String aboutMe, boolean favorite) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.aboutMe = aboutMe;
        this.favorite = favorite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(id, neighbour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setExtras(Neighbour neighbour, Intent intent) {
        Bundle extras = new Bundle();
        extras.putLong("USER_ID", neighbour.getId());
        extras.putString("USER_NAME", neighbour.getName());
        extras.putString("USER_AVATAR", neighbour.getAvatarUrl());
        extras.putString("USER_ADDRESS", neighbour.getAddress());
        extras.putString("USER_PHONE", neighbour.getPhoneNumber());
        extras.putString("USER_ABOUT", neighbour.getAboutMe());
        extras.putBoolean("USER_FAVORITE", neighbour.getFavorite());
        intent.putExtras(extras);
    }

    static public Neighbour getExtras(Intent intent) {
        Bundle extras = intent.getExtras();
        assert extras != null;
        return new Neighbour(extras.getLong("USER_ID"),
                extras.getString("USER_NAME"),
                extras.getString("USER_AVATAR"),
                extras.getString("USER_ADDRESS"),
                extras.getString("USER_PHONE"),
                extras.getString("USER_ABOUT"),
                extras.getBoolean("USER_FAVORITE"));
    }
}