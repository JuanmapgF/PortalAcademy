package Vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
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
	public JButton btnCerrarSesion;
	public JButton btnCrearCurso;
	public JButton btnCancelar;
	private JLabel lblForo;
	public JCheckBox chckbxForo;
	private JLabel lblNewLabel_1;

	public JButton explorar;
	public JButton cursos;
	public JButton ajustes;
	public JButton btnSeleccionar;
	public JFileChooser fileChooserImagen;
	public JLabel lblImagenSeleccionada;

	/**
	 * Create the panel.
	 */
	public CrearCurso() {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);

		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

		cursos = new JButton("Mis cursos");
		cursos.setForeground(Color.BLUE);
		cursos.setBounds(36, 261, 131, 32);
		add(cursos);

		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 336, 131, 32);
		add(ajustes);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(297, 140, 66, 14);
		add(lblNewLabel);

		JLabel lblImagenes = new JLabel("Imagen:");
		lblImagenes.setBounds(297, 193, 76, 14);
		add(lblImagenes);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(297, 246, 76, 14);
		add(lblDescripcin);

		JLabel lblPrivacidad = new JLabel("Privacidad:");
		lblPrivacidad.setBounds(297, 314, 76, 14);
		add(lblPrivacidad);

		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setBounds(297, 368, 76, 14);
		add(lblAforo);

		JLabel lblModo = new JLabel("Modo:");
		lblModo.setBounds(297, 425, 76, 14);
		add(lblModo);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(441, 137, 242, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textAreaDescripcion = new JTextArea();
		JScrollPane jsp = new JScrollPane(textAreaDescripcion);
		jsp.setBounds(441, 241, 242, 47);
		add(jsp);

		rdbtnPublico = new JRadioButton("P\u00FAblico");
		rdbtnPublico.setSelected(true);
		buttonGroupPrivacidad.add(rdbtnPublico);
		rdbtnPublico.setBounds(470, 310, 82, 23);
		add(rdbtnPublico);

		rdbtnPrivado = new JRadioButton("Privado");
		buttonGroupPrivacidad.add(rdbtnPrivado);
		rdbtnPrivado.setBounds(575, 310, 82, 23);
		add(rdbtnPrivado);

		rdbtnPresencial = new JRadioButton("Presencial");
		buttonGroupModo.add(rdbtnPresencial);
		rdbtnPresencial.setBounds(470, 421, 109, 23);
		add(rdbtnPresencial);

		rdbtnOnline = new JRadioButton("Online");
		rdbtnOnline.setSelected(true);
		buttonGroupModo.add(rdbtnOnline);
		rdbtnOnline.setBounds(575, 421, 109, 23);
		add(rdbtnOnline);

		spinnerAforo = new JSpinner();
		spinnerAforo.setBounds(511, 365, 90, 20);
		add(spinnerAforo);

		btnCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesion.setBounds(860, 37, 121, 23);
		add(btnCerrarSesion);

		btnCrearCurso = new JButton("Crear curso");
		btnCrearCurso.setBounds(400, 546, 109, 35);
		add(btnCrearCurso);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(908, 546, 109, 35);
		add(btnCancelar);

		lblForo = new JLabel("Foro:");
		lblForo.setBounds(297, 480, 76, 14);
		add(lblForo);

		chckbxForo = new JCheckBox("");
		chckbxForo.setBounds(470, 476, 39, 23);
		add(chckbxForo);

		lblNewLabel_1 = new JLabel("Crear Curso");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(395, 35, 148, 40);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: " + Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(574, 196, 109, 23);
		add(btnSeleccionar);
		
		lblImagenSeleccionada = new JLabel("");
		lblImagenSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblImagenSeleccionada.setBounds(441, 200, 138, 14);
		add(lblImagenSeleccionada);

		fileChooserImagen = new JFileChooser();
		fileChooserImagen.setFileSelectionMode(JFileChooser.FILES_ONLY);
	}
}
