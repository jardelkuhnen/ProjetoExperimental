package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.enun.Uf;
import br.univel.model.Cliente;

public class ClienteDao {

	static Connection con;

	// insere todos os atributos de cliente na tavela cliente do banco, caso
	// haja erro é apresentado uma mensagem de erro
	public void inserir(Cliente c) {

		con = Conexao.getConnection();

		String sql = "INSERT INTO CLIENTE (NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, GENERO, EMAIL) VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement(sql,
					java.sql.Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, c.getNome().toUpperCase());
			stmt.setString(2, c.getTelefone());
			stmt.setString(3, c.getEndereco().toUpperCase());
			stmt.setString(4, c.getCidade().toUpperCase());
			stmt.setInt(5, c.getEstado().ordinal());
			stmt.setString(6, c.getGenero().toString());
			stmt.setString(7, c.getEmail());

			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			int id = 0;
			if (rs.next()) {
				id = rs.getInt(1);
			}
			c.setId(id);
			stmt.close();

			JOptionPane.showMessageDialog(null,
					"Cliente cadastrado com sucesso!!!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"ERRO: Problemas ao salvar cliente!!!");
			e.printStackTrace();
		}

	}

	public List<Cliente> listarCliente(List<Cliente> lista) throws SQLException {

		String sql = "Select nome from Cliente";

		con = Conexao.getConnection();

		PreparedStatement stmt = con.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Cliente c = new Cliente();

			c.setNome(rs.getString("nome"));

			lista.add(c);
		}

		return lista;
	}

	public List<Cliente> listarCliente() throws SQLException {

		String sql = "Select nome from Cliente";
		List<Cliente> lista = new ArrayList<Cliente>();

		con = Conexao.getConnection();

		PreparedStatement stmt = con.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Cliente c = new Cliente();

			c.setNome(rs.getString("nome"));

			lista.add(c);
		}

		return lista;
	}

	public void editar(Cliente c) {
		con = Conexao.getConnection();

		String sql = "UPDATE CLIENTE SET NOME = ?, TELEFONE = ?, ENDERECO = ?,"
				+ "CIDADE = ?, ESTADO = ?, GENERO = ? WHERE ID = ?;";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(7, c.getId());
			stmt.setString(1, c.getNome().toUpperCase());
			stmt.setString(2, c.getTelefone());
			stmt.setString(3, c.getEndereco().toUpperCase());
			stmt.setString(4, c.getCidade().toUpperCase());
			stmt.setInt(5, c.getEstado().ordinal());
			stmt.setString(6, c.getGenero().toString());

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null,
					"Cliente editado com sucesso !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar cliente !!!");
			e.printStackTrace();
		}

	}

	public Cliente deletar(int id) {

		con = Conexao.getConnection();

		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("DELETE FROM CLIENTE WHERE ID = ?");
			stmt.setInt(1, id);
			int rs = stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,
					"Cliente apagado com sucesso!!!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"ERRO: Problemas ao apagar cliente!!!");
			e.printStackTrace();
		}

		return null;

	}

	public List<Cliente> listarCliente(String nome) {
		con = Conexao.getConnection();
		List<Cliente> lista = new ArrayList<>();

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM CLIENTE WHERE NOME LIKE ?");
			PreparedStatement stmt;

			stmt = con.prepareStatement(sql.toString());

			stmt.setString(1, "%" + nome.toUpperCase() + "%");

			ResultSet rs = stmt.executeQuery();

			Cliente c = new Cliente();
			while (rs.next()) {

				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setTelefone(rs.getString("telefone"));
				c.setEndereco(rs.getString("endereco"));
				c.setCidade(rs.getString("cidade"));
				c.setEstado(Uf.values()[rs.getInt("estado")]);
				c.setEmail(rs.getString("email"));

				lista.add(c);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
