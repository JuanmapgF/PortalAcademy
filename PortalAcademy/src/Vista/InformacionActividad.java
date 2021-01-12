package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controlador.CtrMenu;
import Modelo.Actividad;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;
@SuppressWarnings("serial")
public class InformacionActividad extends JPanel {


	
	/**
	 * Create the panel.
	 */
	public InformacionActividad(Actividad actividad, Usuario user) {
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(499, 746, 81, 27);
		add(lblFecha);
		
		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLugar.setBounds(499, 794, 81, 27);
		add(lblLugar);
		
		JLabel nombreActividad = new JLabel(actividad.getNombre());
		nombreActividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		nombreActividad.setBounds(416, 190, 364, 33);
		add(nombreActividad);
		
		JTextArea descripcionActividad = new JTextArea(actividad.getDescripcion());
		descripcionActividad.setEditable(false);
		JScrollPane jsp = new JScrollPane(descripcionActividad);
		jsp.setBounds(499, 504, 652, 185);
		add(jsp);
		
		JLabel fecha = new JLabel(actividad.getFecha().toString());
		fecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fecha.setBounds(620, 746, 378, 27);
		add(fecha);
		
		JLabel lugar = new JLabel(actividad.getLugar());
		lugar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lugar.setBounds(619, 794, 344, 27);
		add(lugar);
		
		if (user == null) {
			CtrMenu menu = new CtrMenu(new Menu(actividad));
			add(menu.getPanel());
		} else if (user instanceof Organizacion) {
			CtrMenu menu = new CtrMenu(new Menu((Organizacion)user, actividad));
			add(menu.getPanel());
		} else if(user instanceof Profesor){
			CtrMenu menu = new CtrMenu(new Menu((Profesor)user, actividad));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante)user, actividad));
			add(menu.getPanel());
		}
		
	}

}
