package Kurier;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class pracownikController {

    @FXML
    private StackPane pracownikBackground;
	
	
    @FXML
    private Button back;
    
    @FXML
    private Button route;

    @FXML
    private Button checkOrd;

    @FXML
    void onActonBack(ActionEvent event) throws IOException {
       	System.out.println("Powrót");
    	
    	FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/KurierApp.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);
    	
		klasaStage.nextStage.setTitle("APLIKACJA");
		
		klasaStage.scene=scene;
		klasaStage.show();
		
    }
    
  
    @FXML
    void onActionCheckOrd(ActionEvent event) {

    	
    	System.out.println("sprawdzanie zamowienia");
    	
    }

    @FXML
    void onActionRoute(ActionEvent event) {

    	
    	System.out.println("wyznaczanie trasy");
    }

	
}
