package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.JButton;

import br.univel.controller.ClienteController;
import br.univel.dao.ClienteDao;
import br.univel.enun.GeneroCli;
import br.univel.enun.Uf;
import br.univel.model.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import java.awt.Color;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.Window.Type;
import java.awt.Cursor;

public class CadCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtEmail;
	private JComboBox cbEstado;
	private JComboBox cbGenero;

	public CadCliente() {
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 481, 386);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel cadCliente = new JPanel();
		cadCliente.setToolTipText("Cadastro de Clientes");
		cadCliente.setBorder(null);
		cadCliente.setBackground(new Color(240, 240, 240));
		contentPane.add(cadCliente, BorderLayout.CENTER);
		GridBagLayout gbl_cadCliente = new GridBagLayout();
		gbl_cadCliente.columnWidths = new int[] { 69, 86, 25, 63, 66, 65, 0, 0,
				0 };
		gbl_cadCliente.rowHeights = new int[] { 20, 40, 20, 20, 20, 20, 20, 20,
				20, 20, 23, 0 };
		gbl_cadCliente.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_cadCliente.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		cadCliente.setLayout(gbl_cadCliente);

		JLabel lblCadasroDeCliente = new JLabel("Cadasro de Cliente");
		lblCadasroDeCliente.setForeground(new Color(0, 0, 128));
		lblCadasroDeCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				16));
		GridBagConstraints gbc_lblCadasroDeCliente = new GridBagConstraints();
		gbc_lblCadasroDeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCadasroDeCliente.gridwidth = 8;
		gbc_lblCadasroDeCliente.gridx = 0;
		gbc_lblCadasroDeCliente.gridy = 0;
		cadCliente.add(lblCadasroDeCliente, gbc_lblCadasroDeCliente);

		JLabel lblId = new JLabel("C\u00F3digo");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 2;
		cadCliente.add(lblId, gbc_lblId);

		txtId = new JTextField();
		txtId.setEditable(false);
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.gridwidth = 5;
		gbc_txtId.anchor = GridBagConstraints.NORTH;
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.insets = new Insets(0, 0, 5, 5);
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 2;
		cadCliente.add(txtId, gbc_txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		cadCliente.add(lblNewLabel, gbc_lblNewLabel);

		txtNome = new JTextField();
		txtNome.setFocusable(true);
		txtNome.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F2) {
					abriTelaPesquisaCliente();
				}
			}

		});

		txtNome.setColumns(10);
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.anchor = GridBagConstraints.NORTH;
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.gridwidth = 5;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 3;
		cadCliente.add(txtNome, gbc_txtNome);

		JLabel lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 4;
		cadCliente.add(lblTelefone, gbc_lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		GridBagConstraints gbc_txtTelefone = new GridBagConstraints();
		gbc_txtTelefone.anchor = GridBagConstraints.NORTH;
		gbc_txtTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefone.gridwidth = 5;
		gbc_txtTelefone.gridx = 1;
		gbc_txtTelefone.gridy = 4;
		cadCliente.add(txtTelefone, gbc_txtTelefone);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblEndereco = new GridBagConstraints();
		gbc_lblEndereco.anchor = GridBagConstraints.EAST;
		gbc_lblEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereco.gridx = 0;
		gbc_lblEndereco.gridy = 5;
		cadCliente.add(lblEndereco, gbc_lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		GridBagConstraints gbc_txtEndereco = new GridBagConstraints();
		gbc_txtEndereco.anchor = GridBagConstraints.NORTH;
		gbc_txtEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_txtEndereco.gridwidth = 5;
		gbc_txtEndereco.gridx = 1;
		gbc_txtEndereco.gridy = 5;
		cadCliente.add(txtEndereco, gbc_txtEndereco);

		JLabel lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 6;
		cadCliente.add(lblCidade, gbc_lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.anchor = GridBagConstraints.NORTH;
		gbc_txtCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtCidade.gridwidth = 5;
		gbc_txtCidade.gridx = 1;
		gbc_txtCidade.gridy = 6;
		cadCliente.add(txtCidade, gbc_txtCidade);

		JLabel lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 7;
		cadCliente.add(lblEstado, gbc_lblEstado);

		cbEstado = new JComboBox(Uf.values());
		GridBagConstraints gbc_cbEstado = new GridBagConstraints();
		gbc_cbEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEstado.gridwidth = 5;
		gbc_cbEstado.anchor = GridBagConstraints.NORTH;
		gbc_cbEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cbEstado.gridx = 1;
		gbc_cbEstado.gridy = 7;
		cadCliente.add(cbEstado, gbc_cbEstado);

		JLabel lblGnero = new JLabel("G\u00EAnero");
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.anchor = GridBagConstraints.EAST;
		gbc_lblGnero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGnero.gridx = 0;
		gbc_lblGnero.gridy = 8;
		cadCliente.add(lblGnero, gbc_lblGnero);

		cbGenero = new JComboBox(GeneroCli.values());
		GridBagConstraints gbc_cbGenero = new GridBagConstraints();
		gbc_cbGenero.anchor = GridBagConstraints.NORTH;
		gbc_cbGenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbGenero.insets = new Insets(0, 0, 5, 5);
		gbc_cbGenero.gridwidth = 5;
		gbc_cbGenero.gridx = 1;
		gbc_cbGenero.gridy = 8;
		cadCliente.add(cbGenero, gbc_cbGenero);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 9;
		cadCliente.add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.anchor = GridBagConstraints.NORTH;
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.gridwidth = 5;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 9;
		cadCliente.add(txtEmail, gbc_txtEmail);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validaCampos() == true) {
					JOptionPane.showMessageDialog(null,
							"Preencha os campos corretamente !!!");
				} else {
					ClienteController cc = new ClienteController();

					int resposta = JOptionPane.showConfirmDialog(
							null,
							"Deseja excluir o cliente de Id: "
									+ txtId.getText() + " ?");
					if (resposta == JOptionPane.YES_OPTION) {
						cc.deletar(Integer.parseInt(txtId.getText().trim()));

					}
				}
				limparCampos();
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 3;
		gbc_btnExcluir.gridy = 10;
		cadCliente.add(btnExcluir, gbc_btnExcluir);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (validaCampos() == true) {
					JOptionPane.showMessageDialog(null,
							"Preencha corretamente os campos!!!.");

				} else {

					ClienteController cc = new ClienteController();

					Uf estado = (Uf) cbEstado.getSelectedItem();

					GeneroCli genCli = (GeneroCli) cbGenero.getSelectedItem();

					cc.salvar(txtNome.getText().trim(), txtTelefone.getText(),
							txtEndereco.getText().trim(), txtCidade.getText()
									.trim(), estado, genCli, txtEmail.getText()
									.trim());

					limparCampos();
				}

			}
		});

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (validaCampos() == true) {
					JOptionPane.showMessageDialog(null,
							"Preencha corretamente os campos!!!.");

				} else {

					ClienteController cc = new ClienteController();

					Uf estado = (Uf) cbEstado.getSelectedItem();
					GeneroCli genCli = (GeneroCli) cbGenero.getSelectedItem();
					cc.editar(Integer.parseInt(txtId.getText().trim()), txtNome
							.getText().trim(), txtTelefone.getText().trim(),
							txtEndereco.getText().trim(), txtCidade.getText()
									.trim(), estado, genCli, txtEmail.getText()
									.trim());

					limparCampos();

				}

			}
		});
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEditar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditar.gridx = 4;
		gbc_btnEditar.gridy = 10;
		cadCliente.add(btnEditar, gbc_btnEditar);
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSalvar.gridx = 5;
		gbc_btnSalvar.gridy = 10;
		cadCliente.add(btnSalvar, gbc_btnSalvar);
		cadCliente
				.setFocusTraversalPolicy(new FocusTraversalOnArray(
						new Component[] { lblCadasroDeCliente, txtId, txtNome,
								txtTelefone, txtEndereco, txtCidade, cbEstado,
								cbGenero, txtEmail, btnExcluir, btnEditar,
								btnSalvar }));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				txtId, txtNome, txtTelefone, txtEndereco, txtCidade, cbEstado,
				cbGenero, txtEmail, btnExcluir, btnEditar, btnSalvar }));
	}

	private void abriTelaPesquisaCliente() {
		BuscaCliente c = new BuscaCliente(this);
		c.setVisible(true);
		c.setLocationRelativeTo(null);

	}

	public void carregaClientePesquisadoEmTela(Cliente cliente) {
		txtId.setText(String.valueOf(cliente.getId()));
		txtNome.setText(cliente.getNome());
		txtTelefone.setText(cliente.getTelefone());
		txtEndereco.setText(cliente.getEndereco());
		txtCidade.setText(cliente.getCidade());
		txtEmail.setText(cliente.getEmail());
	}

	void limparCampos() {
		txtId.setText("");
		txtNome.setText("");
		txtTelefone.setText("");
		txtEndereco.setText("");
		txtCidade.setText("");
		txtEmail.setText("");

	}

	boolean validaCampos() {
		boolean valida;
		if (txtNome.getText().equals("") || txtTelefone.getText().equals("")) {
			valida = true;
		} else {
			valida = false;
		}
		return valida;

	}
}
