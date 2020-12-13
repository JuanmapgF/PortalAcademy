package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JPanel;

import Modelo.*;
import Vista.*;

public class CtrExplorar implements ActionListener {
	
	private Explorar ventana;
	
	public CtrExplorar(Explorar v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("INICIAR_SESION")) {
			CtrInicio c = new CtrInicio(new Inicio());
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("CERRAR_SESION")) {
			try {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (e.getActionCommand().equals("REGISTRO")) {
			CtrRegistro c = new CtrRegistro(new Registro());
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("VER_CURSO")) {
			Curso cur = ventana.getCurso();
			Usuario user = ventana.getUsuario();
			if (cur != null) {
				CtrDescripcionCurso c = new CtrDescripcionCurso(user, cur);
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("VER_ACTIVIDAD")) {
			Actividad act = ventana.getActividad();
			Usuario user = ventana.getUsuario();
			if (act != null) {
				CtrDescripcionActividad c = new CtrDescripcionActividad(user, act);
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("EXPLORAR")) {
			
		}
		
		if (e.getActionCommand().equals("CURSO")) {
			
		}
		
		if (e.getActionCommand().equals("ACTIVIDAD")) {
			
		}
		
		if (e.getActionCommand().equals("AJUSTES")) {
			
		}
	}
	
	public JPanel getPanel() {
		return ventana;
	}

}
