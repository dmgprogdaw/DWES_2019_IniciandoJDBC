package view.cines;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.cines.CinesCreate;
import negocio.beans.CineBean;

public class CrearCineView {
	
	public static void crearCine(CineBean cine) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		
		// leemos cada uno de los atributos del Cine
		System.out.println("Inserta el nombre");
		String cadena = br.readLine();
		if(cadena.length()>0) {
			
			cine.setNombre(cadena);
		}
		
		// leemos cada uno de los atributos del Cine
		System.out.println("Inserta el  responsable");
		cadena = br.readLine();
		if(cadena.length()>0) {
			
			cine.setResponsable(cadena);
		}
		
		
		
		// leemos cada uno de los atributos del Cine
		System.out.println("Inserta el  telefono?");
		cadena = br.readLine();
		if(cadena.length()>0) {
			
			cine.setTelefono(cadena);
		}
		
		// leemos cada uno de los atributos del Cine
		System.out.println("Inserta el  direccion?");
		cadena = br.readLine();
		if(cadena.length()>0) {
			
			cine.setDireccion(cadena);
		}	
		CinesCreate cc = new CinesCreate();
		cc.createCine(cine);
	}
}
