package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		String user = "admin";
		String pwd = "javafx";
		
		try {
			GridPane root = new GridPane();
			root.setVgap(30);
			root.setHgap(20);
			Label lbUsuario = new Label("Usuario:");
			Label lbPwd = new Label("Contraseña");
			TextField tfUsuario = new TextField();
			PasswordField pfPwd = new PasswordField();
			Button boton = new Button("Validar");
			root.add(lbUsuario, 0, 0);
			root.add(tfUsuario, 1, 0);
			root.add(lbPwd, 0, 1);
			root.add(pfPwd, 1, 1);
			root.add(boton, 0, 2, 2, 1);
			
			boton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					if (tfUsuario.getText().equals(user) && pfPwd.getText().equals(pwd)) {
						/*Alert alert = new Alert(AlertType.CONFIRMATION, "Esta registrado");
						alert.show();*/
						
						crearVentanaResultado();
					}
				}
			});
			
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
	
	public void crearVentanaResultado() {
		Stage escenario2 = new Stage();
		FlowPane flow = new FlowPane();
		Button bt = new Button("Salir");
		
		flow.getChildren().add(new Label("Bienvenid@ a la app"));
		flow.getChildren().add(bt);
		Scene escena2 = new Scene(flow, 200, 150);
		escenario2.setScene(escena2);
		escenario2.show();
		bt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				escenario2.close();
			}
		});
	}
	
}
