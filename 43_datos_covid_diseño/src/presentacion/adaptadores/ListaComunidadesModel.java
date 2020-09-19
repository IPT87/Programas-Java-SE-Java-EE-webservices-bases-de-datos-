package presentacion.adaptadores;

import javax.swing.DefaultListModel;

import model.Caso;
import presentacion.graficos.JVentanaInicio;
import service.CasosService;

public class ListaComunidadesModel extends DefaultListModel<Caso> {
	JVentanaInicio vi = new JVentanaInicio();
	CasosService service = new CasosService(vi.getFuente());
	
	/*@Override
	public Caso getElementAt(int index) {
		return service.mostrarContactos().get(index);
	}
	
	@Override
	public int getSize() {
		return service.mostrarContactos().size();
	}
	
	public void eliminarContacto(Caso caso) {
		service.eliminarContacto(caso.getEmail());
	}*/
}
