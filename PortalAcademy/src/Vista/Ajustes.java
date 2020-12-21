package Vista;

import java.awt.Color;
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
		titulo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		titulo.setBounds(529, 0, 118, 102);
		add(titulo);


		JLabel nueva = new JLabel("Nueva contrase\u00F1a:");
		nueva.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		nueva.setBounds(283, 183, 158, 102);
		add(nueva);

		texto = new JPasswordField();
		texto.setBounds(466, 223, 278, 20);
		add(texto);
		texto.setColumns(10);

		cambiar = new JButton("Cambiar contrase\u00F1a");
		cambiar.setBounds(484, 324, 183, 23);
		add(cambiar);

		eliminar = new JButton("Eliminar cuenta");
		eliminar.setBounds(509, 456, 129, 23);
		add(eliminar);
		
		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());

		this.setBounds(0, 0, 1080, 650);
	}

	public Ajustes(Profesor u) {
		esProfesor = true;
		prof = u;
		setLayout(null);

		JLabel titulo = new JLabel("Ajustes");
		titulo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		titulo.setBounds(529, 0, 118, 102);
		add(titulo);


		JLabel nueva = new JLabel("Nueva contrase\u00F1a:");
		nueva.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		nueva.setBounds(283, 183, 158, 102);
		add(nueva);

		texto = new JPasswordField();
		texto.setBounds(466, 223, 278, 20);
		add(texto);
		texto.setColumns(10);

		cambiar = new JButton("Cambiar contrase\u00F1a");
		cambiar.setBounds(484, 324, 183, 23);
		add(cambiar);

		eliminar = new JButton("Eliminar cuenta");
		eliminar.setBounds(509, 456, 129, 23);
		add(eliminar);
		
		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());

		this.setBounds(0, 0, 1080, 650);
	}

	public Ajustes(Organizacion u) {
		esOrganizacion = true;
		org = u;
		setLayout(null);

		JLabel titulo = new JLabel("Ajustes");
		titulo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		titulo.setBounds(529, 0, 118, 102);
		add(titulo);

		JLabel nueva = new JLabel("Nueva contrase\u00F1a:");
		nueva.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		nueva.setBounds(283, 183, 158, 102);
		add(nueva);

		texto = new JPasswordField();
		texto.setBounds(466, 223, 278, 20);
		add(texto);
		texto.setColumns(10);

		cambiar = new JButton("Cambiar contrase\u00F1a");
		cambiar.setBounds(484, 324, 183, 23);
		add(cambiar);

		eliminar = new JButton("Eliminar cuenta");
		eliminar.setBounds(509, 456, 129, 23);
		add(eliminar);

		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());

		this.setBounds(0, 0, 1080, 650);
	}

	public void controlador(ActionListener ctr) {

		eliminar.addActionListener(ctr);
		eliminar.setActionCommand("ELIMINAR");

		cambiar.addActionListener(ctr);
		cambiar.setActionCommand("CAMBIAR");

	}
}
