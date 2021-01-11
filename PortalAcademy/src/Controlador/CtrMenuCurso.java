package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Vista.CursoTemario;
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
			CtrCursoTemario ctrCursoTemario = new CtrCursoTemario(new CursoTemario(ventana.getCurso()));
			Main.setPanel(ctrCursoTemario.getPanel());
		}

		if (e.getActionCommand().equals("CUESTIONARIOS")) {
			CtrInformacionCursoCuestionario c = new CtrInformacionCursoCuestionario(Main.getUser(), ventana.getCurso());
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("FORO")) {
			CtrInformacionCursoForo c = new CtrInformacionCursoForo(Main.getUser(), ventana.getCurso());
			Main.setPanel(c.getPanel());
		}

	}

	public JPanel getPanel() {
		return ventana;
	}
}
