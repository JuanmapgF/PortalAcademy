package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

public class Explorar extends JPanel {

	private DefaultListModel<String> modeloC = new DefaultListModel<String>();
	private DefaultListModel<String> modeloA = new DefaultListModel<String>();
	private DefaultListModel<String> modeloN = new DefaultListModel<String>();
	private JList<String> listaC;
	private JList<String> listaA;
	private JList<String> listaN;
	private JButton iniciar;
	private JButton cerrar;
	private JButton registrarse;
	private JButton seleccion;
	private Usuario usuario;
	
	private JButton explorar;
	private JButton cursos;
	private JButton actividades;
	private JButton ajustes;
	
	private int index;
	
	public Explorar(Estudiante u, List<Curso> c, List<Actividad> a) {
		this.setBounds(0,0,1080,650);
		usuario = u;
		setLayout(null);
		
		listaC = new JList<String>();
		listaC.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent event) {
		        if (!event.getValueIsAdjusting()){
		        	index = listaC.getSelectedIndex();
		            System.out.println(index);
		        }
		    }
		});
		listaA = new JList<String>();
		listaA.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent event) {
		        if (!event.getValueIsAdjusting()){
		        	index = listaA.getSelectedIndex();
		            System.out.println(index);
		        }
		    }
		});
		addElements(c, a);
		
		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(543, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);
		
		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);
		
		JLabel t_curso = new JLabel("Cursos:");
		t_curso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_curso.setBounds(295, 159, 90, 33);
		add(t_curso);
		
		JLabel t_actividad = new JLabel("Actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_actividad.setBounds(619, 159, 159, 33);
		add(t_actividad);
		
		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(325, 215, 273, 339);
		sp_curso.setViewportView(listaC);
		add(sp_curso);
		
		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(656, 215, 273, 339);
		sp_actividad.setViewportView(listaA);
		add(sp_actividad);
		
		seleccion = new JButton("Ver");
		seleccion.setBounds(567, 575, 121, 23);
		add(seleccion);
		
		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);
		
		cursos = new JButton("Mis cursos");
		cursos.setBounds(36, 261, 131, 32);
		add(cursos);
		
		actividades = new JButton("Mis actividades");
		actividades.setBounds(36, 336, 131, 32);
		add(actividades);
		
		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 413, 131, 32);
		add(ajustes);
	}
	
	public Explorar(List<Curso> c, List<Actividad> a) {
		usuario = null;
		setLayout(null);
		
		listaC = new JList<String>();
		listaC.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent event) {
		        if (!event.getValueIsAdjusting()){
		        	index = listaC.getSelectedIndex();
		            System.out.println(index);
		        }
		    }
		});
		listaA = new JList<String>();
		listaA.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent event) {
		        if (!event.getValueIsAdjusting()){
		        	index = listaA.getSelectedIndex();
		            System.out.println(index);
		        }
		    }
		});
		addElements(c, a);
		
		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(543, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);
		
		iniciar = new JButton("Iniciar sesi\u00F3n");
		iniciar.setBounds(729, 37, 121, 23);
		add(iniciar);
		
		registrarse = new JButton("Registrarse");
		registrarse.setBounds(860, 37, 121, 23);
		add(registrarse);
		
		JLabel t_curso = new JLabel("Cursos:");
		t_curso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_curso.setBounds(295, 159, 90, 33);
		add(t_curso);
		
		JLabel t_actividad = new JLabel("Actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_actividad.setBounds(619, 159, 159, 33);
		add(t_actividad);
		
		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(325, 215, 273, 339);
		sp_curso.setViewportView(listaC);
		add(sp_curso);
		
		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(656, 215, 273, 339);
		sp_actividad.setViewportView(listaA);
		add(sp_actividad);
		
		seleccion = new JButton("Ver");
		seleccion.setBounds(567, 575, 121, 23);
		add(seleccion);
		
		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);
		
		this.setBounds(0, 0, 1080, 650);
	}
	
	public Explorar(Profesor u, List<Curso> l) {
		usuario = u;
		this.setLayout(null);
		
		listaN = new JList<String>();
		addElementsC(l);
		
		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(543, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);
		
		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);
		
		JLabel t_n = new JLabel("Cursos:");
		t_n.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_n.setBounds(418, 159, 191, 33);
		add(t_n);
		
		JScrollPane sp_n = new JScrollPane();
		sp_n.setBounds(463, 215, 273, 339);
		sp_n.setViewportView(listaN);
		add(sp_n);
		
		seleccion = new JButton("Ver");
		seleccion.setBounds(567, 575, 121, 23);
		add(seleccion);
		
		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);
		
		cursos = new JButton("Mis cursos");
		cursos.setBounds(36, 261, 131, 32);
		add(cursos);
		
		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 336, 131, 32);
		add(ajustes);
		
		this.setBounds(0, 0, 1080, 650);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public Explorar(Organizacion u, List<Actividad> l) {
		usuario = u;
		this.setLayout(null);
		
		listaN = new JList<String>();
		addElementsA(l);
		
		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(543, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);
		
		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);
		
		JLabel t_n = new JLabel("Actividades:");
		t_n.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_n.setBounds(418, 159, 191, 33);
		add(t_n);
		
		JScrollPane sp_n = new JScrollPane();
		sp_n.setBounds(463, 215, 273, 339);
		sp_n.setViewportView(listaN);
		add(sp_n);
		
		seleccion = new JButton("Ver");
		seleccion.setBounds(567, 575, 121, 23);
		add(seleccion);
		
		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);
		
		actividades = new JButton("Mis actividades");
		actividades.setBounds(36, 261, 131, 32);
		add(actividades);
		
		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 336, 131, 32);
		add(ajustes);
		
		this.setBounds(0, 0, 1080, 650);
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
		} 
		if (cerrar != null) {
			cerrar.addActionListener(ctr);
			cerrar.setActionCommand("CERRAR_SESION");
		} 
		if (registrarse != null) {
			registrarse.addActionListener(ctr);
			registrarse.setActionCommand("REGISTRO");
		} 
		if (seleccion != null) {
			seleccion.addActionListener(ctr);
			seleccion.setActionCommand("VER");
		}
		if (explorar != null) {
			explorar.addActionListener(ctr);
			explorar.setActionCommand("EXPLORAR");
		}
		if (cursos != null) {
			cursos.addActionListener(ctr);
			cursos.setActionCommand("CURSO");
		}
		if (actividades != null) {
			actividades.addActionListener(ctr);
			actividades.setActionCommand("ACTIVIDAD");
		}
		if (ajustes != null) {
			ajustes.addActionListener(ctr);
			ajustes.setActionCommand("AJUSTES");
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public int getIndex() {
		return index;
	}
}
