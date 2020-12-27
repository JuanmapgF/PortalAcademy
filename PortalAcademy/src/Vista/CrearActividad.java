package Vista;

import java.awt.Font;
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

import com.toedter.calendar.JDateChooser;

import Controlador.CtrMenu;
import Modelo.Organizacion;

@SuppressWarnings("serial")
public class CrearActividad extends JPanel {

	public JTextField textFieldNombre;
	public JTextArea textAreaDescripcion;
	public JSpinner spinnerAforo;

	public JButton btnCrearActividad;
	public JButton btnCancelar;
	public JDateChooser dateChooser;
	private JLabel lblLugar;
	public JTextField textFieldLugar;
	private JLabel lblNewLabel_1;

	public JButton btnSeleccionar;
	public JFileChooser fileChooserImagen;
	public JLabel lblImagenSeleccionada;

	/**
	 * Create the panel.
	 */
	public CrearActividad() {

		this.setBounds(0, 0, 1080, 650);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(397, 140, 66, 14);
		add(lblNewLabel);

		JLabel lblImagenes = new JLabel("Imagenes:");
		lblImagenes.setBounds(397, 193, 76, 14);
		add(lblImagenes);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(397, 246, 76, 14);
		add(lblDescripcin);

		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setBounds(397, 380, 76, 14);
		add(lblAforo);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(541, 137, 242, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textAreaDescripcion = new JTextArea();
		JScrollPane jsp = new JScrollPane(textAreaDescripcion);
		jsp.setBounds(541, 241, 242, 47);
		add(jsp);

		spinnerAforo = new JSpinner();
		spinnerAforo.setBounds(612, 377, 90, 20);
		add(spinnerAforo);

		btnCrearActividad = new JButton("Crear actividad");
		btnCrearActividad.setBounds(400, 546, 139, 35);
		add(btnCrearActividad);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(908, 546, 109, 35);
		add(btnCancelar);

		dateChooser = new JDateChooser("yyyy-MM-dd", "####-##-##", '_');
		dateChooser.setBounds(612, 442, 90, 20);
		Date hoy = new Date();
		dateChooser.getJCalendar().setDate(hoy);
		dateChooser.getJCalendar().setTodayButtonVisible(true);
		dateChooser.getJCalendar().setTodayButtonText("Hoy");
		dateChooser.getJCalendar().setNullDateButtonVisible(true);
		dateChooser.getJCalendar().setWeekOfYearVisible(false);
		dateChooser.getJCalendar().setMinSelectableDate(hoy);
		add(dateChooser);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(397, 448, 76, 14);
		add(lblFecha);

		lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(397, 329, 76, 14);
		add(lblLugar);

		textFieldLugar = new JTextField();
		textFieldLugar.setColumns(10);
		textFieldLugar.setBounds(541, 326, 242, 20);
		add(textFieldLugar);

		lblNewLabel_1 = new JLabel("Crear Actividad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(402, 35, 171, 40);
		add(lblNewLabel_1);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(675, 196, 109, 23);
		add(btnSeleccionar);

		lblImagenSeleccionada = new JLabel("");
		lblImagenSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblImagenSeleccionada.setBounds(540, 200, 138, 14);
		add(lblImagenSeleccionada);

		fileChooserImagen = new JFileChooser();
		fileChooserImagen.setFileSelectionMode(JFileChooser.FILES_ONLY);

		CtrMenu menu = new CtrMenu(new Menu((new Organizacion(Main.getUser().getNick()))));
		add(menu.getPanel());
	}
}
