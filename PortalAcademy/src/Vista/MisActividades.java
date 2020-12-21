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

import Controlador.CtrMenu;
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
	private JButton bVer3 = new JButton();
	private List<Actividad> l;
	
	private Estudiante est = null;
	private Organizacion org = null;
	private Profesor prof = null;
	private boolean estudiante = false;
	private boolean organizacion = false;
	private boolean profesor = false;
	
	private JButton crearActividad;
	
	
	public MisActividades(Estudiante u) {
		estudiante = true;
		est = u;
		this.setLayout(null);
		addElements(u.getActividades());
		
		JScrollPane sp_actividades = new JScrollPane();
		sp_actividades.setBounds(441, 175, 346, 346);
		sp_actividades.setViewportView(listaA);
		add(sp_actividades);
		
		JLabel t_actividad = new JLabel("Mis actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		t_actividad.setBounds(503, 115, 209, 33);
		add(t_actividad);
		
		this.setBounds(0, 0, 1080, 650);
		
		bVer = new JButton("Ver actividad");
		bVer.setBounds(544, 551, 153, 23);
		add(bVer);
		
		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());
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
		
		JLabel t_actividad = new JLabel("Mis actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		t_actividad.setBounds(503, 115, 209, 33);
		add(t_actividad);
		
		this.setBounds(0, 0, 1080, 650);
		
		bVer2 = new JButton("Ver actividad");
		bVer2.setBounds(544, 551, 153, 23);
		add(bVer2);
		
		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());
	}
	
	public MisActividades(Profesor u) {
		profesor = true;
		prof = u;
		this.setLayout(null);
		addElements(u.getActividades());
		
		JScrollPane sp_actividades = new JScrollPane();
		sp_actividades.setBounds(441, 175, 346, 346);
		sp_actividades.setViewportView(listaA);
		add(sp_actividades);
		
		JLabel t_actividad = new JLabel("Mis actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		t_actividad.setBounds(503, 115, 209, 33);
		add(t_actividad);
		
		this.setBounds(0, 0, 1080, 650);
		
		bVer3 = new JButton("Ver actividad");
		bVer3.setBounds(544, 551, 153, 23);
		add(bVer3);
		
		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());
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
		
		bVer3.addActionListener(ctr);
		bVer3.setActionCommand("MISACTIVIDADESPROFESOR");
		
		if (crearActividad != null) {
		crearActividad.addActionListener(ctr);
		crearActividad.setActionCommand("CREARACTIVIDAD");
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
