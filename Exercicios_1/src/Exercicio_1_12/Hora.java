package Exercicio_1_12;
import java.util.Scanner;
public class Hora {
	public byte hora;//INT é muito grande //Atributo ou variável de instância
	public byte minuto;
	public byte segundo;
	Scanner sc = new Scanner(System.in);

	private byte validaHora(byte hora) {
		if(hora > 23)
			return 0;
		return hora;
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
	public void consistente() {
		
	}
	public void setHora(byte hora) {			//Colocar as validações de horário (Consistência)
		this.hora = validaHora(hora);
	}
	public byte getHora() {
		return hora;
	}
	public byte incrementaHora() {//Corrigir a função
		hora++;
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
/*
	public Hora() {
		hora = 0;
		minuto = 0;
		segundo = 0;
	}
	
	public void LeituraHora() {
		System.out.println("Horas:");
		hora = sc.nextInt();
		System.out.println("Minutos:");
		minuto = sc.nextInt();
		System.out.println("Segundos:");
		segundo = sc.nextInt();
	}
	
	public void MostraHora() {
		System.out.println("Horário: " + hora + ":" + minuto + ":" + segundo);
	}
	*/
}
