package variables;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.Conexion;

public class Vacuna {

	private Integer id;
	private String nombre;
	private String lote;
	private Date fechaVencimiento;

	public Vacuna(Integer id, String nombre, String lote, Date fechaVencimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lote = lote;
		this.fechaVencimiento = fechaVencimiento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	private static Conexion cnx = new Conexion();

	public void insertarVacuna() throws SQLException {
		String seleccion = "INSERT INTO `vacuna` (`nombreVacuna`, `lote`, `fechaVencimiento` VALUES (?,?,?);)";
		PreparedStatement ps = cnx.con.prepareStatement(seleccion);
		ps.setString(1, this.nombre);
		ps.setString(2, this.lote);
		ps.setDate(3, this.fechaVencimiento);
	}

}
