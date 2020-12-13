package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import Modelo.BD;
import Modelo.Curso;
import Modelo.Usuario;
import Vista.Inicio;
import Vista.Main;
import Vista.MisCursos;
import Vista.Registro;

public class CtrMisCursos implements ActionListener {
	
	private MisCursos ventana;
	
	public CtrMisCursos(MisCursos v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("MISCURSOSUSUARIO")) {
			Curso c = ventana.getC();
			if(c!=null) {
				//CtrRegistro cr = new CtrRegistro(new Registro());
				//Main.setPanel(cr.getPanel());
			}	
		}
		
		if (e.getActionCommand().equals("MISCURSOSPROFESOR")) {
			Curso c = ventana.getC();
			if(c!=null) {
				//CtrRegistro cr = new CtrRegistro(new Registro());
				//Main.setPanel(cr.getPanel());
			}
		}
	}
	
	public JPanel getPanel() {
		return ventana;
	}
	
	public void visible(Boolean b) {
		ventana.setVisible(b);
	}
}
