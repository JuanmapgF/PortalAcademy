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
import Vista.InformacionActividadCuestionario;

public class CtrInformacionActividadCuestionario implements ActionListener {

	private InformacionActividadCuestionario vista;
	private Actividad actividad;
	private Usuario user;
	private String enalceCuestionario = "https://forms.gle/A6w9nd54iKBxBfFTA";
	
	
	
	public CtrInformacionActividadCuestionario(Actividad actividad, Usuario user) {
		vista = new InformacionActividadCuestionario(user, actividad);
		this.actividad = actividad;
		this.user = user;
	}

	public JPanel getPanel() {
		return vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Crear")) {
			actividad.setSatisfaccion(true);
		}
		
		if(e.getActionCommand().equals("Borrar")) {
			actividad.setSatisfaccion(false);
		}
		
		if(e.getActionCommand().equals("Hacer")) {
			enlace(enalceCuestionario);
		}
		// TODO Auto-generated method stub
		
	}
	
	public void enlace (String enlaceAAceder){
        Desktop enlace=Desktop.getDesktop();
        try {
                enlace.browse(new URI(enlaceAAceder));
        } catch (IOException | URISyntaxException e) {
            e.getMessage();
        }
    }

}
