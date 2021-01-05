package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controlador.CtrMenu;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Mensaje;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class InformacionCurso extends JPanel {
	private JList<String> listaMensajes;
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	
	private JButton editar;
	private JButton editarParticipantes;
	private JButton enviar;
	private JButton refrescar;

	private JTextField textField;
	private String mensajeEscrito;

	/**
	 * Create the panel.
	 *
	 */
	public InformacionCurso(Usuario user, Curso curso) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		listaMensajes = new JList<String>();
		
		JLabel nombreCurso = new JLabel(curso.getNombre());
		nombreCurso.setBounds(428, 34, 364, 33);
		nombreCurso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(nombreCurso);
		
		JTextArea descripcionCurso = new JTextArea(curso.getDescripcion());
		
		descripcionCurso.setEditable(false);
		JScrollPane jsp = new JScrollPane(descripcionCurso);
		jsp.setBounds(278, 102, 459, 102);
		add(jsp);
		
		//-----
		if (curso.getTieneForo()) {
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
			refrescar.setBounds(748, 274, 100, 23);
			add(refrescar);
			
			JLabel lblForo = new JLabel("Foro");
			lblForo.setBounds(278, 215, 46, 14);
			add(lblForo);
			
			listaMensajes.setModel(modelo);
			
			for (Mensaje mensaje : curso.getMensajes()) {
				if (mensaje.getEmisor() == null) {
					modelo.addElement("<INVITADO> : " + mensaje.getTexto());
				} else if (mensaje.getEmisor().equals(user)) {
					modelo.addElement("<TU> : " + mensaje.getTexto());
				} else if (mensaje.getEmisor().equals(curso.getProfesor())) {
					modelo.addElement("<PROFESOR> : " + mensaje.getTexto());
				} else {
					modelo.addElement("<" +mensaje.getEmisor().toString().toUpperCase() + "> : " + mensaje.getTexto());
				}
			}
		}
		
		if (user == null) {
			CtrMenu menu = new CtrMenu(new Menu());
			add(menu.getPanel());
		}  else if (user instanceof Profesor) {
			if(user.equals(curso.getProfesor())) {
				editar = new JButton("Editar Curso");
				editar.setBounds(752, 68, 119, 23);
				add(editar);
				
				editarParticipantes = new JButton("Editar Participantes");
				editarParticipantes.setBounds(752, 168, 149, 23);
				add(editarParticipantes);
			}
			CtrMenu menu = new CtrMenu(new Menu((Profesor)user));
			add(menu.getPanel());
		} else if(user instanceof Organizacion){
			CtrMenu menu = new CtrMenu(new Menu((Organizacion)user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante)user));
			add(menu.getPanel());
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
		
		if (editarParticipantes != null) {
			editarParticipantes.addActionListener(ctr);
			editarParticipantes.setActionCommand("EditarParticipantes");
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
