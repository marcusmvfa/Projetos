package taxonomia_de_Lineu;

public class Classe extends Chordata{

	private String classe = "Mammalia";
	
	public String obterDescricao() {
		return String.format("%s\nClasse: %s",super.obterDescricao(), classe);
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	
}
