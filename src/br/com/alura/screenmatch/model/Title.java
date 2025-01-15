package br.com.alura.screenmatch.model;

public class Title implements Comparable<Title>{
    private String name;
    private int yearOfRelease;
    private boolean includedInThePlan;
    private double sumOfRatings;
    private int totalReviews;
    private int durationInMinutes;

    public Title(String name, int yearOfRelease) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
    }

    public String getName() {
        return name;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public boolean getIncludedInThePlan() {
        return includedInThePlan;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }


    public void setIncludedInThePlan(boolean includedInThePlan) {
        this.includedInThePlan = includedInThePlan;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void displaysTechnicalSheet() {
        System.out.println(name);
        System.out.println(yearOfRelease);
    }

    public void evaluate(double grade) {
        sumOfRatings += grade;
        totalReviews ++;
    }

    public double takeAverage() {
        return sumOfRatings / totalReviews;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }
}
