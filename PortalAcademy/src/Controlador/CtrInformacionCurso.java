package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Mensaje;
import Modelo.Profesor;
import Modelo.Usuario;
import Vista.Ajustes;
import Vista.EditarCurso;
import Vista.Explorar;
import Vista.InformacionCurso;
import Vista.Inicio;
import Vista.Main;
import Vista.MisActividades;
import Vista.MisCursos;
import Vista.Registro;

public class CtrInformacionCurso implements ActionListener {
	private Usuario user;
	private Curso curso;

	private InformacionCurso ventana;

	public CtrInformacionCurso(Usuario user, Curso curso) {
		this.user = user;
		this.curso = curso;
		ventana = new InformacionCurso(user, curso);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Enviar")) {
			if(ventana.mensajeAEnviar().length() > 0) {
				if(user == null) {
					Usuario x = new Usuario("anonimo");
					Mensaje m = new Mensaje(ventana.mensajeAEnviar(), x, curso);
					CtrInformacionCurso c = new CtrInformacionCurso(user, curso);
					Main.setPanel(c.getPanel());
				}else {
					Mensaje m = new Mensaje(ventana.mensajeAEnviar(), user, curso);
					CtrInformacionCurso c = new CtrInformacionCurso(user, curso);
					Main.setPanel(c.getPanel());
				}
				
			}
		}

		if (e.getActionCommand().equals("Refrescar")) {
			CtrInformacionCurso c = new CtrInformacionCurso(user, curso);
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("Editar")) {
			CtrEditarCurso c = new CtrEditarCurso(new EditarCurso(curso, (Profesor) user));
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("EditarParticipantes")) {
			CtrEditarParticipantes c = new CtrEditarParticipantes(new EditarParticipantes(curso, (Profesor) user));
			Main.setPanel(c.getPanel());
		}
		
	}

	public JPanel getPanel() {
		return ventana;
	}

}
