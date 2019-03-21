package com.example.movs_project.Model.ChampionsApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("full")
    @Expose
    public String full;
    @SerializedName("sprite")
    @Expose
    public String sprite;
    @SerializedName("group")
    @Expose
    public String group;
    @SerializedName("x")
    @Expose
    public int x;
    @SerializedName("y")
    @Expose
    public int y;
    @SerializedName("w")
    @Expose
    public int w;
    @SerializedName("h")
    @Expose
    public int h;

    @Override
    public String toString() {
        return "Image{" +
                "full='" + full + '\'' +
                ", sprite='" + sprite + '\'' +
                ", group='" + group + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }
}
