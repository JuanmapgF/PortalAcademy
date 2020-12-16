package Vista;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Modelo.Curso;
import Modelo.Profesor;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class EditarCurso extends JPanel {

	private Curso c;
	private Profesor usuario;
	
	private JButton explorar;
	private JButton cursos;
	private JButton ajustes;
	
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
	private JButton cerrarsesion;
	
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
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblDescripcin.setBounds(264, 214, 136, 27);
		add(lblDescripcin);
		
		descripcion = new JTextArea();
		descripcion.setBounds(400, 191, 311, 113);
		descripcion.setText(c.getDescripcion());
		add(descripcion);
		
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
		
		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);
		
		cursos = new JButton("Mis cursos");
		cursos.setBounds(36, 261, 131, 32);
		add(cursos);
		
		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 336, 131, 32);
		add(ajustes);
		
		lblForo = new JLabel("Foro:");
		lblForo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		lblForo.setBounds(704, 518, 136, 27);
		add(lblForo);
		
		foro = new JCheckBox("");
		foro.setBounds(781, 518, 97, 23);
		foro.setSelected(c.getTieneForo());
		add(foro);
		
		volver = new JButton("Volver");
		volver.setBounds(867, 584, 144, 23);
		add(volver);
		
		cerrarsesion = new JButton("Cerrar sesi\u00F3n");
		cerrarsesion.setBounds(867, 26, 144, 23);
		add(cerrarsesion);
	}
	
	public void controlador(ActionListener ctr) {
		guardar.addActionListener(ctr);
		guardar.setActionCommand("GUARDAR");
		
		eliminar.addActionListener(ctr);
		eliminar.setActionCommand("ELIMINAR");
		
		volver.addActionListener(ctr);
		volver.setActionCommand("VOLVER");
		
		cerrarsesion.addActionListener(ctr);
		cerrarsesion.setActionCommand("CERRAR_SESION");
		
		explorar.addActionListener(ctr);
		explorar.setActionCommand("EXPLORAR");
		
		cursos.addActionListener(ctr);
		cursos.setActionCommand("CURSOS");
		
		ajustes.addActionListener(ctr);
		ajustes.setActionCommand("AJUSTES");
		
		publico.addActionListener(ctr);
		publico.setActionCommand("PUBLICO");
		
		privado.addActionListener(ctr);
		privado.setActionCommand("PRIVADO");
		
		presencial.addActionListener(ctr);
		presencial.setActionCommand("PRESENCIAL");
		
		online.addActionListener(ctr);
		online.setActionCommand("ONLINE");
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
