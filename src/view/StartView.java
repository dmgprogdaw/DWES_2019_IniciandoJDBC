package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Iterator;

import modelo.cines.CinesCreate;
import negocio.beans.CineBean;
import negocio.controlador.Cinesa;
import view.cines.BorrarCineView;
import view.cines.CrearCineView;
import view.cines.ModificarCineView;

public class StartView {

	private Cinesa cines;
	
	private InputStreamReader isr = new InputStreamReader(System.in);
	private BufferedReader br = new BufferedReader (isr);
	
	
	public StartView(Cinesa cines) {
		
		this.cines = cines;
	}
	
	
	
	
	
	public void go() throws NumberFormatException, IOException {
		
		
		
		int numero = 1000;
		
		while(numero!=0) {
			
			System.out.println("\n\n\n\nMenu");
			System.out.println("_____________________");
			System.out.println("1) Modificar Cine");
			System.out.println("2) Lista de Cines");
			System.out.println("3) Insertar Cines");
			System.out.println("4) Borrar Cines");
			System.out.println("\n");
			System.out.println("0) SALIR");
			numero = Integer.parseInt (br.readLine());
			
			switch(numero) {
			
				case 1: modificarCine(); break;
				case 2: listarCines(); break;
				case 3: crearCine(); break;
				case 4: borrarCine(); break;
			}
		}
	}
	
	
	
	
	
	/**
	 * Lista los cines disponibles
	 * PRIVADO
	 */
	private void listarCines() {
		
		Iterator<CineBean> listado =  cines.getCines();
		while(listado.hasNext()) {
			
			CineBean unCine = listado.next();
			System.out.println("["+unCine.getIdCine()+"] "+unCine.getNombre());
		}
	}



	
	/**
	 * Modifica un cine
	 * PRIVADO
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private void modificarCine() throws NumberFormatException, IOException {
		
		// recorro la lista de cines imprimiendo lo que hay		
		Iterator<CineBean> listado =  cines.getCines();
		while(listado.hasNext()) {
			
			CineBean unCine = listado.next();
			System.out.println("["+unCine.getIdCine()+"] "+unCine.getNombre());
		}
		
		// solicito un ID
		System.out.println("Seleccione el ID del cine que quiere modificar");
		int numero = Integer.parseInt (br.readLine());
		
		// recojo el cine se lo paso a la parte de la view que lo modifica
		CineBean unCine = cines.getCine(numero);
		ModificarCineView.modificarCine(unCine);
		
	}
	
	
	
	/**
	 * Crea un cine
	 * PRIVADO
	 * @throws IOException 
	 */
	private void crearCine() throws IOException  {
			
		CineBean cineNew = new CineBean();
		System.out.println("Insertando el cine");
						
		// recojo el cine se lo paso a la parte de la view que lo inserta
		CrearCineView.crearCine(cineNew);
		
//		cineNew.setNombre("Yelmo Cines");
//		cineNew.setResponsable("Alguien");
//		cineNew.setTelefono("123456789");
//		cineNew.setDireccion("Oviedo");
//		
//		CinesCreate createNew = new CinesCreate();
//		createNew.createCine(cineNew);
	}
	
	private void borrarCine() throws NumberFormatException, IOException  {
		
		// recorro la lista de cines imprimiendo lo que hay		
		Iterator<CineBean> listado =  cines.getCines();
		while(listado.hasNext()) {
					
			CineBean unCine = listado.next();
			System.out.println("["+unCine.getIdCine()+"] " + unCine.getNombre() + " " + unCine.getResponsable() + " " + unCine.getTelefono() + " " +  unCine.getDireccion());
		}
				
		// solicito un ID
		System.out.println("Seleccione el ID del cine que quiere borrar");
		int numero = Integer.parseInt (br.readLine());
		CineBean unCine = cines.getCine(numero);
		BorrarCineView.borrarCine(unCine);
	}
}
