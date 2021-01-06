package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.*;
import Vista.*;

public class CtrDescripcionCurso implements ActionListener {
	private Usuario user;
	private Curso curso;
	private DescripcionCurso ventana;

	public CtrDescripcionCurso(Usuario user, Curso curso) {
		this.user = user;
		this.curso = curso;
		ventana = new DescripcionCurso(user, curso);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Unirse")) {
			if (user != null) {
				curso.addEstudiante(user);
				CtrInformacionCurso c = new CtrInformacionCurso(user, curso);
				JOptionPane.showMessageDialog(ventana, "Se ha unido al curso correctamente");
				EnviarCorreo.enviarGmailUnico(Main.getUser().getCorreo(), "PortalAcademy", "Queridísimo "
						+ Main.getUser().getNick()
						+ ": \n\nEnhorabuena formará parte de los participantes del curso gratuito " + curso.getNombre()
						+ ". Disfrútalo esperamos que aprenda mucho.\n\nUn cordial saludo de la comunidad NoTrabaJava.");
				Main.setPanel(c.getPanel());
			} else {
				CtrInformacionCurso c = new CtrInformacionCurso(null, curso);
				JOptionPane.showMessageDialog(ventana, "Se ha unido al curso correctamente");
				Main.setPanel(c.getPanel());
			}
		}

	}

	public JPanel getPanel() {
		return ventana;
	}

}
