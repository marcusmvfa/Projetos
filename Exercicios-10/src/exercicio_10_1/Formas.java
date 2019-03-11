package exercicio_10_1;

import Figuras.Ponto2D;
import Figuras.Retangulo;

public class Formas {
	private int tipo;
	private String forma;
	
	public String verificacao() {
		if(tipo == 1) {
			forma = "Retangulo";
		}
		else if(tipo == 2) {
			forma = "Triangulo";
		}
		else if(tipo == 3) {
			forma = "Circulo";
		}
		return forma;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	
	
}
