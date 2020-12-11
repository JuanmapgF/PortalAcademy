package Controlador;

import java.awt.event.*;
import java.util.List;

import javax.swing.JPanel;

import Vista.*;
import Modelo.*;

public class CtrInicio implements ActionListener {
	
	private Inicio ventana;
	
	public CtrInicio(Inicio v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("REGISTRATE")) {
			CtrRegistro cr = new CtrRegistro(new Registro());
			Main.setPanel(cr.getPanel());
		}
		
		if (e.getActionCommand().equals("INICIAR")) {
			Usuario u = new Usuario(ventana.getUser(), ventana.getPass());
			List<Usuario> users = Usuario.getUsuarios();
			
			if (users.contains(u)) {
				Usuario ini = new Usuario(u.getNick());
				
				BD bd = BD.getBD();
				
				if (Integer.parseInt(bd.SelectEscalar("SELECT COUNT(nick) FROM Estudiante WHERE nick = '" + u.getNick() + "'").toString()) == 1) {
					bd.finalize();
					
				} else if (Integer.parseInt(bd.SelectEscalar("SELECT COUNT(nick) FROM Organizacion WHERE nick = '" + u.getNick() + "'").toString()) == 1) {
										
				} else if (Integer.parseInt(bd.SelectEscalar("SELECT COUNT(nick) FROM Profesor WHERE nick = '" + u.getNick() + "'").toString()) == 1) {
					
				}
			}

		}
	}
	
	public JPanel getPanel() {
		return ventana;
	}
}
