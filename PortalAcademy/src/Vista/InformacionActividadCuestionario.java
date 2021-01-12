package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.CtrMenu;
import Modelo.Actividad;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class InformacionActividadCuestionario extends JPanel{
	private Usuario user;
	private Actividad actividad;
	
	public JButton bHacerCuestionario, bCrear, bBorrar;
	
	public InformacionActividadCuestionario(Usuario user, Actividad actividad) {
		this.user = user;
		this.actividad = actividad;
		
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		if(esCreador() || actividad.getSatisfaccion()) {
			JLabel labelCuestionario = new JLabel("Cuestionario de satisfacci\u00F3n");
			labelCuestionario.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
			labelCuestionario.setBounds(427, 339, 264, 22);
			add(labelCuestionario);
		}
		
		if(actividad.getSatisfaccion() && !esCreador()) {
			bHacerCuestionario = new JButton("Hacer");
			bHacerCuestionario.setFont(new Font("Tahoma", Font.PLAIN, 18));
			bHacerCuestionario.setBounds(745, 336, 79, 29);
			add(bHacerCuestionario);
		}
		
		if(!actividad.getSatisfaccion() && esCreador()) {
			bCrear = new JButton("Crear");
			bCrear.setFont(new Font("Tahoma", Font.PLAIN, 18));
			bCrear.setBounds(966, 332, 75, 31);
			add(bCrear);
			bCrear.setVisible(false);
		}
		
		if(actividad.getSatisfaccion() && esCreador()) {
			bBorrar = new JButton("Borrar");
			bBorrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
			bBorrar.setBounds(1051, 332, 83, 31);
			add(bBorrar);
			bBorrar.setVisible(false);
		}
		
		if(user instanceof Profesor) {
			CtrMenu menu = new CtrMenu(new Menu((Profesor)user));
			add(menu.getPanel());
		}else if(user instanceof Organizacion){
			CtrMenu menu = new CtrMenu(new Menu((Organizacion)user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante)user));
			add(menu.getPanel());
		}
		
//		CtrMenuCurso menuc = new CtrMenuCurso(new MenuActividad(actividad));
//		add(menuc.getPanel());
		
		
	}
	
	private boolean esCreador() {
		if (Main.getUser() == null) {
			return false;
		}
		return Main.getUser().equals(actividad.getOrganizacion());
	}
	
	public void controlador(ActionListener ctr) {
		if(bBorrar != null) {
			this.bBorrar.addActionListener(ctr);
			this.bBorrar.setActionCommand("BORRAR");
		}
		
		if(bCrear != null) {
			this.bCrear.addActionListener(ctr);
			this.bCrear.setActionCommand("CREAR");
		}
		
		if(bHacerCuestionario != null) {
			this.bHacerCuestionario.addActionListener(ctr);
			this.bHacerCuestionario.setActionCommand("HACER");
		}
		
	}
	
}
