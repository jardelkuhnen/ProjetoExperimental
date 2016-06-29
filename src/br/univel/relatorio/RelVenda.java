package br.univel.relatorio;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import org.w3c.dom.ls.LSInput;

import br.univel.dao.ClienteDao;
import br.univel.dao.ProdutoDao;
import br.univel.dao.RelatorioDao;
import br.univel.dao.VendaDao;
import br.univel.enun.GeneroProd;
import br.univel.model.BuscaVendaModel;
import br.univel.model.Cliente;
import br.univel.model.Produto;
import br.univel.view.BuscaProduto;

import javax.swing.JTable;

public class RelVenda extends JFrame {

	private JPanel contentPane;
	static List<Cliente> listaCli = new ArrayList<Cliente>();
	static List<Produto> listaProd = new ArrayList<Produto>();
	private JTable table;
	private BuscaVendaModel model = new BuscaVendaModel();

	public void preencherListas() throws SQLException {

		VendaDao vd = new VendaDao();

		model.incluir(vd.buscarVendas());
		model.fireTableDataChanged();
	}

	/**
	 * Create the frame.
	 */
	public RelVenda() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 383);
		contentPane = new JPanel();
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
		
				JLabel lblRelatrioDeClientes = new JLabel("Relat\u00F3rio de Vendas");
				lblRelatrioDeClientes.setForeground(new Color(0, 0, 128));
				lblRelatrioDeClientes.setFont(new Font("Tahoma", Font.BOLD
						| Font.ITALIC, 18));
				GridBagConstraints gbc_lblRelatrioDeClientes = new GridBagConstraints();
				gbc_lblRelatrioDeClientes.anchor = GridBagConstraints.NORTH;
				gbc_lblRelatrioDeClientes.insets = new Insets(0, 0, 5, 0);
				gbc_lblRelatrioDeClientes.gridwidth = 6;
				gbc_lblRelatrioDeClientes.gridx = 0;
				gbc_lblRelatrioDeClientes.gridy = 0;
				contentPane.add(lblRelatrioDeClientes, gbc_lblRelatrioDeClientes);

		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 9;
		gbc_table.gridwidth = 5;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		contentPane.add(table, gbc_table);

		configuraTela();

		try {
			preencherListas();
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar dados!!!");
			e.printStackTrace();
		}

	}

	private void configuraTela() {

		table.setModel(model);

	}

}
