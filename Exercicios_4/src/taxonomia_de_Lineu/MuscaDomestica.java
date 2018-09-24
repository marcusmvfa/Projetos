package taxonomia_de_Lineu;

public class MuscaDomestica extends Musca{
	private String especie = "Musca Domestica";
	
	public String obterDescricao() {
		return String.format("%s\nEspecie: %s",super.obterDescricao(), especie);
	}
}
