package taxonomia_de_Lineu;

public class HomoSapiens extends Homo{
	private String especie = "Homo Sapiens";
	
	public String obterDescricao() {
		return String.format("%s\nEspecie: %s",super.obterDescricao(), especie);
	}
}
