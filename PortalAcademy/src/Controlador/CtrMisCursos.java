package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import Modelo.BD;
import Modelo.Usuario;
import Vista.Inicio;
import Vista.Main;
import Vista.MisCursos;
import Vista.Registro;

public class CtrMisCursos implements ActionListener {
	
	private MisCursos ventana;
	
	public CtrMisCursos(MisCursos v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("MISCURSOSUSUARIO")) {
			CtrRegistro cr = new CtrRegistro(new Registro());
			Main.setPanel(cr.getPanel());
		}
		
		if (e.getActionCommand().equals("MISCURSOSPROFESOR")) {
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
					
					this.visible(false);
					CtrExplorar ex = new CtrExplorar(ini);
					ex.visible(true);
					
				} else if (Integer.parseInt(bd.SelectEscalar("SELECT COUNT(nick) FROM Organizacion WHERE nick = '" + u.getNick() + "'").toString()) == 1) {
										
				} else if (Integer.parseInt(bd.SelectEscalar("SELECT COUNT(nick) FROM Profesor WHERE nick = '" + u.getNick() + "'").toString()) == 1) {
					
				}
			}

		}
	}
	
	public JPanel getPanel() {
		return ventana;
	}
	
	public void visible(Boolean b) {
		ventana.setVisible(b);
	}
}
