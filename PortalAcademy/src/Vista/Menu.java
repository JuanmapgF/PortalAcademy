package Vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;

import Controlador.CtrButtonDynamic;
import Controlador.CtrCalendario;
import Controlador.CtrMenuActividad;
import Controlador.CtrMenuCurso;
import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;

@SuppressWarnings("serial")
public class Menu extends JPanel {

	private JButton iniciar;
	private JButton explorar;
	private JButton cursos;
	private JButton actividades;
	private JButton ajustes;
	private JButton registrarse;
	private JButton btnChat;
	private JButton cerrarSesion;
	private ButtonDynamic user;
	private JLabel logo;

	private Estudiante est = null;
	private Organizacion org = null;
	private Profesor prof = null;
	private boolean estudiante = false;
	private boolean organizacion = false;
	private boolean profesor = false;

	private final ImageIcon EXPLORAR = new ImageIcon(getClass().getResource("/img/explorar.png"));
	private final ImageIcon MIS_CURSOS = new ImageIcon(getClass().getResource("/img/misCursos.png"));
	private final ImageIcon MIS_ACTIVIDADES = new ImageIcon(getClass().getResource("/img/misActividades.png"));
	private final ImageIcon AJUSTES = new ImageIcon(getClass().getResource("/img/ajustes.png"));
	private final ImageIcon INICIAR_SESION = new ImageIcon(getClass().getResource("/img/iniciarSesion.png"));
	private final ImageIcon REGISTRARSE = new ImageIcon(getClass().getResource("/img/registrarse.png"));
	private final ImageIcon CHAT_PRIVADO = new ImageIcon(getClass().getResource("/img/chatPrivado.png"));
	private final ImageIcon CERRAR_SESION = new ImageIcon(getClass().getResource("/img/cerrarSesion.png"));
	private final ImageIcon LOGO = new ImageIcon(getClass().getResource("/img/logoMenu.png"));
	
	private URL url = getClass().getResource("/img/fondoBlanco.jpg");
    Image image = new ImageIcon(url).getImage();

	public Menu() {

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		iniciar = new JButton(INICIAR_SESION);
		iniciar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		iniciar.setBounds(1358, 47, 189, 60);
		iniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iniciar.setContentAreaFilled(false);
		iniciar.setFocusPainted(false);
		iniciar.setBorderPainted(false);
		add(iniciar);

		registrarse = new JButton(REGISTRARSE);
		registrarse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registrarse.setBounds(1642, 47, 184, 60);
		registrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registrarse.setContentAreaFilled(false);
		registrarse.setFocusPainted(false);
		registrarse.setBorderPainted(false);
		add(registrarse);

		explorar = new JButton(EXPLORAR);
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 191, 205, 60);
		explorar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		explorar.setContentAreaFilled(false);
		explorar.setFocusPainted(false);
		explorar.setBorderPainted(false);
		add(explorar);

		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(680, 975, 593, 40);
		add(lblNewLabel);

		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
		HighlightEvaluator evaluator = new HighlightEvaluator();
		for (Actividad a : Actividad.getTodasLasActividades()) {
			evaluator.add(a.getFecha());
		}

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

