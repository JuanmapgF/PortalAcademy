package Vista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Modelo.*;

import java.awt.Font;

public class Explorar extends JPanel {
	
	/*private JLabel titulo = new JLabel("Explorar");
	private JButton iniciarSesion = new JButton("Iniciar sesión");
	private JButton cerrarSesion = new JButton("Cerrar sesión");
	private List<Curso> cursos;
	private List<Actividad> actividades;
	private JScrollPane scroll1 = new JScrollPane();
	private JScrollPane scroll2 = new JScrollPane();
	private JList listaC = new JList();
	private JList listaA = new JList();
	private DefaultListModel modeloC = new DefaultListModel();
	private DefaultListModel modeloA = new DefaultListModel();
	private JLabel curso = new JLabel("Cursos");
	private JLabel actividad = new JLabel("Actividades");*/
	
	public Explorar(Usuario u, List<Curso> c, List<Actividad> a) {
		
		if (u instanceof Estudiante) {
			
		}
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(343, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Iniciar sesi\u00F3n");
		btnNewButton.setBounds(529, 37, 121, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cerrar sesi\u00F3n");
		btnNewButton_1.setBounds(660, 37, 121, 23);
		add(btnNewButton_1);
		
		JLabel t_curso = new JLabel("Curso:");
		t_curso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_curso.setBounds(95, 159, 90, 33);
		add(t_curso);
		
		JLabel t_actividad = new JLabel("Actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_actividad.setBounds(419, 159, 159, 33);
		add(t_actividad);
		
		JLabel t_n = new JLabel("Curso:");
		t_n.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_n.setBounds(218, 159, 191, 33);
		add(t_n);
		
		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(125, 235, 273, 339);
		add(sp_curso);
		
		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(456, 235, 273, 339);
		add(sp_actividad);
		
		JScrollPane sp_n = new JScrollPane();
		sp_n.setBounds(263, 235, 273, 339);
		add(sp_n);
		
		/*cursos = c;
		actividades = a;
		
		listaC.setModel(modeloC);
		listaA.setModel(modeloA);
		
		addElements();
		
		addScroll();
		
		JPanel title = new JPanel();
		title.setLayout(new BorderLayout());
		title.add(titulo, BorderLayout.CENTER);
		title.add(iniciarSesion, BorderLayout.EAST);
		title.add(cerrarSesion, BorderLayout.EAST);
		
		JPanel explorar = new JPanel();
		explorar.setLayout(new BorderLayout());
		
		JPanel oeste = new JPanel();
		oeste.setLayout(new BorderLayout());
		oeste.add(curso, BorderLayout.NORTH);
		oeste.add(scroll1, BorderLayout.SOUTH);
		
		JPanel este = new JPanel();
		este.setLayout(new BorderLayout());
		este.add(actividad, BorderLayout.WEST);
		oeste.add(scroll2, BorderLayout.SOUTH);
		
		explorar.add(oeste, BorderLayout.WEST);
		explorar.add(este, BorderLayout.EAST);
		
		JPanel res = new JPanel();
		res.setLayout(new BorderLayout());
		res.add(title, BorderLayout.NORTH);
		res.add(explorar, BorderLayout.SOUTH);
		
		this.add(res);*/
	}
}