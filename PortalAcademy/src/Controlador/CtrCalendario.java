package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Usuario;
import Vista.Calendario;
import Vista.Main;
import Vista.Menu;
import Vista.Registro;

public class CtrCalendario   implements ActionListener{
	private Calendario ventana;

	public CtrCalendario(Calendario v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("VER")) {
			if(ventana.getActividad() != null) {
				CtrDescripcionActividad c =  new CtrDescripcionActividad(null, ventana.getActividad()); 
				Main.setPanel(c.getPanel());
			}
			
		}
		
		if (e.getActionCommand().equals("ENTRAR")) {
			if(ventana.getActividad() != null) {
				if(ventana.esProfesor()) {
					CtrInformacionActividad c =  new CtrInformacionActividad(ventana.getProfesor(), ventana.getActividad()); 
					Main.setPanel(c.getPanel());
				}else if (ventana.esEstudiante()) {
					CtrInformacionActividad c =  new CtrInformacionActividad(ventana.getEstudiante(), ventana.getActividad()); 
					Main.setPanel(c.getPanel());
				}else {
					CtrInformacionActividad c =  new CtrInformacionActividad(ventana.getOrganizacion(), ventana.getActividad()); 
					Main.setPanel(c.getPanel());
				}
			}
		}
		
		if (e.getActionCommand().equals("ANADIR")) {
			if(ventana.getInfo() != "" && ventana.getFecha() != null) {
				if(ventana.esProfesor()) {
					ventana.getProfesor().addFecha(ventana.getFecha(),ventana.getInfo());
					JOptionPane.showMessageDialog(ventana, "Evento añadido satisfactoriamente.", "Evento añadido correcto",
							JOptionPane.INFORMATION_MESSAGE);
					CtrCalendario c = new CtrCalendario(new Calendario(ventana.getProfesor(),ventana.getFecha()));
					Main.setPanel(c.getPanel());
				}else if (ventana.esEstudiante()) {
					ventana.getEstudiante().addFecha(ventana.getFecha(),ventana.getInfo());
					JOptionPane.showMessageDialog(ventana, "Evento añadido satisfactoriamente.", "Evento añadido correcto",
							JOptionPane.INFORMATION_MESSAGE);
					CtrCalendario c = new CtrCalendario(new Calendario(ventana.getEstudiante(),ventana.getFecha()));
					Main.setPanel(c.getPanel());
				}else {
					ventana.getOrganizacion().addFecha(ventana.getFecha(),ventana.getInfo());
					JOptionPane.showMessageDialog(ventana, "Evento añadido satisfactoriamente.", "Evento añadido correcto",
							JOptionPane.INFORMATION_MESSAGE);
					CtrCalendario c = new CtrCalendario(new Calendario(ventana.getOrganizacion(),ventana.getFecha()));
					Main.setPanel(c.getPanel());
				}
				
			}
			
		}
		
	}
	
	public JPanel getPanel() {
		return ventana;
	}
}
