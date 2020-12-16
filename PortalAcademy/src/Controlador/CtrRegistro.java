package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Modelo.Actividad;
import Modelo.BD;
import Modelo.Curso;
import Modelo.ErrorBD;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Telefono;
import Modelo.Usuario;
import Vista.Explorar;
import Vista.Inicio;
import Vista.Main;
import Vista.Registro;

public class CtrRegistro implements ActionListener {

	private Registro vista;
	private Usuario usuario;
	private BD bd;

	public CtrRegistro(Registro v) {
		vista = v;
		vista.rdbtnEstudiante.addActionListener(this);
		vista.rdbtnOrganizacion.addActionListener(this);
		vista.rdbtnProfesor.addActionListener(this);
		vista.btnRegistro.addActionListener(this);
		vista.btnInicioSesion.addActionListener(this);
		vista.volver.addActionListener(this);
	}

	public Registro getPanel() {
		return vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vista.volver) {
			try {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == vista.btnInicioSesion) {
			CtrInicio ci = new CtrInicio(new Inicio());
			Main.setPanel(ci.getPanel());
		}
		
		if (e.getSource() == vista.rdbtnEstudiante) {
			vista.lblInfoAdicional.setText("");
			vista.lblInfoAdicional.setVisible(false);
			vista.textFieldInfoAdicional.setText("");
			vista.textFieldInfoAdicional.setVisible(false);
			vista.textFieldCodigo.setVisible(false);
			vista.textFieldCodigo.setText("");
		}

		if (e.getSource() == vista.rdbtnOrganizacion) {
			vista.lblInfoAdicional.setText("Sede:");
			vista.lblInfoAdicional.setVisible(true);
			vista.textFieldInfoAdicional.setText("");
			vista.textFieldInfoAdicional.setVisible(true);
			vista.textFieldCodigo.setVisible(false);
			vista.textFieldCodigo.setText("");
		}

		if (e.getSource() == vista.rdbtnProfesor) {
			vista.lblInfoAdicional.setText("Teléfono:");
			vista.lblInfoAdicional.setVisible(true);
			vista.textFieldInfoAdicional.setText("");
			vista.textFieldInfoAdicional.setVisible(true);
			vista.textFieldCodigo.setText("");
			vista.textFieldCodigo.setVisible(true);
		}

		if (e.getSource() == vista.btnRegistro) {
			try {

				if (!nickValido()) {
					throw new ErrorBD(
							"El nick debe tener al menos 4 caracteres, y debe estar formado solamente por letras y digitos.");
				}

				if (!nickDisponible()) {
					throw new ErrorBD("El nick que has introducido ya ha sido utilizado.");
				}

				if (!correoValido()) {
					throw new ErrorBD("El correo introducido debe ser válido.");
				}

				if (!correoDisponible()) {
					throw new ErrorBD("El correo que has introducido ya ha sido utilizado.");
				}

				if (!contrasenaValida()) {
					throw new ErrorBD(
							"La contraseña tiene que tener al menos 6 caracteres, una mayúscula, una minúscula y un dígito.");
				}

				if (vista.rdbtnProfesor.isSelected() && !telefonoValido()) {
					throw new ErrorBD("El telefono no es valido. Introduzca el codigo de su pais y el telefono.");
				}

				if (vista.rdbtnEstudiante.isSelected()) {
					usuario = new Estudiante(vista.textFieldNick.getText(), vista.textFieldCorreo.getText(),
							new String(vista.passwordFieldContrasena.getPassword()));
					CtrExplorar x = new CtrExplorar(new Explorar((Estudiante)usuario,Curso.getTodosLosCursos(),Actividad.getTodasLasActividades()));
					Main.setPanel(x.getPanel());
				} else if (vista.rdbtnProfesor.isSelected()) {
					usuario = new Profesor(vista.textFieldNick.getText(), vista.textFieldCorreo.getText(),
							new String(vista.passwordFieldContrasena.getPassword()),
							new Telefono(Integer.parseInt(vista.textFieldCodigo.getText()),
									vista.textFieldInfoAdicional.getText()));
					CtrExplorar x = new CtrExplorar(new Explorar((Profesor)usuario,Curso.getTodosLosCursos()));
					Main.setPanel(x.getPanel());
				} else if (vista.rdbtnOrganizacion.isSelected()) {
					usuario = new Organizacion(vista.textFieldNick.getText(), vista.textFieldCorreo.getText(),
							new String(vista.passwordFieldContrasena.getPassword()),
							vista.textFieldInfoAdicional.getText());
					CtrExplorar x = new CtrExplorar(new Explorar((Organizacion)usuario,Actividad.getTodasLasActividades()));
					Main.setPanel(x.getPanel());
				}
				
				Main.setUser(usuario);

				JOptionPane.showMessageDialog(vista, "Cuenta creada satisfactoriamente.", "Registro correcto",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (ErrorBD err) {
				JOptionPane.showMessageDialog(vista, err.getMessage(), "Error al registrarse",
						JOptionPane.ERROR_MESSAGE);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	private boolean telefonoValido() {
		Pattern pattern1 = Pattern.compile("^(?=\\w*\\d)\\S{1,4}$");
		Matcher mather1 = pattern1.matcher(vista.textFieldCodigo.getText());
		Pattern pattern2 = Pattern.compile("^(?=\\w*\\d)\\S{3,15}$");
		Matcher mather2 = pattern2.matcher(vista.textFieldInfoAdicional.getText());
		return mather1.find() && mather2.find();
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
		Pattern pattern = Pattern.compile("^[A-Za-z0-9]\\S{3,30}");
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
