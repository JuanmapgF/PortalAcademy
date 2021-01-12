package Controlador;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JPanel;

import Modelo.Curso;
import Modelo.Usuario;
import Vista.InformacionCursoCuestionarios;
import Vista.Main;

public class CtrInformacionCursoCuestionario implements ActionListener {

	private InformacionCursoCuestionarios vista;
	private Curso curso;
	private Usuario user;
	private String enalceCuestionario = "https://forms.gle/A6w9nd54iKBxBfFTA";

	public CtrInformacionCursoCuestionario(Usuario user, Curso c) {
		vista = new InformacionCursoCuestionarios(user, c);
		curso = c;
		this.user = user;
		vista.controlador(this);
	}

	public JPanel getPanel() {
		return vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("CREAR")) {
			curso.setSatisfaccion(true);
		}

		if (e.getActionCommand().equals("BORRAR")) {
			curso.setSatisfaccion(false);
		}

		if (e.getActionCommand().equals("HACER")) {
			try {
				Abrir_URL(enalceCuestionario);
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getActionCommand().equals("CREARTEST")) {
			CtrCrearTestCurso ctr = new CtrCrearTestCurso(user, curso);
			Main.setPanel(ctr.getPanel());
		}

	}

	public void enlace(String enlaceAAceder) {
		Desktop enlace = Desktop.getDesktop();
		try {
			enlace.browse(new URI(enlaceAAceder));
		} catch (IOException | URISyntaxException e) {
			e.getMessage();
		}
	}

	private void Abrir_URL(String url) throws URISyntaxException {
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				URI uri = new URI("http://www.byspel.com");
				desktop.browse(uri);
			} catch (IOException e) {
				System.err.println("Error: No se pudo abrir el enlace" + e.getMessage());
			}
		} else {
			System.err.println("Error: No se puede abrir enlaces web.");
		}
	}

}
