package Exercicio_1_12;
import java.util.Scanner;
public class Hora {
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	public byte hora;//INT é muito grande //Atributo ou variável de instância
	public byte minuto;
	public byte segundo;

	private byte validaHora(byte hora) {
		if(hora > 23)
			return 0;
		return hora;
	}
	private byte validaMinuto(byte minuto) {
		if(minuto > 59)
			return 0;
		return minuto; 
	}
	public Hora(byte hora, byte minuto) {//dois escopos diferentes //Escopo maior variável de instância
		this.hora = validaHora(hora);
		this.minuto = minuto;
	}
	//Polimorfismo
	public Hora() {				//Construtor Sobrecarregado
		hora = 0;
		minuto = 0;
	}
	public void setHora(byte hora) {			//Colocar as validações de horário (Consistência)
		this.hora = validaHora(hora);
	}
	public byte getHora() {
		return hora;
	}
	public void setMinuto(byte min) {			//Colocar as validações de horário (Consistência)
		this.minuto = validaMinuto(minuto);
	}
	public byte getMinuto() {
		return minuto;
	}
	public byte incrementaHora() {//Corrigir a função
		if(hora!= 24)
			hora++;
		else
			System.out.println("Não é possível incrementar a hora");
		return hora;
	}
	public byte incrementaMinuto() {//Corrigir a função
		minuto++;
		return minuto;
	}
	public void zerar() {
		hora = 0;
		minuto = 0;
	}
	
	public String toString() {
		return String.format("%02d:%02d", hora, minuto);//Cria uma String nesse formato
	}
}
