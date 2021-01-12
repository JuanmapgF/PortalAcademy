package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Curso;
import Modelo.Mensaje;
import Modelo.Usuario;
import Vista.InformacionCursoForo;
import Vista.Main;

public class CtrInformacionCursoForo implements ActionListener {

	private Usuario user;
	private Curso curso;

	private InformacionCursoForo ventana;

	public CtrInformacionCursoForo(Usuario user, Curso curso) {
		this.user = user;
		this.curso = curso;
		ventana = new InformacionCursoForo(user, curso);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Enviar")) {
			String mensaje = ventana.mensajeAEnviar();

			if (mensaje.length() > 80) {
				JOptionPane.showMessageDialog(ventana, "El mensaje ha superado los 80 caracteres permitidos");
			} else if (mensaje.equals("") || mensaje.charAt(0) == ' ') {
				JOptionPane.showMessageDialog(ventana, "El mensaje debe empezar por algun caracter");
			} else {
				if (user == null) {
					Usuario x = new Usuario("anonimo");
					new Mensaje(ventana.mensajeAEnviar(), x, curso);
					CtrInformacionCursoForo c = new CtrInformacionCursoForo(user, curso);
					Main.setPanel(c.getPanel());
				} else {
					new Mensaje(ventana.mensajeAEnviar(), user, curso);
					CtrInformacionCursoForo c = new CtrInformacionCursoForo(user, curso);
					Main.setPanel(c.getPanel());
				}

			}
		}

		if (e.getActionCommand().equals("Refrescar")) {
			CtrInformacionCursoForo c = new CtrInformacionCursoForo(user, curso);
			Main.setPanel(c.getPanel());
		}
	}

	public JPanel getPanel() {
		return ventana;
	}

}
