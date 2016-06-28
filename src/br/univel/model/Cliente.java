package br.univel.model;

import br.univel.enun.GeneroCli;
import br.univel.enun.GeneroProd;
import br.univel.enun.Uf;

public class Cliente {

	private int id;
	private String nome;
	private String endereco;
	private String telefone;
	private String cidade;
	private Uf estado;
	private GeneroCli genero;
	private String email;

	public Cliente() {
		this.id = id;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.genero = genero;
		this.email = email;
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public GeneroCli getGenero() {
		return genero;
	}

	public void setGenero(GeneroCli genero) {
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Uf getEstado() {
		return estado;
	}

	public void setEstado(Uf estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		email = email;
	}

	@Override
	public String toString() {
		return nome;
	}

}
