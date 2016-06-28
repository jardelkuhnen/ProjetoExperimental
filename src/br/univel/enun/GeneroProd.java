package br.univel.enun;

public enum GeneroProd {

	Moveis("Móveis"), Eletrodomésticos("Eletrodomésticos"), Eletrônicos(
			"Eletrônicos");

	private String genero;

	GeneroProd(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

}
