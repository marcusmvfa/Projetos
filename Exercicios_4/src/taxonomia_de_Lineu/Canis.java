package taxonomia_de_Lineu;

public class Canis extends Canidae{
	private String genero = "Canis";
	
	public String obterDescricao() {
		return String.format("%s\nGenero: %s",super.obterDescricao(), genero);
	}
}
