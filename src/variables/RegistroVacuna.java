package variables;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.Conexion;

public class RegistroVacuna {
	private Integer id;
	private Date fecha;
	private Integer pacienteId;
	private Integer vacunaId;
	private Integer funcionarioId;

	
	public RegistroVacuna(Integer id, Date fecha, Integer pacienteId, Integer vacunaId, Integer funcionarioId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.pacienteId = pacienteId;
		this.vacunaId = vacunaId;
		this.funcionarioId = funcionarioId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}

	public Integer getVacunaId() {
		return vacunaId;
	}

	public void setVacunaId(Integer vacunaId) {
		this.vacunaId = vacunaId;
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}
	private static Conexion cnx= new Conexion();
	public void insertarRegistroVacuna() throws SQLException{
		String seleccion="INSERT INTO `registrovacuna` (`fechavacuna`, `pacienteId`, `vacunaId`, `funcionarioId`) VALUES (?,?,?,?);";
		PreparedStatement ps = cnx.con.prepareStatement(seleccion);
		ps.setDate(1, this.fecha);
		ps.setInt(2, this.pacienteId);
		ps.setInt(3, this.vacunaId);
		ps.setInt(4, this.funcionarioId);
	}

}
