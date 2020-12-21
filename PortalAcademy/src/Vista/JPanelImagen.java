package Vista;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanelImagen extends JPanel {

	private ImageIcon image;

	public JPanelImagen(String nombreImagen) {
		if (nombreImagen != null) {
			image = new ImageIcon(nombreImagen);
		}
	}

	@Override
	public void paint(Graphics graphics) {
		if (image != null) {
			graphics.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paint(graphics);
		}
	}

}
