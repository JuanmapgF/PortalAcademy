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
		this.setBounds(0, 0, 1920, 1080);

		JLabel titulo = new JLabel("");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		titulo.setBounds(558, 121, 545, 49);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setText(a.getNombre());
		add(titulo);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(607, 255, 136, 27);
		add(lblNewLabel);

		nombre = new JTextField();
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombre.setBounds(792, 252, 311, 40);
		nombre.setText(a.getNombre());
		add(nombre);
		nombre.setColumns(10);

		JLabel lblImagen = new JLabel("Imagen:");
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImagen.setBounds(607, 366, 136, 27);
		add(lblImagen);

		lblImagenSeleccionada = new JLabel("");
		lblImagenSeleccionada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImagenSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblImagenSeleccionada.setBounds(792, 359, 190, 40);
		add(lblImagenSeleccionada);

		fileChooserImagen = new JFileChooser();
		fileChooserImagen.setFileSelectionMode(JFileChooser.FILES_ONLY);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSeleccionar.setBounds(1046, 359, 166, 40);
		add(btnSeleccionar);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescripcin.setBounds(576, 462, 136, 27);
		add(lblDescripcin);

		descripcion = new JTextArea();
		descripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane jsp = new JScrollPane(descripcion);
		descripcion.setText(a.getDescripcion());
		jsp.setBounds(800, 650, 311, 75);
		add(jsp);

		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAforo.setBounds(632, 559, 136, 27);
		add(lblAforo);

		aforo = new JSpinner();
		aforo.setBounds(792, 556, 47, 40);
		add(aforo);

		aforo.setValue(a.getAforo());

		guardar = new JButton("Guardar cambios");
		guardar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		guardar.setBounds(1307, 455, 197, 40);
		add(guardar);

		eliminar = new JButton("Eliminar actividad");
		eliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eliminar.setBounds(1307, 607, 197, 40);
		add(eliminar);

		volver = new JButton("Descartar cambios");
		volver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		volver.setBounds(1307, 762, 197, 40);
		add(volver);

		calendario = new JCalendar();
		calendario.setBounds(800, 800, 311, 200);
		calendario.setDate(a.getFecha());
		calendario.setTodayButtonVisible(true);
		calendario.setTodayButtonText("Hoy");
		calendario.setWeekOfYearVisible(false);
		calendario.setMinSelectableDate(new Date());
		add(calendario);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFecha.setBounds(632, 816, 136, 27);
		add(lblFecha);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLugar.setBounds(632, 668, 136, 27);
		add(lblLugar);

		lugar = new JTextField();
		lugar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lugar.setBounds(792, 456, 311, 40);
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
