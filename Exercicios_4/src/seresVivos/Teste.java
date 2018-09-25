package seresVivos;

public class Teste {

	public static void main(String[] args) {
		SerVivo a = new SerVivo(false);
		
		a.nascer(19, 07, 1998);
		a.morrer(20, 11, 2900);
		System.out.printf("%s", a.toString());
		
		a.extinguir();
		System.out.printf("%s", a.toString());
	}
}
