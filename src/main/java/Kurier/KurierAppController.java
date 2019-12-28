package Kurier;

import java.io.IOException;

import data.DataContainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class KurierAppController {

	@FXML
	private StackPane background;

	@FXML
	private Label title;

	@FXML
	private Button kontakt;

	@FXML
	private Button cennik;

	@FXML
	private Button klient;

	@FXML
	private Button Service;

	@FXML
	private Button pracownik;
	
    @FXML
    private SplitMenuButton menuButton;

	public KurierAppController() {

	}

	@FXML
	void initialize() {
	}

	@FXML
	void OnActionCennik(ActionEvent event) throws IOException {
       
		System.out.println("Cennik");
    	
    	FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/Cennik.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);
    	
		klasaStage.nextStage.setTitle("APLIKACJA");
		
		klasaStage.scene=scene;
		klasaStage.show();
		
	}

	@FXML
	void OnActionKlient(ActionEvent event) throws IOException {
		System.out.println("KLIENT");
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/klient.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("KLIENT");

		klasaStage.scene = scene;
		klasaStage.show();
	}

	@FXML
	void OnActionKontakt(ActionEvent event) throws IOException {

       	System.out.println("Kontakt");
    	
    	FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/Kontakt.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);
    	
		klasaStage.nextStage.setTitle("APLIKACJA");
		
		klasaStage.scene=scene;
		klasaStage.show();
		
		
		
	}

	@FXML
	void OnActionPracownik(ActionEvent event) throws IOException {

		System.out.println("PRACOWNIK");
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/checkPassword.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("PRACOWNIK");

		klasaStage.scene = scene;
		klasaStage.show();
	}

	@FXML
	void ServiceAction(ActionEvent event) throws IOException {

		System.out.println("Us³ugi");

    	FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/DostepneUslugi.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);
    	
		klasaStage.nextStage.setTitle("APLIKACJA");
		
		klasaStage.scene=scene;
		klasaStage.show();
		

	}

	
	@FXML
    private MenuItem miasto1Button;
	
	   @FXML
	    void onActionMiasto1(ActionEvent event) {

		   menuButton.setText("miasto1");
		   System.out.println("miasto1");
		   
		   
	    }
	   
	    @FXML
	    void onActionMenuButton(ActionEvent event) {

			   System.out.println("miasto1");
			   menuButton.setText("miasto1");
			   System.out.println("miasto2");
			   menuButton.setText("miasto2");
	    	
	    }
	
	
	
	
	

}
