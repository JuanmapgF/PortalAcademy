package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.*;
import Vista.*;

public class CtrEditarActividad implements ActionListener {
	
	private EditarActividad ventana;
	private Organizacion organizacion;
	private Actividad actividad;
	
	public CtrEditarActividad(EditarActividad v) {
		ventana = v;
		organizacion = ventana.getUsuario();
		actividad = ventana.getC();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("GUARDAR")) {
			if (ventana.getAforo() > 0) {
				actividad.setAforo(ventana.getAforo());
				actividad.setDescripcion(ventana.getDescripcion());
				actividad.setNombre(ventana.getNombre());
				
				JOptionPane.showMessageDialog(ventana, "Se ha actualizado la información del curso correctamente");
				
				CtrInformacionActividad c = new CtrInformacionActividad(organizacion, actividad);
				Main.setPanel(c.getPanel());
			} else {
				JOptionPane.showMessageDialog(ventana, "El aforo debe ser un entero positivo");
			}
		}
		
		if (e.getActionCommand().equals("ELIMINAR")) {
			actividad.eliminarCurso();
			CtrMisActividades c = new CtrMisActividades(new MisActividades(organizacion));
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("VOLVER")) {
			int res = JOptionPane.showConfirmDialog(ventana, "¿Salir sin guardar?");
			
			if (res == 0) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades(organizacion));
				Main.setPanel(c.getPanel());
			}
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

		if (e.getActionCommand().equals("EXPLORAR")) {
			CtrExplorar c;
			try {
				c = new CtrExplorar(new Explorar(organizacion, Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (e.getActionCommand().equals("ACTIVIDADES")) {
			CtrMisActividades c = new CtrMisActividades(new MisActividades(organizacion));
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("AJUSTES")) {
			CtrAjustes c = new CtrAjustes(new Ajustes(organizacion));
			Main.setPanel(c.getPanel());
		}
	}
	
	public JPanel getPanel() {
		return ventana;
	}

}
