package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class DescripcionCurso extends JPanel {
	private JButton unirse;
	private JButton cerrar;
	private JButton explorar;
	private JButton cursos;
	private JButton actividades;
	private JButton ajustes;
	private JButton iniciar;
	private JButton registrarse;
	
	/**
	 * Create the panel.
	 */
	public DescripcionCurso(String nombre, String descripcion, Boolean puedeUnirse, Boolean esEstudiante) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		JLabel nombreCurso = new JLabel(nombre);
		nombreCurso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		nombreCurso.setBounds(460, 70, 269, 33);
		add(nombreCurso);
		
		JTextArea descripcionCurso = new JTextArea(descripcion);
		descripcionCurso.setBounds(292, 131, 652, 371);
		add(descripcionCurso);
		descripcionCurso.setEditable(false);
		
		if(esEstudiante != null && esEstudiante) {
			if (puedeUnirse) {
				unirse = new JButton("Unirse");
				unirse.setBounds(478, 511, 89, 23);
				add(unirse);
			}
			cursos = new JButton("Mis cursos");
			cursos.setBounds(36, 261, 131, 32);
			add(cursos);
			
			actividades = new JButton("Mis actividades");
			actividades.setBounds(36, 336, 131, 32);
			add(actividades);
			
			ajustes = new JButton("Ajustes");
			ajustes.setBounds(36, 413, 131, 32);
			add(ajustes);
			
			cerrar = new JButton("Cerrar Sesi\u00F3n");
			cerrar.setBounds(860, 37, 121, 23);
			add(cerrar);
		}else if (esEstudiante != null && !esEstudiante){
			
			cursos = new JButton("Mis cursos");
			cursos.setBounds(36, 261, 131, 32);
			add(cursos);
			
			ajustes = new JButton("Ajustes");
			ajustes.setBounds(36, 336, 131, 32);
			add(ajustes);
			
			cerrar = new JButton("Cerrar Sesi\u00F3n");
			cerrar.setBounds(860, 37, 121, 23);
			add(cerrar);
		}else {
			if (puedeUnirse) {
				unirse = new JButton("Unirse");
				unirse.setBounds(478, 511, 89, 23);
				add(unirse);
			}	
			
			iniciar = new JButton("Iniciar sesi\u00F3n");
			iniciar.setBounds(729, 37, 121, 23);
			add(iniciar);
				
			registrarse = new JButton("Registrarse");
			registrarse.setBounds(860, 37, 121, 23);
			add(registrarse);
			
		}
		
		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);
		
	}
	
	public void controlador(ActionListener ctr) {
		if (iniciar != null) {
			iniciar.addActionListener(ctr);
			iniciar.setActionCommand("INICIAR_SESION");
		}
		
		if (explorar != null) {
			explorar.addActionListener(ctr);
			explorar.setActionCommand("EXPLORAR");
		}
		
		if (registrarse != null) {
			registrarse.addActionListener(ctr);
			registrarse.setActionCommand("REGISTRO");
		}
		
		if(unirse != null) {
			unirse.addActionListener(ctr);
			unirse.setActionCommand("Unirse");
		}
		
		if (cursos != null) {
			cursos.addActionListener(ctr);
			cursos.setActionCommand("CURSO");
		}
		if (actividades != null) {
			actividades.addActionListener(ctr);
			actividades.setActionCommand("ACTIVIDAD");
		}
		if (ajustes != null) {
			ajustes.addActionListener(ctr);
			ajustes.setActionCommand("AJUSTES");
		}
		if (cerrar != null) {
			cerrar.addActionListener(ctr);
			cerrar.setActionCommand("CERRAR_SESION");
		} 
	}
	
}
