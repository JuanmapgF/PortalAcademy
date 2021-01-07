package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controlador.CtrButtonDynamic;
import Controlador.CtrCalendario;
import Controlador.CtrRegistro;
import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;

import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;
import java.awt.Font;

@SuppressWarnings("serial")
public class Menu extends JPanel {

	private JButton iniciar;
	private JButton explorar;
	private JButton cursos;
	private JButton actividades;
	private ButtonDynamic cerrar;
	private JButton ajustes;
	private JButton registrarse;
	private JButton btnChat;
	private ButtonDynamic user;

	private Estudiante est = null;
	private Organizacion org = null;
	private Profesor prof = null;
	private boolean estudiante = false;
	private boolean organizacion = false;
	private boolean profesor = false;

	public Menu() {

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		iniciar = new JButton("Iniciar sesi\u00F3n");
		iniciar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		iniciar.setBounds(1358, 78, 189, 48);
		add(iniciar);

		registrarse = new JButton("Registrarse");
		registrarse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registrarse.setBounds(1642, 78, 184, 48);
		add(registrarse);

		explorar = new JButton("Explorar");
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 191, 205, 48);
		add(explorar);
		
		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
	    HighlightEvaluator evaluator = new HighlightEvaluator();
	    for(Actividad a : Actividad.getTodasLasActividades()) {
			evaluator.add(a.getFecha());
		}
//			evaluator.add(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-09"));
//			evaluator.add(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-10"));
	   
	    jc.getDayChooser().addDateEvaluator(evaluator);
	    jc.setCalendar(jc.getCalendar());  
		add(jc);
		jc.setWeekOfYearVisible(false);
		jc.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {

		    @Override
		    public void propertyChange(PropertyChangeEvent e) {
		    	CtrCalendario c = new CtrCalendario(new Calendario(jc.getDate()));
				Main.setPanel(c.getPanel());

		    }
		});

	}

	
	
	
	
	
	
	public Menu(Estudiante estudiante) {
		this.estudiante = true;
		this.est = estudiante;

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		cerrar = new ButtonDynamic("Cerrar Sesión", ButtonDynamic.CERRAR_SESION);
		cerrar.setBounds(1705, 47, 156,
				122);
		CtrButtonDynamic cbdCerrar = new CtrButtonDynamic(cerrar);
		add(cbdCerrar.getBoton());

		explorar = new JButton("Explorar");
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 233, 205, 48);
		add(explorar);

		cursos = new JButton("Mis cursos");
		cursos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cursos.setBounds(60, 365, 205, 48);
		add(cursos);

		actividades = new JButton("Mis actividades");
		actividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		actividades.setBounds(60, 489, 205, 48);
		add(actividades);

		ajustes = new JButton("Ajustes");
		ajustes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajustes.setBounds(60, 612, 205, 48);
		add(ajustes);

		user = new ButtonDynamic("Sesión iniciada como: " + estudiante.getNick(), ButtonDynamic.USUARIO);
		CtrButtonDynamic cbdUser = new CtrButtonDynamic(user);
		user.setBounds(82, 22, 150, 136);
		add(cbdUser.getBoton());

		btnChat = new JButton("");
		btnChat.setBounds(1501, 47, 81, 74);
		btnChat.setIcon(new ImageIcon(getClass().getResource("/img/chat_privado.png")));
		btnChat.setContentAreaFilled(false);
		btnChat.setFocusPainted(false);
		btnChat.setBorderPainted(false);
		btnChat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnChat);
		
		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
	    HighlightEvaluator evaluator = new HighlightEvaluator();
	    for(Actividad a : estudiante.getListaActividades()) {
			evaluator.add(a.getFecha());
		}
	    
	    for(Date a : estudiante.getFechas()) {
			evaluator.add(a);
		}
//			evaluator.add(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-09"));
//			evaluator.add(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-10"));
	    jc.getDayChooser().addDateEvaluator(evaluator);
	    jc.setCalendar(jc.getCalendar());  
		add(jc);
		jc.setWeekOfYearVisible(false);
		jc.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {

		    @Override
		    public void propertyChange(PropertyChangeEvent e) {
		    	CtrCalendario c = new CtrCalendario(new Calendario(estudiante,jc.getDate()));
				Main.setPanel(c.getPanel());

		    }
		});
	}

	
	public Menu(Profesor profesor) {
		this.prof = profesor;
		this.profesor = true;

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		cerrar = new ButtonDynamic("Cerrar Sesión", ButtonDynamic.CERRAR_SESION);
		cerrar.setBounds(1705, 47, 156,
				122);
		CtrButtonDynamic cbdCerrar = new CtrButtonDynamic(cerrar);
		add(cbdCerrar.getBoton());

		explorar = new JButton("Explorar");
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 233, 205, 48);
		add(explorar);

		cursos = new JButton("Mis cursos");
		cursos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cursos.setBounds(60, 365, 205, 48);
		add(cursos);

		actividades = new JButton("Mis actividades");
		actividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		actividades.setBounds(60, 489, 205, 48);
		add(actividades);

		ajustes = new JButton("Ajustes");
		ajustes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajustes.setBounds(60, 612, 205, 48);
		add(ajustes);

		user = new ButtonDynamic("Sesión iniciada como: " + profesor.getNick(), ButtonDynamic.USUARIO);
		CtrButtonDynamic cbdUser = new CtrButtonDynamic(user);
		user.setBounds(82, 22, 150, 136);
		add(cbdUser.getBoton());

		btnChat = new JButton("");
		btnChat.setBounds(1501, 47, 81, 74);
		btnChat.setIcon(new ImageIcon(getClass().getResource("/img/chat_privado.png")));
		btnChat.setContentAreaFilled(false);
		btnChat.setFocusPainted(false);
		btnChat.setBorderPainted(false);
		btnChat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnChat);
		
		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
	    HighlightEvaluator evaluator = new HighlightEvaluator();
	    
	    for(Actividad a : profesor.getListaActividades()) {
			evaluator.add(a.getFecha());
		}
	    
	    for(Date a : profesor.getFechas()) {
			evaluator.add(a);
		}
