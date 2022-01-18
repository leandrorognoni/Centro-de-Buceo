package centrobuceo.clases;

import centrobuceo.nodos.ListaOrdenadaNodos;

public class ListaOrdenadaPorId extends ListaOrdenadaNodos<Integer, Buceo>  {

	@Override
	public int compare(Buceo dato1, Buceo dato2) {
	     
		return dato1.getId() - dato2.getId() ;
	}

	@Override
	public int compareByKey(Integer clave, Buceo elemento) {
	 
		return clave - elemento.getId();
	}

	 
 

 
 
 

 

}
