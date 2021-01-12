package Vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controlador.CtrMenu;
import Modelo.Profesor;

@SuppressWarnings("serial")
public class CrearCurso extends JPanel {

	public JTextField textFieldNombre;
	private final ButtonGroup buttonGroupPrivacidad = new ButtonGroup();
	private final ButtonGroup buttonGroupModo = new ButtonGroup();
	public JTextArea textAreaDescripcion;
	public JRadioButton rdbtnPublico;
	public JRadioButton rdbtnPrivado;
	public JRadioButton rdbtnPresencial;
	public JRadioButton rdbtnOnline;
	public JSpinner spinnerAforo;

	public JButton btnCrearCurso;
	public JButton btnCancelar;
	private JLabel lblForo;
	public JCheckBox chckbxForo;
	private JLabel lblNewLabel_1;

	public JButton btnSeleccionar;
	public JFileChooser fileChooserImagen;
	public JLabel lblImagenSeleccionada;

	/**
	 * Create the panel.
	 */
	public CrearCurso() {
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(575, 310, 109, 26);
		add(lblNewLabel);

		JLabel lblImagenes = new JLabel("Imagen:");
		lblImagenes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImagenes.setBounds(575, 410, 109, 26);
		add(lblImagenes);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescripcin.setBounds(540, 510, 121, 42);
		add(lblDescripcin);

		JLabel lblPrivacidad = new JLabel("Privacidad:");
		lblPrivacidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrivacidad.setBounds(550, 610, 109, 35);
		add(lblPrivacidad);

		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAforo.setBounds(595, 710, 76, 25);
		add(lblAforo);

		JLabel lblModo = new JLabel("Modo:");
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

		rdbtnPublico = new JRadioButton("P\u00FAblico");
		rdbtnPublico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnPublico.setSelected(true);
		buttonGroupPrivacidad.add(rdbtnPublico);
		rdbtnPublico.setBounds(750, 610, 100, 38);
		add(rdbtnPublico);

		rdbtnPrivado = new JRadioButton("Privado");
		rdbtnPrivado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroupPrivacidad.add(rdbtnPrivado);
		rdbtnPrivado.setBounds(930, 610, 120, 40);
		add(rdbtnPrivado);

		rdbtnPresencial = new JRadioButton("Presencial");
		rdbtnPresencial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroupModo.add(rdbtnPresencial);
		rdbtnPresencial.setBounds(750, 810, 130, 40);
		add(rdbtnPresencial);

		rdbtnOnline = new JRadioButton("Online");
		rdbtnOnline.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnOnline.setSelected(true);
		buttonGroupModo.add(rdbtnOnline);
		rdbtnOnline.setBounds(930, 810, 109, 40);
		add(rdbtnOnline);

		spinnerAforo = new JSpinner();
		spinnerAforo.setBounds(750, 710, 90, 40);
		add(spinnerAforo);

		btnCrearCurso = new JButton(new ImageIcon(getClass().getResource("/img/guardar.png")));
		btnCrearCurso.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCrearCurso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearCurso.setContentAreaFilled(false);
		btnCrearCurso.setText("Guardar nuevo curso");
		btnCrearCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCrearCurso.setBounds(1128, 784, 305, 49);
		add(btnCrearCurso);

		btnCancelar = new JButton(new ImageIcon(getClass().getResource("/img/volver.png")));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBounds(448, 117, 78, 67);
		add(btnCancelar);

		lblForo = new JLabel("Foro:");
		lblForo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblForo.setBounds(595, 910, 82, 25);
		add(lblForo);

		chckbxForo = new JCheckBox("");
		chckbxForo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxForo.setBounds(750, 905, 39, 40);
		add(chckbxForo);

		lblNewLabel_1 = new JLabel("Crear Curso");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(695, 200, 242, 49);
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

		CtrMenu menu = new CtrMenu(new Menu(new Profesor(Main.getUser().getNick())));
		add(menu.getPanel());

	}
}
