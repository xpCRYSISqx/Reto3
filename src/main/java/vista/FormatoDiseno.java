package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

public class FormatoDiseno {

	public static void formatoTitulo(JLabel lblTitulo) {
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Agency FB", Font.BOLD, 44));
		lblTitulo.setBounds(10, 171, 1004, 81);
	}
	
	public static void formatoIcono(JLabel lblIcono) {
		lblIcono.setIcon(new ImageIcon(PanSelLinea.class.getResource("/img/logo-termibus.png")));
		lblIcono.setOpaque(true);
		lblIcono.setBorder(null);
		lblIcono.setForeground(new Color(0, 0, 0));
		lblIcono.setBackground(new Color(255, 255, 255));
		lblIcono.setHorizontalAlignment(SwingConstants.LEFT);
		lblIcono.setBounds(53, 35, 306, 112);
	}
	
	public static void formatoTxt(JTextField campoTxt) {
		campoTxt.setForeground(new Color(0, 0, 0));
		campoTxt.setBackground(new Color(204, 150, 150));
		campoTxt.setBorder(null);
	}
	
	public static void formatoBtn(JButton btn) {
		btn.setForeground(new Color(255, 255, 255));
		btn.setBackground(new Color(204, 0, 0));
		btn.setBorderPainted(false);
		btn.setBorder(null);
		btn.setSelectedIcon(null);
	}
	
	public static void formatoBtnLogin(JButton btn) {
		FormatoDiseno.formatoBtn(btn);
		btn.setBounds(830, 35, 125, 25);
	}
	
	public static void formatoBtnRegistro(JButton btn) {
		FormatoDiseno.formatoBtn(btn);
		btn.setBounds(830, 70, 125, 25);
	}
	
	public static void formatoBtnContinuar(JButton btn) {
		FormatoDiseno.formatoBtn(btn);
		btn.setBounds(846, 642, 100, 25);
	}
	
	public static void formatoBtnAtras(JButton btn) {
		FormatoDiseno.formatoBtn(btn);
		btn.setBounds(45, 607, 100, 25);
	}
	
	public static void formatoBtnCancelar(JButton btn) {
		FormatoDiseno.formatoBtn(btn);
		btn.setBounds(45, 642, 100, 25);
	}
	
	public static void formatoList(JList<String> list) {
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setForeground(new Color(0, 0, 0));
		list.setBackground(new Color(204, 150, 150));
		
	}
	
}
