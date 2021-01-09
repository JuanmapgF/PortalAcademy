package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controlador.CtrMenu;
import Controlador.CtrMenuCurso;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Mensaje;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class InformacionCurso extends JPanel {
	
	private JButton editar;
	private JButton editarParticipantes;

	/**
	 * Create the panel.
	 *
	 */
	public InformacionCurso(Usuario user, Curso curso) {
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		
		JLabel nombreCurso = new JLabel(curso.getNombre());
		nombreCurso.setBounds(429, 189, 364, 33);
		nombreCurso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(nombreCurso);
		
		
		
		JTextArea descripcionCurso = new JTextArea(curso.getDescripcion());
		
		descripcionCurso.setEditable(false);
		JScrollPane jsp = new JScrollPane(descripcionCurso);
		jsp.setBounds(429, 258, 777, 345);
		add(jsp);
		
		//-----
		if (curso.getTieneForo()) {
			
		}
		
		if (user == null) {
			CtrMenu menu = new CtrMenu(new Menu());
			add(menu.getPanel());
		}  else if (user instanceof Profesor) {
			if(user.equals(curso.getProfesor())) {
				editar = new JButton("Editar Curso");
				editar.setBounds(752, 68, 119, 23);
				add(editar);
				
				editarParticipantes = new JButton("Editar Participantes");
				editarParticipantes.setBounds(752, 168, 149, 23);
				add(editarParticipantes);
			}
			CtrMenu menu = new CtrMenu(new Menu((Profesor)user));
			add(menu.getPanel());
		} else if(user instanceof Organizacion){
			CtrMenu menu = new CtrMenu(new Menu((Organizacion)user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante)user));
			add(menu.getPanel());
		}
		
		CtrMenuCurso menuc = new CtrMenuCurso(new MenuCurso(curso));
		add(menuc.getPanel());
	}

	
	public void controlador(ActionListener ctr) {
		
		
		
		if (editarParticipantes != null) {
			editarParticipantes.addActionListener(ctr);
			editarParticipantes.setActionCommand("EditarParticipantes");
		}
		
		if (editar != null) {
			editar.addActionListener(ctr);
			editar.setActionCommand("Editar");
		}
		
	}
	
	
}
