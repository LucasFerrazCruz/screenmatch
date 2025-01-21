package br.com.alura.screenmatch.model;

import com.google.gson.annotations.SerializedName;

public record TitleOmdb(
    @SerializedName("Title") String title,
    @SerializedName("Year") String year,
    @SerializedName("Runtime") String runtime) {
}
