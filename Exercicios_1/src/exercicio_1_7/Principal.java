package exercicio_1_7;

public class Principal {

	public static void main(String[] args) {
		Encapsula_Contador a = new Encapsula_Contador();
		
		System.out.println(a.retornaValor());
		a.incrementar();
		System.out.println(a.retornaValor());
		a.zerar();
		System.out.println(a.retornaValor());
		a.incrementar();
		System.out.println(a.retornaValor());
		a.incrementar();
		System.out.println(a.retornaValor());
		a.incrementar();
		System.out.println(a.retornaValor());
		a.incrementar();
		System.out.println(a.retornaValor());
		a.zerar();
		System.out.println(a.retornaValor());
		

	}

}
