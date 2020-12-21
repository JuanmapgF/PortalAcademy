package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controlador.CtrMenu;
import Modelo.*;

@SuppressWarnings("serial")
public class DescripcionActividad extends JPanel {
	private JButton unirse;

	/**
	 * Create the panel.
	 */
	public DescripcionActividad(Usuario user, Actividad actividad) {

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
		
		

		if (user == null) {

			CtrMenu menu = new CtrMenu(new Menu());
			add(menu.getPanel());
			
			if (actividad.quedanPlazas()) {
				unirse = new JButton("Unirse");
				unirse.setBounds(478, 511, 89, 23);
				add(unirse);
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
			
			if (actividad.quedanPlazas() && (!((Estudiante) user).estaEnActividad(actividad) || !((Profesor) user).estaEnActividad(actividad))) {
				unirse = new JButton("Unirse");
				unirse.setBounds(478, 511, 89, 23);
				add(unirse);
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
