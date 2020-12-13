package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Inicio extends JPanel {
	private JTextField user;
	private JPasswordField cont;
	private JButton iniciar = new JButton();
	private JButton registro = new JButton();
	private JButton volver = new JButton();
	private JLabel error;

	/**
	 * Create the panel.
	 */
	public Inicio() {
		this.setBounds(0, 0, 1080, 650);
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inicio de sesi\u00F3n");
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		lblNewLabel.setBounds(428, 34, 269, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(260, 169, 111, 27);
		add(lblNewLabel_1);
		
		user = new JTextField();
		user.setBounds(412, 172, 242, 20);
		add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(260, 276, 135, 27);
		add(lblNewLabel_1_1);
		
		iniciar = new JButton("Iniciar sesi\u00F3n");
		iniciar.setBounds(479, 389, 116, 33);
		add(iniciar);
		
		registro = new JButton("Registrarse");
		registro.setBounds(601, 496, 111, 20);
		add(registro);
		
		JLabel lblNewLabel_2 = new JLabel("\u00BFA\u00FAn no tienes cuenta? ");
		lblNewLabel_2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(334, 490, 261, 33);
		add(lblNewLabel_2);
		
		cont = new JPasswordField();
		cont.setBounds(412, 279, 242, 20);
		add(cont);
		
		volver = new JButton("Explorar");
		volver.setBounds(47, 563, 111, 20);
		add(volver);
		
		error = new JLabel("El usuario o la contrase\u00F1a introducidos son incorrectos");
		error.setForeground(Color.RED);
		error.setBounds(373, 340, 379, 14);
		add(error);
		error.setVisible(false);
	}
	
	public void controlador(ActionListener ctr) {
		iniciar.addActionListener(ctr);
		iniciar.setActionCommand("INICIAR");
		
		registro.addActionListener(ctr);
		registro.setActionCommand("REGISTRATE");
		
		volver.addActionListener(ctr);
		volver.setActionCommand("VOLVER");
	}
	
	public String getUser() {
		return user.getText();
	}
	
	public String getPass() {
		return String.valueOf(cont.getPassword());
	}
	
	public void mostrarError() {
		error.setVisible(true);
	}
	
	public void ocultarError() {
		error.setVisible(false);
	}
}