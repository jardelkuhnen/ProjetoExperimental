package br.univel.relatorio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import br.univel.dao.ClienteDao;
import br.univel.enun.Uf;
import br.univel.model.BuscaClienteModel;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JTable;

public class RelCliente extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private BuscaClienteModel model = new BuscaClienteModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					RelCliente rel = new RelCliente();
					rel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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

		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.gridheight = 6;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		contentPane.add(table, gbc_table);

		prencherTela();
	}

	private void prencherTela() {

		try {
			ClienteDao dao = new ClienteDao();
			model.incluir(dao.listarCliente());
			table.setModel(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
