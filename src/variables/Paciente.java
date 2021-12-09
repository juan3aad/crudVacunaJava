package variables;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import conexion.Conexion;

public class Paciente extends Usuario {
	private String cedula;
	private Date fechaNacimiento;

	public Paciente(Integer id, String cedula, String nombre, String apellidos, String email, String telefono,Date fechaNacimiento) {
		super(id, nombre, apellidos, email, telefono);
		this.cedula=cedula;
		this.fechaNacimiento=fechaNacimiento;
		// TODO Auto-generated constructor stub
	}

	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	private static Conexion cnx = new Conexion();

	public void insertarPaciente() throws SQLException {
		System.out.println("fecha Paciente xvvvx" + getCedula());
		String seleccion = "INSERT INTO `paciente` ( `cedula`, `nombre`, `apellidos`, `email`, `telefono`, `fechaNacimiento`) VALUES (?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = cnx.con.prepareStatement(seleccion);
		ps.setString(1, this.cedula);
		ps.setString(2, getNombre());
		ps.setString(3, getApellidos());
		ps.setString(4, getEmail());
		ps.setString(5, getTelefono());
		ps.setDate(6, this.fechaNacimiento);
		ps.executeUpdate();

	}
	
	
	public void actualizarPaciente() throws SQLException{
		
		String actualizar = "UPDATE `paciente` set `cedula`=?, `nombre`=?, `apellidos`=?, `email`=?, `telefono`=?, `fechaNacimiento`=? where `idPaciente`=?";
		PreparedStatement ps=cnx.con.prepareStatement(actualizar);
		ps.setString(1, this.cedula);
		ps.setString(2, getNombre());
		ps.setString(3, this.getApellidos());
		ps.setString(4, getEmail());
		ps.setString(5, getTelefono());
		ps.setString(6, getFechaNacimiento().toString());
		ps.setInt(7, getId());
		ps.executeUpdate();
		
		
		
		
	}

}
