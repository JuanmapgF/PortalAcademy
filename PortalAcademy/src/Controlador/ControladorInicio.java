package Controlador;

import java.awt.event.*;
import java.util.List;

import Modelo.Usuario;
import Vista.*;

public class ControladorInicio implements ActionListener {
	
	private Inicio panel;
	
	public ControladorInicio(Inicio p) {
		panel = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("INICIAR")) {
			List<Usuario> users = Usuario.getUsuarios();
		}
	}

}
