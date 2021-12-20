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

public class AdminLoginInterfaceController 
{
	@FXML
	private TextField Username;

	@FXML
	private TextField Password;
	
	@FXML
	private Button LoginButton;

	@FXML
	private Button BackButton;

	@FXML
	public void LoginButtonFunction(ActionEvent event) throws Exception
	{
		String username = Username.getText();
		String password = Password.getText();
		
		if(username.equals("k190312"))
		{
			if(password.equals("ahmdibrkhn"))
			{
				BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
				Scene scene = new Scene(root, 600, 500);
				Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
				primaryStage.setScene(scene);
				primaryStage.show();
			}
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
