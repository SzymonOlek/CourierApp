package Kurier;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class klientControler {


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
	private Button newOrderAccept;

	@FXML
	private Button newOrderCancel;

	@FXML
	void onActionAccept(ActionEvent event) throws IOException {

		System.out.println("akceptacja zamowienia");
		
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/KurierApp.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("APLIKACJA");

		klasaStage.scene = scene;
		klasaStage.show();
		
	}

	@FXML
	void onActionCancelOrder(ActionEvent event) throws IOException {
		
		
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
	
	

}
