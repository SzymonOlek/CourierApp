package Kurier;

import java.io.IOException;


import data.Database;
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
	private Button newOrderAccept;

	@FXML
	private Button newOrderCancel;

    @FXML
    private TextField firstName;

    @FXML
    private TextField secondName;

    @FXML
    private TextField weight;

//    @FXML
//    private TextField adressTo;
//
//    @FXML
//    private TextField postCodeTo1;
//
//    @FXML
//    private TextField postCodeTo2;
//
//    @FXML
//    private TextField adressFrom;
//
//    @FXML
//    private TextField postCodeFrom1;
//
//        @FXML
//    private MenuButton adressTo;
//
//    @FXML
//    private MenuButton adressFrom;
//    @FXML
//    private TextField postCodeFrom2;

    @FXML
    private TextField tel;

    @FXML
    private TextField high;

    @FXML
    private TextField width;

    @FXML
    private TextField length;

	
	
	
	@FXML
	void onActionAccept(ActionEvent event) throws IOException {

		System.out.println("akceptacja zamowienia");

		if(checkIfCorrect()) {
		
		Order order = new Order(firstName.getText(),secondName.getText(),Integer.valueOf(weight.getText()),Integer.valueOf(high.getText()),Integer.valueOf(width.getText()),Integer.valueOf(length.getText()),adressTo.getText(),adressFrom.getText(),tel.getText());
		
		Database baza = new Database();
		
		baza.addOrder(order);

		stringdataToShow = "Numer zamówienia to : " + baza.getMaxID(); //////////// TODO naprawiæ 
		
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
//			firstName.clear();
//			secondName.clear();
//			weight.clear();
//			high.clear();
//			width.clear();
//			length.clear();
//			adressTo.setText("Wybierz adres wysylki");
//			adressFrom.setText("Wybierz adres dostawy");
//			tel.clear();
		}
		
	}
	
	private Boolean checkIfCorrect() {
		
		
		if(firstName.getText().trim().isEmpty() || secondName.getText().trim().isEmpty() || weight.getText().trim().isEmpty() || high.getText().trim().isEmpty() || width.getText().trim().isEmpty() || length.getText().trim().isEmpty() || adressTo.getText().trim()=="Wybierz adres dostawy" || adressFrom.getText().trim()=="Wybierz adres wysylki" || tel.getText().trim().isEmpty())
		{return false;}	
		else {
		return true;
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
	    private MenuButton adressTo;

	    @FXML
	    private MenuItem Miasto0;

	    @FXML
	    private MenuButton adressFrom;

	    

	    @FXML
	    void onActionMiasto0(ActionEvent event) {

	    	adressTo.setText("Miasto0");
	    	System.out.println("Miasto0");

			adressFrom.setText("MAsti123");
	    }

	    Boolean added =false;
	    
			
	        @FXML
	        void onActionFirstMenu(MouseEvent event) {
		    
	    	
	        }
	        @FXML
	        void mouseBackground(MouseEvent event) {
	        	if(added==false) {
	        		
//	        		List<String> lista = new ArrayList<String>();
	        		
	        		for(int i=0;i<10;i++) {
	        			
	        			MenuItem temp1 = new MenuItem ("Miasto" + i);
	        			MenuItem temp2 = new MenuItem ("Miasto" + i);
	        			
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
	        	added=true;
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

	        	dataToShow.setText(stringdataToShow);
	        	
	        }

}
