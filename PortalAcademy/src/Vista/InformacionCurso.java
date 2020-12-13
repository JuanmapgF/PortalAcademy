package Vista;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InformacionCurso extends JPanel {
	private JButton cerrarSesion;

	/**
	 * Create the panel.
	 */
	public InformacionCurso(String nombre, String descripcion, Boolean tieneForo, List<String> mensajes) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
//		if (tieneForo) {
			//TODO: Foro
//		}
		
		
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
	
	public InformacionCurso(String nombre, String descripcion, Boolean publico, Integer aforo,
			Boolean presencial, Boolean tieneForo) {
		
		
	}
	
	public void controlador(ActionListener ctr) {		
		cerrarSesion.addActionListener(ctr);
		cerrarSesion.setActionCommand("Cerrar Sesi\u00F3n");
	}

}
