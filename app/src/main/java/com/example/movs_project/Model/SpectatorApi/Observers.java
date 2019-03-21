package com.example.movs_project.Model.SpectatorApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Observers {

    @SerializedName("encryptionKey")
    @Expose
    public String encryptionKey;

    @Override
    public String toString() {
        return "Observers{" +
                "encryptionKey='" + encryptionKey + '\'' +
                '}';
    }
}
