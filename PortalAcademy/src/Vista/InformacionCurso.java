package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Modelo.*;

@SuppressWarnings("serial")
public class InformacionCurso extends JPanel {
	private JList<String> listaMensajes;
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	private JButton cerrarSesion;
	private JButton iniciar;
	private JButton registrarse;
	private JButton editar;
	private JButton enviar;
	private JButton refrescar;
	private JButton cursos;
	private JButton actividades;
	private JButton ajustes;
	private JButton explorar;
	private JTextField textField;
	private String mensajeEscrito;

	/**
	 * Create the panel.
	 *
	 */
	public InformacionCurso(String nombre, String descripcion, Boolean tieneForo, List<Mensaje> mensajes, Usuario user) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		listaMensajes = new JList<String>();
		
		JLabel nombreCurso = new JLabel(nombre);
		nombreCurso.setBounds(428, 34, 364, 33);
		nombreCurso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(nombreCurso);
		
		JTextArea descripcionCurso = new JTextArea(descripcion);
		descripcionCurso.setBounds(278, 102, 459, 102);
		add(descripcionCurso);
		descripcionCurso.setEditable(false);
		
		//-----
		if (tieneForo) {
			JScrollPane foro = new JScrollPane();
			foro.setBounds(278, 234, 459, 268);
			foro.setViewportView(listaMensajes);
			add(foro);
			
			textField = new JTextField();
			textField.setBounds(278, 513, 459, 20);
			add(textField);
			textField.setColumns(10);
			
			enviar = new JButton("Enviar");
			enviar.setBounds(748, 513, 89, 23);
			add(enviar);
			
			refrescar = new JButton("Refrescar");
			refrescar.setBounds(748, 234, 100, 23);
			add(refrescar);
			
			JLabel lblForo = new JLabel("Foro");
			lblForo.setBounds(278, 215, 46, 14);
			add(lblForo);
			
			listaMensajes.setModel(modelo);
			
			for (Mensaje mensaje : mensajes) {
				if (mensaje.getEmisor() == null) {
					modelo.addElement("<INVITADO> : " + mensaje.getTexto());
				} else if (mensaje.getEmisor().equals(user)) {
					modelo.addElement("<TU> : " + mensaje.getTexto());
				} else if (mensaje.getEmisor() instanceof Profesor) {
					modelo.addElement("<PROFESOR> : " + mensaje.getTexto());
				} else {
					modelo.addElement("<" +mensaje.getEmisor().toString().toUpperCase() + "> : " + mensaje.getTexto());
				}
			}
		}
		
		
		
		
		if (user == null) {
			iniciar = new JButton("Iniciar sesi\u00F3n");
			iniciar.setBounds(729, 37, 121, 23);
			add(iniciar);
				
			registrarse = new JButton("Registrarse");
			registrarse.setBounds(860, 37, 121, 23);
			add(registrarse);
		} else if (user instanceof Estudiante) {
			cursos = new JButton("Mis cursos");
			cursos.setBounds(36, 261, 131, 32);
			add(cursos);
			
			actividades = new JButton("Mis actividades");
			actividades.setBounds(36, 336, 131, 32);
			add(actividades);
			
			ajustes = new JButton("Ajustes");
			ajustes.setBounds(36, 413, 131, 32);
			add(ajustes);
			
			cerrarSesion = new JButton("Cerrar sesi\u00F3n");
			cerrarSesion.setBounds(860, 37, 121, 23);

			add(cerrarSesion);
		} else if (user instanceof Profesor) {
			cursos = new JButton("Mis cursos");
			cursos.setBounds(36, 261, 131, 32);
			add(cursos);
			
			editar = new JButton("Editar");
			editar.setBounds(752, 68, 89, 23);
			add(editar);
			
			cerrarSesion = new JButton("Cerrar sesi\u00F3n");
			cerrarSesion.setBounds(860, 37, 121, 23);

			add(cerrarSesion);
			
			ajustes = new JButton("Ajustes");
			ajustes.setBounds(36, 336, 131, 32);
			add(ajustes);
		}
		
		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);
		
	}

	
	public void controlador(ActionListener ctr) {
		
		if (enviar != null) {
			enviar.addActionListener(ctr);
			enviar.setActionCommand("Enviar");
		}
		
		if (refrescar != null) {
			refrescar.addActionListener(ctr);
			refrescar.setActionCommand("Refrescar");
		}
		
		
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
	
	public String mensajeAEnviar() {
		mensajeEscrito = textField.getText();
		return mensajeEscrito;
	}
}
