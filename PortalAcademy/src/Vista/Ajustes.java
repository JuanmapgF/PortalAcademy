package Vista;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.Font;

public class Ajustes extends JPanel {
	private JTextField texto;

	/*private JLabel titulo = new JLabel("Ajustes");
	private JLabel nueva = new JLabel("Nueva contraseña: ");
	private JTextField texto = new JTextField("");
	private JButton cambiar = new JButton("Cambiar contraseña");
	private JButton cerrarSesion = new JButton("Cerrar sesión");*/
	
	public Ajustes() {
		setLayout(null);
		
		JLabel titulo = new JLabel("Ajustes");
		titulo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		titulo.setBounds(329, 0, 118, 102);
		add(titulo);
		
		JButton cerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		cerrarSesion.setBounds(672, 42, 118, 23);
		add(cerrarSesion);
		
		JLabel nueva = new JLabel("Nueva contrase\u00F1a:");
		nueva.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		nueva.setBounds(83, 183, 158, 102);
		add(nueva);
		
		texto = new JTextField();
		texto.setBounds(266, 223, 278, 20);
		add(texto);
		texto.setColumns(10);
		
		JButton cambiar = new JButton("Cambiar contrase\u00F1a");
		cambiar.setBounds(284, 324, 183, 23);
		add(cambiar);
		
		JButton eliminar = new JButton("Eliminar cuenta");
		eliminar.setBounds(309, 456, 129, 23);
		add(eliminar);
		
		this.setBounds(0, 0, 1080, 650);
	}
}
