package vista;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PanLogin extends JPanel {
	
	JPanel login = new JPanel();
	
	public JTextField textField;
	public JPasswordField passwordField;
	public JButton button;

	/**
	 * Create the panel.
	 */
	public PanLogin() {
		setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario (DNI)");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setBounds(100, 302, 70, 20);
		add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(180, 302, 216, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(110, 333, 53, 14);
		add(lblPassword);
		
		JLabel lblInicioDeSesin = new JLabel("INICIO DE SESI\u00D3N");
		lblInicioDeSesin.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblInicioDeSesin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioDeSesin.setBounds(0, 36, 475, 81);
		add(lblInicioDeSesin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 333, 216, 14);
		add(passwordField);
		
		JButton btnNewButton = new JButton("Iniciar Sesi\u00F3n");
		btnNewButton.setBounds(180, 368, 114, 42);
		add(btnNewButton);
		
		button = new JButton("Cancelar");
		button.setBounds(10, 686, 89, 23);
		add(button);

	}
}
