package Vista;

import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;

@SuppressWarnings("serial")
public class CrearActividad extends JPanel {

	public JTextField textFieldNombre;
	public JTextField textFieldImagen;
	public JTextArea textAreaDescripcion;
	public JSpinner spinnerAforo;
	public JButton btnCerrarSesion;
	public JButton btnCrearActividad;
	public JButton btnCancelar;
	public JDateChooser dateChooser;
	private JLabel lblLugar;
	public JTextField textFieldLugar;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public CrearActividad() {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(297, 140, 46, 14);
		add(lblNewLabel);

		JLabel lblImagenes = new JLabel("Imagenes:");
		lblImagenes.setBounds(297, 193, 76, 14);
		add(lblImagenes);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(297, 246, 76, 14);
		add(lblDescripcin);

		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setBounds(297, 380, 76, 14);
		add(lblAforo);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(441, 137, 242, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldImagen = new JTextField();
		textFieldImagen.setColumns(10);
		textFieldImagen.setBounds(441, 190, 242, 20);
		add(textFieldImagen);

		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(441, 241, 242, 47);
		add(textAreaDescripcion);

		spinnerAforo = new JSpinner();
		spinnerAforo.setBounds(512, 377, 90, 20);
		add(spinnerAforo);

		btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setBounds(952, 39, 118, 23);
		add(btnCerrarSesion);

		btnCrearActividad = new JButton("Crear actividad");
		btnCrearActividad.setBounds(200, 546, 109, 35);
		add(btnCrearActividad);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(908, 546, 109, 35);
		add(btnCancelar);

		dateChooser = new JDateChooser("yyyy-MM-dd", "####-##-##", '_');
		dateChooser.setBounds(512, 442, 90, 20);
		Date hoy = new Date();
		dateChooser.getJCalendar().setDate(hoy);
		dateChooser.getJCalendar().setTodayButtonVisible(true);
		dateChooser.getJCalendar().setTodayButtonText("Hoy");
		dateChooser.getJCalendar().setNullDateButtonVisible(true);
		dateChooser.getJCalendar().setWeekOfYearVisible(false);
		dateChooser.getJCalendar().setMinSelectableDate(hoy);
		add(dateChooser);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(297, 448, 76, 14);
		add(lblFecha);

		lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(297, 329, 76, 14);
		add(lblLugar);

		textFieldLugar = new JTextField();
		textFieldLugar.setColumns(10);
		textFieldLugar.setBounds(441, 326, 242, 20);
		add(textFieldLugar);
		
		lblNewLabel_1 = new JLabel("Crear Actividad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(202, 35, 171, 40);
		add(lblNewLabel_1);
	}
}
