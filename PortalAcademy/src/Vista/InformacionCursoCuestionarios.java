package Vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controlador.CtrMenu;
import Controlador.CtrMenuCurso;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class InformacionCursoCuestionarios extends JPanel {
	
	public JButton bHacerCuestionario, bCrear, bBorrar,bCrearTest, bHacerTest;
	
	private Curso curso;

	
	/**
	 * Create the panel.
	 */
	public InformacionCursoCuestionarios(Usuario user, Curso curso) {
		
		this.curso = curso;
		
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		JLabel labelTest = new JLabel("Test de conocimiento");
		labelTest.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
		labelTest.setBounds(647, 389, 202, 22);
		add(labelTest);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(647, 421, 616, 327);
		add(scrollPane);
		
		JLabel labelCuestionario = new JLabel("Cuestionario de satisfacci\u00F3n");
		labelCuestionario.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
		labelCuestionario.setBounds(647, 776, 264, 22);
		add(labelCuestionario);
		
		bHacerCuestionario = new JButton("Hacer");
		bHacerCuestionario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bHacerCuestionario.setBounds(965, 773, 79, 29);
		add(bHacerCuestionario);
		
		bCrear = new JButton("Crear");
		bCrear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bCrear.setBounds(1186, 769, 75, 31);
		add(bCrear);
		bCrear.setVisible(false);
		
		bBorrar = new JButton("Borrar");
		bBorrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bBorrar.setBounds(1271, 769, 83, 31);
		add(bBorrar);
		bBorrar.setVisible(false);
		
		bCrearTest = new JButton("Crear test");
		bCrearTest.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bCrearTest.setBounds(1152, 382, 111, 31);
		add(bCrearTest);
		bCrearTest.setVisible(false);
		
		bHacerTest = new JButton("Hacer test");
		bHacerTest.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bHacerTest.setBounds(1273, 421, 115, 31);
		add(bHacerTest);
		
		if (esCreador()) {
			bCrearTest.setVisible(true);
			if(curso.getSatisfaccion()) {
				bBorrar.setVisible(true);
			}else {
				bCrear.setVisible(true);
			}
		}
		
		if(user instanceof Profesor) {
			CtrMenu menu = new CtrMenu(new Menu((Profesor)user, curso));
			add(menu.getPanel());
		}else if(user instanceof Organizacion){
			CtrMenu menu = new CtrMenu(new Menu((Organizacion)user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante)user, curso));
			add(menu.getPanel());
		}
		
	}
	
	private boolean esCreador() {
		if (Main.getUser() == null) {
			return false;
		}
		return Main.getUser().equals(curso.getProfesor());
	}
}
