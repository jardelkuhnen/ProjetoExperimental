package br.univel.model;

import java.math.BigDecimal;
import java.util.List;

public class Venda2 {

	private int nNota;
	private String cliente;
	private List<Produto> produtos;
	private int qtd;
	private BigDecimal custo;
	private BigDecimal vlrTotal;
	private BigDecimal vlrPagamento;
	private BigDecimal vlrTroco;
	private String dataHora;

	public BigDecimal getVlrProduto() {
		return custo;
	}

	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public void setVlrProduto(BigDecimal vlrProduto) {
		this.custo = vlrProduto;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public int getnNota() {
		return nNota;
	}

	public void setnNota(int nNota) {
		this.nNota = nNota;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public BigDecimal getVlrPagamento() {
		return vlrPagamento;
	}

	public void setVlrPagamento(BigDecimal vlrPagamento) {
		this.vlrPagamento = vlrPagamento;
	}

	public BigDecimal getVlrTroco() {
		return vlrTroco;
	}

	public void setVlrTroco(BigDecimal vlrTroco) {
		this.vlrTroco = vlrTroco;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

}
