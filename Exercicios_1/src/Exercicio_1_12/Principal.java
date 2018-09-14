package Exercicio_1_12;

public class Principal {

	public static void main(String[] args) {
		Hora hora = new Hora((byte)21, (byte)40);
		
		System.out.println(hora.toString());
		hora.incrementaHora();
		hora.incrementaMinuto();
		System.out.println(hora.toString());
		
		hora.setHora((byte)100);
		System.out.println(hora.toString());
		
		Hora horaZero = new Hora();			//Polimorfismo o que diferencia é a qtd e o tipo de parametros
		System.out.println(hora.toString());
		
		
		Data data = new Data((byte)1, (byte)8, (short)2018);
		System.out.println(data);			//Chamada implicita // chama o toString(isso acontece em todo objeto
	}

}
