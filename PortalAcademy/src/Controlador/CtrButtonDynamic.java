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
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		btn.setText("");
	}

	public ButtonDynamic getBoton() {
		return btn;
	}

}
