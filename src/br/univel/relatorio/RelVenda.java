package br.univel.relatorio;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import br.univel.dao.VendaDao;
import br.univel.model.BuscaVendaModel;
import br.univel.model.Cliente;
import br.univel.model.Produto;

public class RelVenda extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private BuscaVendaModel model = new BuscaVendaModel();

	public void preencherListas() throws SQLException {

		VendaDao vd = new VendaDao();

		model.incluir(vd.buscarVendas());
		table.setModel(model);
	}

	/**
	 * Create the frame.
	 */
	public RelVenda() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 343);
		contentPane = new JPanel();
		setTitle("Relatório de Vendas");
		contentPane.setToolTipText("");
		contentPane
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 88, 162, 65, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 40, 22, 40, 23, 40, 23, 35,
				23, 35, 23, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 10;
		gbc_table.gridwidth = 6;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		contentPane.add(table, gbc_table);

		try {
			preencherListas();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar dados!!!");
			e.printStackTrace();
		}

	}

}
