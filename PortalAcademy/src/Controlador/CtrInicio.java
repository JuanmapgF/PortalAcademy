package Controlador;

import java.awt.event.*;
import java.util.List;

import Vista.*;
import Modelo.*;

public class CtrInicio implements ActionListener {
	
	private InicioSesion ventana;
	
	public CtrInicio(InicioSesion v) {
		ventana = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("INICIAR")) {
			Usuario u = new Usuario(ventana.getUser(), ventana.getPass());
			List<Usuario> users = Usuario.getUsuarios();
			
			if (users.contains(u)) {
				Usuario ini = new Usuario(u.getNick());
				
				BD bd = BD.getBD();
				
				if (Integer.parseInt(bd.SelectEscalar("SELECT COUNT(nick) FROM Estudiante WHERE nick = '" + u.getNick() + "'").toString()) == 1) {
					bd.finalize();
					
					this.visible(false);
					CtrExplorar ex = new CtrExplorar();
					ex.visible(true);
					
				} else if (Integer.parseInt(bd.SelectEscalar("SELECT COUNT(nick) FROM Organizacion WHERE nick = '" + u.getNick() + "'").toString()) == 1) {
										
				} else if (Integer.parseInt(bd.SelectEscalar("SELECT COUNT(nick) FROM Profesor WHERE nick = '" + u.getNick() + "'").toString()) == 1) {
					
				}
			}

		}
	}
	
	public void visible(Boolean b) {
		ventana.setVisible(b);
	}
}
