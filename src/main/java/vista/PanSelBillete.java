package vista;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JRadioButton;

public class PanSelBillete extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	JPanel sel_billete = new JPanel();
	
	public DefaultListModel<String> modeloOrigen = new DefaultListModel<String>();
	public DefaultListModel<String> modeloDestino = new DefaultListModel<String>();
	
	public JLabel lbltitulo,lblOrigen,lblDestino;
	public JButton btnLogin,btnRegistro,btnContinuar,btnAtras,btnCancelar;
	public JRadioButton rbtnIda,rbtnVuelta;
	public JList listaOrigen,listaDestino;
	
	public PanSelBillete() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		lbltitulo = new JLabel("SELECCI\u00D3N DE BILLETE");
		lbltitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lbltitulo.setFont(new Font("Mistral", Font.PLAIN, 44));
		lbltitulo.setBounds(30, 35, 1004, 81);
		add(lbltitulo);
		
		btnLogin = new JButton("Inicio de Sesi\u00F3n");
		btnLogin.setBounds(880, 35, 125, 25);
		add(btnLogin);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(880, 71, 125, 25);
		add(btnRegistro);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(915, 650, 90, 25);
		add(btnContinuar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 650, 100, 25);
		add(btnCancelar);
		
		lblOrigen = new JLabel("Selecccione origen");
		lblOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblOrigen.setBounds(116, 269, 327, 40);
		add(lblOrigen);
		
		lblDestino = new JLabel("Selecccione  destino");
		lblDestino.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestino.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblDestino.setBounds(479, 269, 327, 40);
		add(lblDestino);
		
		listaOrigen = new JList<String>();
		listaOrigen.setBounds(116, 320, 327, 250);
		add(listaOrigen);
		
		listaDestino = new JList<String>();
		listaDestino.setBounds(479, 320, 327, 250);
		add(listaDestino);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(10, 616, 89, 23);
		add(btnAtras);
		
		rbtnIda = new JRadioButton("Simple");
		rbtnIda.setHorizontalAlignment(SwingConstants.LEFT);
		rbtnIda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rbtnIda.setBounds(332, 180, 180, 50);
		add(rbtnIda);
		
		rbtnVuelta = new JRadioButton("Ida / Vuelta");
		rbtnVuelta.setHorizontalAlignment(SwingConstants.CENTER);
		rbtnVuelta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rbtnVuelta.setBounds(512, 180, 180, 50);
		add(rbtnVuelta);

	}
}
