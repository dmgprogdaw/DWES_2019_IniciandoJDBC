package modelo.cines;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.util.BDConect;
import negocio.beans.CineBean;

public class CinesDelete {
	
	public void deleteCine(CineBean cine) {
		
		Connection conexion = BDConect.getConexion();
		PreparedStatement pst = null;

		String sql = "DELETE from cines " +	
					 "WHERE idcines=" +cine.getIdCine();
		
		try {
			pst = conexion.prepareStatement(sql);
			pst.execute(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
