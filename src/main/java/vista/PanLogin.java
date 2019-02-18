package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PanLogin extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JLabel lblIcono,lblTitulo,lblUsuario,lblPassword;
	public JTextField userField;
	public JPasswordField password;
	public JButton btnLogin,btnRegistro,btnCancelar,btnAtras;

	/**
	 * Create the panel.
	 */
	public PanLogin() {
		
		// configuracion del panel
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		// label para el icono corporativo
		lblIcono = new JLabel("");
		FormatoDiseno.formatoIcono(lblIcono);
		add(lblIcono);
		
		// label titulo panel
		lblTitulo = new JLabel("Inicio de sesi\u00F3n");
		FormatoDiseno.formatoTitulo(lblTitulo);
		add(lblTitulo);
		
		// boton registarse
		btnRegistro = new JButton("Registro");
		FormatoDiseno.formatoBtnLogin(btnRegistro);
		add(btnRegistro);
		
		// label usuario
		lblUsuario = new JLabel("Usuario (DNI)");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setBounds(397, 283, 215, 25);
		add(lblUsuario);
		
		// campo usuario
		userField = new JTextField();
		FormatoDiseno.formatoTxt(userField);
		userField.setBounds(397, 308, 215, 30);
		userField.setColumns(10);
		add(userField);
		
		// label password
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setBounds(397, 353, 215, 25);
		add(lblPassword);
		
		// campo password
		password = new JPasswordField();
		FormatoDiseno.formatoTxt(password);
		password.setBounds(397, 378, 215, 30);
		add(password);
		
		// boton de iniciar sesion
		btnLogin = new JButton("Iniciar Sesi\u00F3n");
		FormatoDiseno.formatoBtn(btnLogin);
		btnLogin.setBounds(452, 441, 120, 40);
		add(btnLogin);
		
		// boton cancelar
		btnAtras = new JButton("Atr\u00E1s");
		FormatoDiseno.formatoBtnAtras(btnAtras);
		add(btnAtras);
		
		// boton cancelar
		btnCancelar = new JButton("Cancelar");
		FormatoDiseno.formatoBtnCancelar(btnCancelar);
		add(btnCancelar);
		
	}
}
