package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import Modelo.Actividad;
import Modelo.Curso;
import Vista.AdminUsuarios;
import Vista.Explorar;
import Vista.Main;
import Vista.MainPrueba;
import Vista.AdminActividades;
import Vista.AdminCursos;
import Vista.AdminInicio;

public class CtrAdminUsuarios implements ActionListener{

	private AdminUsuarios vista;
	
	public CtrAdminUsuarios(AdminUsuarios v) {
		vista = v;
		vista.bActividades_1.addActionListener(this);
		vista.bAjustes.addActionListener(this);
		vista.bCerrarSesion.addActionListener(this);
		vista.bCursos_1.addActionListener(this);
		vista.bInicio.addActionListener(this);
		vista.bUsuarios_1.addActionListener(this);
	}
	
	public AdminUsuarios getPanel() {
		return vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// pulsar en cualquiera de los dos botones de "ACTIVIDAD"
		if(e.getSource() == vista.bActividades_1 ) {
			CtrAdminActividades ctr = new CtrAdminActividades(new AdminActividades());
			MainPrueba.setPanel(ctr.getPanel());
		}
		
		//pulsar en el botón "AJUSTES"
		if(e.getSource() == vista.bAjustes ) {
			
		}
		
		//pulsar en el botón "CERRARSESION"
		if(e.getSource() == vista.bCerrarSesion ) {
			try {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//pulsar en el botón "CURSOS"
		if(e.getSource() == vista.bCursos_1) {
			CtrAdminCursos ctr = new CtrAdminCursos(new AdminCursos());
			MainPrueba.setPanel(ctr.getPanel());
		}
		
		//pulsar en el botón "INICIO"
		if(e.getSource() == vista.bInicio) {
			CtrAdminInicio ctr = new CtrAdminInicio(new AdminInicio());
			MainPrueba.setPanel(ctr.getPanel());
		}
		
		//pulsar en el botón "USUARIOS"
		if(e.getSource() == vista.bUsuarios_1) {
			//no se hace nada que nos mantenemos en la vista actual
		}
	}

}
