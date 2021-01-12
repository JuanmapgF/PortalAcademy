package Vista;

import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ButtonDynamic extends JButton {

	public final URL USUARIO = getClass().getResource("/img/usuario.png");
	public final int USUARIO_WIDTH_I = 84;
	public final int USUARIO_HEIGHT_I = 73;
	public final int USUARIO_WIDTH_F = 325;
	public final int USUARIO_HEIGHT_F = 73;
	public final URL SUBIR = getClass().getResource("/img/subir_archivo.png");
	public final int SUBIR_WIDTH_I = 400;
	public final int SUBIR_HEIGHT_I = 73;

	private String name;
	private String tipo;

	public ButtonDynamic(String name, String tipo) {
		super();
		this.name = name;
		this.tipo = tipo;
		if (this.tipo == "USUARIO") {
			setIcon(new ImageIcon(USUARIO));
		} else if (this.tipo == "SUBIR") {
			setIcon(new ImageIcon(SUBIR));
		}

		setFont(new Font("Tahoma", Font.ITALIC, 16));
		setContentAreaFilled(false);
		setBorderPainted(false);

		if (this.tipo == "USUARIO") {
			setHorizontalTextPosition(RIGHT);
			setHorizontalAlignment(LEFT);
			setVerticalTextPosition(CENTER);
			setVerticalAlignment(CENTER);
			setPreferredSize(new Dimension(USUARIO_WIDTH_I, USUARIO_HEIGHT_I));
		} else if (this.tipo == "SUBIR") {
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

	public String getTipo() {
		return tipo;
	}
}
