package Vista;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
public class InformacionActividadCuestionarios extends JPanel{
	private Usuario user;
	private Actividad actividad;
	
	public JButton bHacerCuestionario, bCrear, bBorrar;
	
	public InformacionActividadCuestionarios(Usuario user, Actividad actividad) {
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
			bHacerCuestionario = new JButton(new ImageIcon(getClass().getResource("/img/hacer.png")));
			bHacerCuestionario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			bHacerCuestionario.setContentAreaFilled(false);
			bHacerCuestionario.setFocusPainted(false);
			bHacerCuestionario.setBorderPainted(false);
			bHacerCuestionario.setBounds(1159, 783, 142, 52);
			add(bHacerCuestionario);
		}
		
		if(!actividad.getSatisfaccion() && esCreador()) {
			bCrear = new JButton(new ImageIcon(getClass().getResource("/img/crear.png")));
			bCrear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			bCrear.setContentAreaFilled(false);
			bCrear.setFocusPainted(false);
			bCrear.setBorderPainted(false);
			bCrear.setBounds(1174, 786, 142, 52);
			add(bCrear);
		
		}
		
		if(actividad.getSatisfaccion() && esCreador()) {
			bBorrar = new JButton(new ImageIcon(getClass().getResource("/img/borrar.png")));
			bBorrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			bBorrar.setContentAreaFilled(false);
			bBorrar.setFocusPainted(false);
			bBorrar.setBorderPainted(false);
			bBorrar.setBounds(1297, 786, 142, 52);
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
