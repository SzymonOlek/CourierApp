package Kurier;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import data.DataContainer;
import data.Database;



public class Main extends Application {

	public static void main(String[] args) {
		
		
//		Database bazaDanych = new Database();
//		
////		ResultSet  wynik = bazaDanych.sqlStatement("SELECT * FROM `order`");
//		ResultSet wynik = bazaDanych.getOrder(1);
//		
	

//		bazaDanych.showData(wynik);
//		bazaDanych.showData(bazaDanych.getOrder(1));
		
		
//		bazaDanych.execSQLStatement("INSERT INTO `city` (`id_city`, `name`) VALUES ('1', 'miasto1');"); //chec if correct
		
		
//		DataContainer tempData = new DataContainer("miasta.txt", "graph.txt");
//		
//		tempData.printData();	
//		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/KurierApp.fxml"));
		
		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);
		
		primaryStage.setTitle("APLIKACJA");
		
		klasaStage.setEverything(scene, primaryStage);
		
		klasaStage.show();

	}

}
