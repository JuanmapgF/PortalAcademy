package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Modelo.Actividad;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;

@SuppressWarnings("serial")
public class MisActividades extends JPanel {

	private DefaultListModel<String> modeloA = new DefaultListModel<String>();
	private JList<String> listaA = new JList<String>();
	private JButton bVer = new JButton();
	private JButton bVer2 = new JButton();
	private List<Actividad> l;
	
	private Estudiante est = null;
	private Organizacion org = null;
	private Profesor prof = null;
	private boolean estudiante = false;
	private boolean organizacion = false;
	private boolean profesor = false;
	
	private JButton crearActividad;
	private JButton cerrar;
	private JButton explorar;
	private JButton cursos;
	private JButton actividades;
	private JButton ajustes;
	
	
	public MisActividades(Estudiante u) {
		estudiante = true;
		est = u;
		this.setLayout(null);
		addElements(u.getActividades());
		
		JScrollPane sp_actividades = new JScrollPane();
		sp_actividades.setBounds(441, 175, 346, 346);
		sp_actividades.setViewportView(listaA);
		add(sp_actividades);
		
		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);
		
		JLabel t_actividad = new JLabel("Mis actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		t_actividad.setBounds(503, 115, 209, 33);
		add(t_actividad);
		
		this.setBounds(0, 0, 1080, 650);
		
		bVer = new JButton("Ver actividad");
		bVer.setBounds(544, 551, 153, 23);
		add(bVer);
		
		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);
		
		cursos = new JButton("Mis cursos");
		cursos.setBounds(36, 261, 131, 32);
		add(cursos);
		
		actividades = new JButton("Mis actividades");
		actividades.setForeground(Color.BLUE);
		actividades.setBounds(36, 336, 131, 32);
		add(actividades);
		
		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 413, 131, 32);
		add(ajustes);
		
		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 121, 20);
		add(lblNewLabel_2);
	}
	
	public MisActividades(Organizacion u) {
		organizacion = true;
		org = u;
		this.setLayout(null);
		addElements(u.getActividades());
		
		JScrollPane sp_actividades = new JScrollPane();
		sp_actividades.setBounds(441, 175, 346, 346);
		sp_actividades.setViewportView(listaA);
		add(sp_actividades);
		
		crearActividad = new JButton("Crear actividad");
		crearActividad.setBounds(860, 551, 151, 23);
		add(crearActividad);
		
		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);
		
		JLabel t_actividad = new JLabel("Mis actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		t_actividad.setBounds(503, 115, 209, 33);
		add(t_actividad);
		
		this.setBounds(0, 0, 1080, 650);
		
		bVer2 = new JButton("Ver actividad");
		bVer2.setBounds(544, 551, 153, 23);
		add(bVer2);
		
		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);
		
		actividades = new JButton("Mis actividades");
		actividades.setForeground(Color.BLUE);
		actividades.setBounds(36, 261, 131, 32);
		add(actividades);
		
		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 336, 131, 32);
		add(ajustes);
		
		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 121, 20);
		add(lblNewLabel_2);
	}
	
	public void addElements(List<Actividad> l) {
		this.l = l;
		listaA.setModel(modeloA);
		
		for (Object o : l) {
			modeloA.addElement(o.toString());
		}
		
		listaA.setLayoutOrientation(JList.VERTICAL);
	}
	
	public Actividad getA(){
		if(!listaA.isSelectionEmpty()) {
			return l.get(listaA.getSelectedIndex());
		}else {
			return null;
		}
	}
	
	public void controlador(ActionListener ctr) {
		bVer.addActionListener(ctr);
		bVer.setActionCommand("MISACTIVIDADESUSUARIO");
		
		bVer2.addActionListener(ctr);
		bVer2.setActionCommand("MISACTIVIDADESORGANIZACION");
		
		if (crearActividad != null) {
		crearActividad.addActionListener(ctr);
		crearActividad.setActionCommand("CREARACTIVIDAD");
		}
		
		if (explorar != null) {
			explorar.addActionListener(ctr);
			explorar.setActionCommand("EXPLORAR");
		}
		if (cursos != null) {
			cursos.addActionListener(ctr);
			cursos.setActionCommand("CURSO");
		}
		if (actividades != null) {
			actividades.addActionListener(ctr);
			actividades.setActionCommand("ACTIVIDAD");
		}
		if (ajustes != null) {
			ajustes.addActionListener(ctr);
			ajustes.setActionCommand("AJUSTES");
		}
		
		if (cerrar != null) {
			cerrar.addActionListener(ctr);
			cerrar.setActionCommand("CERRAR_SESION");
		} 
	}
	
	public boolean esEstudiante() {
		return estudiante;
	}
	
	public boolean esOrganizacion() {
		return organizacion;
	}
	
	public boolean esProfesor() {
		return profesor;
	}
	
	public Estudiante getEstudiante() {
		return est;
	}
	
	public Organizacion getOrganizacion() {
		return org;
	}
	
	public Profesor getProfesor() {
		return prof;
	}

}
