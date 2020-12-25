package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;
import Vista.ChatPrivado;
import Vista.Main;

public class CtrChatPrivado implements ActionListener {
	private Usuario user;
	private ChatPrivado ventana;

	public CtrChatPrivado(Usuario user) {
		this.user = user;
		ventana = new ChatPrivado(user);
		ventana.controlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("VER_CHAT")) {
			//CtrConversacion conversacion = new CtrConversacion(user, ventana.getUsuarioSeleccionado());
			//ventana.add(conversacion.getPanel());
		}
	}
	

	public JPanel getPanel() {
		return ventana;
	}
}
