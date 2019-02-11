package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class FormatoDiseno {
	
	public static void tipografia(JLabel fuenteLbl, JButton fuenteBtn, JRadioButton fuenteRbtn, JTextField fuenteTxt, JList<String> fuenteList) {
		fuenteLbl.setFont(new Font("Agency FB", Font.BOLD, 14));
		fuenteBtn.setFont(new Font("Agency FB", Font.BOLD, 12));
		fuenteRbtn.setFont(new Font("Agency FB", Font.BOLD, 18));
		fuenteTxt.setFont(new Font("Agency FB", Font.BOLD, 14));
		fuenteList.setFont(new Font("Agency FB", Font.BOLD, 14));
	}

	public static void formatoTitulo(JLabel lblTitulo) {
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Agency FB", Font.BOLD, 44));
		lblTitulo.setBounds(10, 170, 1004, 80);
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
	
	public static void formatoLbl(JLabel lbl) {
		lbl.setFont(new Font("Agency FB", Font.BOLD, 20));
//		lbl.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public static void formatoTxt(JTextField campoTxt) {
		campoTxt.setFont(new Font("Agency FB", Font.PLAIN, 18));
		campoTxt.setForeground(new Color(0, 0, 0));
		campoTxt.setBackground(new Color(204, 150, 150));
		campoTxt.setBorder(null);
	}
	
	public static void formatoBtn(JButton btn) {
		btn.setFont(new Font("Agency FB", Font.BOLD, 18));
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
	
	public static void formatoBtnCancelarPago(JButton btn) {
		FormatoDiseno.formatoBtn(btn);
//		btn.setBounds(45, 642, 100, 25);
		btn.setBounds(30, 493, 120, 30);
	}
	
	public static void formatoBtnCash(JButton btn) {
		FormatoDiseno.formatoBtn(btn);
		btn.setFont(new Font("Dialog", Font.PLAIN, 18));
	}
	
	public static void formatoRbtn(JRadioButton rbtn) {
		rbtn.setFont(new Font("Agency FB", Font.PLAIN, 28));
		rbtn.setForeground(new Color(0, 0, 0));
		rbtn.setBackground(new Color(255, 255, 255));
		rbtn.setBorderPainted(false);
		rbtn.setBorder(null);
		rbtn.setSelectedIcon(null);
	}
	
	public static void formatoList(JList<String> list) {
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		list.setFont(new Font("Agency FB", Font.PLAIN, 20));
		list.setForeground(new Color(0, 0, 0));
		list.setBackground(new Color(204, 150, 150));
		list.setRequestFocusEnabled(false);
	}
	
}
