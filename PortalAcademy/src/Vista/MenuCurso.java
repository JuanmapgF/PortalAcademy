package Vista;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.net.URL;

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
	private Curso curso;
	
	private JButton editar;
	private JButton editarParticipantes;
	
	private URL url = getClass().getResource("/img/fondoBlanco.jpg");
    Image image = new ImageIcon(url).getImage();
	
	public MenuCurso(Curso curso) {
		this.curso = curso;
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		if(Main.getUser() != null && Main.getUser().equals(curso.getProfesor())) {
			editar = new JButton(new ImageIcon(getClass().getResource("/img/editarCurso.png")));
			editar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			editar.setContentAreaFilled(false);
			editar.setFocusPainted(false);
			editar.setBorderPainted(false);
			editar.setBounds(455, 854, 180, 60);
			add(editar);
			
			editarParticipantes = new JButton(new ImageIcon(getClass().getResource("/img/editarParticipantes.png")));
			editarParticipantes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			editarParticipantes.setContentAreaFilled(false);
			editarParticipantes.setFocusPainted(false);
			editarParticipantes.setBorderPainted(false);
			editarParticipantes.setBounds(678, 854, 180, 60);
			add(editarParticipantes);
		}
		
		
		
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
		return curso;
	}
	
	
	
	public void controlador(ActionListener ctr) {
		if (editarParticipantes != null) {
			editarParticipantes.addActionListener(ctr);
			editarParticipantes.setActionCommand("EDITAR_PARTICIPANTES");
		}
		
		if (editar != null) {
			editar.addActionListener(ctr);
			editar.setActionCommand("EDITAR");
		}
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
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
		
		super.paint(g);
	}
}
