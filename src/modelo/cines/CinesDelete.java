package modelo.cines;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.util.BDConect;
import negocio.beans.CineBean;

public class CinesDelete {
	
	public void deleteCine(CineBean cine) {
		
		Connection conexion = BDConect.getConexion();
		PreparedStatement stmt = null;

		String sql = "DELETE from cines " +	
					 "WHERE idcines=" +cine.getIdCine();
		
		System.out.println(sql);
		try {
			stmt = conexion.prepareStatement(sql);
//			stmt.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
