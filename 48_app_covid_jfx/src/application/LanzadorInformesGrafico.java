package application;
	
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Caso;
import service.CasosService;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class LanzadorInformesGrafico extends Application {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private CasosService service = new CasosService("C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\datos_ccaas.json");
	private String comunidad;
	private Label lbSelectComunidad;
	private ComboBox<String> comboBox;
	private ListView<String> lstCasos = new ListView<String>();
	private ListView<Caso> lstC = new ListView<Caso>();
	private Label tfPositivosFecha = new Label("Casos: 0");
	
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox(5);
			Scene scene = new Scene(root,600,500);
			
			comboBox = new ComboBox<>();
			comboBox.setVisible(false);
			VBox.setMargin(comboBox, new Insets(5, 5, 5, 5));
			
			lbSelectComunidad = new Label("Seleccione comunidad:");
			lbSelectComunidad.setFont(new Font("Cambria", 20));
			VBox.setMargin(lbSelectComunidad, new Insets(5, 5, 5, 5));
			lbSelectComunidad.setVisible(false);
			Label lbFechaPico = new Label("Fecha del pico de los contagios: " + sdf.format(service.fechaPicoContagios()));
			lbFechaPico.setFont(new Font("Cambria", 20));
			lbFechaPico.setVisible(false);
			lbFechaPico.setMaxWidth(Double.MAX_VALUE);
	        lbFechaPico.setAlignment(Pos.CENTER);
			
			MenuItem menuItem = new MenuItem("Por comunidad");
			menuItem.setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			    	lbFechaPico.setVisible(false);
			    	lbSelectComunidad.setVisible(true);
			        List<String> comunidades = service.getComunidades();
			        comboBox.setPromptText("Andalucia");
			        
			        for (int i = 0; i < comunidades.size(); i++) {
			        	 comboBox.getItems().add(comunidades.get(i));
			        	 comboBox.setVisible(true);
			        }
			    }
			});
			
			comboBox.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					lbFechaPico.setVisible(false);
					comunidad = comboBox.getValue();
					
					if (comunidad != null) {
						service.casosComunidad(comunidad);
						crearVentanaResultado();
					}
				}
			});
			
			MenuItem mediaCasosDiarios = new MenuItem("Media contagios diarios");
			mediaCasosDiarios.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					lbSelectComunidad.setVisible(false);
					comboBox.setVisible(false);
					lbFechaPico.setVisible(false);
					crearVentanaInformes();
				}
			});
			
			MenuItem fechaPico = new MenuItem("Fecha pico contagios");
			fechaPico.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					lbSelectComunidad.setVisible(false);
					comboBox.setVisible(false);
					lbFechaPico.setVisible(true);
				}
			});
			
			final Menu menuConsultas = new Menu("Consultas");
			menuConsultas.getItems().add(menuItem);
			
			final Menu menuInformes = new Menu("Informes");
			menuInformes.getItems().add(mediaCasosDiarios);
			menuInformes.getItems().add(fechaPico);
			
			final Menu menuEstadisticas = new Menu("Estadisticas");
			menuEstadisticas.getItems().add(menuInformes);
			
			MenuBar menuBar = new MenuBar();
			menuBar.getMenus().addAll(menuConsultas, menuEstadisticas);
			
			root.getChildren().add(menuBar);
			root.getChildren().add(lbSelectComunidad);
			root.getChildren().add(comboBox);
			root.getChildren().add(lbFechaPico);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Estadistica COVID 19");
			primaryStage.getIcons().add(new Image("file:\\C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\App\\stat.png"));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void crearVentanaResultado() {

		Stage stage2 = new Stage();
		stage2.setTitle("Consultas");
		stage2.getIcons().add(new Image("file:\\C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\App\\change.png"));
		VBox flow = new VBox(5);
		
		ToggleGroup group = new ToggleGroup();
		
		RadioButton rbTodasFechas = new RadioButton("Todas las fechas");
		VBox.setMargin(rbTodasFechas, new Insets(5, 5, 5, 5));
		rbTodasFechas.setToggleGroup(group);
		
		RadioButton rbRangoFechas = new RadioButton("Rango fechas");
		VBox.setMargin(rbRangoFechas, new Insets(5, 5, 5, 5));
		rbRangoFechas.setToggleGroup(group);
		
		Label lb = new Label("Todos los casos:");
		VBox.setMargin(lb, new Insets(0, 5, 0, 5));
		lb.setFont(new Font("Cambria", 25));
		lb.setVisible(false);
		
		Label lbFechaDesde = new Label("Fecha desde:");
		VBox.setMargin(lbFechaDesde, new Insets(0, 5, 0, 5));
		lbFechaDesde.setVisible(false);
		
		Label lbFechaHasta = new Label("Fecha hasta:");
		VBox.setMargin(lbFechaHasta, new Insets(0, 5, 0, 5));
		lbFechaHasta.setVisible(false);
		
		DatePicker datePicker1 = new DatePicker();
		VBox.setMargin(datePicker1, new Insets(0, 5, 0, 5));
		datePicker1.setVisible(false);
		
		DatePicker datePicker2 = new DatePicker();
		VBox.setMargin(datePicker2, new Insets(0, 5, 0, 5));
		datePicker2.setVisible(false);
		
		Button btMostrarDatos = new Button("Mostrar datos");
		btMostrarDatos.setEffect(new Reflection());
		VBox.setMargin(btMostrarDatos, new Insets(5, 5, 20, 5));
		
		flow.getChildren().add(rbTodasFechas);
		flow.getChildren().add(rbRangoFechas);
		flow.getChildren().add(btMostrarDatos);
		flow.getChildren().add(lbFechaDesde);
		flow.getChildren().add(datePicker1);
		flow.getChildren().add(lbFechaHasta);
		flow.getChildren().add(datePicker2);
		flow.getChildren().add(lb);
		
		Scene scene2 = new Scene(flow, 450, 650);
		stage2.setScene(scene2);
		stage2.show();
		
		
		btMostrarDatos.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (rbTodasFechas.isSelected()) {
					lb.setVisible(true);
					flow.getChildren().remove(lstCasos);
					flow.getChildren().remove(lstC);
					Map<String, List<Caso>> casos = service.casosComunidad(comunidad);
					List<String> casosComunidad = new ArrayList<>();
					casos.forEach((k, p) -> p.forEach(c -> casosComunidad.add("Casos " + comunidad + ": " + sdf.format(c.getFecha()) + ", " + c.getPositivos() + " casos positivos.\n")));
					ObservableList<String> lista = FXCollections.observableList(casosComunidad);
					lstCasos = new ListView<String>(lista);
					flow.getChildren().add(lstCasos);
				}
				
				if (rbRangoFechas.isSelected()) {
					flow.getChildren().remove(lstC);
					flow.getChildren().remove(lstCasos);
					Date fechaDesde = java.sql.Date.valueOf(datePicker1.getValue());
					Date fechaHasta = java.sql.Date.valueOf(datePicker2.getValue());
					List<Caso> ls = service.casosPorPeriodo(fechaDesde, fechaHasta).stream().filter(c -> c.getNombreComunidad().equals(comunidad)).collect(Collectors.toList());
					ObservableList<Caso> list = FXCollections.observableList(ls);
					lstC = new ListView<Caso>(list);
					flow.getChildren().add(lstC);
				}
			}
		});
		
		rbTodasFechas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lstC.setVisible(false);
				lbFechaDesde.setVisible(false);
				lbFechaHasta.setVisible(false);
				datePicker1.setVisible(false);
				datePicker2.setVisible(false);
			}
		});
		
		rbRangoFechas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lb.setVisible(false);
				lstCasos.setVisible(false);
				lbFechaDesde.setVisible(true);
				lbFechaHasta.setVisible(true);
				datePicker1.setVisible(true);
				datePicker2.setVisible(true);
			}
		});
		
		stage2.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				lbSelectComunidad.setVisible(false);
				comboBox.setVisible(false);
				comboBox.getSelectionModel().clearSelection();
			}
		});
	}
	
	public void crearVentanaInformes() {
		Stage stage3 = new Stage();
		stage3.setTitle("Informes");
		stage3.getIcons().add(new Image("file:\\C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\App\\info.png"));
		VBox flow = new VBox(10);
		
		Label lb = new Label("Elige fecha:");
		lb.setFont(new Font("Cambria", 25));
		VBox.setMargin(lb, new Insets(5, 5, 5, 5));
		
		DatePicker datePicker = new DatePicker();
		VBox.setMargin(datePicker, new Insets(5, 5, 20, 5));
		
		tfPositivosFecha.setVisible(false);
		
		Button btMostrarDatos = new Button("Mostrar datos");
		VBox.setMargin(btMostrarDatos, new Insets(5, 5, 20, 5));
		btMostrarDatos.setEffect(new Reflection());
		btMostrarDatos.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				flow.getChildren().remove(tfPositivosFecha);
				tfPositivosFecha = new Label("Casos: " + service.totalMediaPositivosDiarios(java.sql.Date.valueOf(datePicker.getValue())));
				tfPositivosFecha.setFont(new Font("Cambria", 25));
				VBox.setMargin(tfPositivosFecha, new Insets(10, 10, 10, 10));
				flow.getChildren().add(tfPositivosFecha);
				tfPositivosFecha.setVisible(true);
			}
		});
		
		flow.getChildren().add(lb);
		flow.getChildren().add(datePicker);
		flow.getChildren().add(btMostrarDatos);
		
		Scene scene3 = new Scene(flow, 450, 550);
		stage3.setScene(scene3);
		stage3.show();
	}
	
}
