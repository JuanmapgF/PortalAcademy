package Controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Vista.ButtonDynamic;

public class CtrButtonDynamic extends MouseAdapter {

	private ButtonDynamic btn;

	public CtrButtonDynamic(ButtonDynamic jbd) {
		btn = jbd;
		btn.addMouseListener(this);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		btn.setText(btn.getName());

		if (btn.getTipo() == "USUARIO") {
			btn.setBounds(btn.getX(), btn.getY(), btn.USUARIO_WIDTH_F, btn.USUARIO_HEIGHT_F);
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		btn.setText("");

		if (btn.getTipo() == "USUARIO") {
			btn.setBounds(btn.getX(), btn.getY(), btn.USUARIO_WIDTH_I, btn.USUARIO_HEIGHT_I);
		}
	}

	public ButtonDynamic getBoton() {
		return btn;
	}

}
