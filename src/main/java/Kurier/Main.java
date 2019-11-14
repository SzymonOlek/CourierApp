package Kurier;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import data.DataContainer;



public class Main extends Application {

	public static void main(String[] args) {
		
		
		DataContainer tempData = new DataContainer("miasta.txt", "graph.txt");
		
		tempData.printData();
		
		
		
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/KurierApp.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);
		
		primaryStage.setTitle("APLIKACJA");
		
		klasaStage.setEverything(scene, primaryStage);
		
		klasaStage.show();

	}

}
