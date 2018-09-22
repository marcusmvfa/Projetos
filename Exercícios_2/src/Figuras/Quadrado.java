package Figuras;

public class Quadrado extends Retangulo{
	Ponto2D a = new Ponto2D(2,2);
	Ponto2D b = new Ponto2D(6,5);
	
	private double comprimento;
	private double largura;
	
	Quadrado(Ponto2D a, Ponto2D b){
		this.a = a.clone();
		this.b = b.clone();
	}
	Quadrado(){
		comprimento = 1;
		largura = comprimento;
	}
	@Override
	public float getComprimento() {
		return (float)comprimento;
	}
	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	public float getLargura() {
		return (float)largura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
	public double Base() {
		return Math.sqrt((a.getX() - b.getX()) * (a.getY() - b.getY()));
	}

	public double Area() {
		return Base() * Base();
	}
	public String toString() {
		return String.format("Area do Quadrado: %d", Area());
	}
}
