package application;
	
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FlowPane root = new FlowPane();
			Button boton1=new Button("Pulsar");
			boton1.setOnAction(new EventHandler<ActionEvent>() {			
				@Override
				public void handle(ActionEvent event) {
					JOptionPane.showMessageDialog(new JFrame(), "Has pulsado");					
				}
			});
			Button boton2=new Button("Pulsar otro");
			root.getChildren().add(boton1);
			root.getChildren().add(boton2);
			Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
