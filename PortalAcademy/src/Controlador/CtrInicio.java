package Controlador;

import java.awt.event.*;
import java.text.ParseException;
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
					
					Estudiante est = null;
					try {
						est = new Estudiante(ini.getNick());
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					try {
						CtrExplorar ex = new CtrExplorar(new Explorar(est, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()), new Menu(est));
						Main.setPanel(ex.getPanel());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} else if (Integer.parseInt(bd.SelectEscalar("SELECT COUNT(nick) FROM Organizacion WHERE nick = '" + u.getNick() + "'").toString()) == 1) {
					bd.finalize();
					
					Organizacion est = new Organizacion(ini.getNick());
					
					try {
						CtrExplorar ex = new CtrExplorar(new Explorar(est, Actividad.getTodasLasActividades()), new Menu(est));
						Main.setPanel(ex.getPanel());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (Integer.parseInt(bd.SelectEscalar("SELECT COUNT(nick) FROM Profesor WHERE nick = '" + u.getNick() + "'").toString()) == 1) {
					bd.finalize();
					
					Profesor est = new Profesor(ini.getNick());
					CtrExplorar ex = new CtrExplorar(new Explorar(est, Curso.getTodosLosCursos()), new Menu(est));
					Main.setPanel(ex.getPanel());
				}
			}

		}
	}
	
	public JPanel getPanel() {
		return ventana;
	}
}
