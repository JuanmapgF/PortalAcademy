package Vista;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Modelo.Actividad;

@SuppressWarnings("serial")
public class AdminActividades extends JPanel {

	public JButton bCerrarSesion, bInicio, bCursos_1, bActividades_1, bUsuarios_1, bAjustes;
	private JTextField txtBuscarActividad;
	
	private DefaultListModel<String> modeloA = new DefaultListModel<String>();
	private JList<String> listA = new JList<String>();

	/**
	 * Create the panel.
	 */
	public AdminActividades() {
		
		//para mostrar la lista de actividades en el scrollpanel
		listA.setModel(modeloA);
		for (Actividad d : Actividad.getTodasLasActividades()) {
			modeloA.addElement(d.toString());
		}
		listA.setLayoutOrientation(JList.VERTICAL);
		//--------------------------------------------------------
		
		setLayout(null);
		this.setBounds(0,0,1080,650);
		
		 bInicio = new JButton("Inicio");
		bInicio.setBounds(10, 85, 91, 21);
		add(bInicio);
		
		 bCursos_1 = new JButton("Cursos");
		bCursos_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bCursos_1.setBounds(10, 116, 91, 23);
		add(bCursos_1);
		
		 bActividades_1 = new JButton("Actividades");
		bActividades_1.setForeground(Color.BLUE);
		bActividades_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bActividades_1.setBounds(10, 149, 91, 23);
		add(bActividades_1);
		
		 bUsuarios_1 = new JButton("Usuarios");
		bUsuarios_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bUsuarios_1.setBounds(10, 182, 91, 23);
		add(bUsuarios_1);
		
		 bAjustes = new JButton("Ajustes");
		bAjustes.setFont(new Font("Calibri", Font.PLAIN, 12));
		bAjustes.setBounds(10, 215, 91, 21);
		add(bAjustes);
		
		 bCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		bCerrarSesion.setVerticalAlignment(SwingConstants.TOP);
		bCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		bCerrarSesion.setFont(new Font("Calibri", Font.PLAIN, 12));
		bCerrarSesion.setBounds(973, 10, 97, 23);
		add(bCerrarSesion);
		
		JLabel lblNewLabel_1 = new JLabel("Actividades");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(160, 54, 349, 74);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setBounds(429, 627, 222, 13);
		add(lblNewLabel);
		
		txtBuscarActividad = new JTextField();
		txtBuscarActividad.setText("Buscar actividad");
		txtBuscarActividad.setForeground(Color.LIGHT_GRAY);
		txtBuscarActividad.setFont(new Font("Calibri", Font.PLAIN, 10));
		txtBuscarActividad.setColumns(10);
		txtBuscarActividad.setBounds(190, 148, 370, 25);
		add(txtBuscarActividad);
		
		JScrollPane spActivadades = new JScrollPane();
		spActivadades.setBounds(190, 195, 700, 400);
		spActivadades.setViewportView(listA);
		add(spActivadades);
		
	}
}
