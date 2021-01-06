package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controlador.CtrMenu;
import Modelo.Actividad;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class DescripcionActividad extends JPanel {
	private JButton unirse = new JButton();

	/**
	 * Create the panel.
	 */
	public DescripcionActividad(Usuario user, Actividad actividad) {
		
		// TODO (Juanma) Hacer que aparezca la imagen normal y la por defecto.

		this.setBounds(0, 0, 1080, 650);
		setLayout(null);

		JLabel nombreActividad = new JLabel(actividad.getNombre());
		nombreActividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		nombreActividad.setBounds(460, 70, 269, 33);
		add(nombreActividad);

		JTextArea descripcionActividad = new JTextArea(actividad.getDescripcion());
		descripcionActividad.setEditable(false);
		JScrollPane jsp = new JScrollPane(descripcionActividad);
		jsp.setBounds(292, 131, 652, 371);
		add(jsp);
		
		unirse = new JButton("Unirse");
		unirse.setBounds(478, 511, 89, 23);
		unirse.setVisible(false);
		add(unirse);

		if (user == null) {

			CtrMenu menu = new CtrMenu(new Menu());
			add(menu.getPanel());
			
			if (actividad.quedanPlazas()) {
				unirse.setVisible(true);
			}

		}else{
			if(user instanceof Profesor) {
				CtrMenu menu = new CtrMenu(new Menu((Profesor)user));
				add(menu.getPanel());
			}else if (user instanceof Estudiante) {
				CtrMenu menu = new CtrMenu(new Menu((Estudiante)user));
				add(menu.getPanel());
			}else {
				CtrMenu menu = new CtrMenu(new Menu((Organizacion)user));
				add(menu.getPanel());
			}
			
			if (actividad.quedanPlazas() && ((user instanceof Estudiante && !((Estudiante) user).estaEnActividad(actividad)) || (user instanceof Profesor && !((Profesor) user).estaEnActividad(actividad)))) {
				unirse.setVisible(true);
			}
		}	
	}

	public void controlador(ActionListener ctr) {

		if (unirse != null) {
			unirse.addActionListener(ctr);
			unirse.setActionCommand("Unirse");
		}
	}

}
