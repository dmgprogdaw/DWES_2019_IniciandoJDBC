package modelo.cines;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.util.BDConect;
import negocio.beans.CineBean;

public class CinesCreate {
	
	public void createCine(CineBean cine) {
		
		Connection conexion = BDConect.getConexion();
		PreparedStatement pst = null;

		String sql = "INSERT INTO cines(nombre, responsable, telefono, direccion)" +	
					 "VALUES (" +
				     "'" + cine.getNombre() + "', " +
				     "'" + cine.getResponsable() + "', " +
				     "'" + cine.getTelefono() + "', " +
				     "'" + cine.getDireccion() +"')";
		
		try {
			pst = conexion.prepareStatement(sql);
			pst.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}