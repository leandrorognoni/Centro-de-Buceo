package centrobuceo.clases;

import centrobuceo.nodos.ColaNodos;
import centrobuceo.tda.Cola;

public abstract class Buzo implements BuceoProfundo, Bitacorado<Buceo> {

	private static final String NOMBRE_INVALIDO = "Nombre invalido";
	private static final String NACIONALIDAD_INVALIDA = "Nacionalidad invalida";
	private static final String EDAD_INVALIDA = "Un buzo no puede ser menor de edad";
	private String nombre;
	private String nacionalidad;
	private int edad;
	//TODO Descomentar y completar
//	private ... bitacora;
	private Cola <Buceo> bitacora;

	/**
	 * Constructor del buzo, los buzos deben tener al menos de 18 años.
	 * 
	 * @param nombre - No puede estar vacio ni ser nulo.
	 * @param nacionalidad - No puede estar vacio ni ser nulo.
	 * @param edad debe ser valida.
	 */
	public Buzo(String nombre, String nacionalidad, int edad) {
		this.setNombre(nombre);
		this.setNacionalidad(nacionalidad);
		this.setEdad(edad);
		this.bitacora = new ColaNodos<>();

	}

	private void setNombre(String nombre) {
	 
			
			if(nombre.isEmpty() || nombre == null) {
			 
				throw new RuntimeException(NOMBRE_INVALIDO);
				
				
			}else {
				this.nombre = nombre;
			}
	 
	    
	}

	private void setNacionalidad(String nacionalidad) {
	  
	 try {
			
			if(nacionalidad == null || nacionalidad.isEmpty()) {
			throw new RuntimeException(NACIONALIDAD_INVALIDA);
				} 
			
		 this.nacionalidad = nacionalidad;
			
	 }catch (RuntimeException r) {
		 
	 }
	 
		
	 

	}

	private void setEdad(int edad) {
		
		 try {
		 
		if(edad <18 || edad>120) {
			throw new RuntimeException(EDAD_INVALIDA);
		  
		} 
			this.edad = edad;
		 
		 }catch (RuntimeException e) {
			 
		 }
		 
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return "Buzo [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", edad=" + edad + "]";
	}

	@Override
	public int cantidadDeEventos() {
		int contador = 0;
		Cola <Buceo> aux = new ColaNodos<>();
		  
		while(!bitacora.isEmpty()) {
			aux.add(bitacora.remove());
			contador++;
		}
		
		if(!aux.isEmpty()) {
			bitacora = aux;
			 
		}
	   
		return contador;
	}

	public abstract boolean habilitado(int metros);

	@Override
	public void agregarABitacora(Buceo buceo) {
		if(buceo != null) {
			bitacora.add(buceo);
		}


	}
}
