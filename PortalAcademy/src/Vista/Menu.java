package Vista;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.CtrButtonDynamic;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;

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

		this.setBounds(0, 0, 1080, 650);
		setLayout(null);

		iniciar = new JButton("Iniciar sesi\u00F3n");
		iniciar.setBounds(729, 37, 121, 23);
		add(iniciar);

		registrarse = new JButton("Registrarse");
		registrarse.setBounds(860, 37, 121, 23);
		add(registrarse);

		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

	}

	public Menu(Estudiante estudiante) {
		this.estudiante = true;
		this.est = estudiante;

		this.setBounds(0, 0, 1080, 650);
		setLayout(null);

		cerrar = new ButtonDynamic("Cerrar Sesión", ButtonDynamic.CERRAR_SESION);
		cerrar.setBounds(860, 37, (int) cerrar.getPreferredSize().getWidth(),
				(int) cerrar.getPreferredSize().getHeight());
		CtrButtonDynamic cbdCerrar = new CtrButtonDynamic(cerrar);
		add(cbdCerrar.getBoton());

		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

		cursos = new JButton("Mis cursos");
		cursos.setBounds(36, 261, 131, 32);
		add(cursos);

		actividades = new JButton("Mis actividades");
		actividades.setBounds(36, 336, 131, 32);
		add(actividades);

		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 413, 131, 32);
		add(ajustes);

		user = new ButtonDynamic("Sesión iniciada como: " + estudiante.getNick(), ButtonDynamic.USUARIO);
		CtrButtonDynamic cbdUser = new CtrButtonDynamic(user);
		user.setBounds(0, 11, (int) user.getPreferredSize().getWidth(), (int) user.getPreferredSize().getHeight());
		add(cbdUser.getBoton());

		btnChat = new JButton("");
		btnChat.setBounds(318, 11, 46, 32);
		btnChat.setIcon(new ImageIcon(getClass().getResource("/img/chat_privado.png")));
		btnChat.setContentAreaFilled(false);
		btnChat.setFocusPainted(false);
		btnChat.setBorderPainted(false);
		add(btnChat);

	}

	public Menu(Profesor profesor) {
		this.prof = profesor;
		this.profesor = true;

		this.setBounds(0, 0, 1080, 650);
		setLayout(null);

		cerrar = new ButtonDynamic("Cerrar Sesión", ButtonDynamic.CERRAR_SESION);
		cerrar.setBounds(860, 37, (int) cerrar.getPreferredSize().getWidth(),
				(int) cerrar.getPreferredSize().getHeight());
		CtrButtonDynamic cbdCerrar = new CtrButtonDynamic(cerrar);
		add(cbdCerrar.getBoton());

		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

		cursos = new JButton("Mis cursos");
		cursos.setBounds(36, 261, 131, 32);
		add(cursos);

		actividades = new JButton("Mis actividades");
		actividades.setBounds(36, 336, 131, 32);
		add(actividades);

		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 413, 131, 32);
		add(ajustes);

		user = new ButtonDynamic("Sesión iniciada como: " + profesor.getNick(), ButtonDynamic.USUARIO);
		CtrButtonDynamic cbdUser = new CtrButtonDynamic(user);
		user.setBounds(0, 11, (int) user.getPreferredSize().getWidth(), (int) user.getPreferredSize().getHeight());
		add(cbdUser.getBoton());

		btnChat = new JButton("");
		btnChat.setBounds(318, 11, 46, 32);
		btnChat.setIcon(new ImageIcon(getClass().getResource("/img/chat_privado.png")));
		btnChat.setContentAreaFilled(false);
		btnChat.setFocusPainted(false);
		btnChat.setBorderPainted(false);
		add(btnChat);

	}

	public Menu(Organizacion organizacion) {
		this.org = organizacion;
		this.organizacion = true;

		this.setBounds(0, 0, 1080, 650);
		setLayout(null);

		cerrar = new ButtonDynamic("Cerrar Sesión", ButtonDynamic.CERRAR_SESION);
		cerrar.setBounds(860, 37, (int) cerrar.getPreferredSize().getWidth(),
				(int) cerrar.getPreferredSize().getHeight());
		CtrButtonDynamic cbdCerrar = new CtrButtonDynamic(cerrar);
		add(cbdCerrar.getBoton());

		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

		actividades = new JButton("Mis actividades");
		actividades.setBounds(36, 261, 131, 32);
		add(actividades);

		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 336, 131, 32);
		add(ajustes);

		user = new ButtonDynamic("Sesión iniciada como: " + organizacion.getNick(), ButtonDynamic.USUARIO);
		CtrButtonDynamic cbdUser = new CtrButtonDynamic(user);
		user.setBounds(0, 11, (int) user.getPreferredSize().getWidth(), (int) user.getPreferredSize().getHeight());
		add(cbdUser.getBoton());

		btnChat = new JButton("");
		btnChat.setBounds(318, 11, 46, 32);
		btnChat.setIcon(new ImageIcon(getClass().getResource("/img/chat_privado.png")));
		btnChat.setContentAreaFilled(false);
		btnChat.setFocusPainted(false);
		btnChat.setBorderPainted(false);
		add(btnChat);

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
}
