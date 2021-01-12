package Vista;

import java.awt.Cursor;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Controlador.CtrMenu;
import Controlador.CtrMenuCurso;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Mensaje;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class InformacionCursoForo extends JPanel {
	private JList<String> listaMensajes;
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	
	private JButton enviar;
	private JButton refrescar;

	private JTextField textField;
	
	/**
	 * Create the panel.
	 */
	public InformacionCursoForo(Usuario user, Curso curso) {
		
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		listaMensajes = new JList();
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
		
		JScrollPane foro = new JScrollPane();
		foro.setBounds(602, 454, 459, 268);
		foro.setViewportView(listaMensajes);
		add(foro);
		
		textField = new JTextField();
		textField.setBounds(602, 733, 459, 20);
		add(textField);
		textField.setColumns(10);
		
		enviar = new JButton(new ImageIcon (getClass().getResource("/img/enviar.png")));
		enviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		enviar.setContentAreaFilled(false);
		enviar.setFocusPainted(false);
		enviar.setBorderPainted(false);
		enviar.setBounds(1071, 714, 73, 59);
		add(enviar);
		
		refrescar = new JButton(new ImageIcon (getClass().getResource("/img/refrescar.png")));
		refrescar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		refrescar.setContentAreaFilled(false);
		refrescar.setFocusPainted(false);
		refrescar.setBorderPainted(false);
		refrescar.setBounds(1071, 454, 57, 59);
		add(refrescar);
		
		
		
		if (user == null) {
			CtrMenu menu = new CtrMenu(new Menu(curso));
			add(menu.getPanel());
		}  else if (user instanceof Profesor) {
			CtrMenu menu = new CtrMenu(new Menu((Profesor)user, curso));
			add(menu.getPanel());
		} else if(user instanceof Organizacion){
			CtrMenu menu = new CtrMenu(new Menu((Organizacion)user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante)user, curso));
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
	}
	
	public String mensajeAEnviar() {
		return textField.getText();
	}

}
