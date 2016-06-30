package br.univel.controller;

import java.math.BigDecimal;

import br.univel.enun.GeneroProd;
import br.univel.enun.Unidade;
import br.univel.model.Produto;
import br.univel.dao.ProdutoDao;

public class ProdutoContoller extends Produto {

	// Classe controller, que irá controlar todas as movimentaçoes do produto,
	// tanto cadastros novos, exclusao e edição
	public void salvar(int codBarras, GeneroProd genero, String descricao,
			int quantidade, Unidade unidade, BigDecimal custo,
			BigDecimal margemLucro) {

		ProdutoContoller pp = new ProdutoContoller();

		pp.setCodBarras(codBarras);
		pp.setDescricao(descricao);
		pp.setQuantidade(quantidade);
		pp.setGenero(genero);
		pp.setUnidade(unidade);
		pp.setCusto(custo);
		pp.setMargemLucro(margemLucro);

		new ProdutoDao().inserir(pp);
	}

	public void editar(int id, int codBarras, String descricao,
			GeneroProd genero, Unidade unidade, BigDecimal custo,
			BigDecimal margemLucro) {

		ProdutoContoller pp = new ProdutoContoller();
		pp.setId(id);
		pp.setCodBarras(codBarras);
		pp.setDescricao(descricao);
		pp.setGenero(genero);
		pp.setUnidade(unidade);
		pp.setCusto(custo);
		pp.setMargemLucro(margemLucro);

		new ProdutoDao().editar(pp);

	}

	public void deletar(int id) {

		Produto pp = new ProdutoDao().deletar(id);

	}

	public void atualizaEstoque(int p, String qtdDigitada) {

		ProdutoDao pd = new ProdutoDao();
		pd.atualizaEstoque(p, qtdDigitada);

	}

}
