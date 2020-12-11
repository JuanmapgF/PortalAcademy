package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Vista.AdminActividades;
import Vista.AdminCursos;

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

	public AdminActividades getPanel() {
		// TODO Auto-generated method stub
		return vista;
	}
}
