package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.BD;
import Vista.Main;
import Vista.MainPrueba;
import Vista.AdminActividades;
import Vista.AdminInicio;

public class CtrAdminInicio implements ActionListener{

	private AdminInicio vista;
	private BD bd;
	
	public CtrAdminInicio(AdminInicio v) {
		vista = v;
		
		vista.bActividades.addActionListener(this);
		vista.bActividades_1.addActionListener(this);
		vista.bAjustes.addActionListener(this);
		vista.bCerrarSesion.addActionListener(this);
		vista.bCursos.addActionListener(this);
		vista.bCursos_1.addActionListener(this);
		vista.bInicio.addActionListener(this);
		vista.bUsuarios.addActionListener(this);
		vista.bUsuarios_1.addActionListener(this);
	}
	
	public AdminInicio getpanel() {
		return vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// pulsar en cualquiera de los dos botones de "ACTIVIDAD"
		if(e.getSource() == vista.bActividades || e.getSource() == vista.bActividades_1 ) {
			CtrAdminActividades ctr = new CtrAdminActividades(new AdminActividades());
			MainPrueba.setPanel(ctr.getPanel());
		}
		
		//pulsar en el botón "AJUSTES"
		if(e.getSource() == vista.bAjustes ) {
			
		}
		
		//pulsar en el botón "CERRARSESION"
		if(e.getSource() == vista.bCerrarSesion ) {

		}
		
		//pulsar en el botón "CURSOS"
		if(e.getSource() == vista.bCursos || e.getSource() == vista.bCursos_1) {
			
		}
		
		//pulsar en el botón "INICIO"
		if(e.getSource() == vista.bInicio) {
			
		}
		
		//pulsar en el botón "USUARIOS"
		if(e.getSource() == vista.bUsuarios || e.getSource() == vista.bUsuarios_1) {
			
		}
		
		
		
	}

}
