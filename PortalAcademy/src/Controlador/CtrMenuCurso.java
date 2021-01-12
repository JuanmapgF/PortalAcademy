package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Profesor;
import Vista.EditarCurso;
import Vista.EditarParticipantes;
import Vista.InformacionCursoTemario;
import Vista.Main;
import Vista.MenuCurso;

public class CtrMenuCurso implements ActionListener {

	private MenuCurso ventana;

	public CtrMenuCurso(MenuCurso v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("INICIO")) {
			CtrInformacionCurso c = new CtrInformacionCurso(Main.getUser(), ventana.getCurso());
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("TEMARIO")) {
			CtrCursoTemario ctrCursoTemario = new CtrCursoTemario(new InformacionCursoTemario(ventana.getCurso()));
			Main.setPanel(ctrCursoTemario.getPanel());
		}

		if (e.getActionCommand().equals("CUESTIONARIOS")) {
			if (Main.getUser() == null) {
				JOptionPane.showMessageDialog(ventana, "No tienes permiso para hacer cuestionarios");
			} else { 
				CtrInformacionCursoCuestionario c = new CtrInformacionCursoCuestionario(Main.getUser(), ventana.getCurso());
				Main.setPanel(c.getPanel());
			}	
		}

		if (e.getActionCommand().equals("FORO")) {
			CtrInformacionCursoForo c = new CtrInformacionCursoForo(Main.getUser(), ventana.getCurso());
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("EDITAR")) {
			CtrEditarCurso c = new CtrEditarCurso(new EditarCurso(ventana.getCurso(), (Profesor) Main.getUser()));
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("EDITAR_PARTICIPANTES")) {
			CtrEditarParticipantes c = new CtrEditarParticipantes(new EditarParticipantes(ventana.getCurso(), (Profesor) Main.getUser()));
			Main.setPanel(c.getPanel());
		}

	}

	public JPanel getPanel() {
		return ventana;
	}
}
