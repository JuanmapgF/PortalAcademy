package Vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.CtrMenu;
import Controlador.CtrMenuCurso;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class InformacionCursoCuestionarios extends JPanel {
	
	public JButton bInicio, bCuestionarios,bHacerCuestionario, bCrear, bBorrar;

	/**
	 * Create the panel.
	 */
	public InformacionCursoCuestionarios(Usuario user, Curso curso) {
		
//		CtrMenu menu_1 = new CtrMenu(new Menu((Profesor)user));
//		add(menu_1.getPanel());
		
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		JLabel labelTest = new JLabel("Test de conocimiento");
		labelTest.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
		labelTest.setBounds(429, 157, 202, 22);
		add(labelTest);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(429, 189, 616, 327);
		add(scrollPane);
		
		JLabel labelCuestionario = new JLabel("Cuestionario de satisfacci\u00F3n");
		labelCuestionario.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
		labelCuestionario.setBounds(429, 544, 264, 22);
		add(labelCuestionario);
		
		bHacerCuestionario = new JButton("Hacer");
		bHacerCuestionario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bHacerCuestionario.setBounds(747, 541, 79, 29);
		add(bHacerCuestionario);
		
		bCrear = new JButton("Crear");
		bCrear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bCrear.setBounds(968, 537, 75, 31);
		add(bCrear);
		bCrear.setVisible(false);
		
		bBorrar = new JButton("Borrar");
		bBorrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bBorrar.setBounds(1053, 537, 83, 31);
		add(bBorrar);
		bBorrar.setVisible(false);
		
		if(user instanceof Profesor) {
			CtrMenu menu = new CtrMenu(new Menu((Profesor)user));
			add(menu.getPanel());
			
			if(curso.getSatisfaccion()) {
				bBorrar.setVisible(true);
			}else {
				bCrear.setVisible(true);
			}
			
		}else if(user instanceof Organizacion){
			CtrMenu menu = new CtrMenu(new Menu((Organizacion)user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante)user));
			add(menu.getPanel());
		}
		CtrMenuCurso menuc = new CtrMenuCurso(new MenuCurso(curso));
		add(menuc.getPanel());
	}
}
