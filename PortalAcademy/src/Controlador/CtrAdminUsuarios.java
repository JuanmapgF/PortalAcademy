package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.AdminUsuarios;
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
	
	public AdminUsuarios getpanel() {
		return vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// pulsar en cualquiera de los dos botones de "ACTIVIDAD"
		if(e.getSource() == vista.bActividades_1 ) {
			
		}
		
		//pulsar en el bot�n "AJUSTES"
		if(e.getSource() == vista.bAjustes ) {
			
		}
		
		//pulsar en el bot�n "CERRARSESION"
		if(e.getSource() == vista.bCerrarSesion ) {

		}
		
		//pulsar en el bot�n "CURSOS"
		if(e.getSource() == vista.bCursos_1) {
			
		}
		
		//pulsar en el bot�n "INICIO"
		if(e.getSource() == vista.bInicio) {
			
		}
		
		//pulsar en el bot�n "USUARIOS"
		if(e.getSource() == vista.bUsuarios_1) {
			
		}
	}

}
