package Vista;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Registro extends JPanel {

	public JTextField textFieldNick;
	public JTextField textFieldCorreo;
	public final ButtonGroup buttonGroupRoles = new ButtonGroup();
	public JTextField textFieldInfoAdicional;
	public JRadioButton rdbtnEstudiante;
	public JRadioButton rdbtnProfesor;
	public JRadioButton rdbtnOrganizacion;
	public JLabel lblInfoAdicional;
	public JButton btnRegistro;
	public JPasswordField passwordFieldContrasena;
	public JTextField textFieldCodigo;
	public JButton btnInicioSesion;
	public JButton volver = new JButton();
	
	/**
	 * Create the panel.
	 */
	public Registro() {
		
		this.setBounds(0,0,1920,1080);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 45));
		lblNewLabel.setBounds(848, 66, 208, 46);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nick:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(733, 190, 62, 23);
		add(lblNewLabel_1);

		textFieldNick = new JTextField();
		textFieldNick.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNick.setBounds(880, 179, 341, 46);
		add(textFieldNick);
		textFieldNick.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Correo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(713, 277, 180, 23);
		add(lblNewLabel_2);

		textFieldCorreo = new JTextField();
		textFieldCorreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldCorreo.setBounds(880, 266, 341, 46);
		add(textFieldCorreo);
		textFieldCorreo.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(674, 364, 196, 23);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Rol:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(749, 491, 46, 23);
		add(lblNewLabel_4);

		volver = new JButton(new ImageIcon(getClass().getResource("/img/explorar.png")));
		volver.setBounds(60, 191, 205, 60);
		volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volver.setContentAreaFilled(false);
		volver.setFocusPainted(false);
		volver.setBorderPainted(false);
		add(volver);
		
		rdbtnEstudiante = new JRadioButton("Estudiante");
		rdbtnEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnEstudiante.setSelected(true);
		buttonGroupRoles.add(rdbtnEstudiante);
		rdbtnEstudiante.setBounds(825, 477, 131, 23);
		add(rdbtnEstudiante);

		rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroupRoles.add(rdbtnProfesor);
		rdbtnProfesor.setBounds(958, 477, 110, 23);
		add(rdbtnProfesor);

		rdbtnOrganizacion = new JRadioButton("Organizaci\u00F3n");
		rdbtnOrganizacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroupRoles.add(rdbtnOrganizacion);
		rdbtnOrganizacion.setBounds(1070, 477, 151, 23);
		add(rdbtnOrganizacion);

		lblInfoAdicional = new JLabel("");
		lblInfoAdicional.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfoAdicional.setVisible(false);
		lblInfoAdicional.setBounds(696, 565, 169, 46);
		add(lblInfoAdicional);

		btnRegistro = new JButton(new ImageIcon(getClass().getResource("/img/registro.png")));
		btnRegistro.setBounds(825, 672, 196, 60);
		btnRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistro.setContentAreaFilled(false);
		btnRegistro.setFocusPainted(false);
		btnRegistro.setBorderPainted(false);
		add(btnRegistro);

		textFieldInfoAdicional = new JTextField();
		textFieldInfoAdicional.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldInfoAdicional.setVisible(false);
		textFieldInfoAdicional.setBounds(1027, 565, 335, 46);
		add(textFieldInfoAdicional);
		textFieldInfoAdicional.setColumns(10);

		passwordFieldContrasena = new JPasswordField();
		passwordFieldContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordFieldContrasena.setBounds(880, 353, 341, 46);
		add(passwordFieldContrasena);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldCodigo.setToolTipText("Codigo país");
		textFieldCodigo.setVisible(false);
		textFieldCodigo.setBounds(890, 565, 76, 46);
		add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u00BFYa tienes una cuenta?");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_5.setBounds(674, 882, 292, 40);
		add(lblNewLabel_5);
		
		btnInicioSesion = new JButton(new ImageIcon(getClass().getResource("/img/iniciarSesion.png")));
		btnInicioSesion.setBounds(1009, 879, 163, 60);
		btnInicioSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInicioSesion.setContentAreaFilled(false);
		btnInicioSesion.setFocusPainted(false);
		btnInicioSesion.setBorderPainted(false);
		add(btnInicioSesion);

	}
}
