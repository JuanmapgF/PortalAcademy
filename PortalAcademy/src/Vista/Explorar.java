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

@SuppressWarnings("serial")
public class Explorar extends JPanel {
	
	private DefaultListModel<String> modeloC = new DefaultListModel<String>();
	private DefaultListModel<String> modeloA = new DefaultListModel<String>();
	private DefaultListModel<String> modeloN = new DefaultListModel<String>();
	private JList<String> listaC = new JList<String>();
	private JList<String> listaA = new JList<String>();
	private JList<String> listaN = new JList<String>();
	
	public Explorar(Usuario u, List<Curso> c, List<Actividad> a) {
		setLayout(null);
		
		addElements(c, a);
		
		if (u instanceof Estudiante) {
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
			
			JScrollPane sp_curso = new JScrollPane();
			sp_curso.setBounds(125, 235, 273, 339);
			sp_curso.setViewportView(listaC);
			add(sp_curso);
			
			JScrollPane sp_actividad = new JScrollPane();
			sp_actividad.setBounds(456, 235, 273, 339);
			sp_actividad.setViewportView(listaA);
			add(sp_actividad);
		} else {
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
			sp_curso.setViewportView(listaC);
			add(sp_curso);
			
			JScrollPane sp_actividad = new JScrollPane();
			sp_actividad.setBounds(456, 235, 273, 339);
			sp_actividad.setViewportView(listaA);
			add(sp_actividad);
			
			JScrollPane sp_n = new JScrollPane();
			sp_n.setBounds(263, 235, 273, 339);
			add(sp_n);
		}
		
		this.setBounds(200, 0, 880, 650);
	}
	
	public Explorar(Usuario u, List<Object> l) {
		this.setLayout(null);
		
		addElements(l);
		
		if (u instanceof Profesor) {
			JLabel lblNewLabel = new JLabel("Explorar");
			lblNewLabel.setBounds(343, 30, 107, 33);
			lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
			add(lblNewLabel);
			
			JButton btnNewButton_1 = new JButton("Cerrar sesi\u00F3n");
			btnNewButton_1.setBounds(660, 37, 121, 23);
			add(btnNewButton_1);
			
			JLabel t_n = new JLabel("Cursos:");
			t_n.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
			t_n.setBounds(218, 159, 191, 33);
			add(t_n);
			
			JScrollPane sp_n = new JScrollPane();
			sp_n.setBounds(263, 235, 273, 339);
			sp_n.setViewportView(listaN);
			add(sp_n);
		} else if (u instanceof Organizacion) {
			JLabel lblNewLabel = new JLabel("Explorar");
			lblNewLabel.setBounds(343, 30, 107, 33);
			lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
			add(lblNewLabel);
			
			JButton btnNewButton_1 = new JButton("Cerrar sesi\u00F3n");
			btnNewButton_1.setBounds(660, 37, 121, 23);
			add(btnNewButton_1);
			
			JLabel t_n = new JLabel("Actividades:");
			t_n.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
			t_n.setBounds(218, 159, 191, 33);
			add(t_n);
			
			JScrollPane sp_n = new JScrollPane();
			sp_n.setBounds(263, 235, 273, 339);
			sp_n.setViewportView(listaN);
			add(sp_n);
		}
		
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
	
	public void addElements(List<Object> l) {
		listaN.setModel(modeloN);
		
		for (Object o : l) {
			modeloN.addElement(o.toString());
		}
		
		listaN.setLayoutOrientation(JList.VERTICAL);
	}
}