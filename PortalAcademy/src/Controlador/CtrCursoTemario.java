package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Archivo;
import Modelo.BD;
import Modelo.ErrorBD;
import Vista.CursoTemario;
import Vista.Main;

public class CtrCursoTemario implements ActionListener {

	private CursoTemario vista;

	public CtrCursoTemario(CursoTemario v) {
		vista = v;
		vista.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("DESCARGAR")) {
			try {
				Archivo archivo = vista.getArchivo();
				if (vista.fileChooserDireccionDescarga
						.showOpenDialog(vista.fileChooserDireccionDescarga) == JFileChooser.APPROVE_OPTION) {
					BD bd = BD.getBD();
					bd.SelectArchivoCurso(archivo.getId(), archivo.getNombre(),
							vista.fileChooserDireccionDescarga.getSelectedFile().getAbsolutePath());
					bd.finalize();
					JOptionPane.showMessageDialog(vista,
							"El archivo " + archivo.getNombre() + " ha sido descargado en la dirección "
									+ vista.fileChooserDireccionDescarga.getSelectedFile().getAbsolutePath(),
							"Descargar archivo", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (ErrorBD err) {
				JOptionPane.showMessageDialog(vista, err.getMessage(), "Descargar archivo", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getActionCommand().equals("BORRAR")) {
			try {
				Archivo archivo = vista.getArchivo();
				archivo.borrar();
				JOptionPane.showMessageDialog(vista,
						"El archivo " + archivo.getNombre() + " ha sido borrado correctamente. ", "Borrar archivo",
						JOptionPane.INFORMATION_MESSAGE);
				CtrCursoTemario ctrCursoTemario = new CtrCursoTemario(new CursoTemario(vista.getCurso()));
				Main.setPanel(ctrCursoTemario.getPanel());
			} catch (ErrorBD err) {
				JOptionPane.showMessageDialog(vista, err.getMessage(), "Descargar archivo", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getActionCommand().equals("SUBIR")) {
			try {
				if (vista.fileChooserFicheroSubir
						.showOpenDialog(vista.fileChooserFicheroSubir) == JFileChooser.APPROVE_OPTION) {
					BD bd = BD.getBD();
					bd.InsertArchivo(vista.fileChooserFicheroSubir.getSelectedFile().getName(),
							vista.fileChooserFicheroSubir.getSelectedFile(), vista.getCurso().getId());
					bd.finalize();
					JOptionPane.showMessageDialog(vista,
							"El archivo " + vista.fileChooserFicheroSubir.getSelectedFile().getName()
									+ " ha sido subido correctamente.",
							"Subida archivo", JOptionPane.INFORMATION_MESSAGE);
					CtrCursoTemario ctrCursoTemario = new CtrCursoTemario(new CursoTemario(vista.getCurso()));
					Main.setPanel(ctrCursoTemario.getPanel());
				}
			} catch (ErrorBD err) {
				JOptionPane.showMessageDialog(vista, err.getMessage(), "Subida archivo", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public JPanel getPanel() {
		return vista;
	}

}
