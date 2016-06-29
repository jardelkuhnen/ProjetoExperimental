package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BuscaVendaModel extends AbstractTableModel {

	List<Venda> listaVenda = new ArrayList<Venda>();

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		return listaVenda.size();
	}

	public void incluir(List<Venda> v) {
		this.listaVenda = v;
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int col) {

		switch (col) {
		case 0:
			return "N. Nota";
		case 1:
			return "Cliente";
		case 2:
			return "Produto";
		case 3:
			return "Quantidade";
		case 4:
			return "Vlr. Total";
		case 5:
			return "Vlr. Pagamento";
		case 6:
			return "Vlr. Troco";
		case 7:
			return "Data/Hora Venda";
		default:
			break;
		}
		return null;
	}

	
	@Override
	public Object getValueAt(int row, int col) {

		Venda v = listaVenda.get(row);
		switch (col) {
		case 0:
			return v.getnNota();
		case 1:
			return v.getCliente();
		case 2:
			return v.getProduto();
		case 3:
			return v.getQtd();
		case 4:
			return v.getVlrTotal();
		case 5:
			return v.getVlrPagamento();
		case 6:
			return v.getVlrTroco();
		case 7:
			return v.getDataHora();
		default:
			break;
		}
		return "Erro em colunas";
	}


	public Venda getvenda(int selectedRow) {

		return listaVenda.get(selectedRow);
	}

}
