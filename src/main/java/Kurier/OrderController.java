package Kurier;

import java.io.IOException;
import data.Server;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;


public class OrderController {

	@FXML
	private TextField textFieldChechOrder;

	@FXML
	private Button checkCheckOrder;

	@FXML
	private Button backCheckOrder;
	
    @FXML
    private Label textToCheckOrder;

	@FXML
	void onActionCheckCheckOrder(ActionEvent event) {
		textToCheckOrder.setText("");
		boolean correct = false;
		String toSet="";
		int inx=-1;
		System.out.println(textFieldChechOrder.getText());
		String value = textFieldChechOrder.getText();
		
		try {
			inx = Integer.parseInt(value);
			correct = true;
		}catch(Exception e){
			textToCheckOrder.setText("podana wartosc nie jest wlasciwa");
		}
		
		if(correct== true) {
			Server s = new Server();
			toSet=s.checkOrderStatus(inx);
			try {
			if(toSet.charAt(0) == 'S' && toSet.charAt(1) == 't' && toSet.charAt(2) == 'a' && toSet.charAt(3) == 'n')
			{
				
				textToCheckOrder.setText(toSet);
			}
			}catch(Exception e) {
				textToCheckOrder.setText("Zamowienie o podanym numerze nie istnieje");
			}
		}
//		textFieldChechOrder.clear();
		
		

	}

	@FXML
	void onActionBackCheckOrder(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/klient.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("APLIKACJA");

		klasaStage.scene = scene;
		klasaStage.show();

	}
	//////////////////////   employ check order
	
	

    @FXML
    private StackPane checkOrderBackground;

    @FXML
    private TextField textFieldChechOrderEmploy;

    @FXML
    private Button checkCheckOrderemploy;

    @FXML
    private Button backCheckOrderEmploy;

    @FXML
    private Label textToCheckOrderEmploy;

    @FXML
    void onActionBackCheckOrderEmploy(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/pracownik.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("APLIKACJA");

		klasaStage.scene = scene;
		klasaStage.show();
    	
    	
    }

    @FXML
    private Label textToCheckOrderEmploy2;

    @FXML
    void onActionCheckOrderEmploy(ActionEvent event) {

    	textToCheckOrderEmploy.setText("");
		boolean correct = false;
		String toSet="";
		int inx=-1;
		System.out.println(textFieldChechOrderEmploy.getText());
		String value = textFieldChechOrderEmploy.getText();
		
		try {
			inx = Integer.parseInt(value);
			correct = true;
		}catch(Exception e){
			textToCheckOrderEmploy.setText("podana wartosc nie jest wlasciwa");
		}
		
		if(correct== true) {
//			toSet=s.getOrderByID(inx);
			try {
//			if(toSet.charAt(0) == 'S' && toSet.charAt(1) == 't' && toSet.charAt(2) == 'a' && toSet.charAt(3) == 'n')
//			{
				
//				textToCheckOrderEmploy.setText(toSet);
			
		    	Server server = new Server();
		    	
		    	String order = server.getOrderByID(inx);
		    	
		    	
		    	textToCheckOrderEmploy2.setText(order);
//			}
			}catch(Exception e) {
				textToCheckOrder.setText("Zamowienie o podanym numerze nie istnieje");
			}
		}
    	
    	
    }
    ///////////////////////////  Change Status
    
    
    @FXML
    private TextField textFieldStatus;

    @FXML
    private Button checkStatusChange;

    @FXML
    private Button backChangeStatus;

    @FXML
    private Label textToChangeStatus;

    @FXML
    private Button changeStatus;
    
    @FXML
    private RadioButton RadioDostarczone;

    @FXML
    private RadioButton RadioRealizacja;
    

    @FXML
    void OnActionChangeStatus(ActionEvent event) {

		boolean correct = false;

		int inx=-1;

		String value = textFieldStatus.getText();
		
		try {
			inx = Integer.parseInt(value);
			correct = true;
		}catch(Exception e){
			textToChangeStatus.setText("podana wartosc nie jest wlasciwa");
		}
		
		if(correct== true) {
			Server s = new Server();

			if(RadioDostarczone.isSelected()) {
				
				s.changeStatus(inx, "zrealizowane");
				textToChangeStatus.setText("Stan zamowienia: "+"zrealizowane");
				
				
			}else if(RadioRealizacja.isSelected()) {
				
				s.changeStatus(inx, "w trakcie realizacji");
				textToChangeStatus.setText("Stan zamowienia: "+"w trakcie realizacji");
				
				
			}else {
				textToChangeStatus.setText("Wybierz status do zmiany");
			}
			
			
		}
    }
    @FXML
    void OnActionDostarczone(ActionEvent event) {
    	
    	RadioRealizacja.setSelected(false);
    
    }

    @FXML
    void OnActionRealizacja(ActionEvent event) {

    	RadioDostarczone.setSelected(false);
    	
    	
    }
    @FXML
    void onActionCheckStatusChange(ActionEvent event) {
    	textToChangeStatus.setText("");
		boolean correct = false;
		String toSet="";
		int inx=-1;
		System.out.println(textFieldStatus.getText());
		String value = textFieldStatus.getText();
		
		try {
			inx = Integer.parseInt(value);
			correct = true;
		}catch(Exception e){
			textToChangeStatus.setText("podana wartosc nie jest wlasciwa");
		}
		
		if(correct== true) {
			Server s = new Server();
			toSet=s.checkOrderStatus(inx);
			try {
			if(toSet.charAt(0) == 'S' && toSet.charAt(1) == 't' && toSet.charAt(2) == 'a' && toSet.charAt(3) == 'n')
			{
				
				textToChangeStatus.setText(toSet);
			}
			}catch(Exception e) {
				textToChangeStatus.setText("Zamowienie o podanym numerze nie istnieje");
			}
		}
    }

    @FXML
    void onActionbackChangeStatus(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/pracownik.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("APLIKACJA");

		klasaStage.scene = scene;
		klasaStage.show();
    	
    }
}
