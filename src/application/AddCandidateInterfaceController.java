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

public class AddCandidateInterfaceController 
{
	@FXML
	private TextField CNIC;

	@FXML
	private TextField First_Name;

	@FXML
	private TextField Last_Name;

	@FXML
	private TextField Political_Party;

	@FXML
	private TextField Political_Position;

	@FXML
	private TextField Election_Constituency;

	@FXML
	private Button AddCandidateButton;

	@FXML
	private Button BackButton;
	
	@FXML
	public void AddCandidateButtonFunction(ActionEvent event) throws Exception
	{
		String cnic = CNIC.getText();
		String first_name = First_Name.getText();
		String last_name = Last_Name.getText();
		String political_party = Political_Party.getText();
		String political_position = Political_Position.getText();
		String election_constituency = Election_Constituency.getText();
				
		MySQLConnection MySQL = new MySQLConnection();
		
		//ElectionCandidate object = new ElectionCandidate(cnic, first_name, last_name, political_party, political_position, election_constituency);
		
		MySQL.insertElectionCandidate(cnic, first_name, last_name, political_party, political_position, election_constituency, 0);
		
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AddCandidateInterface.fxml"));
		Scene scene = new Scene(root, 600, 500);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	public void BackButtonFunction(ActionEvent event) throws Exception
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
		Scene scene = new Scene(root, 600, 500);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
