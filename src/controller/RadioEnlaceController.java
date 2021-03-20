package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.RadioEnlaceModel;

public class RadioEnlaceController {

	private RadioEnlaceModel model;
	private static Scanner sc;
	private ArrayList<Double> auxTopograficoDistancia = new ArrayList<Double>();
	private ArrayList<Double> auxTopograficoAltura = new ArrayList<Double>();

	public RadioEnlaceController(RadioEnlaceModel model) {
		this.setModel(model);

	}

	public RadioEnlaceModel getModel() {
		return model;
	}

	public void setModel(RadioEnlaceModel model) {
		this.model = model;
	}

	public void cadastraAlturas() {
		for (int i = 0; i < model.getPontos(); i++) {
			auxTopograficoAltura.add(this.pegaDouble());
		}
		model.setTopograficoAltura(auxTopograficoAltura);
	}

	public void cadastraDistancias() {
		for (int i = 0; i < model.getPontos(); i++) {
			auxTopograficoDistancia.add(this.pegaDouble());
		}
		model.setTopograficoDistancia(auxTopograficoDistancia);

	}

	public double calculoRaio() {
		double maior = 0;
		double raio;
		double aux2;

		for (int i = 0; i < getModel().getPontos(); i++) {
			if (getModel().getTopograficoAltura().get(i) > maior) {
				maior = getModel().getTopograficoAltura().get(i);
				getModel().setPontoCritico(i);
			}
		}
		aux2 = getModel().getDistanciaRadioEnlace()
				- getModel().getTopograficoDistancia().get(getModel().getPontoCritico());
		raio = 547.75 * Math.sqrt((getModel().getTopograficoDistancia().get(getModel().getPontoCritico()) * aux2)
				/ (getModel().getFrequencia() * 1000 * getModel().getDistanciaRadioEnlace()));
		return raio;
	}

	public boolean calcularEGerarResultados() {
		double aux1 = 0;
		double aux2 = 0;
		double mediaAltura;

		aux1 = getModel().getTopograficoAltura().get(0) + getModel().getAlturaTX();
		aux2 = getModel().getTopograficoAltura().get(getModel().getPontos() - 1) + getModel().getAlturaRX();
		mediaAltura = (aux1 + aux2) / 2;
		getModel().setLos((mediaAltura - getModel().getRaio()) > getModel().getTopograficoAltura()
				.get(getModel().getPontoCritico()));

		if (getModel().getLos()) {
			return true;
		} else {
			return false;
		}
	}

	public void temLoS() {
		sc = new Scanner(System.in);
		System.out.println("Digite a potencia do transmissor em watts: ");
		getModel().setPotenciaTX(sc.nextDouble());
		System.out.println("Digite o numero de conectores: ");
		getModel().setQuantidadeConector(sc.nextInt());
		System.out.println("Digite a atenuação por conector em dB: ");
		getModel().setAtenuacaoPorConector(sc.nextDouble());
		getModel().setAtenuacaoConector(getModel().getQuantidadeConector() * getModel().getAtenuacaoPorConector());
		System.out.println("Digite o ganho da antena de transmissão em dBi: ");
		getModel().setGanhoTX(sc.nextDouble());
		System.out.println("Digite o ganho da antena de recepcao em dBi: ");
		getModel().setGanhoRX(sc.nextDouble());

	}

	public void atenuacaoCabo(int op) {
		switch (op) {
		case 1:
			model.setAtenuacaoCabo(0.22);
			break;

		case 2:
			model.setAtenuacaoCabo(2.40);
			break;

		case 3:
			model.setAtenuacaoCabo(0.40);
			break;

		case 4:
			model.setAtenuacaoCabo(0.39);
			break;

		case 5:
			model.setAtenuacaoCabo(0.14);
			break;

		case 6:
			model.setAtenuacaoCabo(0.25);
			break;

		case 7:
			model.setAtenuacaoCabo(0.6);
			break;

		case 8:
			model.setAtenuacaoCabo(0.32);
			break;

		case 9:
			model.setAtenuacaoCabo(0.20);
			break;

		case 10:
			model.setAtenuacaoCabo(0.34);
			break;

		case 11:
			model.setAtenuacaoCabo(0.37);
			break;

		case 12:
			model.setAtenuacaoCabo(this.pegaDouble());
			break;

		default:
			break;
		}
	}

	public double calculoAtenuacao() {
		double fspl;
		fspl = (20 * Math.log10(model.getDistanciaRadioEnlace())) + ((20 * Math.log10(model.getFrequencia())) + 92.45);
		return fspl;
	}

	public double calculoPotenciaRecebida() {
		double potenciadBm;
		double potenciaRxdBm;
		double aux;
		double comprimentoOnda;

		comprimentoOnda = (300000000 / (model.getFrequencia() * 1000000000));
		potenciadBm = 10 * Math.log10(1000 * model.getPotenciaTX());
		aux = (4 * Math.PI * model.getDistanciaRadioEnlace() * 1000) / comprimentoOnda;
		potenciaRxdBm = potenciadBm + model.getGanhoTX() + model.getGanhoRX() - (20 * Math.log10(aux));
		return potenciaRxdBm;
	}

	public double calculoPotenciaIrradiada() {
		double eirp;
		double potenciaTxdBm;
		double aux;
		double tamanhoCabo;
		double atenuacaoTotalCabo;

		potenciaTxdBm = 10 * (Math.log10(1000 * model.getPotenciaTX()));

		if ((model.getTopograficoAltura().get(0)
				+ model.getAlturaTX()) == (model.getTopograficoAltura().get(model.getPontos() - 1)
						+ model.getAlturaRX())) {
			tamanhoCabo = model.getDistanciaRadioEnlace() * 1000;
		} else {
			aux = (model.getTopograficoAltura().get(0) + model.getAlturaTX())
					- (model.getTopograficoAltura().get(model.getPontos() - 1) + model.getAlturaRX());
			if (aux < 0) {
				aux = aux * (-1);
			}
			tamanhoCabo = Math.sqrt(Math.pow(model.getDistanciaRadioEnlace() * 1000, 2) + Math.pow(aux, 2));
		}

		atenuacaoTotalCabo = tamanhoCabo * model.getAtenuacaoCabo();
		eirp = potenciaTxdBm + model.getGanhoTX() - atenuacaoTotalCabo - model.getAtenuacaoConector();

		return eirp;
	}

	public double pegaDouble() {
		sc = new Scanner(System.in);
		return sc.nextDouble();
	}

	public int pegaInt() {
		sc = new Scanner(System.in);
		return sc.nextInt();
	}
}
