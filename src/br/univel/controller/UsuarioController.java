package br.univel.controller;

import br.univel.dao.UsuarioDao;
import br.univel.model.Usuario;

public class UsuarioController extends Usuario {
	// Classe controller, que irá controlar todas as movimentaçoes do usuario,
	// tanto cadastros novos, exclusao e edição
	public void salvar(int idCliente, int idUs, String usuario, String senha) {

		UsuarioController us = new UsuarioController();

		us.setIdCliente(idCliente);
		us.setIdUs(idUs);
		us.setUsuario(usuario);
		us.setSenha(senha);

		new UsuarioDao().inserir(us);
	}

	public void editar(int idCliente, int idUs, String usuario, String senha) {

		UsuarioController u = new UsuarioController();

		u.setIdCliente(idCliente);
		u.setIdUs(idUs);
		u.setSenha(senha);

		new UsuarioDao().editar(u);

	}

	public void deletar(int idUs) {
		UsuarioDao us = new UsuarioDao().deletar(idUs);
	}

	public boolean logar(String usuario, String senha) {

		UsuarioDao dao = new UsuarioDao();

		return dao.logar(usuario, senha);
	}

}
