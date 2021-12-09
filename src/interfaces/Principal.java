package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 425);
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("RegistroVacuna");
		
		mnNewMenu.add(mntmNewMenuItem);
		
				
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Funcionario");
		
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Paciente");
		
		mnNewMenu.add(mntmNewMenuItem_3);
		
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Usuario");
		
		mnNewMenu.add(mntmNewMenuItem_4);
		
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Vacuna");
		
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Salir");
		
		mnNewMenu.add(mntmNewMenuItem_6);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane deskPaneEsc = new JDesktopPane();
		deskPaneEsc.setBackground(Color.LIGHT_GRAY);
		contentPane.add(deskPaneEsc, BorderLayout.CENTER);
		
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroVacuna vtaPersona = new RegistroVacuna();
				
				deskPaneEsc.add(vtaPersona);
				vtaPersona.show();
				
				
			}
		});
		
				
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario vtaFuncionario= new Funcionario();
				deskPaneEsc.add(vtaFuncionario);
				vtaFuncionario.show();
			}
		});
		
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paciente vtaPaciente= new Paciente();
				deskPaneEsc.add(vtaPaciente);
				vtaPaciente.show();
			}
		});
		
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				CrearLogin vtaCrearLogin= new CrearLogin();
				deskPaneEsc.add(vtaCrearLogin);
				vtaCrearLogin.show();
			}
		});
		
		
		
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vacuna vtaVacuna= new Vacuna();
				deskPaneEsc.add(vtaVacuna);
				vtaVacuna.show();
			}
		});
		
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Salir");
			}
		});
		
		
	}
}
