package application;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.Contacto;
import service.ContactoService;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = new StackPane();
			ContactoService service = new ContactoService();
			ObservableList<Contacto> lista = FXCollections.observableList(service.mostrarContactos());
			ListView<Contacto> lstContactos = new ListView<>(lista);
			lstContactos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contacto>() {
				@Override
				public void changed(ObservableValue<? extends Contacto> observable, Contacto oldValue,
						Contacto newValue) {
					service.eliminarContacto(newValue.getEmail());
					lstContactos.setItems(FXCollections.observableList(service.mostrarContactos()));
				}
			});;
			
			root.getChildren().add(lstContactos);
			
			Scene scene = new Scene(root,400,400);
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
