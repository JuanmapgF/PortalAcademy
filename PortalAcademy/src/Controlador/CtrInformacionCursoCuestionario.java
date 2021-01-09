package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

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
		
		vista.bCuestionarios.addActionListener(this);
		vista.bHacerCuestionario.addActionListener(this);
		vista.bInicio.addActionListener(this);
		// TODO Auto-generated constructor stub
	}

	public JPanel getPanel() {
		return vista;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}

}
