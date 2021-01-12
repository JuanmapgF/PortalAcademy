package Controlador;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Usuario;
import Vista.InformacionActividadCuestionario;
import Vista.Main;

public class CtrInformacionActividadCuestionario implements ActionListener {

	private InformacionActividadCuestionario vista;
	private Actividad actividad;
	private String enlaceCuestionario = "https://forms.gle/A6w9nd54iKBxBfFTA";
	
	private Usuario user;

	public CtrInformacionActividadCuestionario(Actividad actividad, Usuario user) {
		vista = new InformacionActividadCuestionario(user, actividad);
		this.actividad = actividad;
	}

	public JPanel getPanel() {
		return vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Crear")) {
			actividad.setSatisfaccion(true);
			CtrInformacionActividadCuestionario c = new CtrInformacionActividadCuestionario(actividad,user);
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("Borrar")) {
			actividad.setSatisfaccion(false);
			CtrInformacionActividadCuestionario c = new CtrInformacionActividadCuestionario(actividad,user);
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("Hacer")) {
			try {
				Abrir_URL(enlaceCuestionario);
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}finally {
				CtrInformacionActividadCuestionario c = new CtrInformacionActividadCuestionario(actividad,user);
				Main.setPanel(c.getPanel());
			}
		}
		// TODO Auto-generated method stub

	}

	
	
	private void Abrir_URL(String url) throws URISyntaxException {
		 if (Desktop.isDesktopSupported()) {
			 Desktop desktop = Desktop.getDesktop();
			 try {
				 URI uri = new URI(url);
				 desktop.browse(uri);
			 } catch (IOException e) {
				 System.err.println("Error: No se pudo abrir el enlace" + e.getMessage() );
			 }
		 } else {
			 System.err.println("Error: No se puede abrir enlaces web.");
		 }
	}

}
