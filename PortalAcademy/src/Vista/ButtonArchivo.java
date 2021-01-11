package Vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ButtonArchivo extends DefaultCellEditor {
	private JButton btn;
	private String lbl;
	private Boolean clicked;

	public ButtonArchivo(JTextField txt) {
		super(txt);

		btn = new JButton();
		btn.setOpaque(true);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	@Override
	public void fireEditingStopped() {
		super.fireEditingStopped();
	}

	public boolean stopCellEditing() {
		// SET CLICKED TO FALSE FIRST
		clicked = false;

		return super.stopCellEditing();
	}

	public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {

		// SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
		lbl = (obj == null) ? "" : obj.toString();
		btn.setText(lbl);
		clicked = true;
		return btn;
	}

	public void controladorDescargar(ActionListener ctr) {
		btn.addActionListener(ctr);
		btn.setActionCommand("DESCARGAR");
	}

	public void controladorBorrar(ActionListener ctr) {
		btn.addActionListener(ctr);
		btn.setActionCommand("BORRAR");
	}

}
