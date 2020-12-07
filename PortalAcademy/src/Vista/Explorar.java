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
	
	private DefaultListModel modeloC;
	private DefaultListModel modeloA;
	
	public Explorar(Usuario u, List<Curso> c, List<Actividad> a) {
		setLayout(null);
		
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
			add(sp_curso);
			
			JScrollPane sp_actividad = new JScrollPane();
			sp_actividad.setBounds(456, 235, 273, 339);
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
			add(sp_curso);
			
			JScrollPane sp_actividad = new JScrollPane();
			sp_actividad.setBounds(456, 235, 273, 339);
			add(sp_actividad);
			
			JScrollPane sp_n = new JScrollPane();
			sp_n.setBounds(263, 235, 273, 339);
			add(sp_n);
		}
		
		this.setBounds(200, 0, 880, 650);
	}
	
	public Explorar(Usuario u, List<Object> l) {
		
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
			add(sp_n);
		}
		
		this.setBounds(200, 0, 880, 650);
	}
}