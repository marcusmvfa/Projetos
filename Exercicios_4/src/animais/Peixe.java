package animais;

public class Peixe extends Animal{
	
	private String caracteristica;
	
	Peixe(String nome, float comprimento, int numPatas, String cor, String ambiente, float velocidadeMedia, String caracteristica) {
		super(nome, comprimento, numPatas, cor, ambiente, velocidadeMedia);
		
		this.caracteristica = caracteristica;// TODO Auto-generated constructor stub
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public void dadosPeixe() {
		super.dados();
		System.out.println("Caracteristica do peixe: %s " + caracteristica);
	}
}
