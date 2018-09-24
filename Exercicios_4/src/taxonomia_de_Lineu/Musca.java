package taxonomia_de_Lineu;

public class Musca extends Muscidae{
	private String genero = "Musca";
	
	public String obterDescricao() {
		return String.format("%s\nGenero: %s",super.obterDescricao(), genero);
	}
}
