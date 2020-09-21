package presentacion;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Entrada;
import service.EntradasFactory;
import service.EntradasService;

public class Main extends Application {
	
	private EntradasService service =  EntradasFactory.getEntradasService();
	private ListView<Entrada> listaEntradas;
	private ListView<Entrada> listaEntradasPorTema;
	private ListView<Entrada> listaEntradasParteTitulo;
	private Label lbPrecio;

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox(5);
		Scene scene = new Scene(root, 600, 500);
		
		MenuItem todasEntradas = new MenuItem("Todas las entradas");
		todasEntradas.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				root.getChildren().remove(listaEntradas);
				root.getChildren().remove(listaEntradasParteTitulo);
				root.getChildren().remove(listaEntradasPorTema);
				root.getChildren().remove(lbPrecio);
				
				ObservableList<Entrada> oLista = FXCollections.observableList(service.getEntradas());
				
				listaEntradas = new ListView<Entrada>(oLista);
				root.getChildren().add(listaEntradas);
			}
		});
		
		MenuItem buscarPorTema = new MenuItem("Buscar entradas por tema");
		buscarPorTema.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				root.getChildren().remove(listaEntradasPorTema);
				root.getChildren().remove(listaEntradasParteTitulo);
				root.getChildren().remove(listaEntradas);
				root.getChildren().remove(lbPrecio);
				
				String tema = JOptionPane.showInputDialog("Introduce tema");
				
				ObservableList<Entrada> oLista = FXCollections.observableList(service.getEntradasTema(tema));
				
				listaEntradasPorTema = new ListView<Entrada>(oLista);
				root.getChildren().add(listaEntradasPorTema);
			}
		});
		
		MenuItem buscarPorParteTitulo = new MenuItem("Buscar por parte del titulo");
		buscarPorParteTitulo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				root.getChildren().remove(listaEntradasParteTitulo);
				root.getChildren().remove(listaEntradas);
				root.getChildren().remove(listaEntradasPorTema);
				root.getChildren().remove(lbPrecio);
				
				String parteDelTitulo = JOptionPane.showInputDialog("Introduce palabra para buscar en los titulos");
				
				ObservableList<Entrada> oLista = FXCollections.observableList(service.getEntradasParteTitulo(parteDelTitulo));
				
				listaEntradasParteTitulo = new ListView<Entrada>(oLista);
				
				root.getChildren().add(listaEntradasParteTitulo);
				
			}
		});
		
		MenuItem facturacionPorTema = new MenuItem("Facturacion por tema");
		facturacionPorTema.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				root.getChildren().remove(listaEntradasParteTitulo);
				root.getChildren().remove(listaEntradas);
				root.getChildren().remove(listaEntradasPorTema);
				root.getChildren().remove(lbPrecio);
				
				String tema = JOptionPane.showInputDialog("Introduce tema");
				
				lbPrecio = new Label(String.valueOf(service.facturacionPorTema(tema)));
				
				root.getChildren().add(lbPrecio);
			}
		});
		
		
		Menu buscar = new Menu("Buscar");
		buscar.getItems().add(todasEntradas);
		buscar.getItems().add(buscarPorTema);
		buscar.getItems().add(buscarPorParteTitulo);
		buscar.getItems().add(facturacionPorTema);
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(buscar);
		
		root.getChildren().add(menuBar);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Buscador libros");
		primaryStage.getIcons().add(new Image("file:\\C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\App\\search.png"));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
