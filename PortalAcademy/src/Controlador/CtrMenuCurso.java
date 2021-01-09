package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Vista.Main;
import Vista.MenuCurso;


public class CtrMenuCurso  implements ActionListener {
	
	private MenuCurso ventana;

	public CtrMenuCurso (MenuCurso v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("INICIO")) {
			CtrInformacionCursoInicio c = new CtrInformacionCursoInicio(Main.getUser(),ventana.getCurso());
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("TEMARIO")) {
			CtrInformacionCursoTemario c = new CtrInformacionCursoTemario(Main.getUser(),ventana.getCurso());
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("CUESTIONARIOS")) {
			CtrInformacionCursoCuestionarios c = new CtrInformacionCursoCuestionarios(Main.getUser(),ventana.getCurso());
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("FORO")) {
			CtrInformacionCursoForo c = new CtrInformacionCursoForo(Main.getUser(),ventana.getCurso());
			Main.setPanel(c.getPanel());
		}
		
	}
	public JPanel getPanel() {
		return ventana;
	}
}
	
