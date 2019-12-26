package Kurier;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class CennikController {

	

    @FXML
    private Button makeOrderCennik;

    @FXML
    private Button returnCennik;

    @FXML
    void makeOrderCennikOnAction(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/ZlozenieZamowienia.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("APLIKACJA");

		klasaStage.scene = scene;
		klasaStage.show();

    }

    @FXML
    void returnCennikOnAction(ActionEvent event) throws IOException {

       	System.out.println("Powrót");
    	
    	FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/KurierApp.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);
    	
		klasaStage.nextStage.setTitle("APLIKACJA");
		
		klasaStage.scene=scene;
		klasaStage.show();
		
    	
    }
	
	
	
	
	
}
