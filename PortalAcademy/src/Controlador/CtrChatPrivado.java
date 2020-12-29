package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.MensajePrivado;
import Modelo.Usuario;
import Vista.ChatPrivado;
import Vista.Main;

public class CtrChatPrivado implements ActionListener {
	private Usuario user;
	private Usuario seleccionado;
	private ChatPrivado ventana;

	public CtrChatPrivado(Usuario user) {
		this.user = user;
		ventana = new ChatPrivado(user);
		ventana.controlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("VER_CHAT")) {
			seleccionado = ventana.getUsuarioSeleccionado();
			ventana = new ChatPrivado(user, seleccionado);
			ventana.controlador(this);
			
			Main.setPanel(ventana);
		}
		
		if (e.getActionCommand().equals("NUEVO_CHAT")) {
			String nick = ventana.getNuevoUsuario();
			try {
				if (!user.getNick().equals(nick)) {
					seleccionado = new Usuario(nick);
					ventana = new ChatPrivado(user, seleccionado);
					ventana.controlador(this);
					Main.setPanel(ventana);
				}
				
			} catch (Exception e1) {
				
			}
		}
		
		if (e.getActionCommand().equals("ENVIAR")) {
			String mensaje = ventana.getMensaje();
			
			if (mensaje.length() > 80) {
				JOptionPane.showMessageDialog(ventana, "El mensaje ha superado los 80 caracteres permitidos");
			} else if(mensaje.equals("")) {
				JOptionPane.showMessageDialog(ventana, "El mensaje debe tener algun caracter");
			} else {
				new MensajePrivado(ventana.getMensaje(), user, seleccionado);
			}
			seleccionado = ventana.getUsuarioSeleccionado();
			ventana = new ChatPrivado(user, seleccionado);
			ventana.controlador(this);
				
			Main.setPanel(ventana);
				
			
			// Si no se ha introducido nada no se hace nada (?)
			// TODO: Controlar limite de caracteres
			
		}
		
		if (e.getActionCommand().equals("REFRESCAR")) {
			seleccionado = ventana.getUsuarioSeleccionado();
			ventana = new ChatPrivado(user, seleccionado);
			ventana.controlador(this);
			
			Main.setPanel(ventana);
			
		}
	}
	

	public JPanel getPanel() {
		return ventana;
	}
}
