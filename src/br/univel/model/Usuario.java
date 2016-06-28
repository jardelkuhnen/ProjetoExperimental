package br.univel.model;

public class Usuario {

	private int idCliente;
	private int idUs;
	private String usuario;
	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdUs() {
		return idUs;
	}

	public void setIdUs(int idUs) {
		this.idUs = idUs;
	}

}
