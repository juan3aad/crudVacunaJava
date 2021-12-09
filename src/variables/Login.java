package variables;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.Conexion;

public class Login extends Usuario {
	private Integer idFuncionario;
	private String logname;
	private String pass;
	
	public Login(Integer id,Integer idFuncionario,String logname,String pass, String nombre, String apellidos, String email, String telefono) {
		super(id, nombre, apellidos, email, telefono);
		// TODO Auto-generated constructor stub
		
		this.idFuncionario=idFuncionario;
		this.logname=logname;
		this.pass=pass;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}


	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}


	public String getLogname() {
		return logname;
	}


	public void setLogname(String logname) {
		this.logname = logname;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}
	
	private static Conexion cnx= new Conexion();
	
	public void insertarLogin() throws SQLException{
		System.out.println("claudi:"+this.idFuncionario);
		String seleccion="INSERT INTO `login` (`funcionarioId`, `login`, `pass`) VALUES (?,?,?);";
		PreparedStatement ps=cnx.con.prepareStatement(seleccion);
		ps.setInt(1, this.idFuncionario);
		ps.setString(2, this.logname);
		ps.setString(3, this.pass);
		ps.executeUpdate();
	}
	

}
