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
import javax.swing.JTextField;

import Modelo.Mensaje;
import Modelo.Usuario;

public class InformacionCurso extends JPanel {
	private JList<String> listaMensajes;
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	private JButton cerrarSesion;
	private JButton iniciar;
	private JButton registrarse;
	private JButton editar;
	private JButton enviar;
	private JButton refrescar;
	private JTextField textField;
	private String mensajeEscrito;

	/**
	 * Create the panel.
	 *
	 */
	public InformacionCurso(String nombre, String descripcion, Boolean tieneForo, List<Mensaje> mensajes, Boolean esProfesor, Usuario user) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
//		if (tieneForo) {
			//TODO: Foro
//		}
		
		listaMensajes = new JList<String>();
		
		JLabel nombreCurso = new JLabel(nombre);
		nombreCurso.setBounds(428, 34, 269, 33);
		add(nombreCurso);
		
		JTextArea descripcionCurso = new JTextArea(descripcion);
		descripcionCurso.setBounds(278, 102, 459, 102);
		add(descripcionCurso);
		
		//-----
		if (tieneForo) {
			JScrollPane foro = new JScrollPane();
			foro.setBounds(278, 234, 459, 268);
			foro.setViewportView(listaMensajes);
			add(foro);
			
			textField = new JTextField();
			textField.setBounds(278, 536, 459, 20);
			add(textField);
			textField.setColumns(10);
			
			enviar = new JButton("Enviar");
			enviar.setBounds(648, 513, 89, 23);
			add(enviar);
			
			refrescar = new JButton("Refrescar");
			refrescar.setBounds(748, 234, 89, 23);
			add(refrescar);
			
			JLabel lblForo = new JLabel("Foro");
			lblForo.setBounds(278, 215, 46, 14);
			add(lblForo);
			
			listaMensajes.setModel(modelo);
			
			for (Mensaje mensaje : mensajes) {
				if (mensaje.getEmisor().equals(user)) {
					modelo.addElement(new String("\t"+mensaje.getTexto()));
				} else {
					modelo.addElement(mensaje.getEmisor().toString().toUpperCase() + ":" + mensaje.getTexto());
				}
			}
		}
		
		
		
		//-----
		
		// ============== Cargar mensajes ===============
		
		
		
		// ==============================================
		
		if (esProfesor != null) {
			cerrarSesion = new JButton("Cerrar Sesi\u00F3n");
			cerrarSesion.setBounds(952, 39, 118, 23);
			add(cerrarSesion);
		}
		
		if (esProfesor != null && esProfesor) {
			editar = new JButton("Editar");
			editar.setBounds(752, 68, 89, 23);
			add(editar);
		}
		
		if (esProfesor == null) {
			iniciar = new JButton("Iniciar sesi\u00F3n");
			iniciar.setBounds(729, 37, 121, 23);
			add(iniciar);
			
			registrarse = new JButton("Registrarse");
			registrarse.setBounds(860, 37, 121, 23);
			add(registrarse);
		}
		
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
			cerrarSesion.setActionCommand("Cerrar Sesi\u00F3n");
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
	}
	
	public String mensajeAEnviar() {
		mensajeEscrito = textField.getText();
		return mensajeEscrito;
	}
}