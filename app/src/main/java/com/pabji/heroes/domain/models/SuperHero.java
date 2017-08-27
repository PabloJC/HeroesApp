package com.pabji.heroes.domain.models;

import android.os.Parcel;
import android.os.Parcelable;

public class SuperHero implements Parcelable{

    private String name;
    private String photo;
    private String realName;
    private String height;
    private String power;
    private String abilities;
    private String groups;

    public SuperHero(String name, String photo, String realName, String height, String power, String abilities, String groups) {
        this.name = name;
        this.photo = photo;
        this.realName = realName;
        this.height = height;
        this.power = power;
        this.abilities = abilities;
        this.groups = groups;
    }

    public SuperHero(){

    }

    protected SuperHero(Parcel in) {
        name = in.readString();
        photo = in.readString();
        realName = in.readString();
        height = in.readString();
        power = in.readString();
        abilities = in.readString();
        groups = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(photo);
        dest.writeString(realName);
        dest.writeString(height);
        dest.writeString(power);
        dest.writeString(abilities);
        dest.writeString(groups);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SuperHero> CREATOR = new Creator<SuperHero>() {
        @Override
        public SuperHero createFromParcel(Parcel in) {
            return new SuperHero(in);
        }

        @Override
        public SuperHero[] newArray(int size) {
            return new SuperHero[size];
        }
    };

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public String getPhoto() { return this.photo; }

    public void setPhoto(String photo) { this.photo = photo; }

    public String getRealName() { return this.realName; }

    public void setRealName(String realName) { this.realName = realName; }

    public String getHeight() { return this.height; }

    public void setHeight(String height) { this.height = height; }

    public String getPower() { return this.power; }

    public void setPower(String power) { this.power = power; }

    public String getAbilities() { return this.abilities; }

    public void setAbilities(String abilities) { this.abilities = abilities; }

    public String getGroups() { return this.groups; }

    public void setGroups(String groups) { this.groups = groups; }

}
