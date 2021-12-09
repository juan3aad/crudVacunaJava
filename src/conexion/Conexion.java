package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	public Connection con;
	
	public Conexion() {
		establecerConexion();
	}
	
	public void establecerConexion() {
		String host="127.0.0.1";
		String user="root";
		String pass="";
		String baseDatos="unapoo";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String newConnetionURL="jdbc:mysql://"+host+"/"+baseDatos+"?"+"user="+user+"&password="+pass+"&useSSL=false";
			con=DriverManager.getConnection(newConnetionURL);
			System.out.println("Conexión exitosa");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la conexión");
		}
		
	}
	
	public void cerrarConexion() {
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el cierre de la base de datos");
			
		}
	}
}
