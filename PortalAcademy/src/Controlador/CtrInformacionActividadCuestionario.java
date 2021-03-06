package Controlador;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Usuario;
import Vista.InformacionActividadCuestionarios;
import Vista.Main;

public class CtrInformacionActividadCuestionario implements ActionListener {

	private InformacionActividadCuestionarios vista;
	private Actividad actividad;
	private Usuario user;
	private String enlaceCuestionario = "https://forms.gle/A6w9nd54iKBxBfFTA";

	public CtrInformacionActividadCuestionario(Actividad actividad, Usuario user) {
		vista = new InformacionActividadCuestionarios(user, actividad);
		this.actividad = actividad;
		this.user = user;
		vista.controlador(this);
	}

	public JPanel getPanel() {
		return vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("CREAR")) {
			actividad.setSatisfaccion(true);
			CtrInformacionActividadCuestionario c = new CtrInformacionActividadCuestionario(actividad, user);
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("BORRAR")) {
			actividad.setSatisfaccion(false);
			CtrInformacionActividadCuestionario c = new CtrInformacionActividadCuestionario(actividad,user);
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("HACER")) {
			try {
				Abrir_URL(enlaceCuestionario);
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}finally {
				CtrInformacionActividadCuestionario c = new CtrInformacionActividadCuestionario(actividad,user);
				Main.setPanel(c.getPanel());
			}
		}

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
