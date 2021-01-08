package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Controlador.CtrMenu;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;

@SuppressWarnings("serial")
public class Ajustes extends JPanel {

	private JPasswordField texto;
	private JButton eliminar;
	private JButton cambiar;

	private Estudiante estudiante;
	private Profesor prof;
	private Organizacion org;
	private boolean esEstudiante = false;
	private boolean esProfesor = false;
	private boolean esOrganizacion = false;



	public String getTexto() {
		return String.valueOf(texto.getPassword());
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public Profesor getProfesor() {
		return prof;
	}

	public Organizacion getOrganizacion() {
		return org;
	}

	public boolean esEstudiante() {
		return esEstudiante;
	}

	public boolean esProfesor() {
		return esProfesor;
	}

	public boolean esOrganizacion() {
		return esOrganizacion;
	}

	
	public Ajustes(Estudiante u) {
		estudiante = u;
		esEstudiante = true;

		setLayout(null);

		JLabel titulo = new JLabel("Ajustes");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		titulo.setBounds(731, 153, 183, 102);
		add(titulo);


		JLabel nueva = new JLabel("Nueva contrase\u00F1a:");
		nueva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nueva.setBounds(580, 301, 183, 60);
		add(nueva);

		texto = new JPasswordField();
		texto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		texto.setBounds(790, 312, 278, 40);
		add(texto);
		texto.setColumns(10);

		cambiar = new JButton("Cambiar contrase\u00F1a");
		cambiar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cambiar.setBounds(685, 419, 218, 40);
		add(cambiar);

		eliminar = new JButton("Eliminar cuenta");
		eliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eliminar.setBounds(685, 673, 218, 40);
		add(eliminar);
		
		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());

		this.setBounds(0, 0, 1920, 1080);
	}

	
	public Ajustes(Profesor u) {
		esProfesor = true;
		prof = u;
		setLayout(null);

		JLabel titulo = new JLabel("Ajustes");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		titulo.setBounds(731, 153, 183, 102);
		add(titulo);


		JLabel nueva = new JLabel("Nueva contrase\u00F1a:");
		nueva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nueva.setBounds(580, 301, 183, 60);
		add(nueva);

		texto = new JPasswordField();
		texto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		texto.setBounds(790, 312, 278, 40);
		add(texto);
		texto.setColumns(10);

		cambiar = new JButton("Cambiar contrase\u00F1a");
		cambiar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cambiar.setBounds(685, 419, 218, 40);
		add(cambiar);

		eliminar = new JButton("Eliminar cuenta");
		eliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eliminar.setBounds(685, 673, 218, 40);
		add(eliminar);
		
		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());

		this.setBounds(0, 0, 1920, 1080);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public Ajustes(Organizacion u) {
		esOrganizacion = true;
		org = u;
		setLayout(null);

		JLabel titulo = new JLabel("Ajustes");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		titulo.setBounds(731, 153, 183, 102);
		add(titulo);


		JLabel nueva = new JLabel("Nueva contrase\u00F1a:");
		nueva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nueva.setBounds(580, 301, 183, 60);
		add(nueva);

		texto = new JPasswordField();
		texto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		texto.setBounds(790, 312, 278, 40);
		add(texto);
		texto.setColumns(10);

		cambiar = new JButton("Cambiar contrase\u00F1a");
		cambiar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cambiar.setBounds(685, 419, 218, 40);
		add(cambiar);

		eliminar = new JButton("Eliminar cuenta");
		eliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eliminar.setBounds(685, 673, 218, 40);
		add(eliminar);
		
		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());

		this.setBounds(0, 0, 1920, 1080);
	}

	public void controlador(ActionListener ctr) {

		eliminar.addActionListener(ctr);
		eliminar.setActionCommand("ELIMINAR");

		cambiar.addActionListener(ctr);
		cambiar.setActionCommand("CAMBIAR");

	}
}
