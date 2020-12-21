package Vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controlador.CtrMenu;
import Modelo.Organizacion;
import Modelo.Profesor;

@SuppressWarnings("serial")
public class CrearCurso extends JPanel {

	public JTextField textFieldNombre;
	public JTextField textFieldImagen;
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

	

	/**
	 * Create the panel.
	 */
	public CrearCurso() {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);


		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(297, 140, 66, 14);
		add(lblNewLabel);

		JLabel lblImagenes = new JLabel("Imagenes:");
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

		textFieldImagen = new JTextField();
		textFieldImagen.setColumns(10);
		textFieldImagen.setBounds(441, 190, 242, 20);
		add(textFieldImagen);

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
		
		CtrMenu menu = new CtrMenu(new Menu((new Profesor(Main.getUser().getNick()))));
		add(menu.getPanel());
		
	}
}
