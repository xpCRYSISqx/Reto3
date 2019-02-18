package vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Atributos
	public JFrame ventana;
	public PanBienvenida bienvenida;
	public PanLogin login;
	public PanRegistro registro;
	public PanSelBillete sel_billete;
	public PanSelFecha sel_fecha;
	public PanDetalles detalles_compra;
	public PanPago pago;
	public PanFinPago fin_pago;
	public PanDespedida agur;
	
	//Constructor
	public MainFrame() {
		//Parámetros del Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(new Color(255, 192, 203));
				
		InstanciarPaneles();
		AddPaneles();
		
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/Logo_Bilbao.png"));
	    setIconImage(icon);
	    setVisible(true);
	    setTitle("TERMIBUS BILBAO");
	}
	
	
	private void InstanciarPaneles() {
		try {
			bienvenida = new PanBienvenida();
		} catch (IOException e) {
			e.printStackTrace();
		}
		login = new PanLogin();
		registro = new PanRegistro();
		sel_billete = new PanSelBillete();
		sel_fecha = new PanSelFecha();
		detalles_compra = new PanDetalles();
		pago = new PanPago();
		fin_pago = new PanFinPago();
		agur = new PanDespedida();
	}
	
	private void AddPaneles() {
		getContentPane().add(bienvenida);
		getContentPane().add(login);
		getContentPane().add(registro);
		getContentPane().add(sel_billete);
		getContentPane().add(sel_fecha);
		getContentPane().add(detalles_compra);
		getContentPane().add(pago);
		getContentPane().add(fin_pago);
		getContentPane().add(agur);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}