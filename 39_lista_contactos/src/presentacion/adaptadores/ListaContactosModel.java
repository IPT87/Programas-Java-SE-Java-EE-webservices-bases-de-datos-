package presentacion.adaptadores;

import javax.swing.DefaultListModel;
import model.Contacto;
import service.ContactoService;

public class ListaContactosModel extends DefaultListModel<Contacto> {
	ContactoService service = new ContactoService();
	
	@Override
	public Contacto getElementAt(int index) {
		return service.mostrarContactos().get(index);
	}
	
	@Override
	public int getSize() {
		return service.mostrarContactos().size();
	}
	
	public void eliminarContacto(Contacto contacto) {
		service.eliminarContacto(contacto.getEmail());
	}
}
