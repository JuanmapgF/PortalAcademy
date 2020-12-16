package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import Modelo.Actividad;
import Modelo.Curso;
import Vista.AdminActividades;
import Vista.AdminCursos;
import Vista.AdminInicio;
import Vista.AdminUsuarios;
import Vista.Explorar;
import Vista.Main;

public class CtrAdminActividades implements ActionListener{
	
	private AdminActividades vista;

	public CtrAdminActividades(AdminActividades v) {
		vista = v;
		
		vista.bActividades_1.addActionListener(this);
		vista.bAjustes.addActionListener(this);
		vista.bCerrarSesion.addActionListener(this);
		vista.bCursos_1.addActionListener(this);
		vista.bInicio.addActionListener(this);
		vista.bUsuarios_1.addActionListener(this);
	}
	
	public AdminActividades getPanel() {
		return vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// pulsar en cualquiera de los dos botones de "ACTIVIDAD"
		if(e.getSource() == vista.bActividades_1 ) {
			CtrAdminActividades ctr = new CtrAdminActividades(new AdminActividades());
			Main.setPanel(ctr.getPanel());
		}
		
		//pulsar en el bot�n "AJUSTES"
		if(e.getSource() == vista.bAjustes ) {
			
		}
		
		//pulsar en el bot�n "CERRARSESION"
		if(e.getSource() == vista.bCerrarSesion ) {
			try {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//pulsar en el bot�n "CURSOS"
		if(e.getSource() == vista.bCursos_1) {
			CtrAdminCursos ctr = new CtrAdminCursos(new AdminCursos());
			Main.setPanel(ctr.getPanel());
		}
		
		//pulsar en el bot�n "INICIO"
		if(e.getSource() == vista.bInicio) {
			CtrAdminInicio ctr = new CtrAdminInicio(new AdminInicio());
			Main.setPanel(ctr.getPanel());
		}
		
		//pulsar en el bot�n "USUARIOS"
		if(e.getSource() == vista.bUsuarios_1) {
			CtrAdminUsuarios ctr = new CtrAdminUsuarios(new AdminUsuarios());
			Main.setPanel(ctr.getPanel());
		}
	}

	
}
