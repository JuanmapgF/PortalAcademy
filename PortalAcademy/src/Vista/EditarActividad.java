package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;

import Modelo.Actividad;
import Modelo.Organizacion;

@SuppressWarnings("serial")
public class EditarActividad extends JPanel {

	private Actividad a;
	private Organizacion usuario;

	private JButton explorar;
	private JButton actividades;
	private JButton ajustes;

	private JTextField nombre;
	private JTextArea descripcion;
	private JSpinner aforo;
	private JButton guardar;
	private JButton eliminar;
	private JButton volver;
	private JButton cerrarsesion;
	private JCalendar calendario;
	private JTextField lugar;

	public EditarActividad(Actividad act, Organizacion p) {
		usuario = p;
		a = act;
		this.setLayout(null);
		this.setBounds(0, 0, 1080, 650);

		JLabel titulo = new JLabel("");
		titulo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		titulo.setBounds(239, 11, 545, 49);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setText(a.getNombre());
		add(titulo);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblNewLabel.setBounds(264, 123, 136, 27);
		add(lblNewLabel);

		nombre = new JTextField();
		nombre.setBounds(400, 126, 311, 20);
		nombre.setText(a.getNombre());
		add(nombre);
		nombre.setColumns(10);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblDescripcin.setBounds(264, 177, 136, 27);
		add(lblDescripcin);

		descripcion = new JTextArea();
		JScrollPane jsp = new JScrollPane(descripcion);
		descripcion.setText(a.getDescripcion());
		jsp.setBounds(400, 178, 311, 98);
		add(jsp);

		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblAforo.setBounds(264, 295, 136, 27);
		add(lblAforo);

		aforo = new JSpinner();
		aforo.setBounds(400, 298, 47, 20);
		add(aforo);

		aforo.setValue(a.getAforo());

		guardar = new JButton("Guardar cambios");
		guardar.setBounds(867, 255, 144, 23);
		add(guardar);

		eliminar = new JButton("Eliminar actividad");
		eliminar.setBounds(867, 350, 144, 23);
		add(eliminar);

		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

		actividades = new JButton("Mis actividades");
		actividades.setBounds(36, 261, 131, 32);
		add(actividades);

		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 336, 131, 32);
		add(ajustes);

		volver = new JButton("Descartar cambios");
		volver.setBounds(867, 439, 144, 23);
		add(volver);

		cerrarsesion = new JButton("Cerrar sesi\u00F3n");
		cerrarsesion.setBounds(867, 26, 144, 23);
		add(cerrarsesion);

		calendario = new JCalendar();
		calendario.setBounds(400, 400, 311, 200);
		calendario.setDate(a.getFecha());
		calendario.setTodayButtonVisible(true);
		calendario.setTodayButtonText("Hoy");
		calendario.setWeekOfYearVisible(false);
		calendario.setMinSelectableDate(new Date());
		add(calendario);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblFecha.setBounds(264, 405, 136, 27);
		add(lblFecha);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblLugar.setBounds(264, 346, 136, 27);
		add(lblLugar);

		lugar = new JTextField();
		lugar.setBounds(400, 351, 311, 20);
		lugar.setText(a.getLugar());
		add(lugar);
		lugar.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Sesi�n iniciada como: " + Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 121, 20);
		add(lblNewLabel_2);
	}

	public void controlador(ActionListener ctr) {
		guardar.addActionListener(ctr);
		guardar.setActionCommand("GUARDAR");

		eliminar.addActionListener(ctr);
		eliminar.setActionCommand("ELIMINAR");

		volver.addActionListener(ctr);
		volver.setActionCommand("VOLVER");

		cerrarsesion.addActionListener(ctr);
		cerrarsesion.setActionCommand("CERRAR_SESION");

		explorar.addActionListener(ctr);
		explorar.setActionCommand("EXPLORAR");

		actividades.addActionListener(ctr);
		actividades.setActionCommand("ACTIVIDADES");

		ajustes.addActionListener(ctr);
		ajustes.setActionCommand("AJUSTES");
	}

	public Actividad getC() {
		return a;
	}

	public Organizacion getUsuario() {
		return usuario;
	}

	public String getNombre() {
		return nombre.getText();
	}

	public String getDescripcion() {
		return descripcion.getText();
	}

	public Integer getAforo() {
		return (Integer) aforo.getValue();
	}

	public Date getFecha() {
		return calendario.getDate();
	}

	public String getLugar() {
		return lugar.getText();
	}
}
