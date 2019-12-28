package Kurier;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;

public class ServiceController {

    @FXML
    private StackPane serviceBackground;

    @FXML
    private Button returnService;

    @FXML
    void returnServiceOnAction(ActionEvent event) throws IOException {

    	
		System.out.println("Uslugi");

    	FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/KurierApp.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);
    	
		klasaStage.nextStage.setTitle("APLIKACJA");
		
		klasaStage.scene=scene;
		klasaStage.show();
		

    	
    	
    	
    	
    }
    
    


    
    
    
    

}