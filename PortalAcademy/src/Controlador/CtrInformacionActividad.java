package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JPanel;

import Modelo.*;
import Vista.*;

public class CtrInformacionActividad implements ActionListener {
	private Usuario user;
	private Actividad actividad;
	
	private InformacionActividad ventana;
	
	public CtrInformacionActividad(Usuario user, Actividad actividad) {
		this.user = user;
		this.actividad = actividad;
		Boolean esOrganizacion;
		if (user == null) {
			esOrganizacion = null;
		} else if (user instanceof Organizacion) {
			esOrganizacion = true;
		} else {
			esOrganizacion = false;
		}
		ventana = new InformacionActividad(actividad.getNombre(), actividad.getDescripcion(), esOrganizacion);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Cerrar Sesi\\u00F3n")) {
			try {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (e.getActionCommand().equals("Iniciar")) {
			Inicio i = new Inicio();
			i.setFocusable(true);
		    i.requestFocusInWindow();
			CtrInicio c = new CtrInicio(i);
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("Registrarse")) {
			CtrRegistro c = new CtrRegistro(new Registro());
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("Editar")) {
			// TODO: Accede a la vista de editar Curso
		}
	}
	
	public JPanel getPanel() {
		return ventana;
	}

}
