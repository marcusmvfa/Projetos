package animais;

public class Mamifero extends Animal{
	
	private String alimento;
	
	Mamifero(String nome, float comprimento, int numPatas, String cor, String ambiente, float velocidadeMedia, String alimento) {
		super(nome, comprimento, numPatas, cor, ambiente, velocidadeMedia);
		
		this.alimento = alimento;// TODO Auto-generated constructor stub
	}

	public String getAlimento() {
		return alimento;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}

	public void dadosMamifero() {
		super.dados();
		System.out.println("Alimento mamifero: %s " + alimento);
	}
}
