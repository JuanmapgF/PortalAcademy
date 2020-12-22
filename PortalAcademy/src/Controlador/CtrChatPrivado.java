package Controlador;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Usuario;
import Vista.ChatPrivado;
import Vista.Main;

public class CtrChatPrivado {
	private Usuario user;
	private JPanel ventana;

	public CtrChatPrivado(Usuario user) {
		this.user = user;
		ventana = new ChatPrivado(user);
//		ventana.controlador(this);
	}
	

	public JPanel getPanel() {
		return ventana;
	}
}
