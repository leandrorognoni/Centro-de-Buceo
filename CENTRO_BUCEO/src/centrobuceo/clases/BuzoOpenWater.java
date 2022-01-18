package centrobuceo.clases;

/**
 * Buzo con autorizacion para bajar hasta los 22 metros inclusive. nunca puede realizar buceos mas profundos
 *
 */
public class BuzoOpenWater extends Buzo {

	private static final int PROFUNDIDAD_MAXIMA_PERMITIDA = 22;

	public BuzoOpenWater(String nombre, String nacionalidad, int edad) {
		super(nombre,nacionalidad,edad);
	}

	@Override
	public boolean habilitadoBuceoProfundo() {
		 
		return false;
	}

	@Override
	public boolean habilitadoBuceoMedio() {
		 
		return false;
	}

	@Override
	public boolean habilitado(int metros) {
	    boolean puede = false;
	    if(metros<=PROFUNDIDAD_MAXIMA_PERMITIDA) {
	    	puede = true;
	    }
		return puede;
	}

	//TODO A completar
}
