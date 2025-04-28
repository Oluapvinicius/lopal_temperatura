package br.dev.paulo.temperatura.model;

public class Temperatura {

	private double celsius;

	public Temperatura() {
		this.celsius = 0.0;
	}

	public double getCelsius() {
		return celsius;
	}

	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}

	public double converterParaKelvin() {
		return celsius + 273.15;
	}

	public double converterParaFahrenheit() {
		return (celsius * 1.8) + 32;
	}
}
