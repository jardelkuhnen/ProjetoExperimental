package br.univel.dao;

import java.sql.Connection;

public class RelatorioDao {

	Connection con;

	public void gerarRelatorio(String cliente) {

		con = Conexao.getConnection();

	}

}
