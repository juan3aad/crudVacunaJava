package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RegistroVacuna extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFuncionario;
	private JTextField textPaciente;
	private JTextField textVacuna;
	private JTextField textFechaVacuna;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroVacuna frame = new RegistroVacuna();
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
	public RegistroVacuna() {
		setTitle("RegistroVacuna");
		setClosable(true);

		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 510, 360);

		JLabel lblNewLabel_1 = new JLabel("Funcionario:");

		JLabel lblNewLabel_2 = new JLabel("Paciente:");

		JLabel lblNewLabel_3 = new JLabel("Vacuna:");

		JLabel lblNewLabel_4 = new JLabel("Fecha Vacuna:");

		textFuncionario = new JTextField();
		textFuncionario.setColumns(10);

		textPaciente = new JTextField();
		textPaciente.setColumns(10);

		textVacuna = new JTextField();
		textVacuna.setColumns(10);

		textFechaVacuna = new JTextField();
		textFechaVacuna.setColumns(10);

		JButton btnNewButton_1 = new JButton("Modificar");

		JButton btnNewButton_2 = new JButton("Eliminar");

		JButton btnNewButton_3 = new JButton("Guardar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					crearRegistroVacuna();
					System.out.println("Se registro la vacuna");
				} catch (SQLException e1) {
					System.out.println("Error en el registro de la vacuna");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(38)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_4)
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1).addComponent(lblNewLabel_2)
												.addComponent(btnNewButton_3))
										.addGap(18).addComponent(btnNewButton_1))
								.addComponent(lblNewLabel_3))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
										.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(textPaciente, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textVacuna, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFechaVacuna, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addComponent(textFuncionario, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup().addGap(38)
												.addComponent(btnNewButton_2)))))
				.addContainerGap(185, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(49)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1)
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textFuncionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(11)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_2).addComponent(
						textPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textVacuna, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_4).addComponent(
						textFechaVacuna, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(37)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton_3)
						.addComponent(btnNewButton_1).addComponent(btnNewButton_2))
				.addContainerGap(103, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}

	public void crearRegistroVacuna() throws SQLException {
		variables.RegistroVacuna regVac = new variables.RegistroVacuna(null, Date.valueOf(textFechaVacuna.getText()),
				Integer.parseInt(textPaciente.getText()), Integer.parseInt(textVacuna.getText()),
				Integer.parseInt(textFuncionario.getText()));
		regVac.insertarRegistroVacuna();
	}
}
