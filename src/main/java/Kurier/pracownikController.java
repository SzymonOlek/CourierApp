package Kurier;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    void onActionCheckOrd(ActionEvent event) throws IOException {

    	
    	FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/CheckOrderEmployee.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);
    	
		klasaStage.nextStage.setTitle("APLIKACJA");
		
		klasaStage.scene=scene;
		klasaStage.show();
		
    }

    @FXML
    void onActionRoute(ActionEvent event) throws IOException {

    	
    	System.out.println("wyznaczanie trasy");

    	
    	New_View calculating = new New_View();
    	
    }
    
    /////////////////////////   check Password fxml
    
    
    @FXML
    private StackPane checkPasswordBackground;

    @FXML
    private Button acceptPassword;

    @FXML
    private TextField checkPasswordText;

    @FXML
    private Button backCheckPassowrd;

    @FXML
    void onActionAcceptPassword(ActionEvent event) throws IOException {

    	
    	if(checkPasswordText.getText().equals("haslo")) {
    		
    		FXMLLoader loader = new FXMLLoader();

    		loader.setLocation(this.getClass().getResource("/fxml/pracownik.fxml"));

    		StackPane stackPane = (StackPane) loader.load();

    		Scene scene = new Scene(stackPane);

    		klasaStage.nextStage.setTitle("APLIKACJA");

    		klasaStage.scene = scene;
    		klasaStage.show();
    		
    	}else {
    		
    		checkPasswordText.setText("");
    		checkPasswordText.setPromptText("Bledne haslo sprobuj ponownie");
    		
    	}
    	
    	
    	
    	
    }

    @FXML
    void onActionCheckPasswordBack(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/KurierApp.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("APLIKACJA");

		klasaStage.scene = scene;
		klasaStage.show();
    	
    	
    	
    	
    	
    }

    @FXML
    private Button changeOrderStatus;

    @FXML
    void onActionChangeStatus(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/ChangeStatus.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("APLIKACJA");

		klasaStage.scene = scene;
		klasaStage.show();
    	
    }
    @FXML
    private Button route2;

    @FXML
    void onActionRoute2(ActionEvent event) {

    	try {
			New_View calculating = new New_View("temp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

}
