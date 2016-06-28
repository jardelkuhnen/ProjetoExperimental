package br.univel.enun;

public enum Uf {

	AP(0, "Amapá"),
	AM(1, "Amazonas"),
	BA(2, "Bahia"),
	CE(3, "Ceará"),
	DF(4, "Distrito Federal"),
	ES(5, "Espírito Santo"),
	GO(6, "Goiás"),
	MA(7, "Maranhão"),
	MT(8, "Mato Grosso"),
	MS(9, "Mato Grosso do Sul"),
	MG(10, "Minas Gerais"),
	PA(11, "Pará"),
	PB(12, "Paraíba"),
	PR(13, "Paraná"),
	PE(14, "Pernambuco"),
	PI(15, "Piauí"),
	RJ(16, "Rio de Janeiro"),
	RN(17, "Rio Grande do Norte"),
	RS(18, "Rio Grande do Sul"),
	RO(19, "Rondônia"),
	RR(20, "Roraima"),
	SC(21, "Santa Catarina"),
	SP(22, "São Paulo"),
	SE(23, "Sergipe"),
	TO(24, "Tocantins");


	private String descricao;


	private Uf(Integer ordinal, String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return getDescricao();
	}

}
