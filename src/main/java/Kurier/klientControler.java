package Kurier;

import java.io.IOException;

import data.Server;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class klientControler {
	
    String stringdataToShow;


	@FXML
	private StackPane klientBackground;

	@FXML
	private Button logOut;

	@FXML
	private Button checkOrder;

	@FXML
	private Button addOrder;

	@FXML
	private Button deleteOrder;

	@FXML
	void onActionAddOrder(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/ZlozenieZamowienia.fxml"));

		
		StackPane stackPane = (StackPane) loader.load();
		
		
		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("APLIKACJA");
		
		
		klasaStage.scene = scene;
		
		klasaStage.show();

	}

	@FXML
	void onActionCheckOrder(ActionEvent event) throws IOException {

		System.out.print("Sprawdz");

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/CheckOrder.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("APLIKACJA");

		klasaStage.scene = scene;
		klasaStage.show();

	}

	@FXML
	void onActionDeleteOrder(ActionEvent event) throws IOException {
		
		
		System.out.println("KLIENT");
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/RezygnacjaZamowienia.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("KLIENT");

		klasaStage.scene = scene;
		klasaStage.show();
		
		
		
	}

	@FXML
	void onActionLogOut(ActionEvent event) throws IOException {
		System.out.println("Powrót");

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/KurierApp.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("APLIKACJA");

		klasaStage.scene = scene;
		klasaStage.show();

	}
	
	
	  @FXML
	    private Button resignOrder;

	    @FXML
	    private Button backResignOrder;

	    @FXML
	    void onActionBackResignOrder(ActionEvent event) throws IOException {
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
	    private TextField resignOrderText;

	    @FXML
	    void onActionResignOrder(ActionEvent event) throws IOException {

	    	/*
	    	 * 
	    	 * TODO
	    	 * 
	    	 * 
	    	 * 
	    	 */
	    	
	    	
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
	        void onActionFirstMenu(MouseEvent event) {
		    
	    	
	        }
	        
	        
	        @FXML
	        private Label dataToShow;
	        


	        @FXML
	        private Button backShowAddedOrder;

	        @FXML
	        void OnActionBackShowAddedOrder(ActionEvent event) throws IOException {

	        	
	    		FXMLLoader loader = new FXMLLoader();

	    		loader.setLocation(this.getClass().getResource("/fxml/KurierApp.fxml"));

	    		StackPane stackPane = (StackPane) loader.load();

	    		Scene scene = new Scene(stackPane);

	    		klasaStage.nextStage.setTitle("APLIKACJA");

	    		klasaStage.scene = scene;
	    		klasaStage.show();
	        	
	        }
	    
	        @FXML
	        void ReadData(MouseEvent event) {

	        	Server server = new Server();
	        	
	        	int id = server.getMaxOrderID();
	        	
	        	String order = server.getOrderByID(id);
	        	
	        	
	        	dataToShow.setText("Numer zamówienia to " + id +"\n" +order);
	        	
	        }
	        
	        
	          
	        
	        

}
