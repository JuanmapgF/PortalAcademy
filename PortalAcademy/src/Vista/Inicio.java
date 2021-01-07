package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controlador.CtrMenu;

@SuppressWarnings("serial")
public class Inicio extends JPanel {
	private JTextField user;
	private JPasswordField cont;
	private JButton iniciar = new JButton();
	private JButton registro = new JButton();
	private JButton volver = new JButton();
	private JLabel error;
	private JTextField textFieldCorreo;
	private JButton btnRecuperar;

	/**
	 * Create the panel.
	 */
	public Inicio() {
		this.setBounds(0, 0, 1920, 1080);
		this.setLayout(null);

		JLabel lblNewLabel = new JLabel("Inicio de sesi\u00F3n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(771, 89, 286, 49);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(677, 292, 111, 27);
		add(lblNewLabel_1);

		user = new JTextField();
		user.setBounds(895, 286, 341, 46);
		add(user);
		user.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(647, 423, 135, 27);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("\u00BFA\u00FAn no tienes cuenta? ");
		lblNewLabel_2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(647, 724, 261, 33);
		add(lblNewLabel_2);

		cont = new JPasswordField();
		cont.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cont.setBounds(895, 414, 341, 46);
		add(cont);

		error = new JLabel("El usuario o la contrase\u00F1a introducidos son incorrectos");
		error.setFont(new Font("Tahoma", Font.PLAIN, 20));
		error.setForeground(Color.RED);
		error.setBounds(647, 512, 506, 27);
		add(error);
		error.setVisible(false);

		iniciar = new JButton("Iniciar sesi\u00F3n");
		iniciar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		iniciar.setBounds(805, 572, 196, 46);
		add(iniciar);

		registro = new JButton("Registrarse");
		registro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registro.setBounds(946, 713, 196, 46);
		add(registro);

		volver = new JButton("Explorar");
		volver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		volver.setBounds(60, 191, 205, 48);
		add(volver);

		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(515, 886, 341, 46);
		add(textFieldCorreo);
		textFieldCorreo.setColumns(10);

		btnRecuperar = new JButton("Recuperar contrase\u00F1a");
		btnRecuperar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRecuperar.setBounds(946, 882, 242, 46);
		add(btnRecuperar);
	}

	public void controlador(ActionListener ctr) {
		iniciar.addActionListener(ctr);
		iniciar.setActionCommand("INICIAR");

		registro.addActionListener(ctr);
		registro.setActionCommand("REGISTRATE");

		volver.addActionListener(ctr);
		volver.setActionCommand("VOLVER");

		btnRecuperar.addActionListener(ctr);
		btnRecuperar.setActionCommand("RECUPERAR");
	}

	public void controladorEnter(KeyListener ctr) {
		user.addKeyListener(ctr);
		cont.addKeyListener(ctr);
	}

	public String getCorreo() {
		return textFieldCorreo.getText();
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