package Vista;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

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

	public JButton explorar;
	public JButton actividades;
	public JButton ajustes;

	/**
	 * Create the panel.
	 */
	public CrearActividad() {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);

		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

		actividades = new JButton("Mis actividades");
		actividades.setForeground(Color.BLUE);
		actividades.setBounds(36, 261, 131, 32);
		add(actividades);

		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 336, 131, 32);
		add(ajustes);

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

		textFieldImagen = new JTextField();
		textFieldImagen.setColumns(10);
		textFieldImagen.setBounds(541, 190, 242, 20);
		add(textFieldImagen);

		textAreaDescripcion = new JTextArea();
		JScrollPane jsp = new JScrollPane(textAreaDescripcion);
		jsp.setBounds(541, 241, 242, 47);
		add(jsp);

		spinnerAforo = new JSpinner();
		spinnerAforo.setBounds(612, 377, 90, 20);
		add(spinnerAforo);

		btnCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesion.setBounds(860, 37, 121, 23);
		add(btnCerrarSesion);

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

		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: " + Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);
	}
}
