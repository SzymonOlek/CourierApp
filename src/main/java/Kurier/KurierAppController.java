package Kurier;

import java.io.IOException;

import data.DataContainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

	public KurierAppController() {

	}

	@FXML
	void initialize() {
	}

	@FXML
	void OnActionCennik(ActionEvent event) {
		klient.setDisable(true);
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
	void OnActionKontakt(ActionEvent event) {


	}

	@FXML
	void OnActionPracownik(ActionEvent event) throws IOException {

		System.out.println("PRACOWNIK");
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/pracownik.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		klasaStage.nextStage.setTitle("PRACOWNIK");

		klasaStage.scene = scene;
		klasaStage.show();
	}

	@FXML
	void ServiceAction(ActionEvent event) {

		System.out.println("Najlepsza droga : " + new DataContainer().getBestRoute());


	}

	@FXML
	void onMouseEnteredService(MouseEvent event) {


	}

}
