package taxonomia_de_Lineu;

public class Primata extends Classe{
	private String ordem = "Primata";
	
	public String obterDescricao() {
		return String.format("%s\nOrdem: %s",super.obterDescricao(), ordem);
	}
}
