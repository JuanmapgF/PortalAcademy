package Vista;

import java.awt.Cursor;
import java.awt.Font;

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
		
		
		JLabel labelCuestionario = new JLabel("Cuestionario de satisfacci\u00F3n");
		labelCuestionario.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
		labelCuestionario.setBounds(427, 339, 264, 22);
		add(labelCuestionario);
		
		bHacerCuestionario = new JButton(new ImageIcon(getClass().getResource("/img/hacer.png")));
		bHacerCuestionario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bHacerCuestionario.setContentAreaFilled(false);
		bHacerCuestionario.setFocusPainted(false);
		bHacerCuestionario.setBorderPainted(false);
		bHacerCuestionario.setBounds(745, 336, 142, 52);
		add(bHacerCuestionario);
		
		bCrear = new JButton(new ImageIcon(getClass().getResource("/img/crear.png")));
		bCrear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bCrear.setContentAreaFilled(false);
		bCrear.setFocusPainted(false);
		bCrear.setBorderPainted(false);
		bCrear.setBounds(966, 332, 142, 52);
		add(bCrear);
		bCrear.setVisible(false);
		
		bBorrar = new JButton(new ImageIcon(getClass().getResource("/img/borrar.png")));
		bBorrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bBorrar.setContentAreaFilled(false);
		bBorrar.setFocusPainted(false);
		bBorrar.setBorderPainted(false);
		bBorrar.setBounds(1051, 332, 142, 52);
		add(bBorrar);
		bBorrar.setVisible(false);
		
		if(user instanceof Profesor) {
			CtrMenu menu = new CtrMenu(new Menu((Profesor)user));
			add(menu.getPanel());
			
			if(actividad.getSatisfaccion()) {
				bBorrar.setVisible(true);
			}else {
				bCrear.setVisible(true);
			}
			
		}else if(user instanceof Organizacion){
			CtrMenu menu = new CtrMenu(new Menu((Organizacion)user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante)user));
			add(menu.getPanel());
		}
	}
	
	
}
