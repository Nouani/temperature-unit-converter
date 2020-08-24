package br.unicamp.temperatureconverter;

public class UnitTemperature {
    private double degreesCelsius;

    public UnitTemperature(double degreesCelsius) {
        this.setDegreesCelsius(degreesCelsius);
    }

    public void setDegreesCelsius(double degreesCelsius) {
        this.degreesCelsius = degreesCelsius;
    }

    public double getDegreesCelsius() {
        return this.degreesCelsius;
    }

    public double toFahrenheit() {
        return (this.degreesCelsius * 9/5) + 32;
    }

    public double toKelvin() {
        return this.degreesCelsius + 273.15;
    }
}
