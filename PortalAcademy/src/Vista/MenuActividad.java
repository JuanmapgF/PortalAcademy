package Vista;

import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

public class MenuActividad extends JPanel{
	
	private JButton btnInicio;
	private JButton btnCuestionarios;
	private Actividad c;
	
	public MenuActividad(Actividad actividad) {
		c = actividad;
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInicio.setBounds(328, 278, 174, 40);
		add(btnInicio);
		
		btnCuestionarios = new JButton("Cuestionarios");
		btnCuestionarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCuestionarios.setBounds(854, 278, 174, 40);
		add(btnCuestionarios);
		
	}
	
	public Actividad getActividad() {
		return c;
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
	}
}