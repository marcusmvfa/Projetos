package exercicio_10_1;

public class Circulo {
	public float raio;
	public float area;
	private float pi = 3.1416f;

	public float getRaio() {
		return raio;
	}

	public void setRaio(float raio) {
		this.raio = raio;
	}
	
	public float AreaCirculo() {
		return area = (float)(pi * Math.pow(getRaio(), 2));
	}
}
