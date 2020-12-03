package service;

import java.util.List;

import model.Item;

public interface BuscadorService {

	List<Item> buscarItems(String tema);

}