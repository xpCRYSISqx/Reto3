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
	public JButton btnLogin,btnregistro,btnContinuar,btnAtras,btnCancelar;
	public JRadioButton rbtnIda,rbtnVuelta;
	public JList listaOrigen,listaDestino;
	
	public PanSelBillete() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		btnLogin = new JButton("Inicio de Sesi\u00F3n");
		btnLogin.setBounds(907, 11, 107, 23);
		add(btnLogin);
		
		btnregistro = new JButton("Registrar");
		btnregistro.setBounds(907, 38, 107, 23);
		add(btnregistro);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(907, 686, 107, 23);
		add(btnContinuar);
		
		lbltitulo = new JLabel("SELECCI\u00D3N DE BILLETE");
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("Mistral", Font.PLAIN, 44));
		lbltitulo.setBounds(10, 11, 1004, 91);
		add(lbltitulo);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 686, 89, 23);
		add(btnCancelar);
		
		lblOrigen = new JLabel("Origen");
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblOrigen.setBounds(322, 265, 84, 23);
		add(lblOrigen);
		
		lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblDestino.setBounds(522, 265, 66, 23);
		add(lblDestino);
		
		listaOrigen = new JList<String>();
		listaOrigen.setBounds(116, 299, 327, 289);
		add(listaOrigen);
		
		listaDestino = new JList<String>();
		listaDestino.setBounds(479, 299, 327, 289);
		add(listaDestino);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(10, 659, 89, 23);
		add(btnAtras);
		
		rbtnIda = new JRadioButton("Simple");
		rbtnIda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rbtnIda.setBounds(277, 109, 166, 56);
		add(rbtnIda);
		
		rbtnVuelta = new JRadioButton("Ida / Vuelta");
		rbtnVuelta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rbtnVuelta.setBounds(593, 109, 167, 56);
		add(rbtnVuelta);

	}
}
