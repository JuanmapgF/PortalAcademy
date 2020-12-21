package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.*;
import Vista.*;

public class CtrDescripcionActividad implements ActionListener {
	private Usuario user;
	private Actividad actividad;
	private DescripcionActividad ventana;
	
	public CtrDescripcionActividad(Usuario user, Actividad actividad) {
		this.user = user;
		this.actividad = actividad;
		
		ventana = new DescripcionActividad(user, actividad);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Unirse")) {
			if(user == null) {
				CtrInformacionActividad c = new CtrInformacionActividad(null, actividad);
				JOptionPane.showMessageDialog(ventana, "Se ha unido a la actividad correctamente");
				Main.setPanel(c.getPanel());		
			} else {
				actividad.addParticipante(user);
				CtrInformacionActividad c = new CtrInformacionActividad(user, actividad);
				JOptionPane.showMessageDialog(ventana, "Se ha unido a la actividad correctamente");
				Main.setPanel(c.getPanel());
			}
			
			//TODO: Entramos en informacionActividad
		}
		if (e.getActionCommand().equals("CERRAR_SESION")) {
			CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
			Main.setPanel(c.getPanel());
			
		}
		
		if (e.getActionCommand().equals("EXPLORAR")) {
			if (user == null) {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} else if (user instanceof Estudiante) {
				CtrExplorar c = new CtrExplorar(new Explorar((Estudiante)user, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} else if (user instanceof Organizacion) {
				CtrExplorar c = new CtrExplorar(new Explorar((Organizacion)user, Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} else {
				CtrExplorar c = new CtrExplorar(new Explorar((Profesor)user, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("CURSO")) {
			if (user instanceof Estudiante) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos((Estudiante)user));
				Main.setPanel(c.getPanel());
			} else {
				CtrMisCursos c = new CtrMisCursos(new MisCursos((Profesor)user));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("ACTIVIDAD")) {
			if (user instanceof Estudiante) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades((Estudiante)user));
				Main.setPanel(c.getPanel());
			} else if (user instanceof Profesor) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades((Profesor)user));
				Main.setPanel(c.getPanel());
			} else {
				CtrMisActividades c = new CtrMisActividades(new MisActividades((Organizacion)user));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("AJUSTES")) {
			if (user instanceof Estudiante) {
				CtrAjustes c = new CtrAjustes(new Ajustes((Estudiante)user));
				Main.setPanel(c.getPanel());
			}else if (user instanceof Profesor) {
				CtrAjustes c = new CtrAjustes(new Ajustes((Profesor)user));
				Main.setPanel(c.getPanel());
			} else {
				CtrAjustes c = new CtrAjustes(new Ajustes((Organizacion)user));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("INICIAR_SESION")) {
			Inicio i = new Inicio();
			i.setFocusable(true);
		    i.requestFocusInWindow();
			CtrInicio2 c2 = new CtrInicio2(i);
			CtrInicio c = new CtrInicio(i);
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("REGISTRO")) {
			CtrRegistro c = new CtrRegistro(new Registro());
			Main.setPanel(c.getPanel());
		}
		
	}
	
	public JPanel getPanel() {
		return ventana;
	}

}
