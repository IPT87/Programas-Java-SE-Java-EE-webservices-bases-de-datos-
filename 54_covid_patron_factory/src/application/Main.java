package application;
	
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Caso;
import service.BaseService;
import service.CovidFactory;


public class Main extends Application {
	BaseService service=CovidFactory.getFactory().getBaseService();
	TableView<Caso> tbCasos=new TableView<Caso>();
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setVgap(10);
			root.setHgap(20);
			//Scene scene = new Scene(root,800,600);
			ListView<String> lstComunidades=new ListView<String>(FXCollections.observableList(service.comunidades()));
			RadioButton rbTodas=new RadioButton("Todas");
			RadioButton rbEntreFechas=new RadioButton("Entre:");
			ToggleGroup tg=new ToggleGroup();
			rbTodas.setToggleGroup(tg);
			rbEntreFechas.setToggleGroup(tg);
			DatePicker f1=new DatePicker(LocalDate.now());
			DatePicker f2=new DatePicker(LocalDate.now());
			Button bCasos=new Button("Ver casos");
			bCasos.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					if(rbTodas.isSelected()) {
						
						cargarTabla(service.casosDeComunidad(lstComunidades.getSelectionModel().getSelectedItem()));
					}
					if(rbEntreFechas.isSelected()) {
						Date fechaIni=Date.from(f1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
						Date fechaFin=Date.from(f2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
						cargarTabla(service.casosEntreFechasComunidad(fechaIni, fechaFin, lstComunidades.getSelectionModel().getSelectedItem()));
					}
					
				}
			});
			
			root.add(lstComunidades, 0, 1,1,3);
			root.add(rbTodas, 2, 0);
			root.add(rbEntreFechas, 2, 1);
			root.add(f1, 3, 1);
			root.add(f2, 4, 1);
			root.add(bCasos, 3, 2,2,1);
			root.add(tbCasos, 2, 3,3,3);
			root.setVisible(false);
			//generación del menú
			MenuBar menuBar = new MenuBar();
	        Menu mn=new Menu("Consultas");
	        menuBar.getMenus().add(mn);
	        MenuItem it=new MenuItem("Por comunidad");
	        mn.getItems().add(it);
	        it.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					root.setVisible(true);
					
				}
	        	
			});

	        VBox vBox = new VBox(menuBar);
	        vBox.getChildren().add(root);
	        Scene scene = new Scene(vBox, 960, 600);

	        primaryStage.setScene(scene);
	        primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void cargarTabla(List<Caso> casos) {
		//Creamos y configuramos la tabla
        TableColumn<Caso,String> firstNameCol = new TableColumn<>("Comunidad");
        firstNameCol.setMinWidth(150);
        //Informamos los nombres de las propiedades del JavaBean "Contacto"
        //que el programa deberá llamar al hacer un set/get
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Caso, String>("comunidad"));

        TableColumn<Caso,Integer> ageCol = new TableColumn<>("Positivos");
        ageCol.setMinWidth(100);
        ageCol.setCellValueFactory(
                new PropertyValueFactory<Caso, Integer>("positivos"));

        TableColumn<Caso,Date> emailCol = new TableColumn<>("Fecha");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Caso, Date>("fecha"));
        //Asignamos los datos
        tbCasos.setItems(FXCollections.observableList(casos));
        //Añadimos las columnas
        tbCasos.getColumns().addAll(firstNameCol, ageCol, emailCol);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
