package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class InstructionsManualController 
{
	@FXML
	private Button ConitnueButton;

	@FXML
	private Button CancelButton;

	@FXML
	public void continueButtonFunction(ActionEvent event) throws Exception
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("UserSelectionInterface.fxml"));
		Scene scene = new Scene(root, 600, 500);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	@FXML
	private void cancelButtonFunction(ActionEvent event) throws Exception
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("EndingInterface.fxml"));
		Scene scene = new Scene(root, 300, 100);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
