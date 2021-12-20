package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class InstructionsManual extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("InstructionsManual.fxml"));
		Scene scene = new Scene(root, 600, 500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	public void showInstructionsManual(String[] args) {
		launch(args);
	}
}
