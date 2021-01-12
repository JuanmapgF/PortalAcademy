package Vista;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;

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

import Controlador.CtrMenu;
import Modelo.Curso;
import Modelo.Profesor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

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
		this.setBounds(0, 0, 1920, 1080);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(565, 207, 136, 27);
		add(lblNewLabel);

		nombre = new JTextField();
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombre.setBounds(671, 198, 311, 46);
		nombre.setText(c.getNombre());
		add(nombre);
		nombre.setColumns(10);

		JLabel lblImagen = new JLabel("Imagen:");
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImagen.setBounds(565, 307, 136, 27);
		add(lblImagen);

		lblImagenSeleccionada = new JLabel("");
		lblImagenSeleccionada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImagenSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblImagenSeleccionada.setBounds(671, 300, 190, 40);
		add(lblImagenSeleccionada);

		fileChooserImagen = new JFileChooser();
		fileChooserImagen.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		btnSeleccionar = new JButton(new ImageIcon(getClass().getResource("/img/subir_archivo.png")));
		btnSeleccionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSeleccionar.setContentAreaFilled(false);
		btnSeleccionar.setFocusPainted(false);
		btnSeleccionar.setBorderPainted(false);
		btnSeleccionar.setBounds(897, 300, 136, 40);
		add(btnSeleccionar);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescripcin.setBounds(535, 446, 136, 27);
		add(lblDescripcin);

		descripcion = new JTextArea();
		descripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion.setText(c.getDescripcion());
		JScrollPane jsp = new JScrollPane(descripcion);
		jsp.setBounds(670, 410, 311, 113);
		add(jsp);

		JLabel lblPrivacidad = new JLabel("Privacidad:");
		lblPrivacidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrivacidad.setBounds(547, 579, 136, 27);
		add(lblPrivacidad);

		publico = new JRadioButton("P\u00FAblico");
		publico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		publico.setBounds(701, 582, 109, 20);
		add(publico);

		privado = new JRadioButton("Privado");
		privado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		privado.setBounds(872, 581, 109, 23);
		add(privado);

		if (cur.getPublico()) {
			publico.setSelected(true);
		} else {
			privado.setSelected(true);
		}

		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAforo.setBounds(590, 678, 136, 27);
		add(lblAforo);

		aforo = new JSpinner();
		aforo.setBounds(717, 675, 47, 40);
		add(aforo);

		aforo.setValue(c.getAforo());

		JLabel lblModo = new JLabel("Modo:");
		lblModo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModo.setBounds(590, 784, 136, 27);
		add(lblModo);

		presencial = new JRadioButton("Presencial");
		presencial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		presencial.setBounds(701, 786, 120, 23);
		add(presencial);

		online = new JRadioButton("Online");
		online.setFont(new Font("Tahoma", Font.PLAIN, 20));
		online.setBounds(872, 786, 109, 23);
		add(online);

		if (c.getPresencial()) {
			presencial.setSelected(true);
		} else {
			online.setSelected(true);
		}

		guardar = new JButton(new ImageIcon(getClass().getResource("/img/guardar.png")));
		guardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		guardar.setContentAreaFilled(false);
		guardar.setFocusPainted(false);
		guardar.setBorderPainted(false);
		guardar.setText("Guardar cambios");
		guardar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		guardar.setBounds(1128, 784, 249, 49);
		add(guardar);

		eliminar = new JButton(new ImageIcon(getClass().getResource("/img/eliminar.png")));
		eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminar.setContentAreaFilled(false);
		eliminar.setFocusPainted(false);
		eliminar.setBorderPainted(false);
		eliminar.setText("Eliminar curso");
		eliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eliminar.setBounds(1118, 867, 249, 49);
		add(eliminar);

		lblForo = new JLabel("Foro:");
		lblForo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblForo.setBounds(601, 871, 136, 40);
		add(lblForo);

		foro = new JCheckBox("");
		foro.setBounds(701, 871, 97, 40);
		foro.setSelected(c.getTieneForo());
		add(foro);

		volver = new JButton(new ImageIcon(getClass().getResource("/img/volver.png")));
		volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volver.setContentAreaFilled(false);
		volver.setFocusPainted(false);
		volver.setBorderPainted(false);
		volver.setBounds(448, 117, 78, 67);
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
