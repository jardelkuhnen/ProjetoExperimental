package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaModel extends AbstractTableModel {

	private List<Produto> lista = new ArrayList<Produto>();

	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		return lista.size();
	}

	public Object getValueAt(int row, int col) {

		Produto p = lista.get(row);

		switch (col) {
		case 0:
			return p.getDescricao();
		case 1:
			return p.getQuantidade();
		case 2:
			return p.getCusto();

		default:
			return "Erro!";
		}

	}

	public void incluir(Produto p) {
		lista.add(p);
		super.fireTableDataChanged();
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Produto";
		case 1:
			return "Quantidade";
		case 2:
			return "Valor Unitário";
		default:
			return "Erro";

		}
	}

	public void limparlista() {
		lista.clear();
		fireTableDataChanged();
	}

	public Produto getClienteNaLinha(int index) {

		return lista.get(index);
	}

	public void removeProduto(Produto p) {
		int idx = this.lista.indexOf(p);
		this.lista.remove(p);
		super.fireTableRowsDeleted(idx, idx);

	}

}