		logo = new JLabel(LOGO);
		logo.setBounds(780, 10, 400, 100);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setText("Portal Academy");
		logo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(logo);

	}

	public Menu(Estudiante estudiante) {
		this.estudiante = true;
		this.est = estudiante;

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		explorar = new JButton(EXPLORAR);
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 191, 205, 60);
		explorar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		explorar.setContentAreaFilled(false);
		explorar.setFocusPainted(false);
		explorar.setBorderPainted(false);
		add(explorar);

		cursos = new JButton(MIS_CURSOS);
		cursos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cursos.setBounds(60, 365, 205, 60);
		cursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cursos.setContentAreaFilled(false);
		cursos.setFocusPainted(false);
		cursos.setBorderPainted(false);
		add(cursos);

		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(680, 975, 593, 40);
		add(lblNewLabel);

		actividades = new JButton(MIS_ACTIVIDADES);
		actividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		actividades.setBounds(60, 489, 205, 60);
		actividades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		actividades.setContentAreaFilled(false);
		actividades.setFocusPainted(false);
		actividades.setBorderPainted(false);
		add(actividades);

		ajustes = new JButton(AJUSTES);
		ajustes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajustes.setBounds(1627, 47, 81, 74);
		ajustes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajustes.setContentAreaFilled(false);
		ajustes.setFocusPainted(false);
		ajustes.setBorderPainted(false);
		add(ajustes);

		user = new ButtonDynamic(estudiante.getNick(), "USUARIO");
		CtrButtonDynamic cbdUser = new CtrButtonDynamic(user);
		user.setBounds(82, 22, 150, 136);
		add(cbdUser.getBoton());

		cerrarSesion = new JButton(CERRAR_SESION);
		cerrarSesion.setBounds(1718, 47, 81, 74);
		cerrarSesion.setContentAreaFilled(false);
		cerrarSesion.setFocusPainted(false);
		cerrarSesion.setBorderPainted(false);
		cerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(cerrarSesion);

		btnChat = new JButton("");
		btnChat.setBounds(1501, 47, 81, 74);
		btnChat.setIcon(CHAT_PRIVADO);
		btnChat.setContentAreaFilled(false);
		btnChat.setFocusPainted(false);
		btnChat.setBorderPainted(false);
		btnChat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnChat);

		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
		HighlightEvaluator evaluator = new HighlightEvaluator();
		for (Actividad a : estudiante.getListaActividades()) {
			evaluator.add(a.getFecha());
		}

		for (Date a : estudiante.getFechas()) {
			evaluator.add(a);
		}

		jc.getDayChooser().addDateEvaluator(evaluator);
		jc.setCalendar(jc.getCalendar());
		add(jc);
		jc.setWeekOfYearVisible(false);
		jc.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				CtrCalendario c = new CtrCalendario(new Calendario(estudiante, jc.getDate()));
				Main.setPanel(c.getPanel());

			}
		});

		logo = new JLabel(LOGO);
		logo.setBounds(780, 10, 400, 100);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setText("Portal Academy");
		logo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(logo);
	}

	public Menu(Profesor profesor) {
		this.prof = profesor;
		this.profesor = true;

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		explorar = new JButton(EXPLORAR);
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 191, 205, 60);
		explorar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		explorar.setContentAreaFilled(false);
		explorar.setFocusPainted(false);
		explorar.setBorderPainted(false);
		add(explorar);

		cursos = new JButton(MIS_CURSOS);
		cursos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cursos.setBounds(60, 365, 205, 60);
		cursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cursos.setContentAreaFilled(false);
		cursos.setFocusPainted(false);
		cursos.setBorderPainted(false);
		add(cursos);

		actividades = new JButton(MIS_ACTIVIDADES);
		actividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		actividades.setBounds(60, 489, 205, 60);
		actividades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		actividades.setContentAreaFilled(false);
		actividades.setFocusPainted(false);
		actividades.setBorderPainted(false);
		add(actividades);

		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(680, 975, 593, 40);
		add(lblNewLabel);

		ajustes = new JButton(AJUSTES);
		ajustes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajustes.setBounds(1627, 47, 81, 74);
		ajustes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajustes.setContentAreaFilled(false);
		ajustes.setFocusPainted(false);
		ajustes.setBorderPainted(false);
		add(ajustes);

		user = new ButtonDynamic(profesor.getNick(), "USUARIO");
		CtrButtonDynamic cbdUser = new CtrButtonDynamic(user);
		user.setBounds(82, 22, 150, 136);
		add(cbdUser.getBoton());

		cerrarSesion = new JButton(CERRAR_SESION);
		cerrarSesion.setBounds(1718, 47, 81, 74);
		cerrarSesion.setContentAreaFilled(false);
		cerrarSesion.setFocusPainted(false);
		cerrarSesion.setBorderPainted(false);
		cerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(cerrarSesion);

		btnChat = new JButton("");
		btnChat.setBounds(1501, 47, 81, 74);
		btnChat.setIcon(CHAT_PRIVADO);
		btnChat.setContentAreaFilled(false);
		btnChat.setFocusPainted(false);
		btnChat.setBorderPainted(false);
		btnChat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnChat);

		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
		HighlightEvaluator evaluator = new HighlightEvaluator();

		for (Actividad a : profesor.getListaActividades()) {
			evaluator.add(a.getFecha());
		}

		for (Date a : profesor.getFechas()) {
			evaluator.add(a);
		}

		jc.getDayChooser().addDateEvaluator(evaluator);
		jc.setCalendar(jc.getCalendar());
		add(jc);
		jc.setWeekOfYearVisible(false);
		jc.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				CtrCalendario c = new CtrCalendario(new Calendario(profesor, jc.getDate()));
				Main.setPanel(c.getPanel());

			}
		});

		logo = new JLabel(LOGO);
		logo.setBounds(780, 10, 400, 100);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setText("Portal Academy");
		logo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(logo);
	}

	public Menu(Organizacion organizacion) {
		this.org = organizacion;
		this.organizacion = true;

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		explorar = new JButton(EXPLORAR);
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 191, 205, 60);
		explorar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		explorar.setContentAreaFilled(false);
		explorar.setFocusPainted(false);
		explorar.setBorderPainted(false);
		add(explorar);

		actividades = new JButton(MIS_ACTIVIDADES);
		actividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		actividades.setBounds(60, 489, 205, 60);
		actividades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		actividades.setContentAreaFilled(false);
		actividades.setFocusPainted(false);
		actividades.setBorderPainted(false);
		add(actividades);

		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(680, 975, 593, 40);
		add(lblNewLabel);

		ajustes = new JButton(AJUSTES);
		ajustes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajustes.setBounds(1627, 47, 81, 74);
		ajustes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajustes.setContentAreaFilled(false);
		ajustes.setFocusPainted(false);
		ajustes.setBorderPainted(false);
		add(ajustes);

		user = new ButtonDynamic(organizacion.getNick(), "USUARIO");
		CtrButtonDynamic cbdUser = new CtrButtonDynamic(user);
		user.setBounds(82, 22, 590, 136);
		add(cbdUser.getBoton());

		cerrarSesion = new JButton(CERRAR_SESION);
		cerrarSesion.setBounds(1718, 47, 81, 74);
		cerrarSesion.setContentAreaFilled(false);
		cerrarSesion.setFocusPainted(false);
		cerrarSesion.setBorderPainted(false);
		cerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(cerrarSesion);

		btnChat = new JButton("");
		btnChat.setBounds(1501, 47, 81, 74);
		btnChat.setIcon(CHAT_PRIVADO);
		btnChat.setContentAreaFilled(false);
		btnChat.setFocusPainted(false);
		btnChat.setBorderPainted(false);
		btnChat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnChat);

		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
		HighlightEvaluator evaluator = new HighlightEvaluator();

		for (Actividad a : organizacion.getActividades()) {
			evaluator.add(a.getFecha());
		}

		for (Date a : organizacion.getFechas()) {
			evaluator.add(a);
		}

		jc.getDayChooser().addDateEvaluator(evaluator);
		jc.setCalendar(jc.getCalendar());
		add(jc);
		jc.setWeekOfYearVisible(false);
		jc.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				CtrCalendario c = new CtrCalendario(new Calendario(organizacion, jc.getDate()));
				Main.setPanel(c.getPanel());

			}
		});

		logo = new JLabel(LOGO);
		logo.setBounds(780, 10, 400, 100);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setText("Portal Academy");
		logo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(logo);
	}

	public Menu(Curso curso) {

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		iniciar = new JButton(INICIAR_SESION);
		iniciar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		iniciar.setBounds(1358, 47, 189, 60);
		iniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iniciar.setContentAreaFilled(false);
		iniciar.setFocusPainted(false);
		iniciar.setBorderPainted(false);
		add(iniciar);

		registrarse = new JButton(REGISTRARSE);
		registrarse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registrarse.setBounds(1642, 47, 184, 60);
		registrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registrarse.setContentAreaFilled(false);
		registrarse.setFocusPainted(false);
		registrarse.setBorderPainted(false);
		add(registrarse);

		explorar = new JButton(EXPLORAR);
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 191, 205, 60);
		explorar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		explorar.setContentAreaFilled(false);
		explorar.setFocusPainted(false);
		explorar.setBorderPainted(false);
		add(explorar);

		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(680, 975, 593, 40);
		add(lblNewLabel);

		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
		HighlightEvaluator evaluator = new HighlightEvaluator();
		for (Actividad a : Actividad.getTodasLasActividades()) {
			evaluator.add(a.getFecha());
		}

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

		logo = new JLabel(LOGO);
		logo.setBounds(780, 10, 400, 100);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setText("Portal Academy");
		logo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(logo);

		CtrMenuCurso menuc = new CtrMenuCurso(new MenuCurso(curso));
		add(menuc.getPanel());

	}

	public Menu(Estudiante estudiante, Curso curso) {
		this.estudiante = true;
		this.est = estudiante;

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		explorar = new JButton(EXPLORAR);
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 191, 205, 60);
		explorar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		explorar.setContentAreaFilled(false);
		explorar.setFocusPainted(false);
		explorar.setBorderPainted(false);
		add(explorar);

		cursos = new JButton(MIS_CURSOS);
		cursos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cursos.setBounds(60, 365, 205, 60);
		cursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cursos.setContentAreaFilled(false);
		cursos.setFocusPainted(false);
		cursos.setBorderPainted(false);
		add(cursos);

		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(680, 975, 593, 40);
		add(lblNewLabel);

		actividades = new JButton(MIS_ACTIVIDADES);
		actividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		actividades.setBounds(60, 489, 205, 60);
		actividades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		actividades.setContentAreaFilled(false);
		actividades.setFocusPainted(false);
		actividades.setBorderPainted(false);
		add(actividades);

		ajustes = new JButton(AJUSTES);
		ajustes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajustes.setBounds(1627, 47, 81, 74);
		ajustes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajustes.setContentAreaFilled(false);
		ajustes.setFocusPainted(false);
		ajustes.setBorderPainted(false);
		add(ajustes);

		user = new ButtonDynamic(estudiante.getNick(), "USUARIO");
		CtrButtonDynamic cbdUser = new CtrButtonDynamic(user);
		user.setBounds(82, 22, 150, 136);
		add(cbdUser.getBoton());

		cerrarSesion = new JButton(CERRAR_SESION);
		cerrarSesion.setBounds(1718, 47, 81, 74);
		cerrarSesion.setContentAreaFilled(false);
		cerrarSesion.setFocusPainted(false);
		cerrarSesion.setBorderPainted(false);
		cerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(cerrarSesion);

		btnChat = new JButton("");
		btnChat.setBounds(1501, 47, 81, 74);
		btnChat.setIcon(CHAT_PRIVADO);
		btnChat.setContentAreaFilled(false);
		btnChat.setFocusPainted(false);
		btnChat.setBorderPainted(false);
		btnChat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnChat);

		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
		HighlightEvaluator evaluator = new HighlightEvaluator();
		for (Actividad a : estudiante.getListaActividades()) {
			evaluator.add(a.getFecha());
		}

		for (Date a : estudiante.getFechas()) {
			evaluator.add(a);
		}

		jc.getDayChooser().addDateEvaluator(evaluator);
		jc.setCalendar(jc.getCalendar());
		add(jc);
		jc.setWeekOfYearVisible(false);
		jc.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				CtrCalendario c = new CtrCalendario(new Calendario(estudiante, jc.getDate()));
				Main.setPanel(c.getPanel());

			}
		});

		logo = new JLabel(LOGO);
		logo.setBounds(780, 10, 400, 100);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setText("Portal Academy");
		logo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(logo);

		CtrMenuCurso menuc = new CtrMenuCurso(new MenuCurso(curso));
		add(menuc.getPanel());
	}

	public Menu(Profesor profesor, Curso curso) {
		this.prof = profesor;
		this.profesor = true;

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		explorar = new JButton(EXPLORAR);
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 191, 205, 60);
		explorar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		explorar.setContentAreaFilled(false);
		explorar.setFocusPainted(false);
		explorar.setBorderPainted(false);
		add(explorar);

		cursos = new JButton(MIS_CURSOS);
		cursos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cursos.setBounds(60, 365, 205, 60);
		cursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cursos.setContentAreaFilled(false);
		cursos.setFocusPainted(false);
		cursos.setBorderPainted(false);
		add(cursos);

		actividades = new JButton(MIS_ACTIVIDADES);
		actividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		actividades.setBounds(60, 489, 205, 60);
		actividades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		actividades.setContentAreaFilled(false);
		actividades.setFocusPainted(false);
		actividades.setBorderPainted(false);
		add(actividades);

		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(680, 975, 593, 40);
		add(lblNewLabel);

		ajustes = new JButton(AJUSTES);
		ajustes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajustes.setBounds(1627, 47, 81, 74);
		ajustes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajustes.setContentAreaFilled(false);
		ajustes.setFocusPainted(false);
		ajustes.setBorderPainted(false);
		add(ajustes);

		user = new ButtonDynamic(profesor.getNick(), "USUARIO");
		CtrButtonDynamic cbdUser = new CtrButtonDynamic(user);
		user.setBounds(82, 22, 150, 136);
		add(cbdUser.getBoton());

		cerrarSesion = new JButton(CERRAR_SESION);
		cerrarSesion.setBounds(1718, 47, 81, 74);
		cerrarSesion.setContentAreaFilled(false);
		cerrarSesion.setFocusPainted(false);
		cerrarSesion.setBorderPainted(false);
		cerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(cerrarSesion);

		btnChat = new JButton("");
		btnChat.setBounds(1501, 47, 81, 74);
		btnChat.setIcon(CHAT_PRIVADO);
		btnChat.setContentAreaFilled(false);
		btnChat.setFocusPainted(false);
		btnChat.setBorderPainted(false);
		btnChat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnChat);

		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
		HighlightEvaluator evaluator = new HighlightEvaluator();

		for (Actividad a : profesor.getListaActividades()) {
			evaluator.add(a.getFecha());
		}

		for (Date a : profesor.getFechas()) {
			evaluator.add(a);
		}

		jc.getDayChooser().addDateEvaluator(evaluator);
		jc.setCalendar(jc.getCalendar());
		add(jc);
		jc.setWeekOfYearVisible(false);
		jc.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				CtrCalendario c = new CtrCalendario(new Calendario(profesor, jc.getDate()));
				Main.setPanel(c.getPanel());

			}
		});

		logo = new JLabel(LOGO);
		logo.setBounds(780, 10, 400, 100);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setText("Portal Academy");
		logo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(logo);

		CtrMenuCurso menuc = new CtrMenuCurso(new MenuCurso(curso));
		add(menuc.getPanel());
	}

	public Menu(Actividad actividad) {

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		iniciar = new JButton(INICIAR_SESION);
		iniciar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		iniciar.setBounds(1358, 47, 189, 60);
		iniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iniciar.setContentAreaFilled(false);
		iniciar.setFocusPainted(false);
		iniciar.setBorderPainted(false);
		add(iniciar);

		registrarse = new JButton(REGISTRARSE);
		registrarse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registrarse.setBounds(1642, 47, 184, 60);
		registrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registrarse.setContentAreaFilled(false);
		registrarse.setFocusPainted(false);
		registrarse.setBorderPainted(false);
		add(registrarse);

		explorar = new JButton(EXPLORAR);
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 191, 205, 60);
		explorar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		explorar.setContentAreaFilled(false);
		explorar.setFocusPainted(false);
		explorar.setBorderPainted(false);
		add(explorar);

		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(680, 975, 593, 40);
		add(lblNewLabel);

		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
		HighlightEvaluator evaluator = new HighlightEvaluator();
		for (Actividad a : Actividad.getTodasLasActividades()) {
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

		logo = new JLabel(LOGO);
		logo.setBounds(780, 10, 400, 100);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setText("Portal Academy");
		logo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(logo);

		CtrMenuActividad menua = new CtrMenuActividad(new MenuActividad(actividad));
		add(menua.getPanel());

	}

	public Menu(Estudiante estudiante, Actividad actividad) {
		this.estudiante = true;
		this.est = estudiante;

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

//		cerrar = new ButtonDynamic("Cerrar Sesión", ButtonDynamic.CERRAR_SESION);
//		cerrar.setBounds(1705, 47, 156,
//				122);
//		CtrButtonDynamic cbdCerrar = new CtrButtonDynamic(cerrar);
//		add(cbdCerrar.getBoton());

		explorar = new JButton(EXPLORAR);
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 191, 205, 60);
		explorar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		explorar.setContentAreaFilled(false);
		explorar.setFocusPainted(false);
		explorar.setBorderPainted(false);
		add(explorar);

		cursos = new JButton(MIS_CURSOS);
		cursos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cursos.setBounds(60, 365, 205, 60);
		cursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cursos.setContentAreaFilled(false);
		cursos.setFocusPainted(false);
		cursos.setBorderPainted(false);
		add(cursos);

		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(680, 975, 593, 40);
		add(lblNewLabel);

		actividades = new JButton(MIS_ACTIVIDADES);
		actividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		actividades.setBounds(60, 489, 205, 60);
		actividades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		actividades.setContentAreaFilled(false);
		actividades.setFocusPainted(false);
		actividades.setBorderPainted(false);
		add(actividades);

		ajustes = new JButton(AJUSTES);
		ajustes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajustes.setBounds(1627, 47, 81, 74);
		ajustes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajustes.setContentAreaFilled(false);
		ajustes.setFocusPainted(false);
		ajustes.setBorderPainted(false);
		add(ajustes);

		user = new ButtonDynamic(estudiante.getNick(), "USUARIO");
		CtrButtonDynamic cbdUser = new CtrButtonDynamic(user);
		user.setBounds(82, 22, 150, 136);
		add(cbdUser.getBoton());

		cerrarSesion = new JButton(CERRAR_SESION);
		cerrarSesion.setBounds(1718, 47, 81, 74);
		cerrarSesion.setContentAreaFilled(false);
		cerrarSesion.setFocusPainted(false);
		cerrarSesion.setBorderPainted(false);
		cerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(cerrarSesion);

		btnChat = new JButton("");
		btnChat.setBounds(1501, 47, 81, 74);
		btnChat.setIcon(CHAT_PRIVADO);
		btnChat.setContentAreaFilled(false);
		btnChat.setFocusPainted(false);
		btnChat.setBorderPainted(false);
		btnChat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnChat);

		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
		HighlightEvaluator evaluator = new HighlightEvaluator();
		for (Actividad a : estudiante.getListaActividades()) {
			evaluator.add(a.getFecha());
		}

		for (Date a : estudiante.getFechas()) {
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
				CtrCalendario c = new CtrCalendario(new Calendario(estudiante, jc.getDate()));
				Main.setPanel(c.getPanel());

			}
		});

		logo = new JLabel(LOGO);
		logo.setBounds(780, 10, 400, 100);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setText("Portal Academy");
		logo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(logo);

		CtrMenuActividad menua = new CtrMenuActividad(new MenuActividad(actividad));
		add(menua.getPanel());
	}

	public Menu(Profesor profesor, Actividad actividad) {
		this.prof = profesor;
		this.profesor = true;

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

//		cerrar = new ButtonDynamic("Cerrar Sesión", ButtonDynamic.CERRAR_SESION);
//		cerrar.setBounds(1705, 47, 156,
//				122);
//		CtrButtonDynamic cbdCerrar = new CtrButtonDynamic(cerrar);
//		add(cbdCerrar.getBoton());

		explorar = new JButton(EXPLORAR);
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 191, 205, 60);
		explorar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		explorar.setContentAreaFilled(false);
		explorar.setFocusPainted(false);
		explorar.setBorderPainted(false);
		add(explorar);

		cursos = new JButton(MIS_CURSOS);
		cursos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cursos.setBounds(60, 365, 205, 60);
		cursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cursos.setContentAreaFilled(false);
		cursos.setFocusPainted(false);
		cursos.setBorderPainted(false);
		add(cursos);

		actividades = new JButton(MIS_ACTIVIDADES);
		actividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		actividades.setBounds(60, 489, 205, 60);
		actividades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		actividades.setContentAreaFilled(false);
		actividades.setFocusPainted(false);
		actividades.setBorderPainted(false);
		add(actividades);

		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(680, 975, 593, 40);
		add(lblNewLabel);

		ajustes = new JButton(AJUSTES);
		ajustes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajustes.setBounds(1627, 47, 81, 74);
		ajustes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajustes.setContentAreaFilled(false);
		ajustes.setFocusPainted(false);
		ajustes.setBorderPainted(false);
		add(ajustes);

		user = new ButtonDynamic(profesor.getNick(), "USUARIO");
		CtrButtonDynamic cbdUser = new CtrButtonDynamic(user);
		user.setBounds(82, 22, 150, 136);
		add(cbdUser.getBoton());

		cerrarSesion = new JButton(CERRAR_SESION);
		cerrarSesion.setBounds(1718, 47, 81, 74);
		cerrarSesion.setContentAreaFilled(false);
		cerrarSesion.setFocusPainted(false);
		cerrarSesion.setBorderPainted(false);
		cerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(cerrarSesion);

		btnChat = new JButton("");
		btnChat.setBounds(1501, 47, 81, 74);
		btnChat.setIcon(CHAT_PRIVADO);
		btnChat.setContentAreaFilled(false);
		btnChat.setFocusPainted(false);
		btnChat.setBorderPainted(false);
		btnChat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnChat);

		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
		HighlightEvaluator evaluator = new HighlightEvaluator();

		for (Actividad a : profesor.getListaActividades()) {
			evaluator.add(a.getFecha());
		}

		for (Date a : profesor.getFechas()) {
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
				CtrCalendario c = new CtrCalendario(new Calendario(profesor, jc.getDate()));
				Main.setPanel(c.getPanel());

			}
		});

		logo = new JLabel(LOGO);
		logo.setBounds(780, 10, 400, 100);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setText("Portal Academy");
		logo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(logo);

		CtrMenuActividad menua = new CtrMenuActividad(new MenuActividad(actividad));
		add(menua.getPanel());
	}

	public Menu(Organizacion organizacion, Actividad actividad) {
		this.org = organizacion;
		this.organizacion = true;

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

//		cerrar = new ButtonDynamic("Cerrar Sesión", ButtonDynamic.CERRAR_SESION);
//		cerrar.setBounds(1643, 47, 267,
//				122);
//		CtrButtonDynamic cbdCerrar = new CtrButtonDynamic(cerrar);
//		add(cbdCerrar.getBoton());

		explorar = new JButton(EXPLORAR);
		explorar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		explorar.setBounds(60, 191, 205, 60);
		explorar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		explorar.setContentAreaFilled(false);
		explorar.setFocusPainted(false);
		explorar.setBorderPainted(false);
		add(explorar);

		actividades = new JButton(MIS_ACTIVIDADES);
		actividades.setFont(new Font("Tahoma", Font.PLAIN, 20));
		actividades.setBounds(60, 489, 205, 60);
		actividades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		actividades.setContentAreaFilled(false);
		actividades.setFocusPainted(false);
		actividades.setBorderPainted(false);
		add(actividades);

		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(680, 975, 593, 40);
		add(lblNewLabel);

		ajustes = new JButton(AJUSTES);
		ajustes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajustes.setBounds(1627, 47, 81, 74);
		ajustes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajustes.setContentAreaFilled(false);
		ajustes.setFocusPainted(false);
		ajustes.setBorderPainted(false);
		add(ajustes);

		user = new ButtonDynamic(organizacion.getNick(), "USUARIO");
		CtrButtonDynamic cbdUser = new CtrButtonDynamic(user);
		user.setBounds(82, 22, 590, 136);
		add(cbdUser.getBoton());

		cerrarSesion = new JButton(CERRAR_SESION);
		cerrarSesion.setBounds(1718, 47, 81, 74);
		cerrarSesion.setContentAreaFilled(false);
		cerrarSesion.setFocusPainted(false);
		cerrarSesion.setBorderPainted(false);
		cerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(cerrarSesion);

		btnChat = new JButton("");
		btnChat.setBounds(1501, 47, 81, 74);
		btnChat.setIcon(CHAT_PRIVADO);
		btnChat.setContentAreaFilled(false);
		btnChat.setFocusPainted(false);
		btnChat.setBorderPainted(false);
		btnChat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnChat);

		JCalendar jc = new JCalendar();
		jc.setBounds(60, 755, 205, 153);
		HighlightEvaluator evaluator = new HighlightEvaluator();

		for (Actividad a : organizacion.getActividades()) {
			evaluator.add(a.getFecha());
		}

		for (Date a : organizacion.getFechas()) {
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
				CtrCalendario c = new CtrCalendario(new Calendario(organizacion, jc.getDate()));
				Main.setPanel(c.getPanel());

			}
		});

		logo = new JLabel(LOGO);
		logo.setBounds(780, 10, 400, 100);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setText("Portal Academy");
		logo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(logo);

		CtrMenuActividad menua = new CtrMenuActividad(new MenuActividad(actividad));
		add(menua.getPanel());
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
		if (cerrarSesion != null) {
			cerrarSesion.addActionListener(ctr);
			cerrarSesion.setActionCommand("CERRAR_SESION");
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
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
		
		super.paint(g);
	}
}
