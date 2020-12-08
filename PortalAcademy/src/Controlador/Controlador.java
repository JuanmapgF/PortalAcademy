package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.*;

import Modelo.*;
import Vista.*;

public class Controlador implements ActionListener {
	
	private Explorar explorar;
	private Inicio inicio;
	private Registro registro;
	private Menu menu;
	
	private JPanel panel;
	
	public void setVista(JPanel v) {
		panel = v;
		tipo(panel);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	private void tipo(JPanel p) {
		if (p instanceof Explorar) {
			explorar = (Explorar) p;
		} else if (p instanceof Inicio) {
			inicio = (Inicio) p;
		} else if (p instanceof Registro) {
			registro = (Registro) p;
		} else if (p instanceof Menu) {
			menu = (Menu) p;
		}
	}
	
	public void setVista(JPanel m, JPanel e) {
		JPanel contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1080, 650);
		contentPane.add(m);
		contentPane.add(e);
		
		panel = contentPane;
		
		tipo(m);
		tipo(e);
	}
	
	public Controlador() {
		setVista(new Inicio());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("INICIAR")) {
			tipo(panel);
			Usuario u = new Usuario(inicio.getUser(), inicio.getPass());
			List<Usuario> users = Usuario.getUsuarios();
			Usuario ini;
			
			for (Usuario us : users) {
				if (us.equals(u)) {
					ini = us;
					System.out.println("123");
					if (ini instanceof Estudiante) {
						
						Menu m = new Menu(ini);
						Explorar ex = null;
						try {
							ex = new Explorar(ini, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						setVista(m,ex);
					} else {
						Menu m = new Menu(ini);
						Explorar ex = null;
						try {
							ex = new Explorar(ini, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		}
		
		if (e.getActionCommand().equals("REGISTRATE")) {
			setVista(new Registro());
			System.out.println(1);
			Prueba.anyadirVentana(Prueba.getVentana(), getPanel());
		}
		
		
		
	}

	public Explorar getExplorar() {
		return explorar;
	}

	public void setExplorar(Explorar explorar) {
		this.explorar = explorar;
	}

	public Inicio getInicio() {
		return inicio;
	}

	public void setInicio(Inicio inicio) {
		this.inicio = inicio;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}
