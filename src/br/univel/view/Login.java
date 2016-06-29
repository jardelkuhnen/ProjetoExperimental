package br.univel.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.univel.controller.UsuarioController;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Login fLogin = new Login();
					fLogin.setVisible(true);
					fLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					fLogin.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 443, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		panel.setForeground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 51, 0, 0, 281, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 21, 9, 28, 12, 12, 50, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblRf = new JLabel("Prolar Planejados");
		lblRf.setForeground(new Color(0, 0, 128));
		lblRf.setFont(new Font("Andalus", Font.PLAIN, 28));
		GridBagConstraints gbc_lblRf = new GridBagConstraints();
		gbc_lblRf.gridwidth = 5;
		gbc_lblRf.insets = new Insets(0, 0, 5, 0);
		gbc_lblRf.gridx = 0;
		gbc_lblRf.gridy = 0;
		panel.add(lblRf, gbc_lblRf);

		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioController uc = new UsuarioController();
				boolean msg = uc.logar(txtUsuario.getText(), txtSenha.getText());

				if (msg) {

					limpaCampos();
					Principal p = new Principal();
					p.setExtendedState(JFrame.MAXIMIZED_BOTH);
					p.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null,
							"Usuário não cadastrado");
				}
			}
		});

		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.gridwidth = 3;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 1;
		gbc_txtUsuario.gridy = 3;
		panel.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 5;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtSenha = new JPasswordField();
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.gridwidth = 3;
		gbc_txtSenha.insets = new Insets(0, 0, 5, 0);
		gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenha.gridx = 1;
		gbc_txtSenha.gridy = 5;
		panel.add(txtSenha, gbc_txtSenha);
		GridBagConstraints gbc_btnLogar = new GridBagConstraints();
		gbc_btnLogar.gridwidth = 5;
		gbc_btnLogar.gridx = 0;
		gbc_btnLogar.gridy = 6;
		panel.add(btnLogar, gbc_btnLogar);
	}

	public void limpaCampos() {
		txtUsuario.setText("");
		txtSenha.setText("");
	}

}