//			evaluator.add(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-09"));
//			evaluator.add(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-10"));
	    jc.getDayChooser().addDateEvaluator(evaluator);
	    jc.setCalendar(jc.getCalendar());  
		add(jc);
		jc.setWeekOfYearVisible(false);
		jc.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {

		    @Override
		    public void propertyChange(PropertyChangeEvent e) {
		    	CtrCalendario c = new CtrCalendario(new Calendario(profesor,jc.getDate()));
				Main.setPanel(c.getPanel());

		    }
		});
	}

	/**
	 * @wbp.parser.constructor
	 */
	public Menu(Organizacion organizacion) {
		this.org = organizacion;
		this.organizacion = true;

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		cerrar = new ButtonDynamic("Cerrar Sesión", ButtonDynamic.CERRAR_SESION);
		cerrar.setBounds(1643, 47, 267,
				122);
		CtrButtonDynamic cbdCerrar = new CtrButtonDynamic(cerrar);
		add(cbdCerrar.getBoton());

		explorar = new JButton("Explorar");
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 233, 205, 48);
		add(explorar);

		actividades = new JButton("Mis actividades");
		actividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		actividades.setBounds(60, 365, 205, 48);
		add(actividades);

		ajustes = new JButton("Ajustes");
		ajustes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajustes.setBounds(60, 489, 205, 48);
		add(ajustes);

		user = new ButtonDynamic("Sesión iniciada como: " + organizacion.getNick(), ButtonDynamic.USUARIO);
		CtrButtonDynamic cbdUser = new CtrButtonDynamic(user);
		user.setBounds(82, 22, 590, 136);
		add(cbdUser.getBoton());

		btnChat = new JButton("");
		btnChat.setBounds(1501, 47, 81, 74);
		btnChat.setIcon(new ImageIcon(getClass().getResource("/img/chat_privado.png")));
		btnChat.setContentAreaFilled(false);
		btnChat.setFocusPainted(false);
		btnChat.setBorderPainted(false);
		btnChat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnChat);
		
		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
	    HighlightEvaluator evaluator = new HighlightEvaluator();

	    for(Actividad a : organizacion.getActividades()) {
			evaluator.add(a.getFecha());
		}
	    
	    for(Date a : organizacion.getFechas()) {
			evaluator.add(a);
		}
	    
//			evaluator.add(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-09"));
//			evaluator.add(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-10"));
	    jc.getDayChooser().addDateEvaluator(evaluator);
	    jc.setCalendar(jc.getCalendar());  
		add(jc);
		jc.setWeekOfYearVisible(false);
		jc.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {

		    @Override
		    public void propertyChange(PropertyChangeEvent e) {
		    	CtrCalendario c = new CtrCalendario(new Calendario(organizacion,jc.getDate()));
				Main.setPanel(c.getPanel());

		    }
		});
	}

	public void controlador(ActionListener ctr) {
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
		if (iniciar != null) {
			iniciar.addActionListener(ctr);
			iniciar.setActionCommand("INICIAR_SESION");
		}

		if (registrarse != null) {
			registrarse.addActionListener(ctr);
			registrarse.setActionCommand("REGISTRARSE");
		}

		if (btnChat != null) {
			btnChat.addActionListener(ctr);
			btnChat.setActionCommand("CHAT");
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
	
	private static class HighlightEvaluator implements IDateEvaluator {

        private final List<Date> list = new ArrayList<>();

        public void add(Date date) {
            list.add(date);
        }

        @Override
        public boolean isSpecial(Date date) {
            return list.contains(date);
        }

        @Override
        public Color getSpecialForegroundColor() {
            return Color.black;
        }

        @Override
        public Color getSpecialBackroundColor() {
            return Color.yellow;
        }

        @Override
        public String getSpecialTooltip() {
            return "Highlighted event.";
        }

        @Override
        public boolean isInvalid(Date date) {
            return false;
        }

        @Override
        public Color getInvalidForegroundColor() {
            return null;
        }

        @Override
        public Color getInvalidBackroundColor() {
            return null;
        }

        @Override
        public String getInvalidTooltip() {
            return null;
        }
    }
}
