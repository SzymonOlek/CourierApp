package Kurier;

import java.io.IOException;
import java.util.ArrayList;

import data.Server;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class makeOrderController {

    @FXML
    private MenuButton adressTo;

    @FXML
    private MenuItem Miasto0;

    @FXML
    private MenuButton adressFrom;

	
    @FXML
	private Button newOrderAccept;

	@FXML
	private Button newOrderCancel;

    @FXML
    private TextField firstName;

    @FXML
    private TextField secondName;

    @FXML
    private TextField weight;

    @FXML
    private TextField tel;

    @FXML
    private TextField high;

    @FXML
    private TextField width;

    @FXML
    private TextField length;

	
	private Boolean checkIfCorrect() {
		
		
		if(firstName.getText().trim().isEmpty() || secondName.getText().trim().isEmpty() || weight.getText().trim().isEmpty() || high.getText().trim().isEmpty() || width.getText().trim().isEmpty() || length.getText().trim().isEmpty() || adressTo.getText().trim()=="Wybierz adres dostawy" || adressFrom.getText().trim()=="Wybierz adres wysylki" || tel.getText().trim().isEmpty())
		{return false;}	
		else {
		return true;
		}
		
	}
	
	@FXML
	void onActionAccept(ActionEvent event) throws IOException {

		System.out.println("akceptacja zamowienia");

		if(checkIfCorrect()) {
		
		Order order = new Order(firstName.getText(),secondName.getText(),Integer.valueOf(weight.getText()),Integer.valueOf(high.getText()),Integer.valueOf(width.getText()),Integer.valueOf(length.getText()),adressTo.getText(),adressFrom.getText(),tel.getText());
		
		Server server = new Server();
		
		server.addOrder(order);
		
		
		firstName.clear();
		secondName.clear();
		weight.clear();
		high.clear();
		width.clear();
		length.clear();
		adressTo.setText("Wybierz adres wysylki");
		adressFrom.setText("Wybierz adres dostawy");
		tel.clear();
		
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/ShowAddedOrder.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("APLIKACJA");

		klasaStage.scene = scene;

		klasaStage.show();
		}
		else {

		}
		
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
	protected void initialize() {
	
		Server server =  new Server ();
		ArrayList<String> cities = server.getCityNames();
		
		for(String city :  cities) {
			
			MenuItem temp1 = new MenuItem (city);
			MenuItem temp2 = new MenuItem (city);
			
			temp1.setOnAction(new EventHandler<ActionEvent>(){
				 public void handle(ActionEvent e) 
		            { 
		                adressTo.setText(((MenuItem)e.getSource()).getText() ); 
		            } 
				
				}
			);
			temp2.setOnAction(new EventHandler<ActionEvent>(){
				 public void handle(ActionEvent e) 
		            { 
		                adressFrom.setText(((MenuItem)e.getSource()).getText() ); 
		            } 
				
				}
			);
			
			
			adressFrom.getItems().add(temp2);
			adressTo.getItems().add(temp1);
		}
		
		
	
	}
	
	

@FXML
void mouseBackground(MouseEvent event) {
	
}
}
