package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.MensajePrivado;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;
import Vista.ChatPrivado;
import Vista.Conversacion;
import Vista.Main;

public class CtrChatPrivado implements ActionListener {
	private Usuario user;
	private Usuario seleccionado;
	private ChatPrivado ventana;
	private Conversacion conversacion;

	public CtrChatPrivado(Usuario user) {
		this.user = user;
		ventana = new ChatPrivado(user);
		ventana.controlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("VER_CHAT")) {
			if (conversacion != null) {
				ventana.remove(conversacion);
			}
			seleccionado = ventana.getUsuarioSeleccionado();
			conversacion = new Conversacion(user, seleccionado);
			
			ventana.add(conversacion);
			conversacion.controlador(this);
			conversacion.revalidate();
			conversacion.repaint();
		}
		
		if (e.getActionCommand().equals("ENVIAR")) {
			ventana.remove(conversacion);
			new MensajePrivado(conversacion.getMensaje(), user, seleccionado);
			conversacion = new Conversacion(user, seleccionado);
			
			ventana.add(conversacion);
			conversacion.controlador(this);
			conversacion.revalidate();
			conversacion.repaint();
			
		}
		
		if (e.getActionCommand().equals("REFRESCAR")) {
			ventana.remove(conversacion);
			conversacion = new Conversacion(user, seleccionado);
			
			ventana.add(conversacion);
			conversacion.controlador(this);
			conversacion.revalidate();
			conversacion.repaint();
			
		}
	}
	

	public JPanel getPanel() {
		return ventana;
	}
}
