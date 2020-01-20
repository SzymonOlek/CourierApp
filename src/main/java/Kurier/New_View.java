package Kurier;

import java.io.IOException;

import data.Counter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class New_View{
	
	
	public New_View() throws IOException {
		
    	FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/Calculations.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);
		
		Stage stage = new Stage();
		
		stage.setOnCloseRequest(event -> {
		    Counter.numberOfCalculatingWindows-=1;

		});
    	
		stage.setTitle("Obliczanie");
		
		stage.setScene(scene);
		
		stage.show();
		
		
		
		
		
	}
	public New_View(String s ) throws IOException {
		
    	FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/Calculations2.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);
		
		Stage stage = new Stage();
		
		stage.setOnCloseRequest(event -> {
		    Counter.numberOfCalculatingWindowsSend-=1;

		});
    	
		stage.setTitle("Obliczanie");
		
		stage.setScene(scene);
		
		stage.show();
		
		
		
		
		
	}
	
		
		
		
		
		

	

}
