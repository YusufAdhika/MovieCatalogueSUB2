package com.example.moviecataloguesub2.listmovie;

import android.os.Parcel;
import android.os.Parcelable;

public class WatchModel implements Parcelable {
    private String string;
    private String overview;
    private Integer poster;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getPoster() {
        return poster;
    }

    public void setPoster(Integer poster) {
        this.poster = poster;
    }

    public WatchModel(String string, String overview, Integer poster) {
        this.string = string;
        this.overview = overview;
        this.poster = poster;
    }

    public WatchModel(int contentLayoutId, String string, String overview, Integer poster) {
        this.string = string;
        this.overview = overview;
        this.poster = poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.string);
        dest.writeString(this.overview);
        dest.writeValue(this.poster);
    }

    protected WatchModel(Parcel in) {
        this.string = in.readString();
        this.overview = in.readString();
        this.poster = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<WatchModel> CREATOR = new Parcelable.Creator<WatchModel>() {
        @Override
        public WatchModel createFromParcel(Parcel source) {
            return new WatchModel(source);
        }

        @Override
        public WatchModel[] newArray(int size) {
            return new WatchModel[size];
        }
    };
}