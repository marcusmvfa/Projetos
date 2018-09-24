package taxonomia_de_Lineu;

public class Diptera extends Insecta{
	private String ordem = "Diptera";
	
	public String obterDescricao() {
		return String.format("%s\nOrdem: %s",super.obterDescricao(), ordem);
	}
}
