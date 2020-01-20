package Kurier;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import algorithms.Algorithm;



public class Main extends Application {

	public static void main(String[] args) {
	
		launch(args);
		
//		Algorithm a = new Algorithm();
//										 
//		int [][] matrix = new int[][] { { 0, 5, 11, 4}, 
//										{ 5, 0, 7, 7},
//										{ 11, 7, 0, 8}, 
//										{ 4, 7, 8, 0},
//		};
//				
//		a.minCost(matrix);
//		String lastTrace = a.GetLastTrace();
//		int [] trace = a.parseToint(lastTrace, "->");
//		
//		for(int i=0;i<trace.length;i++)
//			System.out.println(trace[i]);
//		
//		
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
