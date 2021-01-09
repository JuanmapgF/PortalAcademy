package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.BD;
import Modelo.Curso;
import Modelo.Usuario;
import Vista.InformacionCursoCuestionarios;
import Vista.Main;

public class CtrInformacionCursoCuestionario implements ActionListener{
	
	private InformacionCursoCuestionarios vista;
	private Curso curso;
	private Usuario user;
	
	

	
	public CtrInformacionCursoCuestionario(Usuario user, Curso c) {
		vista = new InformacionCursoCuestionarios(user,c);
		curso = c;
		this.user = user;
		// TODO Auto-generated constructor stub
	}

	public JPanel getPanel() {
		return vista;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Crear")) {
			curso.setSatisfaccion(true);
		}
		
		if(e.getActionCommand().equals("Borrar")) {
			curso.setSatisfaccion(false);
		}
		
		
	}

}
