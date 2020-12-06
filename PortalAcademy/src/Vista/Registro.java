package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ButtonGroup;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNick;
	private JTextField textFieldCorreo;
	private JTextField textFieldContrasena;
	private final ButtonGroup buttonGroupRol = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
					.addGap(31))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setBounds(320, 3, 160, 56);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nick:");
		lblNewLabel_1.setBounds(226, 73, 75, 32);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(425, 70, 160, 32);
		textFieldNick.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldNick.setColumns(10);
		panel.add(textFieldNick);
		
		JLabel lblNewLabel_2 = new JLabel("Correo:");
		lblNewLabel_2.setBounds(226, 110, 84, 38);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_2);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(425, 113, 160, 32);
		textFieldCorreo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldCorreo.setColumns(10);
		panel.add(textFieldCorreo);
		
		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_3.setBounds(226, 159, 108, 38);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_3);
		
		textFieldContrasena = new JTextField();
		textFieldContrasena.setBounds(425, 156, 160, 32);
		textFieldContrasena.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldContrasena.setColumns(10);
		panel.add(textFieldContrasena);
		
		JRadioButton rdbtnProfesor = new JRadioButton("Profesor");
		buttonGroupRol.add(rdbtnProfesor);
		rdbtnProfesor.setBounds(467, 218, 96, 23);
		panel.add(rdbtnProfesor);
		
		JRadioButton rdbtnOrganizacion = new JRadioButton("Organizaci\u00F3n");
		buttonGroupRol.add(rdbtnOrganizacion);
		rdbtnOrganizacion.setBounds(590, 218, 125, 23);
		panel.add(rdbtnOrganizacion);
		
		JLabel lblNewLabel_3_1 = new JLabel("Rol:");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(226, 208, 108, 38);
		panel.add(lblNewLabel_3_1);
		
		JRadioButton rdbtnEstudiante = new JRadioButton("Estudiante");
		buttonGroupRol.add(rdbtnEstudiante);
		rdbtnEstudiante.setSelected(true);
		rdbtnEstudiante.setBounds(340, 218, 108, 23);
		panel.add(rdbtnEstudiante);
		contentPane.setLayout(gl_contentPane);
	}
}
