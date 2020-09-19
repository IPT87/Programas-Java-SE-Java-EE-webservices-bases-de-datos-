package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.Contacto;
import service.ContactoService;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = new StackPane();
			ContactoService service = new ContactoService();
			ObservableList<Contacto> lista = FXCollections.observableList(service.mostrarContactos());
			//montamos la tabla
			TableView<Contacto> table = new TableView<Contacto>();
			//Creamos y configuramos la tabla
	        TableColumn<Contacto,String> firstNameCol = new TableColumn<>("Nombre");
	        firstNameCol.setMinWidth(150);
	        //Informamos los nombres de las propiedades del JavaBean "Contacto"
	        //que el programa deberá llamar al hacer un set/get
	        firstNameCol.setCellValueFactory(
	                new PropertyValueFactory<Contacto, String>("nombre"));

	        TableColumn<Contacto,Integer> ageCol = new TableColumn<>("Edad");
	        ageCol.setMinWidth(100);
	        ageCol.setCellValueFactory(
	                new PropertyValueFactory<Contacto, Integer>("edad"));

	        TableColumn<Contacto,String> emailCol = new TableColumn<>("Email");
	        emailCol.setMinWidth(200);
	        emailCol.setCellValueFactory(
	                new PropertyValueFactory<Contacto, String>("email"));
	        //Asignamos los datos
	        table.setItems(lista);
	        //Añadimos las columnas
	        table.getColumns().addAll(firstNameCol, ageCol, emailCol);
	        //agregamos la tabla al panel raíz
	        root.getChildren().add(table);
			
			Scene scene = new Scene(root,600,400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
