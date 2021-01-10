package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.Curso;
import Modelo.Usuario;
import Vista.AdminCursos;
import Vista.CrearTestCurso;
import Vista.InformacionCursoCuestionarios;
import Vista.Main;

public class CtrCrearTestCurso implements ActionListener{
	
	private CrearTestCurso vista;
	private Curso curso;
	private Usuario user;
	
	
	public CtrCrearTestCurso(Usuario user, Curso curso) {
		vista = new CrearTestCurso(user,curso);
		this.curso = curso;
		this.user = user;
		
		// TODO Auto-generated constructor stub
	}
	
	public JPanel getPanel() {
		return vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Atr\\u00E1s")) {
			CtrInformacionCursoCuestionario ctr = new CtrInformacionCursoCuestionario(user, curso);
			Main.setPanel(ctr.getPanel());
		}
		
		if(e.getActionCommand().equals("Guardar")) {
			
		}
	}

}
