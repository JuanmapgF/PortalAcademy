package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Modelo.BD;
import Modelo.ErrorBD;
import Vista.Registro;

public class ControladorRegistro implements ActionListener {

	private Registro vista;

	private BD bd;

	public ControladorRegistro(Registro v) {
		vista = v;
		vista.rdbtnEstudiante.addActionListener(this);
		vista.rdbtnOrganizacion.addActionListener(this);
		vista.rdbtnProfesor.addActionListener(this);
		vista.btnRegistro.addActionListener(this);
	}

	public Registro getPanel() {
		return vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.rdbtnEstudiante) {
			vista.lblInfoAdicional.setText("");
			vista.lblInfoAdicional.setVisible(false);
			vista.textFieldInfoAdicional.setVisible(false);
		}

		if (e.getSource() == vista.rdbtnOrganizacion) {
			vista.lblInfoAdicional.setText("Sede:");
			vista.lblInfoAdicional.setVisible(true);
			vista.textFieldInfoAdicional.setVisible(true);
		}

		if (e.getSource() == vista.rdbtnProfesor) {
			vista.lblInfoAdicional.setText("Tel�fono:");
			vista.lblInfoAdicional.setVisible(true);
			vista.textFieldInfoAdicional.setVisible(true);
		}

		if (e.getSource() == vista.btnRegistro) {
			try {
				
				if (!nickValido()) {
					throw new ErrorBD(
							"El nick debe tener al menos 4 caracteres, y debe estar formado por al menos 1 digito y una letra.");
				}
				
				if (!nickDisponible()) {
					throw new ErrorBD("El nick que has introducido ya ha sido utilizado.");
				}
				
				
				if (!correoValido()) {
					throw new ErrorBD("El correo introducido debe ser v�lido.");
				}
				
				if (!correoDisponible()) {
					throw new ErrorBD("El correo que has introducido ya ha sido utilizado.");
				}
				
				if (!contrasenaValida()) {
					throw new ErrorBD(
							"La contrase�a tiene que tener al menos 6 caracteres, una may�scula, una min�scula y un d�gito.");
				}
				
				vista.buttonGroupRoles.getButtonCount();
			} catch (ErrorBD err) {
				JOptionPane.showMessageDialog(vista, err.getMessage(), "Error al registrarse",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private boolean correoDisponible() {
		bd = BD.getBD();
		int ccorreo = Integer.parseInt(bd.SelectEscalar(
				"SELECT COUNT(correo) FROM Usuario WHERE Usuario.correo = '" + vista.textFieldCorreo.getText() + "'")
				.toString());
		bd.finalize();
		return ccorreo == 0;
	}

	public boolean correoValido() {
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,4})$");
		Matcher mather = pattern.matcher(vista.textFieldCorreo.getText());
		return mather.find();
	}

	private boolean nickValido() {
		Pattern pattern = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Za-z])\\S{4,30}$");
		Matcher mather = pattern.matcher(vista.textFieldNick.getText());
		return mather.find();
	}

	private boolean nickDisponible() {
		bd = BD.getBD();
		int cnick = Integer.parseInt(bd.SelectEscalar("SELECT COUNT(nick) FROM Usuario WHERE Usuario.nick = '"
				+ vista.textFieldNick.getText().toUpperCase() + "'").toString());
		bd.finalize();
		return cnick == 0;
	}

	private boolean contrasenaValida() {
		Pattern pattern = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{6,20}$");
		Matcher mather = pattern.matcher(new String(vista.passwordFieldContrasena.getPassword()));
		return mather.find();
	}

}
