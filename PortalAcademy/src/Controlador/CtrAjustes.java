package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Vista.Ajustes;
import Vista.Explorar;
import Vista.Main;

public class CtrAjustes implements ActionListener {

	private Ajustes ventana;

	public CtrAjustes(Ajustes v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("ELIMINAR")) {
			
			
			if (JOptionPane.showConfirmDialog(ventana, "¿Está seguro de que desea eliminar su cuenta?", "Eliminar cuenta", JOptionPane.OK_CANCEL_OPTION) == 0) {
				
				if (ventana.esEstudiante()) {
					ventana.getEstudiante().eliminarUsuario();
				} else if (ventana.esOrganizacion()) {
					ventana.getOrganizacion().eliminarUsuario();
				} else if (ventana.esProfesor()) {
					ventana.getProfesor().eliminarUsuario();
				}

				CtrExplorar c = new CtrExplorar(
						new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());

				JOptionPane.showMessageDialog(ventana, "Cuenta eliminada satisfactoriamente");
			}
			
		}

		if (e.getActionCommand().equals("CAMBIAR")) {
			if (contrasenaValida()) {
				JOptionPane.showMessageDialog(ventana, "La contraseña se ha actualizado satisfactoriamente");
				if (ventana.esEstudiante()) {
					ventana.getEstudiante().setPassword(ventana.getTexto());
					CtrExplorar c = new CtrExplorar(new Explorar(ventana.getEstudiante(), Curso.getTodosLosCursos(),
							Actividad.getTodasLasActividades()));
					Main.setPanel(c.getPanel());
				} else if (ventana.esOrganizacion()) {
					ventana.getOrganizacion().setPassword(ventana.getTexto());
					CtrExplorar c = new CtrExplorar(new Explorar(ventana.getOrganizacion(), Curso.getTodosLosCursos(),
							Actividad.getTodasLasActividades()));
					Main.setPanel(c.getPanel());
				} else if (ventana.esProfesor()) {
					ventana.getProfesor().setPassword(ventana.getTexto());
					CtrExplorar c = new CtrExplorar(new Explorar(ventana.getProfesor(), Curso.getTodosLosCursos(),
							Actividad.getTodasLasActividades()));
					Main.setPanel(c.getPanel());
				}
			} else {
				JOptionPane.showMessageDialog(ventana,
						"La contraseña debe tener al menos 6 caracteres, contener al menos una mayúscula, una minúscula y un dígito");
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
