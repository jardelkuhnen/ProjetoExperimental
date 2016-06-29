package br.univel.controller;

import br.univel.dao.ClienteDao;
import br.univel.enun.GeneroCli;
import br.univel.enun.GeneroProd;
import br.univel.enun.Uf;
import br.univel.model.Cliente;

public class ClienteController extends Cliente {
	// Classe controller, que irá controlar todas as movimentaçoes do cliente,
	// tanto cadastros novos, exclusao e edição
	public void salvar(String nome, String telefone, String endereco,
			String cidade, Uf estado, GeneroCli genero, String email) {

		ClienteController cc = new ClienteController();

		cc.setNome(nome);
		cc.setTelefone(telefone);
		cc.setEndereco(endereco);
		cc.setCidade(cidade);
		cc.setEstado(estado);
		cc.setGenero(genero);
		cc.setEmail(email);

		new ClienteDao().inserir(cc);

	}

	public void editar(int id, String nome, String telefone, String endereco,
			String cidade, Uf estado, GeneroCli genero, String email) {

		ClienteController cc = new ClienteController();
		cc.setId(id);
		cc.setNome(nome);
		cc.setTelefone(telefone);
		cc.setEndereco(endereco);
		cc.setCidade(cidade);
		cc.setEstado(estado);
		cc.setGenero(genero);
		cc.setEmail(email);

		new ClienteDao().editar(cc);

	}

	public void deletar(int id) {
		ClienteDao cd = new ClienteDao();
		cd.deletar(id);
	}

}
