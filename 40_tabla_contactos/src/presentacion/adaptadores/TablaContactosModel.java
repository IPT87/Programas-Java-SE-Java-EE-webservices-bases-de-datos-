package presentacion.adaptadores;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import model.Contacto;
import service.ContactoService;

public class TablaContactosModel extends AbstractTableModel {
	private ContactoService service = new ContactoService();
	private List<Contacto> contactos;
	
	public TablaContactosModel() {
		this.contactos = service.mostrarContactos();
	}
	
	@Override
	public int getRowCount() {
		return contactos.size();
	}

	@Override
	public int getColumnCount() {
		//devuelve el total de atributos de la clase Contacto
		return Contacto.class.getDeclaredFields().length;
	}

	@Override
	public String getColumnName(int column) {
		return Contacto.class.getDeclaredFields()[column].getName();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Object res = null;
		switch (column) {
		case 0:
			res = contactos.get(row).getIdcontacto();
			break;
		case 1:
			res = contactos.get(row).getNombre();
			break;
		case 2:
			res = contactos.get(row).getEmail();
			break;
		case 3:
			res = contactos.get(row).getEdad();
			break;
		}
		return res;
	}
	
}
