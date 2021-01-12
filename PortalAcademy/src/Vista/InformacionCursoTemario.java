package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.TableCellEditor;

import Controlador.CtrButtonDynamic;
import Controlador.CtrMenu;
import Modelo.Archivo;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Profesor;

@SuppressWarnings("serial")
public class InformacionCursoTemario extends JPanel {

	private Curso curso;
	private List<Archivo> lista_archivos_curso;
	private JTable temarios;
	private ButtonArchivo descargar;
	private ButtonArchivo borrar;
	public JFileChooser fileChooserDireccionDescarga;
	public JFileChooser fileChooserFicheroSubir;
	private ButtonDynamic buttonDynamicSubir;

	/**
	 * Create the panel.
	 */
	public InformacionCursoTemario(Curso c) {
		curso = c;
		lista_archivos_curso = curso.getArchivosCurso();
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		descargar = new ButtonArchivo(new JTextField("Descargar"));
		borrar = new ButtonArchivo(new JTextField("Borrar"));
		JLabel lblNombreCurso = new JLabel(curso.getNombre());
		lblNombreCurso.setBorder(new LineBorder(Color.BLACK));
		lblNombreCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreCurso.setBounds(380, 135, 106, 27);
		add(lblNombreCurso);

		JLabel lblTemario = new JLabel("Temario");
		lblTemario.setBorder(new LineBorder(Color.BLACK));
		lblTemario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTemario.setBounds(518, 345, 847, 41);
		add(lblTemario);

		cargarTemario();
		JScrollPane spTemario = new JScrollPane(temarios, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		spTemario.setWheelScrollingEnabled(true);
		spTemario.setBounds(359, 422, 1178, 384);
		spTemario.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
		spTemario.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		spTemario.setFont(new Font("Segoe UI", Font.BOLD, 20));

		add(spTemario);

		fileChooserDireccionDescarga = new JFileChooser();
		fileChooserDireccionDescarga.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		fileChooserFicheroSubir = new JFileChooser();
		fileChooserFicheroSubir.setFileSelectionMode(JFileChooser.FILES_ONLY);

		buttonDynamicSubir = new ButtonDynamic("Subir archivo", "SUBIR");
		buttonDynamicSubir.setBounds(1385, 317, 152, 80);
		CtrButtonDynamic ctrButtonDynamic = new CtrButtonDynamic(buttonDynamicSubir);
		add(ctrButtonDynamic.getBoton());

		if (Main.getUser() == null) {
			CtrMenu menu = new CtrMenu(new Menu(curso));
			add(menu.getPanel());
		} else if (Main.getUser() instanceof Profesor) {
			CtrMenu menu = new CtrMenu(new Menu((Profesor) Main.getUser(), curso));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante) Main.getUser(), curso));
			add(menu.getPanel());
		}
	}

	private void cargarTemario() {
		Object datosTemario[][];
		int cnt = 0;
		if (!esCreador()) {
			datosTemario = new Object[lista_archivos_curso.size()][2];
			for (Archivo archivo : lista_archivos_curso) {
				datosTemario[cnt][0] = archivo.getNombre();
				datosTemario[cnt][1] = "Descargar";
				cnt++;
			}
			String[] headerTemario = { "Nombre", "" };
			temarios = new JTable(datosTemario, headerTemario);
			temarios.getColumnModel().getColumn(0).setCellEditor(new TableCellEditor() {

				@Override
				public boolean stopCellEditing() {
					return false;
				}

				@Override
				public boolean shouldSelectCell(EventObject arg0) {
					return false;
				}

				@Override
				public void removeCellEditorListener(CellEditorListener arg0) {
					removeCellEditorListener(arg0);
				}

				@Override
				public boolean isCellEditable(EventObject arg0) {
					return false;
				}

				@Override
				public Object getCellEditorValue() {
					return getCellEditorValue();
				}

				@Override
				public void cancelCellEditing() {
					cancelCellEditing();
				}

				@Override
				public void addCellEditorListener(CellEditorListener arg0) {
					addCellEditorListener(arg0);
				}

				@Override
				public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3,
						int arg4) {
					return getTableCellEditorComponent(arg0, arg1, arg2, arg3, arg4);
				}
			});
			temarios.getColumnModel().getColumn(0).setMinWidth(990);
			temarios.getColumnModel().getColumn(0).setMaxWidth(990);
			temarios.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
			temarios.getColumnModel().getColumn(1).setCellEditor(descargar);
			temarios.getColumnModel().getColumn(1).setMinWidth(180);
			temarios.getColumnModel().getColumn(1).setMaxWidth(180);
		} else {
			datosTemario = new Object[lista_archivos_curso.size()][3];
			for (Archivo archivo : lista_archivos_curso) {
				datosTemario[cnt][0] = archivo.getNombre();
				datosTemario[cnt][1] = "Descargar";
				datosTemario[cnt][2] = "Borrar";
				cnt++;
			}
			String[] headerTemario = { "Nombre", "", "" };
			temarios = new JTable(datosTemario, headerTemario);
			temarios.getColumnModel().getColumn(0).setCellEditor(new TableCellEditor() {

				@Override
				public boolean stopCellEditing() {
					return false;
				}

				@Override
				public boolean shouldSelectCell(EventObject arg0) {
					return false;
				}

				@Override
				public void removeCellEditorListener(CellEditorListener arg0) {
					removeCellEditorListener(arg0);
				}

				@Override
				public boolean isCellEditable(EventObject arg0) {
					return false;
				}

				@Override
				public Object getCellEditorValue() {
					return getCellEditorValue();
				}

				@Override
				public void cancelCellEditing() {
					cancelCellEditing();
				}

				@Override
				public void addCellEditorListener(CellEditorListener arg0) {
					addCellEditorListener(arg0);
				}

				@Override
				public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3,
						int arg4) {
					return getTableCellEditorComponent(arg0, arg1, arg2, arg3, arg4);
				}
			});
			temarios.getColumnModel().getColumn(0).setMinWidth(801);
			temarios.getColumnModel().getColumn(0).setMaxWidth(801);
			temarios.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
			temarios.getColumnModel().getColumn(1).setCellEditor(descargar);
			temarios.getColumnModel().getColumn(1).setMinWidth(188);
			temarios.getColumnModel().getColumn(1).setMaxWidth(188);
			temarios.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
			temarios.getColumnModel().getColumn(2).setCellEditor(borrar);
			temarios.getColumnModel().getColumn(2).setMinWidth(188);
			temarios.getColumnModel().getColumn(2).setMaxWidth(188);
		}
		temarios.setCellSelectionEnabled(false);
		temarios.setTableHeader(null);
		temarios.setShowHorizontalLines(false);
		temarios.setShowVerticalLines(false);
		temarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		temarios.setRowHeight(75);

	}

	private boolean esCreador() {
		if (Main.getUser() == null) {
			return false;
		}
		return Main.getUser().equals(curso.getProfesor());
	}

	public void controlador(ActionListener ctr) {
		this.descargar.controladorDescargar(ctr);
		this.buttonDynamicSubir.addActionListener(ctr);
		this.buttonDynamicSubir.setActionCommand("SUBIR");
		if (esCreador()) {
			this.borrar.controladorBorrar(ctr);
		}
	}

	public Archivo getArchivo() {
		return lista_archivos_curso.get(temarios.getSelectedRow());
	}

	public Curso getCurso() {
		return curso;
	}

}
