package Vista;

import java.awt.Component;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ImageRenderer extends JPanel implements TableCellRenderer {
	public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {
		
		if (value != null) {
			return new JPanelImagen(((File) value).getName());
		} else {
			return new JPanelImagen(getClass().getResource("/img/curso_default.png"));
		}
		
	}
}
