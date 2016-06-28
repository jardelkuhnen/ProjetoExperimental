package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BuscaClienteModel extends AbstractTableModel {
	List<Cliente> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	public void incluir(List<Cliente> c) {
		this.lista = c;
		fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Cliente c = lista.get(row);

		switch (col) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getTelefone();
		case 3:
			return c.getEndereco();
		default:
			break;
		}
		return null;
	}

	@Override
	public String getColumnName(int col) {

		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
		case 2:
			return "Telefone";
		case 3:
			return "Endereco";
		default:
			break;
		}
		return " ";

	}

	public Cliente getCliente(Integer indice) {
		return lista.get(indice);
	}

}
