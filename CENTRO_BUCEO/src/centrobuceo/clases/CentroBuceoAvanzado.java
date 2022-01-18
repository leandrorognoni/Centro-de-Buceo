package centrobuceo.clases;
 

import centrobuceo.nodos.ColaNodos;
import centrobuceo.tda.Cola;
import centrobuceo.tda.ListaOrdenada;
 

public class CentroBuceoAvanzado {

	private static final String BUCEO_INVALIDO = "Buceo Invalido";
  
    private String nombre ;
	private Cola <String> erroresDeReserva;
	private ListaOrdenada<Integer, Buceo> buceosDisponibles;
	private Cola <Buzo> buzosRegistrados;
	private int [] cantidadBuceosPorMes;
	 

	public CentroBuceoAvanzado(String nombre) {
		this.nombre = nombre;
		this.erroresDeReserva = new ColaNodos<>();
		this.buceosDisponibles = new ListaOrdenadaPorId();
		this.buzosRegistrados = new ColaNodos<>();
		this.cantidadBuceosPorMes = new int [Mes.values().length];

	}

	/**
	 * Se registra un buceo para un determinado buzo. si ocurre un error se registra
	 * en el log de errores, pero no se aborta la ejecucion.
	 * 
	 * -El buzo no puede ser nulo.
	 * 
	 * -El buceo cuyo id se indica, debe estar en la coleccion de buceos disponibles.
	 * 
	 * -El buzo debe estar habilitado para realizar el buceo seleccionado.
	 * 
	 * -De poder registrar al buzo, se debe agregar el buceo a su bitacora y
	 * agregarlo a los buzos registrados, que deben estar almacenados de forma
	 * cronologica.
	 * 
	 * @param buzo    Que desea bucear.
	 * @param idBuceo Identificador del buceo que el buzo quiere hacer.
	 */
	public void registrarBuceo(Buzo buzo, Integer idBuceo) {
		 String mensaje = null;
		 try {
		 Buceo buceoBuscado = this.buscarBuceoPorID(idBuceo);
		
		  
		
			  if(buzo == null) {
				 mensaje = "Buzo nulo";
				 throw new RuntimeException();
				 
			 }
				 
			 if(buceoBuscado == null ) {
				 mensaje = BUCEO_INVALIDO;
				 throw new RuntimeException(); 
			 }
			
			if(!buzo.habilitado(buceoBuscado.getProfundidad())) {
						  mensaje = "Buzo no habilitado por profundidad";
						 throw new RuntimeException();
						 
			 }
					
					 buzosRegistrados.add(buzo);
					 buzo.agregarABitacora(buceoBuscado);			 
					
				 
					 
				 
			 
			 
		 }catch (RuntimeException run) {
			   erroresDeReserva.add(mensaje);
			 
		 }
			
		
		 
	}

	public void agregarBuceo(Buceo buceo, Mes mes) {
	 
	 
	 if(buceo == null  ) {
		 
		 throw new IllegalArgumentException(BUCEO_INVALIDO);
		 
		
		}	
	       buceosDisponibles.add(buceo);
		  cantidadBuceosPorMes[mes.ordinal()]++;
			 
	 
	 
	 
	}

	private Buceo buscarBuceoPorID(Integer idBuceo) {
	 
		Buceo buscado = buceosDisponibles.search(idBuceo);
 
		return buscado;

	}

	public void listarErroresCronologico() {
		System.out.println("Mostrando errores en forma cronologica: ");
		Cola <String> aux = new ColaNodos<>();
		String mensajeAux = null;
 
		 
		while(!erroresDeReserva.isEmpty()) {
		 mensajeAux = erroresDeReserva.remove();
		 System.out.println(mensajeAux); 
		 aux.add(mensajeAux);
		}
		
		if(!aux.isEmpty()) {
			erroresDeReserva = aux;
		}
		
	
 
	}


	public void mostrarCantidadDeBuceosPorBuzoRegistrado() {
 
		Cola<Buzo> aux = new ColaNodos<>();
		Buzo buzoAux = null;
		System.out.println("Cantidad de buceos registrados en " + this.nombre  );
		
		  while(!buzosRegistrados.isEmpty()) {
			   buzoAux = buzosRegistrados.remove();
			   System.out.println(buzoAux +  "tiene : " + buzoAux.cantidadDeEventos() + " buceos realizados");
			   aux.add(buzoAux);
		  }
		
			 if(!aux.isEmpty()) {
				 buzosRegistrados = aux;
			 }
		  

	}

	public void mostrarCantidadDeReservasPorMes() {
		System.out.println("------------------");
		System.out.println("Cantidad de buceos por Mes: ");
	    
		for(int i = 0; i<cantidadBuceosPorMes.length;i++) {
			System.out.println("El mes de "  + Mes.values()[i] + " tiene una cantidad de reservas de :  "
				+	cantidadBuceosPorMes[i]);
		}
 

	}

 

	 
	
	
}
