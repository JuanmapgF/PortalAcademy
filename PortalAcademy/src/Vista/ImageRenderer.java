package Vista;

import java.awt.Component;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ImageRenderer extends JPanel implements TableCellRenderer {
	
	private boolean esCurso;
	
	public ImageRenderer(boolean esCurso) {
		super();
		this.esCurso = esCurso;
	}
	
	public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {
		if (value != null) {
			return new JPanelImagen(((File) value).getName());
		} else {
			if (esCurso) {
				return new JPanelImagen(getClass().getResource("/img/curso_default.png"));
			} else {
				return new JPanelImagen(getClass().getResource("/img/actividad_default.png"));
			}
			
		}
		
	}
}
