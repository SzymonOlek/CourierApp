package Kurier;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	void onActionCheckOrder(ActionEvent event) {

		System.out.println(textFieldChechOrder.getText());
		textFieldChechOrder.clear();

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

}
