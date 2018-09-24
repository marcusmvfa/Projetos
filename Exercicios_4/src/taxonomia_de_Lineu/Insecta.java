package taxonomia_de_Lineu;

public class Insecta extends Arthropodra{
	private String classe = "Insecta";
	
	public String obterDescricao() {
		return String.format("%s\nClasse: %s",super.obterDescricao(), classe);
	}
}
