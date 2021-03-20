package view;

import controller.RadioEnlaceController;
import model.RadioEnlaceModel;

public class RadioEnlaceView {

	public static void main(String[] args) {
		RadioEnlaceController controller = new RadioEnlaceController(new RadioEnlaceModel());
		exibeCadastroDeDados(controller);
		exibirRaio(controller);
		exibirResultados(controller);

	}

	public static void exibeCadastroDeDados(RadioEnlaceController controller) {
		System.out.println("Digite a altura da torre do transmissor em metros: ");
		controller.getModel().setAlturaTX(controller.pegaDouble());
		System.out.println("Digite a altura da torre do receptor em metros: ");
		controller.getModel().setAlturaRX(controller.pegaDouble());
		System.out.println("Digite a distancia do Radio Enlace em quilometros: ");
		controller.getModel().setDistanciaRadioEnlace(controller.pegaDouble());
		System.out.println("Digite o valor da frequencia de operacao em GHz: ");
		controller.getModel().setFrequencia(controller.pegaDouble());
		System.out.println(
				"Para criar um Perfil Topografico eh necessario montar uma tabela de dados. Digite o numero de pontos que o seu perfil tera: ");
		controller.getModel().setPontos(controller.pegaInt());
		System.out.println("Digite as alturas dos pontos em metros: ");
		controller.cadastraAlturas();
		System.out.println("Digite as distancias dos pontos em quilometros: ");
		controller.cadastraDistancias();	

	}

	public static void exibirRaio(RadioEnlaceController controller) {
		System.out.println("O raio da zona de Fresnel de seu perfil eh de " + controller.calculoRaio());

	}

	public static void exibirResultados(RadioEnlaceController controller) {
		if (controller.calcularEGerarResultados() == true) {
			System.out.println("O Perfil Topografico possui uma linha de visada");
			System.out.println("Digite a potencia do transmissor em watts: ");
			controller.getModel().setPotenciaTX(controller.pegaDouble());
			System.out.println("Digite o numero de conectores: ");
			controller.getModel().setQuantidadeConector(controller.pegaInt());
			System.out.println("Digite a atenuação por conector em dB: ");
			controller.getModel().setAtenuacaoPorConector(controller.pegaDouble());
			controller.getModel().setAtenuacaoConector(
					controller.getModel().getQuantidadeConector() * controller.getModel().getAtenuacaoPorConector());
			System.out.println("Digite o ganho da antena de transmissão em dBi: ");
			controller.getModel().setGanhoTX(controller.pegaDouble());
			System.out.println("Digite o ganho da antena de recepcao em dBi: ");
			controller.getModel().setGanhoRX(controller.pegaDouble());
			System.out.println("Para o projeto, eh necessario escolher o cabo desejado.");
			System.out.println("Nosso programa oferece algumas opcoes, porem voce pode construir a sua!");
			System.out.println("Segue abaixo algumas opcoes. Digite a que mais lhe interessa: ");
			System.out.println("1 - Cabo TRI-LAN-400 50 ohms -> 2.4 GHz -> 0.22 dB de atenuacao por metro de cabo");
			System.out.println("2 - Cabo RG-174 50 ohms -> 2.4 GHz -> 2.40 dB de atenuacao por metro de cabo");
			System.out.println("3 - Cabo TRI-LAN-240 50 ohms -> 2.4 GHz -> 0.40 dB de atenuacao por metro de cabo");
			System.out.println("4 - Cabo RF-7 50 ohms -> 2.4 GHz -> 0.39 dB de atenuacao por metro de cabo");
			System.out
					.println("5 - Cabo DATALINK LMR 600 50 ohms -> 2.4 GHz -> 0.14 dB de atenuacao por metro de cabo");
			System.out.println("6 - Cabo RG 213 50 ohms -> 2.4 GHz -> 0.25 dB de atenuacao por metro de cabo");
			System.out.println("7 - Cabo TRI-LAN-240 50 ohms -> 5 GHz -> 0.60 dB de atenuacao por metro de cabo");
			System.out.println("8 - Cabo TRI-LAN-400 50 ohms -> 5 GHz -> 0.32 dB de atenuacao por metro de cabo");
			System.out.println("9 - Cabo DATALINK LMR 600 50 ohms -> 5 GHz -> 0.20 dB de atenuacao por metro de cabo");
			System.out.println(
					"10 - Cabo DATALINK DLC 8 Premium 50 ohms -> 5 GHz -> 0.34 dB de atenuacao por metro de cabo");
			System.out.println(
					"11 - Cabo DATALINK DLC 213 Premium 50 ohms -> 5 GHz -> 0.37 dB de atenuacao por metro de cabo");
			System.out.println("12 - Crie seu cabo! Digite a atenuacao (em dB) por metro desejada: ");
			System.out.println("Digite aqui: ");
			controller.atenuacaoCabo(controller.pegaInt());

			exibeCalculoAtenuacao(controller);
			exibeCalculoPotenciaRecebida(controller);
			exibeCalculoPotenciaIrradiada(controller);

		} else if (controller.calcularEGerarResultados() == false) {
			System.out.println("O Perfil Topografico não possui uma linha de visada");

		} else {
			System.out.println("Deu ruim");
		}
	}

	public static void exibeCalculoAtenuacao(RadioEnlaceController controller) {
		System.out.println("O nivel de sinal entregue ao receptor eh de: " + controller.calculoAtenuacao() + " dB");

	}

	public static void exibeCalculoPotenciaRecebida(RadioEnlaceController controller) {
		System.out.println("O valor da potencia recebida eh de: " + controller.calculoPotenciaRecebida() + " dBm");
	}

	public static void exibeCalculoPotenciaIrradiada(RadioEnlaceController controller) {
		System.out.println("A potencia efetivamente recebida eh de: " + controller.calculoPotenciaIrradiada() + " dBm");
	}

}
