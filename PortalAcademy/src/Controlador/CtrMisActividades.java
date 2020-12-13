package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Vista.MisActividades;
import Vista.MisCursos;

public class CtrMisActividades implements ActionListener {

	private MisActividades ventana;
	
	public CtrMisActividades(MisActividades v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("MISACTIVIDADESUSUARIO")) {
			Actividad c = ventana.getA();
			if(c!=null) {
				//CtrRegistro cr = new CtrRegistro(new Registro());
				//Main.setPanel(cr.getPanel());
			}	
		}
		
		if (e.getActionCommand().equals("MISACTIVIDADESORGANIZACION")) {
			Actividad c = ventana.getA();
			if(c!=null) {
				//CtrRegistro cr = new CtrRegistro(new Registro());
				//Main.setPanel(cr.getPanel());
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
