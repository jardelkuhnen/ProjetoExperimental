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

import br.univel.enun.Uf;

import java.awt.Color;

public class RelCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCidade;

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
	public RelCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 249);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 66, 280, 65, 0 };
		gbl_contentPane.rowHeights = new int[] { 22, 0, 35, 23, 35, 23, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblRelatrioDeClientes = new JLabel("Relat\u00F3rio de Clientes");
		lblRelatrioDeClientes.setForeground(new Color(0, 0, 128));
		lblRelatrioDeClientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_lblRelatrioDeClientes = new GridBagConstraints();
		gbc_lblRelatrioDeClientes.gridwidth = 3;
		gbc_lblRelatrioDeClientes.anchor = GridBagConstraints.NORTH;
		gbc_lblRelatrioDeClientes.insets = new Insets(0, 0, 5, 5);
		gbc_lblRelatrioDeClientes.gridx = 0;
		gbc_lblRelatrioDeClientes.gridy = 1;
		contentPane.add(lblRelatrioDeClientes, gbc_lblRelatrioDeClientes);

		JLabel label = new JLabel("Cidade");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 3;
		contentPane.add(label, gbc_label);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtCidade.gridx = 1;
		gbc_txtCidade.gridy = 3;
		contentPane.add(txtCidade, gbc_txtCidade);

		JButton btnBuscaCidade = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscaCidade = new GridBagConstraints();
		gbc_btnBuscaCidade.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBuscaCidade.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscaCidade.gridx = 2;
		gbc_btnBuscaCidade.gridy = 3;
		contentPane.add(btnBuscaCidade, gbc_btnBuscaCidade);

		JLabel lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 5;
		contentPane.add(lblEstado, gbc_lblEstado);

		JComboBox cbEstado = new JComboBox(Uf.values());
		GridBagConstraints gbc_cbEstado = new GridBagConstraints();
		gbc_cbEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEstado.insets = new Insets(0, 0, 0, 5);
		gbc_cbEstado.gridx = 1;
		gbc_cbEstado.gridy = 5;
		contentPane.add(cbEstado, gbc_cbEstado);

		JButton btnBuscaEstado = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscaEstado = new GridBagConstraints();
		gbc_btnBuscaEstado.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBuscaEstado.gridx = 2;
		gbc_btnBuscaEstado.gridy = 5;
		contentPane.add(btnBuscaEstado, gbc_btnBuscaEstado);
	}

}
