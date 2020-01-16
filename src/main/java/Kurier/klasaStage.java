package Kurier;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class klasaStage {
	
	static Stage nextStage;
	
	static FXMLLoader loader;

	static StackPane stackPane;

	static Scene scene;

	static void setEverything(Scene scene,Stage nextStage) {
		klasaStage.nextStage = nextStage;
		klasaStage.scene=scene;
		
	}
	
	static void show() {
		
		nextStage.setScene(scene);


		nextStage.show();
		
	}
	
	
	
	
	

}
