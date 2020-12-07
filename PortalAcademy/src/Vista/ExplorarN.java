package Vista;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

public class ExplorarN extends JPanel {

public ExplorarN(Usuario u, List<Object> l) {
		
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
	}

}
