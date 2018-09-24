package animais;

public class Animal {
	private String nome;
	private float comprimento;
	private int numPatas;
	private String cor;
	private String ambiente;
	private float velocidadeMedia;
	
	
	Animal(String nome, float comprimento, int numPatas, String cor,
			String ambiente, float velocidadeMedia){
		this.nome = nome;
		this.comprimento = comprimento;
		this.numPatas = numPatas;
		this.cor = cor;
		this.ambiente = ambiente;
		this.velocidadeMedia = velocidadeMedia;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public float getComprimento() {
		return comprimento;
	}


	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}


	public int getNumPatas() {
		return numPatas;
	}


	public void setNumPatas(int numPatas) {
		this.numPatas = numPatas;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getAmbiente() {
		return ambiente;
	}


	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}


	public float getVelocidadeMedia() {
		return velocidadeMedia;
	}


	public void setVelocidadeMedia(float velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
	
	public void dados() {
		System.out.printf("Dados do animal:\nNome: %s\n", nome);
		System.out.printf("Comprimento: %.2f cm\n", comprimento);
		System.out.printf("Numero de patas: %d\n", numPatas);
		System.out.printf("Cor: %s\n", cor);
		System.out.printf("Ambiente: %s\n", ambiente);
		System.out.printf("Velocidade media: %.2f m/s\n", velocidadeMedia);
	}
	
}
