package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UserInterfaceController 
{
	@FXML
	private Button AdminButton;
	
	@FXML
	private Button VoteButton;	

	@FXML
	private Button BackButton;
	
	@FXML
	public void AdminButtonFunction(ActionEvent event) throws Exception
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AdminLoginInterface.fxml"));
		Scene scene = new Scene(root, 600, 500);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	public void VoteCastingButtonFunction(ActionEvent event) throws Exception
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("VoterInterface.fxml"));
		Scene scene = new Scene(root, 600, 500);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@FXML
	public void BackButtonFunction(ActionEvent event) throws Exception
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("InstructionsManual.fxml"));
		Scene scene = new Scene(root, 600, 500);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
