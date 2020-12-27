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

		if (btn.getIcono() == ButtonDynamic.CERRAR_SESION) {
			btn.setBounds(btn.getX(), btn.getY(), ButtonDynamic.CERRAR_SESION_WIDTH_F,
					ButtonDynamic.CERRAR_SESION_HEIGHT_F);
		} else if (btn.getIcono() == ButtonDynamic.USUARIO) {
			btn.setBounds(btn.getX(), btn.getY(), ButtonDynamic.USUARIO_WIDTH_F, ButtonDynamic.USUARIO_HEIGHT_F);
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		btn.setText("");

		if (btn.getIcono() == ButtonDynamic.CERRAR_SESION) {
			btn.setBounds(btn.getX(), btn.getY(), ButtonDynamic.CERRAR_SESION_WIDTH_I,
					ButtonDynamic.CERRAR_SESION_HEIGHT_I);
		} else if (btn.getIcono() == ButtonDynamic.USUARIO) {
			btn.setBounds(btn.getX(), btn.getY(), ButtonDynamic.USUARIO_WIDTH_I, ButtonDynamic.USUARIO_HEIGHT_I);
		}
	}

	public ButtonDynamic getBoton() {
		return btn;
	}

}
