package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;

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

import Controlador.CtrMenu;
import Modelo.Curso;
import Modelo.Profesor;

@SuppressWarnings("serial")
public class EditarCurso extends JPanel {

	private Curso c;
	private Profesor usuario;

	private JTextField nombre;
	private JTextArea descripcion;
	private JRadioButton publico;
	private JRadioButton privado;
	private JSpinner aforo;
	private JRadioButton presencial;
	private JRadioButton online;
	private JButton guardar;
	private JButton eliminar;
	private JLabel lblForo;
	private JCheckBox foro;
	private JButton volver;
	private JButton btnSeleccionar;
	private JFileChooser fileChooserImagen;
	private JLabel lblImagenSeleccionada;

	public EditarCurso(Curso cur, Profesor p) {
		usuario = p;
		c = cur;
		this.setLayout(null);
		this.setBounds(0, 0, 1080, 650);

		JLabel titulo = new JLabel("");
		titulo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		titulo.setBounds(239, 11, 545, 49);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setText(c.getNombre());
		add(titulo);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblNewLabel.setBounds(264, 123, 136, 27);
		add(lblNewLabel);

		nombre = new JTextField();
		nombre.setBounds(400, 126, 311, 20);
		nombre.setText(c.getNombre());
		add(nombre);
		nombre.setColumns(10);

		JLabel lblImagen = new JLabel("Imagen:");
		lblImagen.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblImagen.setBounds(264, 175, 136, 27);
		add(lblImagen);

		lblImagenSeleccionada = new JLabel("");
		lblImagenSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblImagenSeleccionada.setBounds(400, 175, 190, 14);
		add(lblImagenSeleccionada);

		fileChooserImagen = new JFileChooser();
		fileChooserImagen.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(590, 170, 120, 23);
		add(btnSeleccionar);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblDescripcin.setBounds(264, 240, 136, 27);
		add(lblDescripcin);

		descripcion = new JTextArea();
		descripcion.setText(c.getDescripcion());
		JScrollPane jsp = new JScrollPane(descripcion);
		jsp.setBounds(400, 240, 311, 113);
		add(jsp);

		JLabel lblPrivacidad = new JLabel("Privacidad:");
		lblPrivacidad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblPrivacidad.setBounds(264, 362, 136, 27);
		add(lblPrivacidad);

		publico = new JRadioButton("P\u00FAblico");
		publico.setBounds(395, 364, 109, 23);
		add(publico);

		privado = new JRadioButton("Privado");
		privado.setBounds(540, 364, 109, 23);
		add(privado);

		if (cur.getPublico()) {
			publico.setSelected(true);
		} else {
			privado.setSelected(true);
		}

		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblAforo.setBounds(264, 446, 136, 27);
		add(lblAforo);

		aforo = new JSpinner();
		aforo.setBounds(400, 449, 47, 20);
		add(aforo);

		aforo.setValue(c.getAforo());

		JLabel lblModo = new JLabel("Modo:");
		lblModo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblModo.setBounds(264, 518, 136, 27);
		add(lblModo);

		presencial = new JRadioButton("Presencial");
		presencial.setBounds(395, 518, 109, 23);
		add(presencial);

		online = new JRadioButton("Online");
		online.setBounds(540, 520, 109, 23);
		add(online);

		if (c.getPresencial()) {
			presencial.setSelected(true);
		} else {
			online.setSelected(true);
		}

		guardar = new JButton("Guardar cambios");
		guardar.setBounds(867, 255, 144, 23);
		add(guardar);

		eliminar = new JButton("Eliminar curso");
		eliminar.setBounds(867, 350, 144, 23);
		add(eliminar);

		lblForo = new JLabel("Foro:");
		lblForo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblForo.setBounds(704, 518, 136, 27);
		add(lblForo);

		foro = new JCheckBox("");
		foro.setBounds(781, 518, 97, 23);
		foro.setSelected(c.getTieneForo());
		add(foro);

		volver = new JButton("Descartar cambios");
		volver.setBounds(867, 434, 144, 23);
		add(volver);

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

		publico.addActionListener(ctr);
		publico.setActionCommand("PUBLICO");

		privado.addActionListener(ctr);
		privado.setActionCommand("PRIVADO");

		presencial.addActionListener(ctr);
		presencial.setActionCommand("PRESENCIAL");

		online.addActionListener(ctr);
		online.setActionCommand("ONLINE");

		btnSeleccionar.addActionListener(ctr);
		btnSeleccionar.setActionCommand("SELECCIONAR");
	}

	public void setLabelImagen(String img) {
		lblImagenSeleccionada.setText(img);
	}

	public JFileChooser getFileChooserImagen() {
		return fileChooserImagen;
	}

	public Curso getC() {
		return c;
	}

	public Profesor getUsuario() {
		return usuario;
	}

	public String getNombre() {
		return nombre.getText();
	}

	public String getDescripcion() {
		return descripcion.getText();
	}

	public boolean getPublico() {
		return publico.isSelected();
	}

	public void setPublico(boolean b) {
		publico.setSelected(b);
	}

	public boolean getPrivado() {
		return privado.isSelected();
	}

	public void setPrivado(boolean b) {
		privado.setSelected(b);
	}

	public Integer getAforo() {
		return (Integer) aforo.getValue();
	}

	public boolean getPresencial() {
		return presencial.isSelected();
	}

	public void setPresencial(boolean b) {
		presencial.setSelected(b);
	}

	public boolean getOnline() {
		return online.isSelected();
	}

	public void setOnline(boolean b) {
		online.setSelected(b);
	}

	public boolean getForo() {
		return foro.isSelected();
	}
}
