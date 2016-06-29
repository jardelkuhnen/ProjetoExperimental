package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTable;

import br.univel.model.TabelaModel;
import br.univel.relatorio.RelCliente;
import br.univel.relatorio.RelProduto;
import br.univel.relatorio.RelVenda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Principal() {

		setPreferredSize(new Dimension(640, 480));
		setTitle("Prolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);

		JMenuItem mntmCadastros = new JMenuItem("Clientes");
		mntmCadastros.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.ALT_MASK));
		mntmCadastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CadCliente cdCliente = new CadCliente();
				cdCliente.setVisible(true);
				cdCliente.setLocationRelativeTo(null);
			}
		});
		mnCadastros.add(mntmCadastros);

		JMenuItem mntmUsurio = new JMenuItem("Usu\u00E1rios");
		mntmUsurio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
				InputEvent.ALT_MASK));
		mntmUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadUsuario cadUsuario = new CadUsuario();
				cadUsuario.setVisible(true);
				cadUsuario.setLocationRelativeTo(null);
			}
		});
		mnCadastros.add(mntmUsurio);

		JMenuItem mntmProduto = new JMenuItem("Produtos");
		mntmProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				InputEvent.ALT_MASK));
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CadProduto cadProduto = new CadProduto();
				cadProduto.setVisible(true);
				cadProduto.setLocationRelativeTo(null);
			}
		});
		mnCadastros.add(mntmProduto);

		JMenu mnVenda = new JMenu("Lan\u00E7amentos");
		menuBar.add(mnVenda);

		JMenuItem mntmVenda = new JMenuItem("Venda");
		mntmVenda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				InputEvent.ALT_MASK));
		mntmVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadVenda TVenda = new CadVenda();
				TVenda.setVisible(true);
				TVenda.setLocationRelativeTo(null);
				TVenda.configuraManual();

			}
		});
		mnVenda.add(mntmVenda);

		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				RelCliente relCliente = new RelCliente();
				relCliente.setVisible(true);
				relCliente.setLocationRelativeTo(null);
			}
		});
		mnRelatrios.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Produto");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RelProduto relProduto = new RelProduto();
				relProduto.setVisible(true);
				relProduto.setLocationRelativeTo(null);

			}
		});
		mnRelatrios.add(mntmNewMenuItem_1);

		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mntmVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RelVenda relVenda = new RelVenda();
				relVenda.setVisible(true);
				relVenda.setLocationRelativeTo(null);
				relVenda.setExtendedState(relVenda.getExtendedState()
						| JFrame.MAXIMIZED_BOTH);

			}
		});
		mnRelatrios.add(mntmVendas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 178, 46, 0 };
		gbl_panel.rowHeights = new int[] { 101, 14, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				Principal.class
						.getResource("/br/univel/Imagem/Prolar_logotipos-para-loja-de-mo\u0301veis.jpg")));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);
	}

}
