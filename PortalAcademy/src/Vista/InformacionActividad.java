package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Modelo.Actividad;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Usuario;
@SuppressWarnings("serial")
public class InformacionActividad extends JPanel {
	private JButton cerrarSesion;
	private JButton iniciar;
	private JButton registrarse;
	private JButton editar;
	private JButton cursos;
	private JButton actividades;
	private JButton ajustes;
	private JButton explorar;
	
	/**
	 * Create the panel.
	 */
	public InformacionActividad(Actividad actividad, Usuario user) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(278, 336, 63, 14);
		add(lblFecha);
		
		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLugar.setBounds(278, 382, 63, 14);
		add(lblLugar);
		
		JLabel nombreActividad = new JLabel(actividad.getNombre());
		nombreActividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		nombreActividad.setBounds(428, 34, 364, 33);
		add(nombreActividad);
		
		JTextArea descripcionActividad = new JTextArea(actividad.getDescripcion());
		descripcionActividad.setEditable(false);
		JScrollPane jsp = new JScrollPane(descripcionActividad);
		jsp.setBounds(278, 102, 652, 185);
		add(jsp);
		
		JLabel fecha = new JLabel(actividad.getFecha().toString());
		fecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fecha.setBounds(382, 336, 377, 14);
		add(fecha);
		
		JLabel lugar = new JLabel(actividad.getLugar());
		lugar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lugar.setBounds(382, 384, 342, 14);
		add(lugar);
		
		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);
		
		if (user == null) {
			iniciar = new JButton("Iniciar sesi\u00F3n");
			iniciar.setBounds(729, 37, 121, 23);
			add(iniciar);
			
			explorar.setForeground(Color.BLUE);
			
			registrarse = new JButton("Registrarse");
			registrarse.setBounds(860, 37, 121, 23);
			add(registrarse);
		} else if (user instanceof Estudiante) {
			cursos = new JButton("Mis cursos");
			cursos.setBounds(36, 261, 131, 32);
			add(cursos);
			
			actividades = new JButton("Mis actividades");
			actividades.setBounds(36, 336, 131, 32);
			actividades.setForeground(Color.BLUE);
			add(actividades);
			
			ajustes = new JButton("Ajustes");
			ajustes.setBounds(36, 413, 131, 32);
			add(ajustes);
			
			cerrarSesion = new JButton("Cerrar sesi\u00F3n");
			cerrarSesion.setBounds(860, 37, 121, 23);
			add(cerrarSesion);
			
			JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+Main.getUser().getNick());
			lblNewLabel_2.setBounds(10, 11, 240, 20);
			add(lblNewLabel_2);
		} else if (user instanceof Organizacion) {
			actividades = new JButton("Mis actividades");
			actividades.setForeground(Color.BLUE);
			actividades.setBounds(36, 261, 131, 32);
			add(actividades);
			
			editar = new JButton("Editar");
			editar.setBounds(752, 68, 89, 23);
			add(editar);
			
			cerrarSesion = new JButton("Cerrar sesi\u00F3n");
			cerrarSesion.setBounds(860, 37, 121, 23);
			add(cerrarSesion);
			
			ajustes = new JButton("Ajustes");
			ajustes.setBounds(36, 336, 131, 32);
			add(ajustes);
			
			JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+Main.getUser().getNick());
			lblNewLabel_2.setBounds(10, 11, 240, 20);
			add(lblNewLabel_2);
		}
		
		
		
		
	}
	
	public void controlador(ActionListener ctr) {
		
		if (cerrarSesion != null) {
			cerrarSesion.addActionListener(ctr);
			cerrarSesion.setActionCommand("CERRAR_SESION");
		}
		
		if (iniciar != null) {
			iniciar.addActionListener(ctr);
			iniciar.setActionCommand("Iniciar");
		}
		
		if (registrarse != null) {
			registrarse.addActionListener(ctr);
			registrarse.setActionCommand("Registrarse");
		}
		
		if (editar != null) {
			editar.addActionListener(ctr);
			editar.setActionCommand("Editar");
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
		
		if (explorar != null) {
			explorar.addActionListener(ctr);
			explorar.setActionCommand("EXPLORAR");
		}
	}

}
