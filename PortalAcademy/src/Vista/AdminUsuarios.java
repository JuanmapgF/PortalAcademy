package Vista;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Modelo.Usuario;

@SuppressWarnings("serial")
public class AdminUsuarios extends JPanel {

	public JButton bCerrarSesion, bInicio, bCursos_1, bActividades_1, bUsuarios_1,  bForos_1, bNoticias_1, bEliminar;

	private DefaultListModel<String> modeloA = new DefaultListModel<String>();
	private JList<String> listA = new JList<String>();
	private List<Usuario> lista_usuarios;
	
	private URL url = getClass().getResource("/img/fondoBlanco.jpg");
    Image image = new ImageIcon(url).getImage();

	/**
	 * Create the panel.
	 */
	public AdminUsuarios() {

		this.setBounds(0, 0, 1920, 1080);
		this.setLayout(null);

		// para mostrar la lista de Usuarios en el scrollpanel
		listA.setModel(modeloA);
		lista_usuarios = Usuario.getUsuarios();
		lista_usuarios.remove(Main.getUser());
		for (Usuario u : lista_usuarios) {
			modeloA.addElement(u.toString());
		}
		listA.setLayoutOrientation(JList.VERTICAL);
		// ------------------------------------------------------

		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(680, 975, 593, 40);
		add(lblNewLabel);

		bCerrarSesion = new JButton(new ImageIcon(getClass().getResource("/img/cerrarSesion.png")));
		bCerrarSesion.setBounds(1718, 47, 81, 74);
		bCerrarSesion.setContentAreaFilled(false);
		bCerrarSesion.setFocusPainted(false);
		bCerrarSesion.setBorderPainted(false);
		bCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(bCerrarSesion);

		bInicio = new JButton(new ImageIcon(getClass().getResource("/img/inicioAdmin.png")));
		bInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bInicio.setContentAreaFilled(false);
		bInicio.setFocusPainted(false);
		bInicio.setBorderPainted(false);
		bInicio.setBounds(64, 246, 199, 60);
		add(bInicio);

		bCursos_1 = new JButton(new ImageIcon(getClass().getResource("/img/cursos.png")));
		bCursos_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bCursos_1.setContentAreaFilled(false);
		bCursos_1.setFocusPainted(false);
		bCursos_1.setBorderPainted(false);
		bCursos_1.setBounds(64, 318, 199, 60);
		add(bCursos_1);

		bActividades_1 = new JButton(new ImageIcon(getClass().getResource("/img/actividades.png")));
		bActividades_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bActividades_1.setContentAreaFilled(false);
		bActividades_1.setFocusPainted(false);
		bActividades_1.setBorderPainted(false);
		bActividades_1.setBounds(64, 389, 199, 60);
		add(bActividades_1);
		
		bUsuarios_1 = new JButton(new ImageIcon(getClass().getResource("/img/usuarios.png")));
		bUsuarios_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bUsuarios_1.setContentAreaFilled(false);
		bUsuarios_1.setFocusPainted(false);
		bUsuarios_1.setBorderPainted(false);
		bUsuarios_1.setBounds(64, 460, 199, 60);
		add(bUsuarios_1);
		
		bForos_1 = new JButton(new ImageIcon(getClass().getResource("/img/foros.png")));
		bForos_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bForos_1.setContentAreaFilled(false);
		bForos_1.setFocusPainted(false);
		bForos_1.setBorderPainted(false);
		bForos_1.setBounds(64, 531, 199, 60);
		add(bForos_1);

		bNoticias_1 = new JButton(new ImageIcon(getClass().getResource("/img/noticias.png")));
		bNoticias_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bNoticias_1.setContentAreaFilled(false);
		bNoticias_1.setFocusPainted(false);
		bNoticias_1.setBorderPainted(false);
		bNoticias_1.setBounds(64, 602, 199, 60);
		add(bNoticias_1);

		JLabel lblNewLabel_1 = new JLabel("Usuarios");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(858, 190, 381, 74);
		add(lblNewLabel_1);

		JScrollPane spUsuarios = new JScrollPane();
		spUsuarios.setBounds(600, 300, 700, 400);
		spUsuarios.setViewportView(listA);
		add(spUsuarios);

		bEliminar = new JButton(new ImageIcon(getClass().getResource("/img/eliminarAdmin.png")));
		bEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bEliminar.setContentAreaFilled(false);
		bEliminar.setFocusPainted(false);
		bEliminar.setBorderPainted(false);
		bEliminar.setBounds(1451, 454, 199, 74);
		add(bEliminar);

		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: " + Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);
		
	}

	public Usuario getUsuario() {
		if (listA.isSelectionEmpty()) {
			return null;
		} else {
			return lista_usuarios.get(listA.getSelectedIndex());
		}
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
		
		super.paint(g);
	}
}
