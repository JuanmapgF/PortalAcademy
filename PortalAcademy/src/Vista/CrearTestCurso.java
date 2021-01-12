package Vista;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.CtrMenu;
import Controlador.CtrMenuCurso;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class CrearTestCurso extends JPanel {

	public JTextField tfNombre;

	public JTextField tfDescripccion;

	public JTextField tfLink;
	
	private Usuario user;
	private Curso curso;
	private JButton volver;
	private JButton bGuardar;
	/**
	 * Create the panel.
	 */
	public CrearTestCurso(Usuario user, Curso curso) {
		
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		JLabel labelTest = new JLabel("CREAR TEST DE CONOCIMIENTO\r\n");
		labelTest.setFont(new Font("Tahoma", Font.PLAIN, 40));
		labelTest.setBounds(767, 361, 590, 49);
		add(labelTest);
		
		JLabel lNombre = new JLabel("Nombre:");
		lNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lNombre.setBounds(649, 428, 78, 25);
		add(lNombre);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfNombre.setBounds(806, 421, 428, 40);
		add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lDescripccion = new JLabel("Descripci\u00F3n:");
		lDescripccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lDescripccion.setBounds(617, 472, 110, 25);
		add(lDescripccion);
		
		tfDescripccion = new JTextField();
		tfDescripccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDescripccion.setBounds(806, 472, 645, 297);
		add(tfDescripccion);
		tfDescripccion.setColumns(10);
		
		JLabel lLink = new JLabel("Link al test:");
		lLink.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lLink.setBounds(622, 787, 105, 25);
		add(lLink);
		
		tfLink = new JTextField();
		tfLink.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfLink.setBounds(806, 780, 645, 40);
		add(tfLink);
		tfLink.setColumns(10);
		
		bGuardar = new JButton("Crear test");
		bGuardar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bGuardar.setBounds(1657, 472, 140, 40);
		add(bGuardar);
		
		volver = new JButton(new ImageIcon(getClass().getResource("/img/volver.png")));
		volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volver.setContentAreaFilled(false);
		volver.setFocusPainted(false);
		volver.setBorderPainted(false);
		volver.setBounds(454, 386, 78, 67);
		add(volver);
		
		if (user instanceof Profesor) {
			CtrMenu menu = new CtrMenu(new Menu((Profesor) user, curso));
			add(menu.getPanel());
		} else if (user instanceof Organizacion) {
			CtrMenu menu = new CtrMenu(new Menu((Organizacion) user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante) user, curso));
			add(menu.getPanel());
		}

		CtrMenuCurso menuc = new CtrMenuCurso(new MenuCurso(curso));
		add(menuc.getPanel());
	}
	
	public void controlador(ActionListener ctr) {
		if(volver != null) {
			this.volver.addActionListener(ctr);
			this.volver.setActionCommand("VOLVER");
		}
		
		if(bGuardar != null) {
			this.bGuardar.addActionListener(ctr);
			this.bGuardar.setActionCommand("CREAR");
		}
		
		
	}
}
