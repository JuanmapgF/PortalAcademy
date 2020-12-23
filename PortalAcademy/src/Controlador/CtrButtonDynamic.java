package Controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Vista.JButtonDynamic;

public class CtrButtonDynamic extends MouseAdapter {
	
	private JButtonDynamic btn;

	public CtrButtonDynamic(JButtonDynamic jbd) {
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

	public JButtonDynamic getBoton() {
		return btn;
	}

}
