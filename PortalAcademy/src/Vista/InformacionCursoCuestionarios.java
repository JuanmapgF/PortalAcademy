package Vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.CtrMenu;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

public class InformacionCursoCuestionarios extends JPanel {

	/**
	 * Create the panel.
	 */
	public InformacionCursoCuestionarios(Usuario user, Curso curso) {
		
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		JButton bInicio = new JButton("Inicio");
		bInicio.setVerticalAlignment(SwingConstants.TOP);
		bInicio.setForeground(new Color(0, 0, 255));
		bInicio.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		bInicio.setBounds(429, 102, 77, 29);
		add(bInicio);
		
		JButton bCuestionarios = new JButton("Cuestionarios");
		bCuestionarios.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		bCuestionarios.setBounds(516, 102, 143, 29);
		add(bCuestionarios);
		
		if(user instanceof Profesor) {
			CtrMenu menu = new CtrMenu(new Menu((Profesor)user));
			add(menu.getPanel());
		}else if(user instanceof Organizacion){
			CtrMenu menu = new CtrMenu(new Menu((Organizacion)user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante)user));
			add(menu.getPanel());
		}
		
	}

}
