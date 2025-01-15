package br.com.alura.screenmatch.calculations;

import br.com.alura.screenmatch.model.Title;

public class TimeCalculator {
    private double timeTotal = 0;

    public double getTimeTotal() {
        return timeTotal;
    }

    public void includes(Title title) {
        System.out.println("Adicionando duração em minutos de: " + title.getName());
        timeTotal += title.getDurationInMinutes();
    }
}
