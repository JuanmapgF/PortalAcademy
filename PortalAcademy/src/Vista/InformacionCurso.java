package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controlador.CtrMenu;
import Controlador.CtrMenuCurso;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class InformacionCurso extends JPanel {
	
	

	/**
	 * Create the panel.
	 *
	 */
	public InformacionCurso(Usuario user, Curso curso) {
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		
		JLabel nombreCurso = new JLabel(curso.getNombre());
		nombreCurso.setBounds(429, 189, 364, 33);
		nombreCurso.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(nombreCurso);
		
		
		
		JTextArea descripcionCurso = new JTextArea(curso.getDescripcion());
		
		descripcionCurso.setEditable(false);
		JScrollPane jsp = new JScrollPane(descripcionCurso);
		jsp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jsp.setBounds(429, 450, 777, 345);
		add(jsp);
		
		
		
		if (user == null) {
			CtrMenu menu = new CtrMenu(new Menu(curso));
			add(menu.getPanel());
		}  else if (user instanceof Profesor) {
			CtrMenu menu = new CtrMenu(new Menu((Profesor)user, curso));
			add(menu.getPanel());
		} else if(user instanceof Organizacion){
			CtrMenu menu = new CtrMenu(new Menu((Organizacion)user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante)user, curso));
			add(menu.getPanel());
		}
		
	}
	
	
}
