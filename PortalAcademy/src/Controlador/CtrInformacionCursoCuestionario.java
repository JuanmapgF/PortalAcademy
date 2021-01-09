package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Curso;
import Vista.InformacionCursoCuestionarios;

public class CtrInformacionCursoCuestionario implements ActionListener{
	
	private InformacionCursoCuestionarios vista;
	private Curso curso;
	
	public CtrInformacionCursoCuestionario(InformacionCursoCuestionarios v, Curso c) {
		vista = v;
		curso = c;
		
		vista.bCuestionarios.addActionListener(this);
		vista.bHacerCuestionario.addActionListener(this);
		vista.bInicio.addActionListener(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vista.bInicio) {
			
		}
	}

}
