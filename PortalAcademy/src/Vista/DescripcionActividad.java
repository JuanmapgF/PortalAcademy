package Vista;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
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

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		JLabel nombreActividad = new JLabel(actividad.getNombre());
		nombreActividad.setFont(new Font("Tahoma", Font.PLAIN, 40));
		nombreActividad.setBounds(596, 79, 756, 51);
		add(nombreActividad);

		JTextArea descripcionActividad = new JTextArea(actividad.getDescripcion());
		descripcionActividad.setEditable(false);
		JScrollPane jsp = new JScrollPane(descripcionActividad);
		jsp.setBounds(750, 300, 652, 371);
		add(jsp);
		
		unirse = new JButton(new ImageIcon(getClass().getResource("/img/unirse.png")));
		unirse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		unirse.setContentAreaFilled(false);
		unirse.setFocusPainted(false);
		unirse.setBorderPainted(false);
		unirse.setBounds(750, 702, 180, 60);
		unirse.setVisible(false);
		add(unirse);

		File imagen = actividad.getImagen();
		
		JPanelImagen jpi;
		if(imagen!=null) {
			jpi = new JPanelImagen(imagen.getName());
		}else{
			jpi = new JPanelImagen(getClass().getResource("/img/actividad_default.png"));
		}
		jpi.setBounds(449, 300, 250, 225);
		add(jpi);
		
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
