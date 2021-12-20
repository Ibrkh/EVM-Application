package application;

import java.sql.SQLException;
import java.util.ArrayList;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VoteCastingInterfaceController 
{
    @FXML
    private GridPane Box;

    @FXML
    private TextField CNIC;

	@FXML
    private TextField CandidateName;

	@FXML
    private TextField PoliticalParty;

	@FXML
    private TextField ElectionConstituency;

    @FXML
    private Button BackButton;

    @FXML
    private Button VoteButton;
            
	public void initialize() throws ClassNotFoundException, SQLException 
	{
		MySQLConnection MySQL = new MySQLConnection();
		 
		 // This is a temporary ArrayList which stores all candidates
		 ArrayList<ElectionCandidate> Candidates = new ArrayList<ElectionCandidate>();
		 
		 Candidates = MySQL.retrieveCandidates();
		
		 for(int i=0; i<Candidates.size(); i++)
		 {
			 Text candidateText = new Text();
			 candidateText.setText(Candidates.get(i).getCitizen_ID() + " " + Candidates.get(i).getFirstName() + " " + Candidates.get(i).getLastName()  + " " + Candidates.get(i).getElectionConstituency() + " " + Candidates.get(i).getPoliticalParty());
			 
			 Box.add(candidateText, 0, i);
		 }
	 }
	 
	@FXML
 	public void VoteButtonFunction(ActionEvent event) throws Exception
		{
			String candidateCNIC = CNIC.getText();
			String candidateParty = PoliticalParty.getText();
			String candidateConstituency = ElectionConstituency.getText();
			
			MySQLConnection MySQL = new MySQLConnection();

			MySQL.updateCandidateVoteFrequency(candidateCNIC);
			MySQL.updatePartyVoteFrequency(candidateParty);
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("UserSelectionInterface.fxml"));
			Scene scene = new Scene(root, 600, 500);
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
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
