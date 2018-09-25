package seresVivos;
public class SerVivo {
	private boolean extinto;
	private int dia;
	private int mes;
	private int ano;
	private int ndia;
	private int nmes;
	private int nano;
	
	
	SerVivo(boolean extinto){
		this.extinto = extinto;
		dia = 0;
		mes = 0;
		ano = 0;
		ndia = 0;
		nmes = 0;
		nano = 0;
	}

	public boolean isExtinto() {
		return extinto;
	}

	public void setExtinto(boolean extinto) {
		this.extinto = extinto;
	}
	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getNdia() {
		return ndia;
	}

	public void setNdia(int ndia) {
		this.ndia = ndia;
	}

	public int getNmes() {
		return nmes;
	}

	public void setNmes(int nmes) {
		this.nmes = nmes;
	}

	public int getNano() {
		return nano;
	}

	public void setNano(int nano) {
		this.nano = nano;
	}

	public void extinguir() {
		if(extinto == true)
			return;
		else
			extinto = true;
	}
	
	public String nascer(int ndia, int nmes, int nano) {
		this.ndia = ndia;
		this.nmes = nmes;
		this.nano = nano;
		
		return String.format("%d/%d/%d", dia, mes, ano);
	}
	
	public String morrer(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		return String.format("%d/%d/%d", dia, mes, ano);
	}
	
	public String toString() {
		return String.format("Extinto: %b\nData de nascimento: %s\nData da morte: %s\n", extinto, nascer(ndia,nmes,nano), morrer(dia,mes,ano));
	}
	
}
