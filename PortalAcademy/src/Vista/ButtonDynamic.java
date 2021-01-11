package Vista;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ButtonDynamic extends JButton {

	public static final String CERRAR_SESION = "resources/img/cerrar_sesion.png";
	public static final int CERRAR_SESION_WIDTH_I = 114;
	public static final int CERRAR_SESION_HEIGHT_I = 52;
	public static final int CERRAR_SESION_WIDTH_F = 114;
	public static final int CERRAR_SESION_HEIGHT_F = 52;
	public static final String USUARIO = "resources/img/usuario.png";
	public static final int USUARIO_WIDTH_I = 84;
	public static final int USUARIO_HEIGHT_I = 73;
	public static final int USUARIO_WIDTH_F = 325;
	public static final int USUARIO_HEIGHT_F = 73;
	public static final String SUBIR = "resources/img/subir_archivo.png";
	public static final int SUBIR_WIDTH_I = 400;
	public static final int SUBIR_HEIGHT_I = 73;

	private String name;
	private String icono;

	public ButtonDynamic(String name, String icono) {
		super();
		this.name = name;
		this.icono = icono;
		setIcon(new ImageIcon(icono));
		setFont(new Font("Tahoma", Font.ITALIC, 16));
		setContentAreaFilled(false);
		setBorderPainted(false);

		if (icono == CERRAR_SESION) {
			setHorizontalTextPosition(LEFT);
			setHorizontalAlignment(CENTER);
			setVerticalTextPosition(BOTTOM);
			setVerticalAlignment(CENTER);
			setPreferredSize(new Dimension(CERRAR_SESION_WIDTH_I, CERRAR_SESION_HEIGHT_I));

		} else if (icono == USUARIO) {
			setHorizontalTextPosition(RIGHT);
			setHorizontalAlignment(LEFT);
			setVerticalTextPosition(CENTER);
			setVerticalAlignment(CENTER);
			setPreferredSize(new Dimension(USUARIO_WIDTH_I, USUARIO_HEIGHT_I));
		} else if (icono == SUBIR) {
			setHorizontalTextPosition(CENTER);
			setHorizontalAlignment(CENTER);
			setVerticalTextPosition(BOTTOM);
			setVerticalAlignment(CENTER);
			setPreferredSize(new Dimension(SUBIR_WIDTH_I, SUBIR_HEIGHT_I));
		}
	}

	public String getName() {
		return name;
	}

	public String getIcono() {
		return icono;
	}
}
