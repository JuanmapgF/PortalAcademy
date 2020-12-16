package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Vista.*;

public class CtrAjustes implements ActionListener {
	
	private Ajustes ventana;
	
	public CtrAjustes(Ajustes v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("CERRAR")) {
			try {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (e.getActionCommand().equals("ELIMINAR")) {
			if (ventana.esEstudiante()) {
				ventana.getEstudiante().eliminarUsuario();
			} else if (ventana.esOrganizacion()) {
				ventana.getProfesor().eliminarUsuario();
			} else if (ventana.esProfesor()) {
				ventana.getOrganizacion().eliminarUsuario();
			}
			
			try {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(ventana, "Cuenta eliminada satisfactoriamente");
		}
		
		if (e.getActionCommand().equals("CAMBIAR")) {
			if (contrasenaValida()) {
				JOptionPane.showMessageDialog(ventana, "La contraseña se ha actualizado satisfactoriamente");
				if (ventana.esEstudiante()) {
					ventana.getEstudiante().setPassword(ventana.getTexto());
					try {
						CtrExplorar c = new CtrExplorar(new Explorar(ventana.getEstudiante(), Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
						Main.setPanel(c.getPanel());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (ventana.esOrganizacion()) {
					ventana.getOrganizacion().setPassword(ventana.getTexto());
					try {
						CtrExplorar c = new CtrExplorar(new Explorar(ventana.getOrganizacion(), Actividad.getTodasLasActividades()));
						Main.setPanel(c.getPanel());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (ventana.esProfesor()) {
					ventana.getProfesor().setPassword(ventana.getTexto());
					CtrExplorar c = new CtrExplorar(new Explorar(ventana.getProfesor(), Curso.getTodosLosCursos()));
					Main.setPanel(c.getPanel());
				}
				
				
			} else {
				JOptionPane.showMessageDialog(ventana, "La contraseña debe tener al menos 6 caracteres, contener al menos una mayúscula, una minúscula y un dígito");
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
			} else if (ventana.esOrganizacion()) {
				try {
					CtrExplorar c = new CtrExplorar(new Explorar(ventana.getOrganizacion(), Actividad.getTodasLasActividades()));
					Main.setPanel(c.getPanel());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (ventana.esProfesor()) {
				CtrExplorar c = new CtrExplorar(new Explorar(ventana.getProfesor(), Curso.getTodosLosCursos()));
				Main.setPanel(c.getPanel());
			} else {
				try {
					CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
					Main.setPanel(c.getPanel());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
			} else {
				CtrMisActividades c = new CtrMisActividades(new MisActividades(ventana.getOrganizacion()));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("AJUSTES")) {
			if (ventana.esEstudiante()) {
				CtrAjustes c = new CtrAjustes(new Ajustes(ventana.getEstudiante()));
				Main.setPanel(c.getPanel());
			} else if (ventana.esProfesor()) {
				CtrAjustes c = new CtrAjustes(new Ajustes(ventana.getProfesor()));
				Main.setPanel(c.getPanel());
			} else if (ventana.esOrganizacion()) {
				CtrAjustes c = new CtrAjustes(new Ajustes(ventana.getOrganizacion()));
				Main.setPanel(c.getPanel());
			}
		}
	}
	
	public JPanel getPanel() {
		return ventana;
	}
	
	private boolean contrasenaValida() {
		Pattern pattern = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{6,20}$");
		Matcher mather = pattern.matcher(new String(ventana.getTexto()));
		return mather.find();
	}

}
