package br.univel.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.model.Produto;

public class ProdutoDao {

	Connection con;

	// Métod insere banco pegando valores das variáveis da classe produto
	public void inserir(Produto produto) {

		con = Conexao.getConnection();
		String sql = "INSERT INTO PRODUTO (codBarras, genero, descricao,"
				+ "quantidade, unidade, custo, margemLucro) values (?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, produto.getCodBarras());
			stmt.setString(2, produto.getGenero().toString());
			stmt.setString(3, produto.getDescricao().toUpperCase());
			stmt.setInt(4, produto.getQuantidade());
			stmt.setString(5, produto.getUnidade().toString().toUpperCase());
			stmt.setBigDecimal(6, produto.getCusto());
			stmt.setBigDecimal(7, produto.getMargemLucro());

			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			int idProd = 0;
			if (rs.next()) {
				idProd = rs.getInt(1);
			}
			produto.setId(idProd);
			stmt.close();

			JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Produto> listarProdutos() throws SQLException {

		String sql = "Select descricao from Produto";
		List<Produto> consulta = new ArrayList<Produto>();

		con = Conexao.getConnection();

		PreparedStatement pp = con.prepareStatement(sql);
		ResultSet rs = pp.executeQuery();

		while (rs.next()) {
			Produto produto = new Produto();

			produto.setDescricao(rs.getString("descricao"));

			consulta.add(produto);
		}
		return consulta;

	}

	public void editar(Produto p) {
		con = Conexao.getConnection();

		String sql = "UPDATE PRODUTO SET ID = ?, codBarras = ?, genero = ?, descricao = ?, quantidade = ?, unidade = ?, custo = ?, margemLucro = ? where id = ?;";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(8, p.getId());
			stmt.setInt(1, p.getCodBarras());
			stmt.setString(2, p.getGenero().toString());
			stmt.setString(3, p.getDescricao().toUpperCase());
			stmt.setInt(4, p.getQuantidade());
			stmt.setString(5, p.getUnidade().toString());
			stmt.setBigDecimal(6, p.getCusto());
			stmt.setBigDecimal(7, p.getMargemLucro());

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null,
					"Produto editado com sucesso !!!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao editar produto !!!");
			e.printStackTrace();
		}

	}

	public Produto deletar(int id) {

		con = Conexao.getConnection();

		try {
			String sql = "DELETE FROM PRODUTO WHERE ID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);
			JOptionPane.showMessageDialog(null,
					"Produto apagado com sucesso!!!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"ERRO: Problemas ao apagar produto!!!");
			e.printStackTrace();
		}

		return null;

	}

	public BigDecimal valorProd(int vlrProduto) {

		con = Conexao.getConnection();

		String sql = "SELECT CUSTO FROM PRODUTO WHERE ID = ? ";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, vlrProduto);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				return rs.getBigDecimal("CUSTO");
			}
			System.out.println(rs.getBigDecimal("CUSTO"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao buscar valor do produto!");
			e.printStackTrace();
		}

		return BigDecimal.ZERO;
	}

	public BigDecimal buscaMargem(int idProd) {

		try {
			con = Conexao.getConnection();
			String sql = "SELECT MARGEMLUCRO FROM PRODUTO WHERE ID = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, idProd);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				return rs.getBigDecimal("margemLucro");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao buscar margem de lucro!!!");
			e.printStackTrace();
		}
		return BigDecimal.ZERO;

	}

	public BigDecimal buscarValorProd(int idProd) {
		try {
			con = Conexao.getConnection();
			String sql = "SELECT CUSTO FROM PRODUTO WHERE ID = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, idProd);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				return rs.getBigDecimal("custo");
			}

		} catch (SQLException e) {
			JOptionPane
					.showMessageDialog(null, "Erro ao buscar valor produto!");
			e.printStackTrace();
		}

		return BigDecimal.ZERO;
	}

	public List<Produto> listarGenero(List<Produto> listaProd) {

		try {
			con = Conexao.getConnection();

			String sql = "SELECT GENERO FROM PRODUTO;";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();

				p.setGenero(rs.getString("genero").toString());

				listaProd.add(p);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar categorias!");
			e.printStackTrace();
		}
		return listaProd;

	}

	public List<Produto> buscarProduto(String descricao) {

		List<Produto> lista = new ArrayList<Produto>();
		try {
			con = Conexao.getConnection();

			String sql = "SELECT * FROM PRODUTO WHERE DESCRICAO LIKE ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + descricao.toUpperCase() + "%");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setDescricao(rs.getString("descricao"));
				p.setCodBarras(rs.getInt("codBarras"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setCusto(rs.getBigDecimal("custo"));
				p.setGenero(rs.getString("genero"));
				p.setId(rs.getInt("id"));
				p.setMargemLucro(rs.getBigDecimal("margemLucro"));

				lista.add(p);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar produtos!");
			e.printStackTrace();
		}
		return lista;

	}
}
