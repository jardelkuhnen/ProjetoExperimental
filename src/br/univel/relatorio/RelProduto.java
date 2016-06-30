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
import javax.swing.table.TableModel;

import br.univel.dao.ProdutoDao;
import br.univel.enun.GeneroProd;
import br.univel.model.BuscaProdutoModel;
import br.univel.model.Produto;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

public class RelProduto extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private BuscaProdutoModel model = new BuscaProdutoModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelProduto rel = new RelProduto();
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
	public RelProduto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setTitle("Relatório de Produtos");
		contentPane.setToolTipText("");
		contentPane
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 63, 67, 175, 65, 0 };
		gbl_contentPane.rowHeights = new int[] { 35, 22, 35, 23, 35, 23, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 6;
		gbc_table.gridwidth = 4;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		contentPane.add(table, gbc_table);

		prencherLista();

	}

	private void prencherLista() {

		ProdutoDao pd = new ProdutoDao();

		model.incluir(pd.buscarProduto());
		table.setModel(model);

	}

}
