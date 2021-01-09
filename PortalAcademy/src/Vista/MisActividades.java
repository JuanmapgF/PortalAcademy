package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;

import Controlador.CtrMenu;
import Modelo.Actividad;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;

@SuppressWarnings("serial")
public class MisActividades extends JPanel {

	private JTable actividades;
	private ButtonEditorActividad editorActividad = new ButtonEditorActividad(new JTextField());
	private List<Actividad> l;
	private Object[][] datos = null;
	
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
		
		this.setBounds(0, 0, 1920, 1080);
		u.setListaActividades();
		l = u.getListaActividades();
		
		datosTabla();
		
		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(591, 275, 465, 500);
		sp_actividad.setViewportView(actividades);
		sp_actividad.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_actividad);
		sp_actividad.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		actividades.setRowHeight(75);
		actividades.setShowVerticalLines(false);
		actividades.getColumnModel().getColumn(0).setMaxWidth(75);
		actividades.getColumnModel().getColumn(0).setMinWidth(75);
//		actividades.getColumnModel().getColumn(1).setMaxWidth(315);
//		actividades.getColumnModel().getColumn(1).setMinWidth(315);
		
		JLabel t_actividad = new JLabel("Mis actividades");
		t_actividad.setFont(new Font("Tahoma", Font.PLAIN, 40));
		t_actividad.setBounds(682, 123, 265, 56);
		add(t_actividad);
		
		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public MisActividades(Organizacion u) {
		organizacion = true;
		org = u;
		this.setLayout(null);
		this.setBounds(0, 0, 1920, 1080);
		
		l = u.getActividades();
		datosTabla();
		
		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(591, 275, 465, 500);
		sp_actividad.setViewportView(actividades);
		sp_actividad.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_actividad);
		sp_actividad.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		actividades.setRowHeight(75);
		actividades.setShowVerticalLines(false);
		actividades.getColumnModel().getColumn(0).setMaxWidth(75);
		actividades.getColumnModel().getColumn(0).setMinWidth(75);
//		actividades.getColumnModel().getColumn(1).setMaxWidth(315);
//		actividades.getColumnModel().getColumn(1).setMinWidth(315);
		
		crearActividad = new JButton("Crear actividad");
		crearActividad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		crearActividad.setBounds(1175, 403, 171, 40);
		add(crearActividad);
		
		JLabel t_actividad = new JLabel("Mis actividades");
		t_actividad.setFont(new Font("Tahoma", Font.PLAIN, 40));
		t_actividad.setBounds(682, 123, 265, 56);
		add(t_actividad);
		
		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());
	}
	
	public MisActividades(Profesor u) {
		profesor = true;
		prof = u;
		this.setLayout(null);
		
		this.setBounds(0, 0, 1920, 1080);
		l = u.getActividades();
		datosTabla();
		
		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(591, 275, 465, 500);
		sp_actividad.setViewportView(actividades);
		sp_actividad.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_actividad);
		sp_actividad.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		actividades.setRowHeight(75);
		actividades.setShowVerticalLines(false);
		actividades.getColumnModel().getColumn(0).setMaxWidth(75);
		actividades.getColumnModel().getColumn(0).setMinWidth(75);
//		actividades.getColumnModel().getColumn(1).setMaxWidth(315);
//		actividades.getColumnModel().getColumn(1).setMinWidth(315);
		
		JLabel t_actividad = new JLabel("Mis actividades");
		t_actividad.setFont(new Font("Tahoma", Font.PLAIN, 40));
		t_actividad.setBounds(682, 123, 265, 56);
		add(t_actividad);
		
		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());
	}
	
	public Actividad getActividad() {
		return l.get(actividades.getSelectedRow());
	}
	
	public void controlador(ActionListener ctr) {
		editorActividad.controladorMisActividades(ctr);
		
		if (crearActividad != null) {
		crearActividad.addActionListener(ctr);
		crearActividad.setActionCommand("CREARACTIVIDAD");
		}
		
	}
	
	private void datosTabla() {
		datos = new Object[l.size()][2];
		
		int k = 0;
		for (Actividad a : l) {
			datos[k][0] = a.getImagen();
			datos[k][1] = a.getNombre();
			k++;
		}
		
		String[] columnHeaders = {"Imagen", "Actividad"};
		
		actividades = new JTable(datos, columnHeaders);
		actividades.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(true));
		actividades.getColumnModel().getColumn(1).setCellEditor(editorActividad);
		actividades.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		actividades.setTableHeader(null);
		actividades.setCellSelectionEnabled(false);
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
