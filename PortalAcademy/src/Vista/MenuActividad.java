package Vista;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Modelo.Actividad;

public class MenuActividad extends JPanel{
	
	private JButton editar;
	
	private JButton btnInicio;
	private JButton btnCuestionarios;
	private Actividad actividad;
	
	private URL url = getClass().getResource("/img/fondoBlanco.jpg");
    Image image = new ImageIcon(url).getImage();
	
	public MenuActividad(Actividad actividad) {
		this.actividad = actividad;
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		btnInicio = new JButton(new ImageIcon(getClass().getResource("/img/inicio.png")));
		btnInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInicio.setContentAreaFilled(false);
		btnInicio.setFocusPainted(false);
		btnInicio.setBorderPainted(false);
		btnInicio.setBounds(328, 278, 174, 40);
		add(btnInicio);
		
		btnCuestionarios = new JButton(new ImageIcon(getClass().getResource("/img/cuestionarios.png")));
		btnCuestionarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCuestionarios.setContentAreaFilled(false);
		btnCuestionarios.setFocusPainted(false);
		btnCuestionarios.setBorderPainted(false);
		btnCuestionarios.setBounds(592, 278, 174, 40);
		add(btnCuestionarios);
		
		if(Main.getUser() != null && Main.getUser().equals(actividad.getOrganizacion())) {
			editar = new JButton(new ImageIcon(getClass().getResource("/img/editarActividad.png")));
			editar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			editar.setContentAreaFilled(false);
			editar.setFocusPainted(false);
			editar.setBorderPainted(false);
			editar.setBounds(455, 854, 180, 60);
			add(editar);
		}
		
	}
	
	public Actividad getActividad() {
		return actividad;
	}
	
	public void controlador(ActionListener ctr) {
		if (btnInicio != null) {
			btnInicio.addActionListener(ctr);
			btnInicio.setActionCommand("INICIO");
		}
		if (btnCuestionarios != null) {
			btnCuestionarios.addActionListener(ctr);
			btnCuestionarios.setActionCommand("CUESTIONARIOS");
		}
		if (editar != null) {
			editar.addActionListener(ctr);
			editar.setActionCommand("EDITAR");
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
		
		super.paint(g);
	}
}