package br.univel.relatorio;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import br.univel.dao.ClienteDao;
import br.univel.model.BuscaClienteModel;
import javax.swing.JScrollPane;

public class RelCliente extends JFrame {

	private JPanel contentPane;
	private BuscaClienteModel model = new BuscaClienteModel();
	private JTable table;

	/**
	 * Create the frame.
	 */
	public RelCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 249);
		setTitle("Relatório de Clientes");
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 66, 280, 65, 0 };
		gbl_contentPane.rowHeights = new int[] { 22, 0, 35, 23, 35, 23, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		table.setModel(model);
		
		prencherTela();
	}

	private void prencherTela() {

		ClienteDao dao = new ClienteDao();
		try {
			model.incluir(dao.listarCliente());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
