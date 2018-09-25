package Passaro;

import java.util.ArrayList;

public class Sistema_Passaros {
	
	private int qtdPassaros = 0;
	
	Passaros[] vetor;
	
	Sistema_Passaros(){
		vetor = new Passaros[4];
	}
	
	public void incluir(Passaros p) {
		vetor[qtdPassaros] = p;
		qtdPassaros++;
	}
	
	public float valorEstoque() {
		float valor = 0;
		
		for(int i=0; i< qtdPassaros; i++) {
			valor += vetor[i].getValor();
		}
		return valor;
	}
	public int velho() {
		int idoso = 0;
		
		for(int i=0;i<qtdPassaros;i++) {
			if(idoso < vetor[i].getTempoMeses()) {
				idoso = vetor[i].getTempoMeses();
			}
		}
		return idoso;
	}
}
