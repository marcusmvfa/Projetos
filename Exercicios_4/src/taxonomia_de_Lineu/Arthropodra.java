package taxonomia_de_Lineu;

public class Arthropodra implements Reino{

	private String filo = "Arthropoda";
	
	@Override
	public String obterDescricao() {
		return String.format("Reino: %s\nFilo: %s", nome, filo);
	}

}
