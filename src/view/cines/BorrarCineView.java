package view.cines;

import java.io.IOException;

import modelo.cines.CinesDelete;
import negocio.beans.CineBean;

public class BorrarCineView {
	
	public static void borrarCine(CineBean cine) throws IOException {
		
		CinesDelete cd = new CinesDelete();
		cd.deleteCine(cine);
		
	
	}
}
