package br.univel.enun;

public enum Unidade {

	UN("Unidade"), 
	KG("Kilo"), 
	PCT("Pacote"), 
	CX("Caixa");

	private String unidade;

	Unidade(String unidade) {
		this.unidade = unidade;
	}

	public String getUnidade() {
		return unidade;
	}

}
