package Exercicio_1_12;

public class Teste {

	public static void main(String[] args) {
		Hora a = new Hora();
		Hora a1 = new Hora();
		Data b = new Data();
		
		a.incrementaHora();
		a.incrementaMinuto();
		a.incrementaMinuto();
		System.out.printf("%s", a.toString());
		//b.LeituraData();
		
		//a.MostraHora();
		//b.MostrarData();
		/*
		if(a.hora == a1.hora || a.minuto == a1.minuto || a.segundo == a1.segundo) {
			System.out.println("Horário igual");
		}else {
			System.out.println("Horário Diferente");
		}*/

	}
}
