package br.univel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	// Dados da conexão ao banco de dados
	private static final String URL_H2 = "jdbc:h2:~/Prolar";
	private static final String DRIVER_CLASS = "org.h2.Driver";
	private static final String USER = "sa";
	private static final String PASS = "sa";
	public static ResultSet rs;
	public java.sql.Statement stm;
	public Connection con;

	public static Connection getConnection() {

		System.out.println("Iniciando conexão ao banco de dados!!!");

		try {
			Class.forName(DRIVER_CLASS);
			return DriverManager.getConnection(URL_H2, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

}
