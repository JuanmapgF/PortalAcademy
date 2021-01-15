package Vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

import Modelo.MensajeNoticia;

@SuppressWarnings("serial")
public class AdminNoticias extends JPanel {

	public JButton bCerrarSesion, bInicio, bCursos_1, bActividades_1, bUsuarios_1, agregarNoticia, bForos_1, bNoticias_1;
	private JTextField nuevoMensaje;
	
	private List<MensajeNoticia> lista_noticias = MensajeNoticia.getTodasLasNoticias();
	private JTable noticias;
	private Object[][] datosNoticias = null;
	
	private URL url = getClass().getResource("/img/fondoBlanco.jpg");
    Image image = new ImageIcon(url).getImage();
	
	/**
	 * Create the panel.
	 */
	public AdminNoticias() {
		setLayout(null);
		this.setBounds(0, 0, 1920, 1080);
		
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

		
		
		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: " + Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);
		
		cargarNoticias();
		
		JScrollPane sp_noticias = new JScrollPane(noticias, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp_noticias.setWheelScrollingEnabled(true);
		sp_noticias.setBounds(431, 179, 1133, 170);
		sp_noticias.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_noticias);
		sp_noticias.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		noticias.setRowHeight(0, 130);
		noticias.setRowHeight(1, 40);
		noticias.setShowHorizontalLines(false);
		noticias.setShowVerticalLines(false);
		for (int i = 0; i < noticias.getModel().getColumnCount(); i++) {
			noticias.getColumnModel().getColumn(i).setMaxWidth(170);
			noticias.getColumnModel().getColumn(i).setMinWidth(170);
		}
		noticias.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		nuevoMensaje = new JTextField();
		nuevoMensaje.setBounds(431, 380, 560, 46);
		nuevoMensaje.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(nuevoMensaje);
		nuevoMensaje.setColumns(10);
		
		agregarNoticia = new JButton(new ImageIcon(getClass().getResource("/img/agregar.png")));
		agregarNoticia.setBounds(1051, 375, 57, 59);
		agregarNoticia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		agregarNoticia.setContentAreaFilled(false);
		agregarNoticia.setFocusPainted(false);
		agregarNoticia.setBorderPainted(false);
		add(agregarNoticia);
		
	}
	
	private void cargarNoticias() {
		datosNoticias = new Object[2][lista_noticias.size()];
		
		int k = 0;
		
		for (MensajeNoticia noticia : lista_noticias) {
			datosNoticias[0][k] = noticia.getTexto();
			datosNoticias[1][k] = noticia.getFecha();
			k++;
		}
		
		String columnHeadersNoticias[] = new String[lista_noticias.size()];
		for (int i = 0; i < lista_noticias.size(); i++) {
			columnHeadersNoticias[i] = "";
		}
		
		noticias = new JTable(datosNoticias, columnHeadersNoticias);
		for (int i = 0; i < noticias.getModel().getColumnCount(); i++) {
			noticias.getColumnModel().getColumn(i).setCellRenderer(new NoticiasRenderer());
		}
		noticias.setTableHeader(null);
		noticias.setCellSelectionEnabled(false);
	}
	
	
	public String getNoticia() {
		return nuevoMensaje.getText();
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
		
		super.paint(g);
	}

}
