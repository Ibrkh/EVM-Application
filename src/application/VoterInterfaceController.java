package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VoterInterfaceController 
{
	@FXML
	private TextField CNIC;

	@FXML
	private TextField FirstName;

	@FXML
	private TextField LastName;

	@FXML
	private Button SubmitButton;

	@FXML
	private Button BackButton;

	@FXML
	public void SubmitButtonFunction(ActionEvent event) throws Exception
	{		
		String cnic = CNIC.getText();
		String firstName = FirstName.getText();
		String lastName = LastName.getText();
		
		MySQLConnection MySQL = new MySQLConnection();
		
		if (MySQL.uniqueVoter(cnic) == true)
		{
			MySQL.insertElectionVoter(cnic, firstName, lastName);

			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("VoteCastingInterface.fxml"));
			Scene scene = new Scene(root, 600, 500);
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else
		{
			System.out.println("Election Voter cannot vote more than once..\nThis Voter has already Voted");
		}
	}

	@FXML
	public void BackButtonFunction(ActionEvent event) throws Exception
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("UserSelectionInterface.fxml"));
		Scene scene = new Scene(root, 600, 500);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
