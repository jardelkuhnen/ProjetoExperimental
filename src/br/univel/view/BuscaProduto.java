package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.dao.ProdutoDao;
import br.univel.model.BuscaClienteModel;
import br.univel.model.BuscaProdutoModel;
import br.univel.model.Cliente;
import br.univel.model.Produto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class BuscaProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtProduto;
	private JTable table;
	private BuscaProdutoModel model = new BuscaProdutoModel();
	private CadProduto cadProduto;

	/**
	 * Create the frame.
	 */

	public BuscaProduto() {
		setTitle("Busca Produto");
		this.cadProduto = cadProduto;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		txtProduto = new JTextField();
		GridBagConstraints gbc_txtProduto = new GridBagConstraints();
		gbc_txtProduto.insets = new Insets(0, 0, 5, 0);
		gbc_txtProduto.anchor = GridBagConstraints.NORTH;
		gbc_txtProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProduto.gridx = 0;
		gbc_txtProduto.gridy = 0;
		contentPane.add(txtProduto, gbc_txtProduto);
		txtProduto.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ProdutoDao pd = new ProdutoDao();

				model.incluir(pd.buscarProduto(txtProduto.getText()
						.toUpperCase()));
				table.setModel(model);

			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar.anchor = GridBagConstraints.EAST;
		gbc_btnBuscar.gridx = 0;
		gbc_btnBuscar.gridy = 1;
		contentPane.add(btnBuscar, gbc_btnBuscar);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				txtProduto, btnBuscar, table }));

		// Configura o layout da tela
		configuraTela();

		addMouseClickedTable();
	}

	private void addMouseClickedTable() {

		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {

					int selectedRow = table.getSelectedRow();

					Produto produtoSelecionado = ((BuscaProdutoModel) table
							.getModel()).getProduto(selectedRow);

					System.out.println(produtoSelecionado);
					BuscaProduto.this.cadProduto
							.carregaProdutoPesquisadoEmTela(produtoSelecionado);
					fechaTela();
				}
			}

		});

	}

	private void fechaTela() {
		this.setVisible(false);
	}

	private void configuraTela() {
		BuscaProdutoModel model = new BuscaProdutoModel();
		table.setModel(model);

	}
}
