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

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;

public class MisActividades extends JPanel {

	private DefaultListModel<String> modeloA = new DefaultListModel<String>();
	private JList<String> listaA = new JList<String>();
	private JButton bVer = new JButton();
	private JButton bVer2 = new JButton();
	private List<Actividad> l;
	
	public MisActividades(Estudiante u) {
		this.setLayout(null);
		addElements(u.getActividades());
		
		JScrollPane sp_actividades = new JScrollPane();
		sp_actividades.setBounds(241, 75, 346, 346);
		sp_actividades.setViewportView(listaA);
		add(sp_actividades);
		
		JLabel t_actividad = new JLabel("Mis actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		t_actividad.setBounds(303, 31, 209, 33);
		add(t_actividad);
		
		this.setBounds(200, 0, 880, 650);
		
		JButton bVer = new JButton("Ver actividad");
		bVer.setBounds(362, 475, 103, 23);
		add(bVer);
	}
	
	
	public MisActividades(Organizacion u) {
		this.setLayout(null);
		addElements(u.getActividades());
		
		JScrollPane sp_actividades = new JScrollPane();
		sp_actividades.setBounds(241, 75, 346, 346);
		sp_actividades.setViewportView(listaA);
		add(sp_actividades);
		
		JLabel t_actividad = new JLabel("Mis actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		t_actividad.setBounds(303, 31, 209, 33);
		add(t_actividad);
		
		this.setBounds(200, 0, 880, 650);
		
		JButton bVer2 = new JButton("Ver actividad");
		bVer2.setBounds(362, 475, 103, 23);
		add(bVer2);
	}
	
	public void addElements(List<Actividad> l) {
		this.l = l;
		listaA.setModel(modeloA);
		
		for (Object o : l) {
			modeloA.addElement(o.toString());
		}
		
		listaA.setLayoutOrientation(JList.VERTICAL);
	}
	
	public Actividad getA(){
		if(!listaA.isSelectionEmpty()) {
			return l.get(listaA.getSelectedIndex());
		}else {
			return null;
		}
	}
	
	public void controlador(ActionListener ctr) {
		bVer.addActionListener(ctr);
		bVer.setActionCommand("MISACTIVIDADESUSUARIO");
		
		bVer2.addActionListener(ctr);
		bVer2.setActionCommand("MISACTIVIDADESORGANIZACION");
	}

}
