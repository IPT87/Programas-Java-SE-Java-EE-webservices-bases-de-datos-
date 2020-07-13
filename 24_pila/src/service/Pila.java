package service;

import java.util.ArrayList;

public class Pila<E> {
	
	ArrayList<E> lista = new ArrayList<>();
	
	public boolean agregar(E elemento) {
		return lista.add(elemento);
	}
	
	public E quitar() {
		return lista.size() > 0 ? lista.remove(lista.size() - 1) : null;
	}
	
	public boolean contains(Object obj) {	
		for (E elemento : lista) {
			if (elemento.equals(obj)) {
				return true;
			}
		}
		return false;
	}
}
