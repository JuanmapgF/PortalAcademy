package Vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

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
	public JTextField textFieldLugar;
	private JLabel lblNewLabel_1;

	public JButton btnSeleccionar;
	public JFileChooser fileChooserImagen;
	public JLabel lblImagenSeleccionada;

	/**
	 * Create the panel.
	 */
	public CrearActividad() {

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(575, 310, 109, 26);
		add(lblNombre);

		JLabel lblImagenes = new JLabel("Imagen:");
		lblImagenes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImagenes.setBounds(575, 410, 109, 26);
		add(lblImagenes);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescripcin.setBounds(540, 510, 121, 42);
		add(lblDescripcin);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLugar.setBounds(590, 610, 109, 35);
		add(lblLugar);

		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAforo.setBounds(595, 710, 76, 25);
		add(lblAforo);

		JLabel lblModo = new JLabel("Fecha:");
		lblModo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModo.setBounds(595, 810, 76, 35);
		add(lblModo);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNombre.setBounds(750, 305, 242, 40);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JScrollPane jsp = new JScrollPane(textAreaDescripcion);
		jsp.setBounds(750, 510, 242, 47);
		add(jsp);

		spinnerAforo = new JSpinner();
		spinnerAforo.setBounds(750, 710, 90, 40);
		add(spinnerAforo);


		btnCrearActividad = new JButton(new ImageIcon(getClass().getResource("/img/guardar.png")));
		btnCrearActividad.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCrearActividad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearActividad.setContentAreaFilled(false);
		btnCrearActividad.setText("Guardar nueva actividad");
		btnCrearActividad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCrearActividad.setBounds(1128, 784, 305, 49);
		add(btnCrearActividad);

		btnCancelar = new JButton(new ImageIcon(getClass().getResource("/img/volver.png")));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBounds(448, 117, 78, 67);
		add(btnCancelar);

		dateChooser = new JDateChooser("yyyy-MM-dd", "####-##-##", '_');
		dateChooser.setBounds(750, 810, 90, 40);
		Date hoy = new Date();
		dateChooser.getJCalendar().setDate(hoy);
		dateChooser.getJCalendar().setTodayButtonVisible(true);
		dateChooser.getJCalendar().setTodayButtonText("Hoy");
		dateChooser.getJCalendar().setNullDateButtonVisible(true);
		dateChooser.getJCalendar().setWeekOfYearVisible(false);
		dateChooser.getJCalendar().setMinSelectableDate(hoy);
		add(dateChooser);

		

		textFieldLugar = new JTextField();
		textFieldLugar.setColumns(10);
		textFieldLugar.setBounds(750, 610, 242, 40);
		add(textFieldLugar);

		lblNewLabel_1 = new JLabel("Crear Actividad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(675, 200, 270, 49);
		add(lblNewLabel_1);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSeleccionar.setBounds(975, 410, 140, 40);
		add(btnSeleccionar);

		lblImagenSeleccionada = new JLabel("");
		lblImagenSeleccionada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImagenSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblImagenSeleccionada.setBounds(750, 410, 170, 40);
		add(lblImagenSeleccionada);

		fileChooserImagen = new JFileChooser();
		fileChooserImagen.setFileSelectionMode(JFileChooser.FILES_ONLY);

		CtrMenu menu = new CtrMenu(new Menu((new Organizacion(Main.getUser().getNick()))));
		add(menu.getPanel());
	}
}
