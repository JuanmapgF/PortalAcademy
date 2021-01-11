package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.BD;
import Modelo.Curso;
import Modelo.ErrorBD;
import Modelo.Usuario;
import Vista.AdminCursos;
import Vista.CrearTestCurso;
import Vista.InformacionCursoCuestionarios;
import Vista.Main;

public class CtrCrearTestCurso implements ActionListener{
	
	private CrearTestCurso vista;
	private Curso curso;
	private Usuario user;
	private static BD bd;
	
	private String nombre, descripccion, link;
	
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
			
			try {
				if (!nombreValido()) {
					throw new ErrorBD("El nombre no puede estar vac�o.");
					
				}else if (!descripcionValida()) {
					throw new ErrorBD("La descripci�n no puede estar vac�a.");
					
				}else if (!linkValido()) {
					throw new ErrorBD("El link no puede estar vac�o");
					
				}else {
					nombre = vista.tfNombre.getText();
					descripccion = vista.tfDescripccion.getText();
					link = vista.tfLink.getText();
					
					
					bd = BD.getBD();
					bd.Insert("INSERT INTO Test (idCurso,nombre,descripccion,link) VALUES (" + curso.getId() + ",'" + nombre + "', '"+ descripccion +
							"', '"+ link+"')");
					bd.finalize();
					
					JOptionPane.showMessageDialog(vista,
							"El test " + nombre + " ha sido creado satisfactoriamente.", "Test creado",JOptionPane.INFORMATION_MESSAGE);
					
					CtrInformacionCursoCuestionario c = new CtrInformacionCursoCuestionario(user, curso);
					Main.setPanel(c.getPanel());
				}

			} catch (ErrorBD err) {
				JOptionPane.showMessageDialog(vista, err.getMessage(), "Error crear test", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}

	
	
	private boolean descripcionValida() {
		return !(vista.tfDescripccion.getText().isEmpty() || vista.tfDescripccion.getText() == null);
	}

	private boolean nombreValido() {
		return !(vista.tfNombre.getText().isEmpty() || vista.tfNombre.getText() == null);
	}
	
	private boolean linkValido() {
		return !(vista.tfLink.getText().isEmpty() || vista.tfLink.getText() == null);
	}
}
