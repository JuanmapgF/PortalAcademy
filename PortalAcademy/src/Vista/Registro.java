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

	/**
	 * Create the panel.
	 */
	public Registro() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(444, 39, 107, 35);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nick:");
		lblNewLabel_1.setBounds(271, 130, 86, 23);
		add(lblNewLabel_1);

		textFieldNick = new JTextField();
		textFieldNick.setBounds(477, 130, 118, 23);
		add(textFieldNick);
		textFieldNick.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Correo:");
		lblNewLabel_2.setBounds(271, 190, 86, 23);
		add(lblNewLabel_2);

		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(477, 190, 118, 23);
		add(textFieldCorreo);
		textFieldCorreo.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_3.setBounds(271, 247, 86, 23);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Rol:");
		lblNewLabel_4.setBounds(271, 313, 86, 23);
		add(lblNewLabel_4);

		rdbtnEstudiante = new JRadioButton("Estudiante");
		rdbtnEstudiante.setSelected(true);
		buttonGroupRoles.add(rdbtnEstudiante);
		rdbtnEstudiante.setBounds(393, 313, 104, 23);
		add(rdbtnEstudiante);

		rdbtnProfesor = new JRadioButton("Profesor");
		buttonGroupRoles.add(rdbtnProfesor);
		rdbtnProfesor.setBounds(499, 313, 86, 23);
		add(rdbtnProfesor);

		rdbtnOrganizacion = new JRadioButton("Organizaci\u00F3n");
		buttonGroupRoles.add(rdbtnOrganizacion);
		rdbtnOrganizacion.setBounds(587, 313, 124, 23);
		add(rdbtnOrganizacion);

		lblInfoAdicional = new JLabel("");
		lblInfoAdicional.setVisible(false);
		lblInfoAdicional.setBounds(271, 389, 86, 20);
		add(lblInfoAdicional);

		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(477, 468, 118, 40);
		add(btnRegistro);

		textFieldInfoAdicional = new JTextField();
		textFieldInfoAdicional.setVisible(false);
		textFieldInfoAdicional.setBounds(477, 389, 118, 23);
		add(textFieldInfoAdicional);
		textFieldInfoAdicional.setColumns(10);

		passwordFieldContrasena = new JPasswordField();
		passwordFieldContrasena.setBounds(477, 247, 118, 24);
		add(passwordFieldContrasena);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setToolTipText("Codigo pa�s");
		textFieldCodigo.setVisible(false);
		textFieldCodigo.setBounds(411, 389, 56, 23);
		add(textFieldCodigo);
		textFieldCodigo.setColumns(10);

	}
}
