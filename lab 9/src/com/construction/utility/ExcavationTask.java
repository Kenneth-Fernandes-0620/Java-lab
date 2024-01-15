package com.construction.utility;

public class ExcavationTask implements ConstructionTask {
    private double hours;
    private double hourlyRate;

    public ExcavationTask(double hours, double hourlyRate) {
        this.hours = hours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateCost() {
        return hours * hourlyRate;
    }

    @Override
    public String toString() {
        return "ExcavationTask [hours=" + hours + ", hourlyRate=" + hourlyRate + "]";
    }
}

