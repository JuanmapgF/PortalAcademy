package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JPanel;

import Modelo.*;
import Vista.*;

public class CtrExplorar implements ActionListener {
	
	private Explorar ventana;
	private Menu menu;
	
	public CtrExplorar(Explorar v, Menu m) {
		ventana = v;
		ventana.controlador(this);
		menu = m;
		menu.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("INICIAR_SESION")) {
			CtrInicio c = new CtrInicio(new Inicio());
			Main.setCPane(c.getPanel());
		}
		
		if (e.getActionCommand().equals("CERRAR_SESION")) {
			try {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()), new Menu(null));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if (e.getActionCommand().equals("REGISTRO")) {
			CtrRegistro c = new CtrRegistro(new Registro());
			Main.setPanel(c.getPanel());
		}
		
	}
	
	public JPanel getPanel() {
		JPanel pane = new JPanel();
		pane.removeAll();
		pane.invalidate();
		pane.add(ventana);
		pane.add(menu);
		pane.revalidate();
		
		return pane;
	}

}
