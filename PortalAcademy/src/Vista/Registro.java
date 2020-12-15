package Vista;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

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
		
		this.setBounds(0,0,1080,650);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(544, 39, 107, 35);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nick:");
		lblNewLabel_1.setBounds(371, 130, 86, 23);
		add(lblNewLabel_1);

		textFieldNick = new JTextField();
		textFieldNick.setBounds(577, 130, 118, 23);
		add(textFieldNick);
		textFieldNick.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Correo:");
		lblNewLabel_2.setBounds(371, 190, 86, 23);
		add(lblNewLabel_2);

		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(577, 190, 118, 23);
		add(textFieldCorreo);
		textFieldCorreo.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_3.setBounds(371, 247, 86, 23);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Rol:");
		lblNewLabel_4.setBounds(371, 313, 86, 23);
		add(lblNewLabel_4);

		volver = new JButton("Explorar");
		volver.setBounds(36, 191, 131, 32);
		add(volver);
		
		rdbtnEstudiante = new JRadioButton("Estudiante");
		rdbtnEstudiante.setSelected(true);
		buttonGroupRoles.add(rdbtnEstudiante);
		rdbtnEstudiante.setBounds(493, 313, 104, 23);
		add(rdbtnEstudiante);

		rdbtnProfesor = new JRadioButton("Profesor");
		buttonGroupRoles.add(rdbtnProfesor);
		rdbtnProfesor.setBounds(599, 313, 86, 23);
		add(rdbtnProfesor);

		rdbtnOrganizacion = new JRadioButton("Organizaci\u00F3n");
		buttonGroupRoles.add(rdbtnOrganizacion);
		rdbtnOrganizacion.setBounds(687, 313, 124, 23);
		add(rdbtnOrganizacion);

		lblInfoAdicional = new JLabel("");
		lblInfoAdicional.setVisible(false);
		lblInfoAdicional.setBounds(371, 389, 86, 20);
		add(lblInfoAdicional);

		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(577, 468, 118, 40);
		add(btnRegistro);

		textFieldInfoAdicional = new JTextField();
		textFieldInfoAdicional.setVisible(false);
		textFieldInfoAdicional.setBounds(577, 389, 118, 23);
		add(textFieldInfoAdicional);
		textFieldInfoAdicional.setColumns(10);

		passwordFieldContrasena = new JPasswordField();
		passwordFieldContrasena.setBounds(577, 247, 118, 24);
		add(passwordFieldContrasena);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setToolTipText("Codigo país");
		textFieldCodigo.setVisible(false);
		textFieldCodigo.setBounds(511, 389, 56, 23);
		add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u00BFYa tienes una cuenta?");
		lblNewLabel_5.setBounds(416, 576, 118, 14);
		add(lblNewLabel_5);
		
		btnInicioSesion = new JButton("Inicio Sesi\u00F3n");
		btnInicioSesion.setBounds(577, 572, 118, 23);
		add(btnInicioSesion);

	}
}
