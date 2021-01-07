package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;

import Controlador.CtrCalendario;
import Controlador.CtrMenu;
import Modelo.Actividad;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;

public class Calendario extends JPanel {
	
	
	private DefaultListModel<String> modeloC = new DefaultListModel<String>();
	private JList<String> listaC = new JList<String>();
	private List<Actividad> l;
	private DefaultListModel<String> modeloC2 = new DefaultListModel<String>();
	private JList<String> listaC2 = new JList<String>();
	private JButton bVer = new JButton();
	private JButton bVer2 = new JButton();
	private JButton bAnadir = new JButton();
	private JTextField textField = new JTextField();;
	JDateChooser dateChooser = new JDateChooser();
	
	private Estudiante est = null;
	private Organizacion org = null;
	private Profesor prof = null;
	private boolean estudiante = false;
	private boolean organizacion = false;
	private boolean profesor = false;
	
	public Calendario (Date d) {
			this.setBounds(0, 0, 1080, 650);
			setLayout(null);
			
			addElements(Actividad.getActividadFecha(d));
			
			JScrollPane sp_ac = new JScrollPane();
			sp_ac.setBounds(375, 225, 346, 346);
			sp_ac.setViewportView(listaC);
			add(sp_ac);
			
			bVer = new JButton("Ver actividad");
			bVer.setBounds(752, 412, 151, 23);
			add(bVer);
			
			Calendar cal = Calendar.getInstance();
		    cal.setTime(d);
			JLabel lblNewLabel = new JLabel("Eventos del día " + cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR));
			lblNewLabel.setBounds(381, 149, 403, 33);
			lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
			add(lblNewLabel);
			
			
			CtrMenu menu = new CtrMenu(new Menu());
			add(menu.getPanel());
		}
		
		public Calendario(Profesor p, Date d) {
			prof = p;
			profesor = true;
			this.setBounds(0, 0, 1080, 650);
			setLayout(null);

			addElements(p.getActividadesFecha(d));
			addElements2(p.getInformacion(d));

			JLabel lblNewLabel2 = new JLabel("Mis actividades");
			lblNewLabel2.setBounds(375, 169, 151, 33);
			lblNewLabel2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
			add(lblNewLabel2);

			JLabel lblNewLabel5 = new JLabel("Fecha:");
			lblNewLabel5.setBounds(755, 432, 151, 23);
			lblNewLabel5.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
			add(lblNewLabel5);

			JLabel lblNewLabel6 = new JLabel("Información:");
			lblNewLabel6.setBounds(755, 490, 151, 23);
			lblNewLabel6.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
			add(lblNewLabel6);

			JLabel lblNewLabel3 = new JLabel("Mis eventos");
			lblNewLabel3.setBounds(375, 386, 126, 33);
			lblNewLabel3.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
			add(lblNewLabel3);

			JScrollPane sp_ac = new JScrollPane();
			sp_ac.setBounds(375, 205, 346, 170);
			sp_ac.setViewportView(listaC);
			add(sp_ac);

			JScrollPane sp_ac2 = new JScrollPane();
			sp_ac2.setBounds(375, 420, 346, 170);
			sp_ac2.setViewportView(listaC2);
			add(sp_ac2);

			bVer2 = new JButton("Ver actividad");
			bVer2.setBounds(755, 300, 151, 23);
			add(bVer2);

			bAnadir = new JButton("Añadir evento");
			bAnadir.setBounds(755, 547, 151, 23);
			add(bAnadir);

			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			JLabel lblNewLabel = new JLabel("Eventos del día " + cal.get(Calendar.DAY_OF_MONTH) + "/"
					+ (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR));
			lblNewLabel.setBounds(385, 100, 403, 33);
			lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
			add(lblNewLabel);

			dateChooser.setBounds(755, 456, 151, 23);
			add(dateChooser);

			textField.setBackground(Color.WHITE);
			textField.setBounds(755, 513, 151, 23);
			add(textField);
			textField.setColumns(10);

			CtrMenu menu = new CtrMenu(new Menu(p));
			add(menu.getPanel());
		}
	
		
		public Calendario (Estudiante e, Date d) {
			est = e;
			estudiante = true;
			this.setBounds(0, 0, 1080, 650);
			setLayout(null);
			
			addElements(e.getActividadesFecha(d));
			addElements2(e.getInformacion(d));
			
			
			JLabel lblNewLabel2 = new JLabel("Mis actividades");
			lblNewLabel2.setBounds(375, 169, 151, 33);
			lblNewLabel2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
			add(lblNewLabel2);
			
			JLabel lblNewLabel5 = new JLabel("Fecha:");
			lblNewLabel5.setBounds(755, 432, 151, 23);
			lblNewLabel5.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
			add(lblNewLabel5);
			
			JLabel lblNewLabel6 = new JLabel("Información:");
			lblNewLabel6.setBounds(755, 490, 151, 23);
			lblNewLabel6.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
			add(lblNewLabel6);
			
			JLabel lblNewLabel3 = new JLabel("Mis eventos");
			lblNewLabel3.setBounds(375, 386, 126, 33);
			lblNewLabel3.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
			add(lblNewLabel3);
			
			JScrollPane sp_ac = new JScrollPane();
			sp_ac.setBounds(375, 205, 346, 170);
			sp_ac.setViewportView(listaC);
			add(sp_ac);
			
			JScrollPane sp_ac2 = new JScrollPane();
			sp_ac2.setBounds(375, 420, 346, 170);
			sp_ac2.setViewportView(listaC2);
			add(sp_ac2);
			
			bVer2 = new JButton("Ver actividad");
			bVer2.setBounds(755, 300, 151, 23);
			add(bVer2);
			
			bAnadir = new JButton("Añadir evento");
			bAnadir.setBounds(755, 547, 151, 23);
			add(bAnadir);
			
			Calendar cal = Calendar.getInstance();
		    cal.setTime(d);
			JLabel lblNewLabel = new JLabel("Eventos del día " + cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR));
			lblNewLabel.setBounds(385, 100, 403, 33);
			lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
			add(lblNewLabel);
			
			dateChooser.setBounds(755, 456, 151, 23);
			add(dateChooser);
			
			textField.setBackground(Color.WHITE);
			textField.setBounds(755, 513, 151, 23);
			add(textField);
			textField.setColumns(10);
			
			CtrMenu menu = new CtrMenu(new Menu(e));
			add(menu.getPanel());
		}	
		
		public Calendario (Organizacion o, Date d) {
			org = o;
			organizacion = true;
			this.setBounds(0, 0, 1080, 650);
			setLayout(null);
			
			addElements(o.getActividadesFechaA(d));
			addElements2(o.getInformacion(d));
			
			
			JLabel lblNewLabel2 = new JLabel("Mis actividades");
			lblNewLabel2.setBounds(375, 169, 151, 33);
			lblNewLabel2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
			add(lblNewLabel2);
			
			JLabel lblNewLabel5 = new JLabel("Fecha:");
			lblNewLabel5.setBounds(755, 432, 151, 23);
			lblNewLabel5.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
			add(lblNewLabel5);
			
			JLabel lblNewLabel6 = new JLabel("Información:");
			lblNewLabel6.setBounds(755, 490, 151, 23);
			lblNewLabel6.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
			add(lblNewLabel6);
			
			JLabel lblNewLabel3 = new JLabel("Mis eventos");
			lblNewLabel3.setBounds(375, 386, 126, 33);
			lblNewLabel3.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
			add(lblNewLabel3);
			
			JScrollPane sp_ac = new JScrollPane();
			sp_ac.setBounds(375, 205, 346, 170);
			sp_ac.setViewportView(listaC);
			add(sp_ac);
			
			JScrollPane sp_ac2 = new JScrollPane();
			sp_ac2.setBounds(375, 420, 346, 170);
			sp_ac2.setViewportView(listaC2);
			add(sp_ac2);
			
			bVer2 = new JButton("Ver actividad");
			bVer2.setBounds(755, 300, 151, 23);
			add(bVer2);
			
			bAnadir = new JButton("Añadir evento");
			bAnadir.setBounds(755, 547, 151, 23);
			add(bAnadir);
			
			Calendar cal = Calendar.getInstance();
		    cal.setTime(d);
			JLabel lblNewLabel = new JLabel("Eventos del día " + cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR));
			lblNewLabel.setBounds(385, 100, 403, 33);
			lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
			add(lblNewLabel);
			
			dateChooser.setBounds(755, 456, 151, 23);
			add(dateChooser);
			
			textField.setBackground(Color.WHITE);
			textField.setBounds(755, 513, 151, 23);
			add(textField);
			textField.setColumns(10);
			
			CtrMenu menu = new CtrMenu(new Menu(o));
			add(menu.getPanel());
		}
	
	public void addElements(List<Actividad> l) {
		this.l = l;
		listaC.setModel(modeloC);

		for (Object o : l) {
			modeloC.addElement(o.toString());
		}

		listaC.setLayoutOrientation(JList.VERTICAL);
	}
	
	public void addElements2(List<String> l) {
		listaC2.setModel(modeloC2);

		for (Object o : l) {
			modeloC2.addElement(o.toString());
		}

		listaC2.setLayoutOrientation(JList.VERTICAL);
	}
	
	public Actividad getActividad() {
		if (!listaC.isSelectionEmpty()) {
			return l.get(listaC.getSelectedIndex());
		} else {
			return null;
		}
	}
	
	
	public Date getFecha() {
		return dateChooser.getDate();
	}
	
	public String getInfo() {
		return textField.getText();
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
	
	
	public void controlador(ActionListener ctr) {
		if(bVer != null) {
			bVer.addActionListener(ctr);
			bVer.setActionCommand("VER");
		}
		
		if(bVer2 != null) {
			bVer2.addActionListener(ctr);
			bVer2.setActionCommand("ENTRAR");
		}
		
		if(bAnadir != null) {
			bAnadir.addActionListener(ctr);
			bAnadir.setActionCommand("ANADIR");
		}
	}
}
