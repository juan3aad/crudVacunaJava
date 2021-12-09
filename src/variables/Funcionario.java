package variables;

import java.sql.SQLException;

//import com.mysql.jdbc.PreparedStatement;
import java.sql.PreparedStatement;

import conexion.Conexion;

public class Funcionario extends Usuario {
	private String cedula;
	
	public Funcionario(Integer id,String cedula, String nombre, String apellidos, String email, String telefono) {
		super(id, nombre, apellidos, email, telefono);
		// TODO Auto-generated constructor stub
		this.cedula=cedula;
	}

	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	//Realizar conexion con la base de datos
	private static Conexion cnx= new Conexion();
	
	public void insertarFuncionario() throws SQLException{
		System.out.println("Cedula fun:"+getCedula());
		String seleccion="INSERT INTO `funcionario` ( `cedula`, `nombre`, `apellidos`, `email`, `telefono`) VALUES (?, ?, ?, ?, ?);";
		PreparedStatement ps=cnx.con.prepareStatement(seleccion);
		ps.setString(1, this.cedula);
		ps.setString(2, getNombre());
		ps.setString(3, getApellidos());
		ps.setString(4, getEmail());
		ps.setString(5, getTelefono());
		ps.executeUpdate();
		
	}
	
	
	
	
   
	

}
