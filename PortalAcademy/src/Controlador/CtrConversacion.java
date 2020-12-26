package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.Usuario;
import Vista.Conversacion;

public class CtrConversacion implements ActionListener {
	private Usuario user;
	private Usuario seleccionado;
	private Conversacion ventana;
	
	
	public CtrConversacion(Usuario user, Usuario seleccionado) {
		this.user = user;
		this.seleccionado = seleccionado;
		ventana = new Conversacion(user, seleccionado);
		ventana.controlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public JPanel getPanel() {
		return ventana;
	}
	
}
