package br.univel.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import br.univel.controller.VendaController;
import br.univel.dao.ClienteDao;
import br.univel.dao.ProdutoDao;
import br.univel.dao.VendaDao;
import br.univel.model.Cliente;
import br.univel.model.Produto;
import br.univel.model.TabelaModel;

public class CadVenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtNNota;
	private JTextField txtVlrTotal;
	private JTextField txtVlrPagamento;
	private JComboBox cbProduto;
	private JComboBox cbCliente;
	private JTextField txtQuantidade;
	private JLabel lblVlrTotal;
	private TabelaModel model;

	List<Produto> listaProd = new ArrayList<Produto>();
	List<Cliente> listaCli = new ArrayList<Cliente>();
	List<Produto> listaVenda = new ArrayList();
	boolean valido;
	private JPanel panel;
	private JTable table;
	private JTextField txtProduto;

	public CadVenda() {
		setTitle("Venda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		try {
			preencheLista();
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null,
					"ERRO: Problemas ao preencher lista de produtos");
			e2.printStackTrace();
		}

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 96, 25, 33, 37, 97, 50, 80, 52,
				77, 0 };
		gbl_panel.rowHeights = new int[] { 30, 20, 20, 20, 20, 23, 171, 20, 20,
				20, 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblvendas = new JLabel("***Vendas***");
		lblvendas.setForeground(new Color(0, 0, 128));
		lblvendas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblvendas = new GridBagConstraints();
		gbc_lblvendas.gridwidth = 9;
		gbc_lblvendas.anchor = GridBagConstraints.NORTH;
		gbc_lblvendas.insets = new Insets(0, 0, 5, 0);
		gbc_lblvendas.gridx = 0;
		gbc_lblvendas.gridy = 1;
		panel.add(lblvendas, gbc_lblvendas);

		JLabel lblNmeroNota = new JLabel("Nota");
		GridBagConstraints gbc_lblNmeroNota = new GridBagConstraints();
		gbc_lblNmeroNota.anchor = GridBagConstraints.EAST;
		gbc_lblNmeroNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmeroNota.gridx = 0;
		gbc_lblNmeroNota.gridy = 2;
		panel.add(lblNmeroNota, gbc_lblNmeroNota);
		txtNNota = new JTextField();
		GridBagConstraints gbc_txtNNota = new GridBagConstraints();
		gbc_txtNNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNNota.anchor = GridBagConstraints.NORTH;
		gbc_txtNNota.insets = new Insets(0, 0, 5, 5);
		gbc_txtNNota.gridwidth = 3;
		gbc_txtNNota.gridx = 1;
		gbc_txtNNota.gridy = 2;
		panel.add(txtNNota, gbc_txtNNota);
		txtNNota.setColumns(10);

		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 3;
		panel.add(lblCliente, gbc_lblCliente);

		cbCliente = new JComboBox(new Vector<Cliente>(listaCli));
		GridBagConstraints gbc_cbCliente = new GridBagConstraints();
		gbc_cbCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCliente.anchor = GridBagConstraints.NORTH;
		gbc_cbCliente.insets = new Insets(0, 0, 5, 5);
		gbc_cbCliente.gridwidth = 7;
		gbc_cbCliente.gridx = 1;
		gbc_cbCliente.gridy = 3;
		panel.add(cbCliente, gbc_cbCliente);

		JLabel lblNewLabel = new JLabel("Produto");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 4;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		cbProduto = new JComboBox(new Vector<Produto>(listaProd));
		GridBagConstraints gbc_cbProduto = new GridBagConstraints();
		gbc_cbProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbProduto.anchor = GridBagConstraints.NORTH;
		gbc_cbProduto.insets = new Insets(0, 0, 5, 5);
		gbc_cbProduto.gridwidth = 7;
		gbc_cbProduto.gridx = 1;
		gbc_cbProduto.gridy = 4;
		panel.add(cbProduto, gbc_cbProduto);

		JLabel lblQuantidade = new JLabel("Qtd");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.anchor = GridBagConstraints.EAST;
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 0;
		gbc_lblQuantidade.gridy = 5;
		panel.add(lblQuantidade, gbc_lblQuantidade);

		txtQuantidade = new JTextField();
		GridBagConstraints gbc_txtQuantidade = new GridBagConstraints();
		gbc_txtQuantidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtQuantidade.gridwidth = 2;
		gbc_txtQuantidade.gridx = 1;
		gbc_txtQuantidade.gridy = 5;
		panel.add(txtQuantidade, gbc_txtQuantidade);
		txtQuantidade.setColumns(10);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				adicionarProdutos();

			}
		});
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAdicionar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdicionar.gridx = 6;
		gbc_btnAdicionar.gridy = 5;
		panel.add(btnAdicionar, gbc_btnAdicionar);

		JButton button = new JButton("Remover");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				removerProduto();
				txtQuantidade.setText("");
				txtVlrTotal.setText("");

			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 7;
		gbc_button.gridy = 5;
		panel.add(button, gbc_button);

		JScrollPane tabela = new JScrollPane();
		GridBagConstraints gbc_tabela = new GridBagConstraints();
		gbc_tabela.gridwidth = 9;
		gbc_tabela.insets = new Insets(0, 0, 5, 0);
		gbc_tabela.fill = GridBagConstraints.BOTH;
		gbc_tabela.gridx = 0;
		gbc_tabela.gridy = 6;
		panel.add(tabela, gbc_tabela);

		table = new JTable();
		tabela.setViewportView(table);

		JLabel lblValorTotal = new JLabel("Valor Total");
		GridBagConstraints gbc_lblValorTotal = new GridBagConstraints();
		gbc_lblValorTotal.anchor = GridBagConstraints.EAST;
		gbc_lblValorTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorTotal.gridx = 0;
		gbc_lblValorTotal.gridy = 7;
		panel.add(lblValorTotal, gbc_lblValorTotal);

		txtVlrTotal = new JTextField();
		GridBagConstraints gbc_txtVlrTotal = new GridBagConstraints();
		gbc_txtVlrTotal.anchor = GridBagConstraints.NORTH;
		gbc_txtVlrTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVlrTotal.insets = new Insets(0, 0, 5, 5);
		gbc_txtVlrTotal.gridwidth = 5;
		gbc_txtVlrTotal.gridx = 1;
		gbc_txtVlrTotal.gridy = 7;
		panel.add(txtVlrTotal, gbc_txtVlrTotal);
		txtVlrTotal.setColumns(10);

		JLabel lblValorPagamento = new JLabel("Vlr. Pagamento");
		GridBagConstraints gbc_lblValorPagamento = new GridBagConstraints();
		gbc_lblValorPagamento.anchor = GridBagConstraints.EAST;
		gbc_lblValorPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorPagamento.gridx = 0;
		gbc_lblValorPagamento.gridy = 8;
		panel.add(lblValorPagamento, gbc_lblValorPagamento);

		txtVlrPagamento = new JTextField();
		GridBagConstraints gbc_txtVlrPagamento = new GridBagConstraints();
		gbc_txtVlrPagamento.anchor = GridBagConstraints.NORTH;
		gbc_txtVlrPagamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVlrPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_txtVlrPagamento.gridwidth = 5;
		gbc_txtVlrPagamento.gridx = 1;
		gbc_txtVlrPagamento.gridy = 8;
		panel.add(txtVlrPagamento, gbc_txtVlrPagamento);
		txtVlrPagamento.setColumns(10);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gravarVenda();
			}
		});
		GridBagConstraints gbc_btnGravar = new GridBagConstraints();
		gbc_btnGravar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGravar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGravar.anchor = GridBagConstraints.NORTH;
		gbc_btnGravar.gridx = 6;
		gbc_btnGravar.gridy = 9;
		panel.add(btnGravar, gbc_btnGravar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					this.finalize();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnCancelar.gridx = 7;
		gbc_btnCancelar.gridy = 9;
		panel.add(btnCancelar, gbc_btnCancelar);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { txtNNota, cbCliente, cbProduto,
						txtQuantidade, btnAdicionar, txtVlrTotal,
						txtVlrPagamento, btnCancelar, btnGravar }));

	}

	protected void abrirTelaPesquisaProduto() {

		BuscaProduto prod = new BuscaProduto();
		prod.setVisible(true);
		prod.setLocationRelativeTo(null);
	}

	protected void removerProduto() {

		Produto p = getProdutoSelecionado();
		if (p != null) {
			((TabelaModel) table.getModel()).removeProduto(p);
		}

	}

	private Produto getProdutoSelecionado() {

		Produto p = null;

		int index = table.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "Linha não selecionada");

		} else {
			p = ((TabelaModel) table.getModel()).getClienteNaLinha(index);
		}

		return p;
	}

	public void carregaProdutoPesquisadoEmTela(Produto produto) {
		txtProduto.setText(produto.getDescricao());
		txtQuantidade.setText(String.valueOf(produto.getQuantidade()));
	}

	public void adicionarProdutos() {

		String produto = cbProduto.getSelectedItem().toString();
		int indexProd = cbProduto.getSelectedIndex();
		if (indexProd == 0) {
			indexProd = indexProd + 1;
		}
		int qtd = Integer.parseInt(txtQuantidade.getText());
		BigDecimal custo = new ProdutoDao().valorProd(indexProd);
		BigDecimal mgLucro = margemLucro(indexProd);
		String qtdDigitada = txtQuantidade.getText().trim();
		BigDecimal mg = custo.multiply(mgLucro);
		BigDecimal vlrFinal = mg.divide(new BigDecimal(100.00)).add(custo)
				.multiply(new BigDecimal(qtdDigitada));

		Produto p = new Produto();
		p.setDescricao(produto);
		p.setQuantidade(qtd);
		p.setCusto(vlrFinal);
		model.incluir(p);
		listaVenda.add(p);
		txtVlrTotal.setText(NumberFormat.getCurrencyInstance()
				.format(p.getCusto()).toString());

	}

	// Grava a venda no banco de dados
	public void gravarVenda() {

		VendaController vd = new VendaController();

		Cliente c = (Cliente) cbCliente.getSelectedItem();
		Produto p = (Produto) cbProduto.getSelectedItem();
		String horaData = horaVenda();
		String qtdDigitada = txtQuantidade.getText().trim();
		int indexProd = cbProduto.getSelectedIndex();
		if (indexProd == 0) {
			indexProd = indexProd + 1;
		}

		// busca no banco o valor do produto selecionado
		BigDecimal vlrProd = valroProd(indexProd);

		// Busca no banco o valor de mergem de lucro
		BigDecimal mgLucro = margemLucro(indexProd);

		int qtd = Integer.parseInt(qtdDigitada);

		// Quantidade de produtos na venda, utilizado para fazer o calculo de
		// valor final da venda
		BigDecimal mg = vlrProd.multiply(mgLucro);
		BigDecimal vlrFinal = mg.divide(new BigDecimal(100.00)).add(vlrProd);
		BigDecimal vlrPagamento = new BigDecimal(txtVlrPagamento.getText()
				.trim());
		if (qtdDigitada.isEmpty()) {
			qtdDigitada = "0";
		}

		// ------------------------------------troco

		if (vlrFinal.compareTo(vlrFinal) > vlrPagamento.compareTo(vlrPagamento)
				|| vlrPagamento.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Valor de pagamento menor que o valor total da venda!!!");

		} else {

			BigDecimal troco = vlrPagamento.subtract(vlrFinal);
			JOptionPane.showMessageDialog(null, "Troco do cliente: "
					+ NumberFormat.getCurrencyInstance().format(troco));

			vd.gravarVenda(Integer.parseInt(txtNNota.getText().trim()),
					c.toString(), p.toString(), qtd, vlrFinal, vlrPagamento,
					troco, horaData);
			limparModel();

			limparCampos();
		}
	}

	private void limparModel() {

		model.limparlista();
		listaVenda.clear();
	}

	protected void configuraManual() {
		model = new TabelaModel();
		table.setModel(model);
	}

	// limpa os campos
	private void limparCampos() {
		txtNNota.setText("");
		txtQuantidade.setText("");
		txtVlrPagamento.setText("");
		txtVlrTotal.setText("");

	}

	// Pega a hora e retorna para a variavel que chamou o método
	public String horaVenda() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		return dateFormat.format(date).toString();
	}

	private BigDecimal margemLucro(int i) {

		ProdutoDao pd = new ProdutoDao();

		return pd.buscaMargem(i);
	}

	public BigDecimal valroProd(int idProd) {
		ProdutoDao pd = new ProdutoDao();
		return pd.buscarValorProd(idProd);
	}

	// Preenche lista de produtos e lista de cliente que sao exibidos no
	// comboBox
	void preencheLista() throws SQLException {

		VendaDao vdao = new VendaDao();
		ClienteDao cdao = new ClienteDao();

		vdao.listarProdutos(listaProd);
		cdao.listarCliente(listaCli);

	}
}
