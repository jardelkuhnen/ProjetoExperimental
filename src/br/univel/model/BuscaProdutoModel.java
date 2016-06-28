package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BuscaProdutoModel extends AbstractTableModel {

	List<Produto> listaProd = new ArrayList<Produto>();

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return listaProd.size();
	}

	public void incluir(List<Produto> c) {
		this.listaProd = c;
		fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Produto p = listaProd.get(row);
		switch (col) {
		case 0:
			return p.getId();
		case 1:
			return p.getCodBarras();
		case 2:
			return p.getDescricao();
		case 3:
			return p.getCusto();
		case 4:
			return p.getQuantidade();
		default:
			break;
		}
		return "";
	}

	@Override
	public String getColumnName(int col) {

		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Cod. Barras";
		case 2:
			return "Descrição";
		case 3:
			return "Custo";
		case 4:
			return "Quantidade";

		default:
			break;
		}
		return null;
	}

	public Produto getProduto(int selectedRow) {

		return listaProd.get(selectedRow);
	}

}
