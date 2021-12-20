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

public class AddPartyInterfaceController 
{
	@FXML
	private TextField PartyName;

	@FXML
	private TextField ChairmanName;

	@FXML
	private Button AddPartyButton;

	@FXML
	private Button BackButton;
	
	@FXML
	public void AddPartyButtonFunction(ActionEvent event) throws Exception
	{
		String partyName = PartyName.getText();
		String chairmanName = ChairmanName.getText();
				
		MySQLConnection MySQL = new MySQLConnection();
				
		MySQL.insertPoliticalParty(partyName, chairmanName, 0);
		
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AddPartyInterface.fxml"));
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
