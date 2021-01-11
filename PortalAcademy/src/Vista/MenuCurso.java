package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Modelo.Curso;

@SuppressWarnings("serial")
public class MenuCurso extends JPanel{
	
	private JButton btnInicio;
	private JButton btnTemario;
	private JButton btnCuestionarios;
	private JButton btnForo;
	private Curso c;
	
	public MenuCurso(Curso curso) {
		c = curso;
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInicio.setBounds(328, 278, 174, 40);
		add(btnInicio);
		
		btnTemario = new JButton("Temario");
		btnTemario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTemario.setBounds(592, 278, 174, 40);
		add(btnTemario);
		
		btnCuestionarios = new JButton("Cuestionarios");
		btnCuestionarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCuestionarios.setBounds(854, 278, 174, 40);
		add(btnCuestionarios);
		
		if(curso.getTieneForo()) {
			btnForo = new JButton("Foro");
			btnForo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnForo.setBounds(1115, 278, 174, 40);
			add(btnForo);
		}
		
		
	}
	
	public Curso getCurso() {
		return c;
	}
	
	public void controlador(ActionListener ctr) {
		if (btnInicio != null) {
			btnInicio.addActionListener(ctr);
			btnInicio.setActionCommand("INICIO");
		}
		if (btnTemario != null) {
			btnTemario.addActionListener(ctr);
			btnTemario.setActionCommand("TEMARIO");
		}
		if (btnCuestionarios != null) {
			btnCuestionarios.addActionListener(ctr);
			btnCuestionarios.setActionCommand("CUESTIONARIOS");
		}
		if (btnForo != null) {
			btnForo.addActionListener(ctr);
			btnForo.setActionCommand("FORO");
		}
	}
}
