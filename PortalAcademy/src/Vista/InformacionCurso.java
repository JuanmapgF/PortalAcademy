package Vista;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InformacionCurso extends JPanel {
	private JButton cerrarSesion;

	/**
	 * Create the panel.
	 */
	public InformacionCurso(String nombre, String descripcion, List<String> mensajes) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		JLabel nombreCurso = new JLabel(nombre);
		nombreCurso.setBounds(428, 34, 269, 33);
		add(nombreCurso);
		
		JTextArea descripcionCurso = new JTextArea(descripcion);
		descripcionCurso.setBounds(278, 102, 652, 371);
		add(descripcionCurso);
		
		cerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		cerrarSesion.setBounds(952, 39, 118, 23);
		add(cerrarSesion);
	}

}
