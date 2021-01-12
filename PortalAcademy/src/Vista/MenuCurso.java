package Vista;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Modelo.Curso;

@SuppressWarnings("serial")
public class MenuCurso extends JPanel{
	
	private JButton btnInicio;
	private JButton btnTemario;
	private JButton btnCuestionarios;
	private JButton btnForo;
	private Curso c;
	
	public MenuCurso(Curso curso) {
		c = curso;
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		btnInicio = new JButton(new ImageIcon(getClass().getResource("/img/inicio.png")));
		btnInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInicio.setContentAreaFilled(false);
		btnInicio.setFocusPainted(false);
		btnInicio.setBorderPainted(false);
		btnInicio.setBounds(328, 278, 174, 40);
		add(btnInicio);
		
		btnTemario = new JButton(new ImageIcon(getClass().getResource("/img/temario.png")));
		btnTemario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTemario.setContentAreaFilled(false);
		btnTemario.setFocusPainted(false);
		btnTemario.setBorderPainted(false);
		btnTemario.setBounds(592, 278, 174, 40);
		add(btnTemario);
		
		btnCuestionarios = new JButton(new ImageIcon(getClass().getResource("/img/cuestionarios.png")));
		btnCuestionarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCuestionarios.setContentAreaFilled(false);
		btnCuestionarios.setFocusPainted(false);
		btnCuestionarios.setBorderPainted(false);
		btnCuestionarios.setBounds(854, 278, 174, 40);
		add(btnCuestionarios);
		
		if(curso.getTieneForo()) {
			btnForo = new JButton(new ImageIcon(getClass().getResource("/img/foro.png")));
			btnForo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnForo.setContentAreaFilled(false);
			btnForo.setFocusPainted(false);
			btnForo.setBorderPainted(false);
			btnForo.setBounds(1115, 278, 174, 40);
			add(btnForo);
		}
		
		
	}
	
	public Curso getCurso() {
		return c;
	}
	
	public void controlador(ActionListener ctr) {
		if (btnInicio != null) {
			btnInicio.addActionListener(ctr);
			btnInicio.setActionCommand("INICIO");
		}
		if (btnTemario != null) {
			btnTemario.addActionListener(ctr);
			btnTemario.setActionCommand("TEMARIO");
		}
		if (btnCuestionarios != null) {
			btnCuestionarios.addActionListener(ctr);
			btnCuestionarios.setActionCommand("CUESTIONARIOS");
		}
		if (btnForo != null) {
			btnForo.addActionListener(ctr);
			btnForo.setActionCommand("FORO");
		}
	}
}
