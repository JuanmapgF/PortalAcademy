package Vista;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Modelo.*;

import java.awt.Font;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class Explorar extends JPanel {
	
	private DefaultListModel<String> modeloC = new DefaultListModel<String>();
	private DefaultListModel<String> modeloA = new DefaultListModel<String>();
	private DefaultListModel<String> modeloN = new DefaultListModel<String>();
	private JList<String> listaC = new JList<String>();
	private JList<String> listaA = new JList<String>();
	private JList<String> listaN = new JList<String>();
	private JButton iniciar;
	private JButton cerrar;
	private JButton registrarse;
	private JButton seleccion;
	private Usuario usuario;
	
	public Explorar(Estudiante u, List<Curso> c, List<Actividad> a) {
		usuario = u;
		setLayout(null);
		addElements(c, a);
		
		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(343, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);
		
		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(660, 37, 121, 23);
		add(cerrar);
		
		JLabel t_curso = new JLabel("Curso:");
		t_curso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_curso.setBounds(95, 159, 90, 33);
		add(t_curso);
		
		JLabel t_actividad = new JLabel("Actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_actividad.setBounds(419, 159, 159, 33);
		add(t_actividad);
		
		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(125, 235, 273, 339);
		sp_curso.setViewportView(listaC);
		add(sp_curso);
		
		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(456, 235, 273, 339);
		sp_actividad.setViewportView(listaA);
		add(sp_actividad);
		
		seleccion = new JButton("Ver");
		seleccion.setBounds(367, 610, 121, 23);
		add(seleccion);
		
		this.setBounds(200, 0, 880, 650);
	}
	
	public Explorar(List<Curso> c, List<Actividad> a) {
		usuario = null;
		setLayout(null);
		addElements(c, a);
		
		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(343, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);
		
		iniciar = new JButton("Iniciar sesi\u00F3n");
		iniciar.setBounds(529, 37, 121, 23);
		add(iniciar);
		
		registrarse = new JButton("Registrarse");
		registrarse.setBounds(660, 37, 121, 23);
		add(registrarse);
		
		JLabel t_curso = new JLabel("Curso:");
		t_curso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_curso.setBounds(95, 159, 90, 33);
		add(t_curso);
		
		JLabel t_actividad = new JLabel("Actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_actividad.setBounds(419, 159, 159, 33);
		add(t_actividad);
		
		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(125, 235, 273, 339);
		sp_curso.setViewportView(listaC);
		add(sp_curso);
		
		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(456, 235, 273, 339);
		sp_actividad.setViewportView(listaA);
		add(sp_actividad);
		
		seleccion = new JButton("Ver");
		seleccion.setBounds(367, 610, 121, 23);
		add(seleccion);
		
		this.setBounds(200, 0, 880, 650);
	}
	
	
	
	public Explorar(Profesor u, List<Curso> l) {
		usuario = u;
		this.setLayout(null);
		
		addElementsC(l);
		
		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(343, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);
		
		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(660, 37, 121, 23);
		add(cerrar);
		
		JLabel t_n = new JLabel("Cursos:");
		t_n.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_n.setBounds(218, 159, 191, 33);
		add(t_n);
		
		JScrollPane sp_n = new JScrollPane();
		sp_n.setBounds(263, 235, 273, 339);
		sp_n.setViewportView(listaN);
		add(sp_n);
		
		seleccion = new JButton("Ver");
		seleccion.setBounds(367, 610, 121, 23);
		add(seleccion);
		
		this.setBounds(200, 0, 880, 650);
	}
	
	public Explorar(Organizacion u, List<Actividad> l) {
		usuario = u;
		this.setLayout(null);
		
		addElementsA(l);
		
		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(343, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);
		
		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(660, 37, 121, 23);
		add(cerrar);
		
		JLabel t_n = new JLabel("Actividades:");
		t_n.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_n.setBounds(218, 159, 191, 33);
		add(t_n);
		
		JScrollPane sp_n = new JScrollPane();
		sp_n.setBounds(263, 235, 273, 339);
		sp_n.setViewportView(listaN);
		add(sp_n);
		
		seleccion = new JButton("Ver");
		seleccion.setBounds(367, 610, 121, 23);
		add(seleccion);
		
		this.setBounds(200, 0, 880, 650);
	}
	
	public void addElements(List<Curso> c, List<Actividad> a) {
		listaC.setModel(modeloC);
		listaA.setModel(modeloA);
		
		for (Curso o : c) {
			modeloC.addElement(o.toString());
		}
		
		for (Actividad d : a) {
			modeloA.addElement(d.toString());
		}
		
		listaC.setLayoutOrientation(JList.VERTICAL);
		listaA.setLayoutOrientation(JList.VERTICAL);
	}
	
	public void addElementsC(List<Curso> l) {
		listaN.setModel(modeloN);
		
		for (Curso o : l) {
			modeloN.addElement(o.toString());
		}
		
		listaN.setLayoutOrientation(JList.VERTICAL);
	}
	
	public void addElementsA(List<Actividad> l) {
		listaN.setModel(modeloN);
		
		for (Object o : l) {
			modeloN.addElement(o.toString());
		}
		
		listaN.setLayoutOrientation(JList.VERTICAL);
	}
	
	public void controlador(ActionListener ctr) {
		if (iniciar != null) {
			iniciar.addActionListener(ctr);
			iniciar.setActionCommand("INICIAR_SESION");
		} else if (cerrar != null) {
			cerrar.addActionListener(ctr);
			cerrar.setActionCommand("CERRAR_SESION");
		} else if (registrarse != null) {
			registrarse.addActionListener(ctr);
			registrarse.setActionCommand("REGISTRO");
		} else if (seleccion != null) {
			seleccion.addActionListener(ctr);
			seleccion.setActionCommand("VER");
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
}