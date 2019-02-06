package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PanLogin extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel login = new JPanel();
	
	public JLabel lblTitulo,lblUsuario,lblPassword;
	public JTextField userField;
	public JPasswordField password;
	public JButton btnLogin,btnRegistrar,btnCancelar;

	/**
	 * Create the panel.
	 */
	public PanLogin() {
		
		// configuracion del panel
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		// label titulo panel
		lblTitulo = new JLabel("INICIO DE SESI\u00D3N");
		lblTitulo.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 11, 1014, 81);
		add(lblTitulo);
		
		// label usuario
		lblUsuario = new JLabel("Usuario (DNI)");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setBounds(397, 263, 215, 25);
		add(lblUsuario);
		
		// campo usuario
		userField = new JTextField();
		userField.setBounds(397, 288, 215, 30);
		add(userField);
		userField.setColumns(10);
		
		// label password
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setBounds(397, 333, 215, 25);
		add(lblPassword);
		
		// campo password
		password = new JPasswordField();
		password.setBounds(397, 358, 215, 30);
		add(password);
		
		// boton de iniciar sesion
		btnLogin = new JButton("Iniciar Sesi\u00F3n");
		btnLogin.setBounds(453, 399, 115, 40);
		add(btnLogin);
		
		// boton cancelar
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 679, 90, 30);
		add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(925, 11, 90, 30);
		add(btnRegistrar);

	}
}
