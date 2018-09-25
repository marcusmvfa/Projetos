package Passaro;

public class Passaros {
	private String especie;
	private float valor;
	private int gaiola;
	private int tempoMeses;
	
	
	Passaros(String espec,float val, int gaiola, int meses){
		this.especie = espec;
		this.valor = val;
		this.gaiola = gaiola;
		this.tempoMeses = meses;
	}
	Passaros(){
		especie = "";
		valor = 0;
		gaiola = 0;
		tempoMeses = 0;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getGaiola() {
		return gaiola;
	}
	public void setGaiola(int gaiola) {
		this.gaiola = gaiola;
	}
	public int getTempoMeses() {
		return tempoMeses;
	}
	public void setTempoMeses(int tempoMeses) {
		this.tempoMeses = tempoMeses;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
}
