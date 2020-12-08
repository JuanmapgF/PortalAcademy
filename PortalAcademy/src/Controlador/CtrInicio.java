package Controlador;

import java.awt.event.*;
import java.text.ParseException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.BD;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;
import Vista.*;

public class CtrInicio implements ActionListener {
	
	private Inicio panel;
	private JFrame ventana;
	
	public CtrInicio(Inicio p) {
		panel = p;
		ventana.add(panel);
	}

	public Inicio getPanel() {
		return panel;
	}

	public void setPanel(Inicio panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("INICIAR")) {
			System.out.println(12);
			String user = panel.getUser() + panel.getPass();
			System.out.println(user);
			Usuario u = new Usuario(panel.getUser(), panel.getPass());
			List<Usuario> users = Usuario.getUsuarios();
			
			if (users.contains(u)) {
				Usuario ini = new Usuario(u.getNick());
				
				BD bd = BD.getBD();
				
				if (Integer.parseInt(bd.SelectEscalar("SELECT COUNT(nick) FROM Estudiante WHERE nick = '" + u.getNick() + "'").toString()) == 1) {
					bd.finalize();
					Menu m = new Menu(ini);
					Explorar ex = null;
					try {
						ex = new Explorar(ini, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JPanel contentPane = new JPanel();
					contentPane.setBounds(0, 0, 1080, 650);
					contentPane.add(m);
					contentPane.add(ex);
					
					Prueba.changeWindow(contentPane);
				} else if (Integer.parseInt(bd.SelectEscalar("SELECT COUNT(nick) FROM Organizacion WHERE nick = '" + u.getNick() + "'").toString()) == 1) {
					bd.finalize();
					Menu m = new Menu(ini);
					Explorar ex = null;
					try {
						ex = new Explorar(new Organizacion(ini.getNick()), Actividad.getTodasLasActividades());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JPanel contentPane = new JPanel();
					contentPane.setBounds(0, 0, 1080, 650);
					contentPane.add(m);
					contentPane.add(ex);
					
					Prueba.changeWindow(contentPane);
					
					
				} else if (Integer.parseInt(bd.SelectEscalar("SELECT COUNT(nick) FROM Profesor WHERE nick = '" + u.getNick() + "'").toString()) == 1) {
					bd.finalize();
					Menu m = new Menu(ini);
					Explorar ex = new Explorar(new Profesor(ini.getNick()), Curso.getTodosLosCursos());
					
					JPanel contentPane = new JPanel();
					contentPane.setBounds(0, 0, 1080, 650);
					contentPane.add(m);
					contentPane.add(ex);
					
					Prueba.changeWindow(contentPane);
					
				}
				
				
			}
		}
	}

	public JFrame getVentana() {
		return ventana;
	}

	public void setVentana(JFrame ventana) {
		this.ventana = ventana;
	}

}
