package br.com.alura.screenmatch.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public record TitleOmdbResponse(
    @SerializedName("Search") List<TitleOmdb> search,
    @SerializedName("totalResults") String totalResults,
    @SerializedName("Response") String response
) {}
