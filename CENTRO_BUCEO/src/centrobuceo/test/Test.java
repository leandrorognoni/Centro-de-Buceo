package centrobuceo.test;


import centrobuceo.clases.*;

public class Test {

	public static void main(String[] args) {
		System.out.println("Centro de Buceo \n----------------");
		CentroBuceoAvanzado cba = new CentroBuceoAvanzado("Centro de Buceo");

		System.out.println("Se Agregan buceos");
		agregarBuceos(cba);

		System.out.println("Se registran buceadores");
		registrarBuceadores(cba);
		
		System.out.println("**********************************");
		System.out.println("Listados");
		cba.listarErroresCronologico();
		System.out.println("**********************************");
		cba.mostrarCantidadDeBuceosPorBuzoRegistrado();

		cba.mostrarCantidadDeReservasPorMes();
	}

	private static void agregarBuceos(CentroBuceoAvanzado cba) {

		agregarBuceo(cba, new Buceo(6, "Isla Victoria", 18), Mes.ENERO);
		agregarBuceo(cba, new Buceo(2, "Dique Piedras Moras", 23), Mes.ENERO);
		agregarBuceo(cba, new Buceo(8, "Parque Nacional de Tierra del Fuego", 20), Mes.FEBRERO);
		agregarBuceo(cba, new Buceo(4, "Los Reyunos", 25), Mes.MARZO);
		agregarBuceo(cba, new Buceo(1, "Dique Segunda Usina", 35), Mes.ABRIL);
		agregarBuceo(cba, new Buceo(10, "Puerto Madryn", 30), Mes.MAYO);
		agregarBuceo(cba, new Buceo(5, "Nahuel Huapi", 22), Mes.JUNIO);
		agregarBuceo(cba, new Buceo(7, "Golfo San Matías", 30), Mes.SEPTIEMBRE);
		agregarBuceo(cba, new Buceo(9, "PirAmides", 25), Mes.NOVIEMBRE);
		agregarBuceo(cba, new Buceo(3, "Bosque sumergido de Villa Traful", 20), Mes.DICIEMBRE);
	}

	private static void agregarBuceo(CentroBuceoAvanzado cba, Buceo b, Mes mes) {
	 
		try {
			
		cba.agregarBuceo(b, mes);
		
		}catch (RuntimeException r) {
		      System.out.println("Buceo no valido");
			
		} 
	 
	}

	private static void registrarBuceadores(CentroBuceoAvanzado cba) {
		registrarBuceadorOpenWater(cba, "Juan", "Argentino", 23, 3);
		registrarBuceadorOpenWater(cba, "John", "Norteamericano", 16, 1);
		registrarBuceadorOpenWater(cba, "Catalina", "Argentina", 23, 5);
		registrarBuceadorOpenWater(cba, "Catalina", "Argentina", 23, 10);

		registrarBuceadorAdvanced(cba, "Esteban", "Argentino", 23, 3);
		//registrarBuceadorAdvanced(cba, "", "Chileno", 23, 3);
		registrarBuceadorAdvanced(cba, "Ricardo", "Español", 23, 7);
		registrarBuceadorAdvanced(cba, "Juana", null, 23, 7);
		registrarBuceadorAdvanced(cba, "Carolina", "Argentina", 23, 1);

		registrarBuceadorTecnico(cba, "Maximiliano", "Argentino", 23, 1);
		registrarBuceadorTecnico(cba, "Maximiliano", "Argentino", 23, 144);
		registrarBuceadorTecnico(cba, "Juana", "Argentina", 23, 2);
		registrarBuceadorTecnico(cba, "Josefa", "Argentino", 23, 7);
	}

	private static void registrarBuceadorOpenWater(CentroBuceoAvanzado cba, String nombre, String nacionalidad,
			int edad, int idBuceo) {
		 try {
				BuzoOpenWater buzoOpen = new BuzoOpenWater(nombre, nacionalidad, edad);
				cba.registrarBuceo(buzoOpen, idBuceo);
		 }catch (RuntimeException r) {
			 System.out.println(r.getMessage());
		 }
	
		 
	}

	private static void registrarBuceadorAdvanced(CentroBuceoAvanzado cba, String nombre, String nacionalidad, int edad,
			int idBuceo) {
	       
		try {
	     	BuzoAdvancedOpenWater buzoAdvanced = new BuzoAdvancedOpenWater(nombre, nacionalidad, edad);
			cba.registrarBuceo(buzoAdvanced, idBuceo);
			
		}catch (RuntimeException r){
			 System.out.println(r.getMessage());
		 
			
		}
		 
	

	}

	private static void registrarBuceadorTecnico(CentroBuceoAvanzado cba, String nombre, String nacionalidad, int edad,
			int idBuceo) {
		try {
     BuzoTecnico buzoTecnico = new BuzoTecnico(nombre, nacionalidad, edad);
     cba.registrarBuceo(buzoTecnico, idBuceo);
		}catch (RuntimeException r){
			 System.out.println(r.getMessage());
			
		}

	}

}
