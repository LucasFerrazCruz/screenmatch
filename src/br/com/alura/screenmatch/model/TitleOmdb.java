package br.com.alura.screenmatch.model;

import com.google.gson.annotations.SerializedName;

public record TitleOmdb(
    @SerializedName("Title") String title,
    @SerializedName("Year") String year) {

    public int getYearAsInt() {
        try {
            if (year != null && year.length() <= 4) {
                return Integer.parseInt(year);
            } else {
                throw new NumberFormatException("Ano inválido: " + year);
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Erro ao converter o ano: " + e.getMessage(), e);
        }
    }
}
