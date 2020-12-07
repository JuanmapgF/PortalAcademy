package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.BD;

import Vista.adminInicio;

public class CtrAdminInicio implements ActionListener{

	private adminInicio vista;
	private BD bd;
	
	public CtrAdminInicio(adminInicio v) {
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
	
	public adminInicio getpanel() {
		return vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// pulsar en cualquiera de los dos botones de "ACTIVIDAD"
		if(e.getSource() == vista.bActividades || e.getSource() == vista.bActividades_1 ) {
			
			
		}
		
		//pulsar en el bot�n "AJUSTES"
		if(e.getSource() == vista.bAjustes ) {
			
		}
		
		//pulsar en el bot�n "CerrarSesion"
		if(e.getSource() == vista.bCerrarSesion ) {
			
		}
		
		if(e.getSource() == vista.bCursos )
		
		
		
	}

}
