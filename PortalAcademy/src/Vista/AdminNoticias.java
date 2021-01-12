package Vista;

import java.awt.Color;
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
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(726, 812, 466, 40);
		add(lblNewLabel);
		
		bCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		bCerrarSesion.setVerticalAlignment(SwingConstants.TOP);
		bCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bCerrarSesion.setBounds(1647, 58, 202, 48);
		add(bCerrarSesion);

		bInicio = new JButton("Inicio");
		bInicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bInicio.setBounds(64, 246, 143, 40);
		add(bInicio);

		bCursos_1 = new JButton("Cursos");
		bCursos_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bCursos_1.setBounds(64, 312, 143, 40);
		add(bCursos_1);

		bActividades_1 = new JButton("Actividades");
		bActividades_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bActividades_1.setBounds(64, 376, 143, 40);
		add(bActividades_1);

		bUsuarios_1 = new JButton("Usuarios");
		bUsuarios_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bUsuarios_1.setBounds(64, 437, 143, 40);
		add(bUsuarios_1);
		
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
		agregarNoticia.setContentAreaFilled(false);
		agregarNoticia.setFocusPainted(false);
		agregarNoticia.setBorderPainted(false);
		add(agregarNoticia);
		
		bForos_1 = new JButton("Foros");
		bForos_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bForos_1.setBounds(64, 498, 143, 40);
		add(bForos_1);

		bNoticias_1 = new JButton("Noticias");
		bNoticias_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bNoticias_1.setBounds(64, 567, 143, 40);
		add(bNoticias_1);
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
		// TODO Auto-generated method stub
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        this.setOpaque(false);
		
		super.paint(g);
	}

}
