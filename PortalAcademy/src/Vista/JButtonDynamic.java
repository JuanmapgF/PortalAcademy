package Vista;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class JButtonDynamic extends JButton {

	public static final String CERRAR_SESION = "resources/img/cerrarSesion.png";
	private static final int CERRAR_SESION_WIDTH = 114;
	private static final int CERRAR_SESION_HEIGHT = 52;

	private String name;

	public JButtonDynamic(String name, String icono) {
		super();
		this.name = name;
		setIcon(new ImageIcon(icono));
		setFont(new Font("HP Simplified", Font.ITALIC, 15));
		setContentAreaFilled(false);
		setHorizontalTextPosition(CENTER);
		setHorizontalAlignment(CENTER);
		setVerticalTextPosition(BOTTOM);
		setVerticalAlignment(CENTER);

		if (icono == CERRAR_SESION) {
			setPreferredSize(new Dimension(CERRAR_SESION_WIDTH, CERRAR_SESION_HEIGHT));
		}
	}

	public String getName() {
		return name;
	}
}
