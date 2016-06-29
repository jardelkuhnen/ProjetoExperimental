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

import br.univel.enun.GeneroProd;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtMargemLucro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

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
		contentPane.setToolTipText("");
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 63, 67, 175, 65, 0 };
		gbl_contentPane.rowHeights = new int[] { 35, 22, 35, 23, 35, 23, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblRelatrioDeClientes = new JLabel("Relat\u00F3rio de Produtos");
		lblRelatrioDeClientes.setForeground(new Color(0, 0, 128));
		lblRelatrioDeClientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_lblRelatrioDeClientes = new GridBagConstraints();
		gbc_lblRelatrioDeClientes.anchor = GridBagConstraints.NORTH;
		gbc_lblRelatrioDeClientes.insets = new Insets(0, 0, 5, 5);
		gbc_lblRelatrioDeClientes.gridwidth = 4;
		gbc_lblRelatrioDeClientes.gridx = 0;
		gbc_lblRelatrioDeClientes.gridy = 1;
		contentPane.add(lblRelatrioDeClientes, gbc_lblRelatrioDeClientes);

		JLabel lblMargemLucro = new JLabel("Margem Lucro");
		GridBagConstraints gbc_lblMargemLucro = new GridBagConstraints();
		gbc_lblMargemLucro.anchor = GridBagConstraints.WEST;
		gbc_lblMargemLucro.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargemLucro.gridx = 1;
		gbc_lblMargemLucro.gridy = 3;
		contentPane.add(lblMargemLucro, gbc_lblMargemLucro);

		txtMargemLucro = new JTextField();
		txtMargemLucro.setColumns(10);
		GridBagConstraints gbc_txtMargemLucro = new GridBagConstraints();
		gbc_txtMargemLucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMargemLucro.insets = new Insets(0, 0, 5, 5);
		gbc_txtMargemLucro.gridx = 2;
		gbc_txtMargemLucro.gridy = 3;
		contentPane.add(txtMargemLucro, gbc_txtMargemLucro);

		JButton btnBuscaLucro = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscaLucro = new GridBagConstraints();
		gbc_btnBuscaLucro.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBuscaLucro.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscaLucro.gridx = 3;
		gbc_btnBuscaLucro.gridy = 3;
		contentPane.add(btnBuscaLucro, gbc_btnBuscaLucro);

		JLabel lblEstado = new JLabel("Categoria");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 5;
		contentPane.add(lblEstado, gbc_lblEstado);

		JComboBox cbCategoria = new JComboBox(GeneroProd.values());
		GridBagConstraints gbc_cbCategoria = new GridBagConstraints();
		gbc_cbCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCategoria.insets = new Insets(0, 0, 0, 5);
		gbc_cbCategoria.gridx = 2;
		gbc_cbCategoria.gridy = 5;
		contentPane.add(cbCategoria, gbc_cbCategoria);

		JButton btnBuscaCategoria = new JButton("Buscar");
		btnBuscaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				
			}
		});
		GridBagConstraints gbc_btnBuscaCategoria = new GridBagConstraints();
		gbc_btnBuscaCategoria.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBuscaCategoria.gridx = 3;
		gbc_btnBuscaCategoria.gridy = 5;
		contentPane.add(btnBuscaCategoria, gbc_btnBuscaCategoria);
	}

}
