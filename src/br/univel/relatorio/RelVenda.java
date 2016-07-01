package br.univel.relatorio;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import br.univel.dao.VendaDao;
import br.univel.model.BuscaVendaModel;
import javax.swing.JScrollPane;
import java.awt.Insets;

public class RelVenda extends JFrame {

	private JPanel contentPane;
	private BuscaVendaModel model = new BuscaVendaModel();
	private JTable table;

	public void preencherListas() throws SQLException {

		VendaDao vd = new VendaDao();

		model.incluir(vd.buscarVendas());
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
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.gridheight = 10;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(model);

		try {
			preencherListas();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar dados!!!");
			e.printStackTrace();
		}

	}

}
