package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class CrearCurso extends JPanel {
	private JTextField textFieldNombre;
	private JTextField textFieldImagen;
	private final ButtonGroup buttonGroupPrivacidad = new ButtonGroup();
	private final ButtonGroup buttonGroupModo = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public CrearCurso() {
		this.setBounds(0,0,1080,650);
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
		
		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(441, 241, 242, 47);
		add(textAreaDescripcion);
		
		JRadioButton rdbtnPublico = new JRadioButton("P\u00FAblico");
		buttonGroupPrivacidad.add(rdbtnPublico);
		rdbtnPublico.setBounds(470, 310, 82, 23);
		add(rdbtnPublico);
		
		JRadioButton rdbtnPrivado = new JRadioButton("Privado");
		buttonGroupPrivacidad.add(rdbtnPrivado);
		rdbtnPrivado.setBounds(575, 310, 82, 23);
		add(rdbtnPrivado);
		
		JRadioButton rdbtnPresencial = new JRadioButton("Presencial");
		buttonGroupModo.add(rdbtnPresencial);
		rdbtnPresencial.setBounds(470, 421, 109, 23);
		add(rdbtnPresencial);
		
		JRadioButton rdbtnOnline = new JRadioButton("Online");
		buttonGroupModo.add(rdbtnOnline);
		rdbtnOnline.setBounds(575, 421, 109, 23);
		add(rdbtnOnline);
		
		JSpinner spinnerAforo = new JSpinner();
		spinnerAforo.setBounds(511, 365, 90, 20);
		add(spinnerAforo);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(952, 36, 89, 23);
		add(btnNewButton);
	}
}
