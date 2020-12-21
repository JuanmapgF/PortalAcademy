package Vista;

import java.awt.Color;
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

	private JButton editar;

	
	/**
	 * Create the panel.
	 */
	public InformacionActividad(Actividad actividad, Usuario user) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(278, 336, 63, 14);
		add(lblFecha);
		
		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLugar.setBounds(278, 382, 63, 14);
		add(lblLugar);
		
		JLabel nombreActividad = new JLabel(actividad.getNombre());
		nombreActividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		nombreActividad.setBounds(428, 34, 364, 33);
		add(nombreActividad);
		
		JTextArea descripcionActividad = new JTextArea(actividad.getDescripcion());
		descripcionActividad.setEditable(false);
		JScrollPane jsp = new JScrollPane(descripcionActividad);
		jsp.setBounds(278, 102, 652, 185);
		add(jsp);
		
		JLabel fecha = new JLabel(actividad.getFecha().toString());
		fecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fecha.setBounds(382, 336, 377, 14);
		add(fecha);
		
		JLabel lugar = new JLabel(actividad.getLugar());
		lugar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lugar.setBounds(382, 384, 342, 14);
		add(lugar);
		
		if (user == null) {
			CtrMenu menu = new CtrMenu(new Menu());
			add(menu.getPanel());
		} else if (user instanceof Organizacion) {
			editar = new JButton("Editar");
			editar.setBounds(752, 68, 89, 23);
			add(editar);
			
			CtrMenu menu = new CtrMenu(new Menu((Organizacion)user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Profesor)user));
			add(menu.getPanel());
		} 
		
	}
	
	public void controlador(ActionListener ctr) {	
		if (editar != null) {
			editar.addActionListener(ctr);
			editar.setActionCommand("Editar");
		}
	}

}
