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
		
		JLabel nombreCurso = new JLabel(actividad.getNombre());
		nombreCurso.setBounds(429, 189, 364, 33);
		nombreCurso.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(nombreCurso);
		
		if(esCreador() || actividad.getSatisfaccion()) {
			JLabel labelCuestionario = new JLabel("Cuestionario de satisfacci\u00F3n");
			labelCuestionario.setFont(new Font("Tahoma", Font.BOLD, 30));
			labelCuestionario.setBounds(647, 776, 435, 52);
			add(labelCuestionario);
		}
		
		if(actividad.getSatisfaccion() && !esCreador()) {
			bHacerCuestionario = new JButton("Hacer");
			bHacerCuestionario.setFont(new Font("Tahoma", Font.PLAIN, 20));
			bHacerCuestionario.setBounds(1159, 783, 104, 46);
			add(bHacerCuestionario);
		}
		
		if(!actividad.getSatisfaccion() && esCreador()) {
			bCrear = new JButton("Crear");
			bCrear.setFont(new Font("Tahoma", Font.PLAIN, 20));
			bCrear.setBounds(1174, 786, 89, 40);
			add(bCrear);
		
		}
		
		if(actividad.getSatisfaccion() && esCreador()) {
			bBorrar = new JButton("Borrar");
			bBorrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
			bBorrar.setBounds(1297, 786, 101, 40);
			add(bBorrar);
		}
		
		if(user instanceof Profesor) {
			CtrMenu menu = new CtrMenu(new Menu((Profesor)user, actividad));
			add(menu.getPanel());
		}else if(user instanceof Organizacion){
			CtrMenu menu = new CtrMenu(new Menu((Organizacion)user, actividad));
			add(menu.getPanel());
		} else if (user instanceof Estudiante) {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante)user, actividad));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu(actividad));
			add(menu.getPanel());
		}
		
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
