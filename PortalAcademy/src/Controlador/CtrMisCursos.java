package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.BD;
import Modelo.Curso;
import Modelo.Usuario;
import Vista.Ajustes;
import Vista.Explorar;
import Vista.Inicio;
import Vista.Main;
import Vista.MisActividades;
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
		
		if (e.getActionCommand().equals("CERRAR_SESION")) {
			try {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (e.getActionCommand().equals("CREARCURSO")) {
			//
		}
		
		
		if (e.getActionCommand().equals("MISCURSOSUSUARIO")) {
			Curso c = ventana.getC();
			if(c!=null) {
				//CtrRegistro cr = new CtrRegistro(new Registro());
				//Main.setPanel(cr.getPanel());
			}	
		}
		
		if (e.getActionCommand().equals("MISCURSOSPROFESOR")) {
			Curso c = ventana.getC();
			if(c!=null) {
				//CtrRegistro cr = new CtrRegistro(new Registro());
				//Main.setPanel(cr.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("EXPLORAR")) {
			if (ventana.esEstudiante()) {
				try {
					CtrExplorar c = new CtrExplorar(new Explorar(ventana.getEstudiante(), Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
					Main.setPanel(c.getPanel());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				CtrExplorar c = new CtrExplorar(new Explorar(ventana.getProfesor(), Curso.getTodosLosCursos()));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("CURSO")) {
			if (ventana.esEstudiante()) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos(ventana.getEstudiante()));
				Main.setPanel(c.getPanel());
			} else {
				CtrMisCursos c = new CtrMisCursos(new MisCursos(ventana.getProfesor()));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("ACTIVIDAD")) {
			if (ventana.esEstudiante()) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades(ventana.getEstudiante()));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("AJUSTES")) {
			if (ventana.esEstudiante()) {
				CtrAjustes c = new CtrAjustes(new Ajustes(ventana.getEstudiante()));
				Main.setPanel(c.getPanel());
			} else {
				CtrAjustes c = new CtrAjustes(new Ajustes(ventana.getProfesor()));
				Main.setPanel(c.getPanel());
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
