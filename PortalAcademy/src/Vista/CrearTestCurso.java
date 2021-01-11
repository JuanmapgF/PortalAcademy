package Vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.Curso;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class CrearTestCurso extends JPanel {

	private Usuario user;
	private Curso curso;
	private JTextField tfNombre;
	private JTextField textField;
	private JTextField tfLink;
	/**
	 * Create the panel.
	 */
	public CrearTestCurso(Usuario user, Curso curso) {
		
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		JLabel labelTest = new JLabel("CREAR TEST DE CONOCIMIENTO\r\n");
		labelTest.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelTest.setBounds(429, 157, 394, 29);
		add(labelTest);
		
		JLabel lNombre = new JLabel("Nombre:");
		lNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lNombre.setBounds(429, 235, 78, 25);
		add(lNombre);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfNombre.setBounds(556, 232, 428, 31);
		add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lDescripccion = new JLabel("Descripci\u00F3n:");
		lDescripccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lDescripccion.setBounds(429, 307, 110, 25);
		add(lDescripccion);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(556, 314, 645, 297);
		add(textField);
		textField.setColumns(10);
		
		JLabel lLink = new JLabel("Link al test:");
		lLink.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lLink.setBounds(429, 671, 102, 25);
		add(lLink);
		
		tfLink = new JTextField();
		tfLink.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfLink.setBounds(556, 668, 645, 31);
		add(tfLink);
		tfLink.setColumns(10);
		
		JButton bGuardar = new JButton("Guardar");
		bGuardar.setFont(new Font("Tahoma", Font.BOLD, 20));
		bGuardar.setBounds(429, 846, 115, 33);
		add(bGuardar);
		
		JButton bAtras = new JButton("Atr\u00E1s");
		bAtras.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bAtras.setBounds(1599, 167, 75, 31);
		add(bAtras);
	}
}
