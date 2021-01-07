package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;

import Controlador.CtrMenu;
import Modelo.Actividad;
import Modelo.Organizacion;

@SuppressWarnings("serial")
public class EditarActividad extends JPanel {

	private Actividad a;
	private Organizacion usuario;

	private JTextField nombre;
	private JTextArea descripcion;
	private JSpinner aforo;
	private JButton guardar;
	private JButton eliminar;
	private JButton volver;

	private JCalendar calendario;
	private JTextField lugar;

	private JButton btnSeleccionar;
	private JFileChooser fileChooserImagen;
	private JLabel lblImagenSeleccionada;

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

		JLabel lblImagen = new JLabel("Imagen:");
		lblImagen.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblImagen.setBounds(264, 165, 136, 27);
		add(lblImagen);

		lblImagenSeleccionada = new JLabel("");
		lblImagenSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblImagenSeleccionada.setBounds(400, 170, 190, 14);
		add(lblImagenSeleccionada);

		fileChooserImagen = new JFileChooser();
		fileChooserImagen.setFileSelectionMode(JFileChooser.FILES_ONLY);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(590, 165, 120, 23);
		add(btnSeleccionar);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblDescripcin.setBounds(264, 210, 136, 27);
		add(lblDescripcin);

		descripcion = new JTextArea();
		JScrollPane jsp = new JScrollPane(descripcion);
		descripcion.setText(a.getDescripcion());
		jsp.setBounds(400, 210, 311, 75);
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

		volver = new JButton("Descartar cambios");
		volver.setBounds(867, 439, 144, 23);
		add(volver);

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

		CtrMenu menu = new CtrMenu(new Menu(p));
		add(menu.getPanel());
	}

	public void controlador(ActionListener ctr) {
		
		guardar.addActionListener(ctr);
		guardar.setActionCommand("GUARDAR");

		eliminar.addActionListener(ctr);
		eliminar.setActionCommand("ELIMINAR");

		volver.addActionListener(ctr);
		volver.setActionCommand("VOLVER");

		btnSeleccionar.addActionListener(ctr);
		btnSeleccionar.setActionCommand("SELECCIONAR");

	}

	public void setLabelImagen(String img) {
		lblImagenSeleccionada.setText(img);
	}

	public JFileChooser getFileChooserImagen() {
		return fileChooserImagen;
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
