package interfaces;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Statement;

import conexion.Conexion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import variables.*;



public class Funcionario extends JInternalFrame {
	private JTextField textCedula;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;
	private JTextField textTelefono;
	private JTextField textID;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionario frame = new Funcionario();
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
	public Funcionario() {
		setClosable(true);
		setTitle("Funcionario");
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("Cedula:");
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		
		textCedula = new JTextField();
		textCedula.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		JList list = new JList();
		
		JList list_1 = new JList();
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellidos:");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email:");
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Telefono:");
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//System.out.println("cuando->"+textCedula.getText());
					crear_funcionario();
					System.out.println("Registro Almacenado");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
						
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(textCedula.getText().equals(""))
					{
						System.out.println("Debe ingresar un valor");
						
						JOptionPane.showMessageDialog(null, "Debe ingresar el id o la cedula");
					}
					else
					{
						//buscarFuncionario();
						
						
						try {
							Conexion cone= new Conexion();
							cone.establecerConexion();
							Statement stam=(Statement) cone.con.createStatement();
							ResultSet rtaset= stam.executeQuery("SELECT * FROM funcionario WHERE cedula='"+textCedula.getText()+"'");
							
							while(rtaset.next()) {
								textID.setText(rtaset.getString("idFuncionario"));
								//textCedula.setText(rtaset.getString("cedula"));
								textNombre.setText(rtaset.getString("nombre"));
								textApellido.setText(rtaset.getString("apellidos"));
								textEmail.setText(rtaset.getString("email"));
								textTelefono.setText(rtaset.getString("telefono"));
								
								
							}
							
							
							
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					
					
				
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		
		textID = new JTextField();
		textID.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnGuardar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2))
							.addGap(90)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textApellido, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(textTelefono, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textCedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(10)
													.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
												.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
										.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(116, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_1)
							.addGap(18)
							.addComponent(lblNewLabel_1_1_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(textApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1_1_1)
						.addComponent(textTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar)
						.addComponent(btnBuscar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
	
	//Metodo para crear funcionario
	void crear_funcionario() throws SQLException{
		
		variables.Funcionario fun = new variables.Funcionario(null, textCedula.getText(), textNombre.getText(), textApellido.getText(), textEmail.getText(), textTelefono.getText());
		fun.insertarFuncionario();
	}
	
	/*private Funcionario buscarFuncionario() {
		variables.Funcionario fun = new variables.Funcionario();
		variables.Funcionario fun = new 
	}*/
}
