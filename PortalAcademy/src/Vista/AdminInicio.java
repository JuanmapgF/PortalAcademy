package Vista;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AdminInicio extends JPanel {

	public JButton bCerrarSesion, bCursos, bActividades, bUsuarios, bInicio, bCursos_1, bActividades_1, bUsuarios_1,
			bNoticias, bForos, bForos_1, bNoticias_1;
	
	private URL url = getClass().getResource("/img/fondoBlanco.jpg");
    Image image = new ImageIcon(url).getImage();

	/**
	 * Create the panel.
	 */
	public AdminInicio() {

		this.setBounds(0, 0, 1920, 1080);
		this.setLayout(null);

		bCursos = new JButton(new ImageIcon(getClass().getResource("/img/cursos.png")));
		bCursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bCursos.setContentAreaFilled(false);
		bCursos.setFocusPainted(false);
		bCursos.setBorderPainted(false);
		bCursos.setBounds(764, 229, 199, 60);
		add(bCursos);

		bActividades = new JButton(new ImageIcon(getClass().getResource("/img/actividades.png")));
		bActividades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bActividades.setContentAreaFilled(false);
		bActividades.setFocusPainted(false);
		bActividades.setBorderPainted(false);
		bActividades.setBounds(764, 324, 199, 60);
		add(bActividades);

		bUsuarios = new JButton(new ImageIcon(getClass().getResource("/img/usuarios.png")));
		bUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bUsuarios.setContentAreaFilled(false);
		bUsuarios.setFocusPainted(false);
		bUsuarios.setBorderPainted(false);
		bUsuarios.setBounds(764, 416, 199, 60);
		add(bUsuarios);
		
		bForos = new JButton(new ImageIcon(getClass().getResource("/img/foros.png")));
		bForos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bForos.setContentAreaFilled(false);
		bForos.setFocusPainted(false);
		bForos.setBorderPainted(false);
		bForos.setBounds(764, 510, 199, 60);
		add(bForos);

		bNoticias = new JButton(new ImageIcon(getClass().getResource("/img/noticias.png")));
		bNoticias.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bNoticias.setContentAreaFilled(false);
		bNoticias.setFocusPainted(false);
		bNoticias.setBorderPainted(false);
		bNoticias.setBounds(764, 602, 199, 60);
		add(bNoticias);

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

		JLabel lblNewLabel_1 = new JLabel("Administrador");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(735, 105, 534, 74);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: " + Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);

		

	}
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
		
		super.paint(g);
	}
}
