package Exercicio_1_12;

public class DataHora {
	private Data data;
	private Hora hora;
	
	public DataHora() {			//Construtor dentro de um construtor
		data = new Data();
		hora = new Hora();
	}
	
	public String toString() {
		return String.format("%s - %s", data, hora);
	}
}
