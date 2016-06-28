package br.univel.model;

import java.math.BigDecimal;

import br.univel.enun.GeneroProd;
import br.univel.enun.Unidade;

public class Produto {

	private int id;
	private int codBarras;
	private String descricao;
	private GeneroProd genero;
	private Unidade unidade;
	private BigDecimal custo;
	private BigDecimal margemLucro;
	private int quantidade;
	private String genero1;

	// public Produto(String produto, int qtd, ) {
	// this.descricao = produto;
	// this.quantidade = qtd;
	// }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(int codBarras) {
		this.codBarras = codBarras;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public GeneroProd getGenero() {
		return genero;
	}

	public void setGenero(GeneroProd genero) {
		this.genero = genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public BigDecimal getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(BigDecimal margemLucro) {
		this.margemLucro = margemLucro;
	}

	@Override
	public String toString() {
		return descricao;
	}

	public void setGenero(String genero1) {
		this.genero1 = genero1;

	}

}
