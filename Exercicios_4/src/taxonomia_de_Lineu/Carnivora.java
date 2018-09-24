package taxonomia_de_Lineu;

public class Carnivora extends Classe{
	private String ordem = "Carnivora";
	
	public String obterDescricao() {
		return String.format("%s\nOrdem: %s",super.obterDescricao(), ordem);
	}

}
