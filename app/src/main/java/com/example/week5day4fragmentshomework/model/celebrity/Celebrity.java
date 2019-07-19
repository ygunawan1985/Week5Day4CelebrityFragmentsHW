package com.example.week5day4fragmentshomework.model.celebrity;

import android.os.Parcel;
import android.os.Parcelable;

public class Celebrity implements Parcelable {
    private String firstName;
    private String lastName;
    private int age;
    private String nationality;
    private String mostPopularMovie;
    private String picture;

    public Celebrity() {
    }

    public Celebrity(String firstName, String lastName, int age, String nationality, String mostPopularMovie, String picture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
        this.mostPopularMovie = mostPopularMovie;
        this.picture = picture;
    }

    protected Celebrity(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        age = in.readInt();
        nationality = in.readString();
        mostPopularMovie = in.readString();
        picture = in.readString();
    }

    public static final Creator<Celebrity> CREATOR = new Creator<Celebrity>() {
        @Override
        public Celebrity createFromParcel(Parcel in) {
            return new Celebrity(in);
        }

        @Override
        public Celebrity[] newArray(int size) {
            return new Celebrity[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMostPopularMovie() {
        return mostPopularMovie;
    }

    public void setMostPopularMovie(String mostPopularMovie) {
        this.mostPopularMovie = mostPopularMovie;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeInt(age);
        parcel.writeString(nationality);
        parcel.writeString(mostPopularMovie);
        parcel.writeString(picture);
    }
}
