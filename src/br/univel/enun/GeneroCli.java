package br.univel.enun;

public enum GeneroCli {

	MASCULINO("Masculino"), FEMININO("Feminino"), VIADO("Viado"), LESBICA(
			"Lesbica"), TRANS("Trans");

	private String genero;

	GeneroCli(String nome) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

}
