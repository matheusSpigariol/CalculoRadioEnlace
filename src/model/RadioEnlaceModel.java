package model;

import java.util.ArrayList;

public class RadioEnlaceModel {
	private double alturaTX;
	private double alturaRX;
	private double potenciaTX;
	private double atenuacaoPorConector;
	private double atenuacaoConector;
	private double ganhoTX;
	private double ganhoRX;
	private double distanciaRadioEnlace;
	private double frequencia;
	private double atenuacaoCabo;
	private double raio;
	private int pontoCritico;
	private int quantidadeConector;
	private int pontos;
	private boolean los = true;
	private ArrayList<Double> topograficoDistancia = new ArrayList<Double>();
	private ArrayList<Double> topograficoAltura = new ArrayList<Double>();

	public double getAlturaTX() {
		return alturaTX;
	}

	public void setAlturaTX(double alturaTX) {
		this.alturaTX = alturaTX;
	}

	public double getAlturaRX() {
		return alturaRX;
	}

	public void setAlturaRX(double alturaRX) {
		this.alturaRX = alturaRX;
	}

	public double getPotenciaTX() {
		return potenciaTX;
	}

	public void setPotenciaTX(double potenciaTX) {
		this.potenciaTX = potenciaTX;
	}

	public double getAtenuacaoPorConector() {
		return atenuacaoPorConector;
	}

	public void setAtenuacaoPorConector(double atenuacaoPorConector) {
		this.atenuacaoPorConector = atenuacaoPorConector;
	}

	public double getAtenuacaoConector() {
		return atenuacaoConector;
	}

	public void setAtenuacaoConector(double atenuacaoConector) {
		this.atenuacaoConector = atenuacaoConector;
	}

	public double getGanhoTX() {
		return ganhoTX;
	}

	public void setGanhoTX(double ganhoTX) {
		this.ganhoTX = ganhoTX;
	}

	public double getGanhoRX() {
		return ganhoRX;
	}

	public void setGanhoRX(double ganhoRX) {
		this.ganhoRX = ganhoRX;
	}

	public double getDistanciaRadioEnlace() {
		return distanciaRadioEnlace;
	}

	public void setDistanciaRadioEnlace(double distanciaRadioEnlace) {
		this.distanciaRadioEnlace = distanciaRadioEnlace;
	}

	public double getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(double frequencia) {
		this.frequencia = frequencia;
	}

	public double getAtenuacaoCabo() {
		return atenuacaoCabo;
	}

	public void setAtenuacaoCabo(double atenuacaoCabo) {
		this.atenuacaoCabo = atenuacaoCabo;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	public int getQuantidadeConector() {
		return quantidadeConector;
	}

	public void setQuantidadeConector(int quantidadeConector) {
		this.quantidadeConector = quantidadeConector;
	}

	public int getPontoCritico() {
		return pontoCritico;
	}

	public void setPontoCritico(int pontoCritico) {
		this.pontoCritico = pontoCritico;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public boolean getLos() {
		return los;
	}

	public void setLos(boolean b) {
		this.los = b;
	}

	public ArrayList<Double> getTopograficoDistancia() {
		return topograficoDistancia;
	}

	public void setTopograficoDistancia(ArrayList<Double> topograficoDistancia) {
		this.topograficoDistancia = topograficoDistancia;
	}

	public ArrayList<Double> getTopograficoAltura() {
		return topograficoAltura;
	}

	public void setTopograficoAltura(ArrayList<Double> topograficoAltura) {
		this.topograficoAltura = topograficoAltura;
	}

}
