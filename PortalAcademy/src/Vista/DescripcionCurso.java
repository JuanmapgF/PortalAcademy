package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controlador.CtrMenu;
import Modelo.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

@SuppressWarnings("serial")
public class DescripcionCurso extends JPanel {
	private JButton unirse;

	/**
	 * Create the panel.
	 */
	public DescripcionCurso(Usuario user, Curso curso) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);

		JLabel nombreCurso = new JLabel(curso.getNombre());
		nombreCurso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		nombreCurso.setBounds(460, 70, 269, 33);
		add(nombreCurso);

		JTextArea descripcionCurso = new JTextArea(curso.getDescripcion());
		descripcionCurso.setEditable(false);
		JScrollPane jsp = new JScrollPane(descripcionCurso);
		add(jsp);

		unirse = new JButton("Unirse");
		unirse.setBounds(478, 511, 89, 23);
		unirse.setVisible(false);
		add(unirse);

		File imagen = curso.getImagen();
		if (imagen == null) {
			jsp.setBounds(292, 131, 652, 371);
		} else {
			jsp.setBounds(470, 132, 471, 371);
		}
		JPanelImagen jpi = new JPanelImagen(imagen != null ? imagen.getName() : null);
		jpi.setBounds(202, 132, 250, 225);
		add(jpi);

		if (user == null) {
			CtrMenu menu = new CtrMenu(new Menu());
			add(menu.getPanel());

			if (curso.getPublico() && curso.quedanPlazas()) {
				unirse.setVisible(true);
			}

		} else {

			if (user instanceof Profesor) {
				CtrMenu menu = new CtrMenu(new Menu((Profesor) user));
				add(menu.getPanel());
			} else if (user instanceof Estudiante) {
				CtrMenu menu = new CtrMenu(new Menu((Estudiante) user));
				add(menu.getPanel());
			} else {
				CtrMenu menu = new CtrMenu(new Menu((Organizacion) user));
				add(menu.getPanel());
			}

			if (curso.quedanPlazas() && ((user instanceof Estudiante && !((Estudiante) user).estaEnCurso(curso))
					|| (user instanceof Profesor && !curso.getProfesor().equals(user)
							&& !((Profesor) user).estaEnCurso(curso)))) {
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
