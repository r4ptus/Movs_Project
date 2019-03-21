package com.example.movs_project.Model.MasteryApi;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Slot {

    @SerializedName("runes")
    @Expose
    public List<Rune> runes = new ArrayList<>();

}
