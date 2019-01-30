package vista;

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
	public PanSelLinea sel_linea;
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
		
		InstanciarPaneles();
		AddPaneles();
		
	}
	
	
	private void InstanciarPaneles() {
		bienvenida = new PanBienvenida();
		login = new PanLogin();
		registro = new PanRegistro();
		sel_linea = new PanSelLinea();
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
		getContentPane().add(sel_linea);
		getContentPane().add(sel_billete);
		getContentPane().add(sel_fecha);
		getContentPane().add(detalles_compra);
		getContentPane().add(pago);
		getContentPane().add(fin_pago);
		getContentPane().add(agur);		
	}
	
	
	
	
	
	
	
	
	
	
}