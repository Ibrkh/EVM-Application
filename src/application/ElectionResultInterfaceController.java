package application;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ElectionResultInterfaceController 
{
    @FXML
    private GridPane VoteFrequencyBox;

    @FXML
    private GridPane VotePercentageBox;

    @FXML
    private GridPane ElectionWinnerBox;

    @FXML
    private Button BackButton;
    
	public void initialize() throws ClassNotFoundException, SQLException 
	 {
		MySQLConnection MySQL = new MySQLConnection();
		 
		 // This is a temporary ArrayList which stores all parties
		 ArrayList<ElectionPoliticalParty> Party = new ArrayList<ElectionPoliticalParty>();
		 Party = MySQL.retrieveParties();
		 		 
		 for(int i=0; i<Party.size(); i++)
		 {
			 Text PartyText = new Text();
			 PartyText.setText(Party.get(i).getPoliticalPartyName() + " " + Party.get(i).getPolticalChairman() + " " + Party.get(i).getTotalVotes());
			 
			 VoteFrequencyBox.add(PartyText, 0, i);
		 }

		 for(int i=0; i<Party.size(); i++)
		 {
			 float ElectionTotalVoteCount = MySQL.retrieveElectionTotalVoteCount();
			 float voteCount = Party.get(i).getTotalVotes();
			 float votePercentage = (voteCount/ElectionTotalVoteCount) * 100;
			 
			 Text PartyText = new Text();
			 PartyText.setText(Party.get(i).getPoliticalPartyName() + " " + Party.get(i).getPolticalChairman() + " " + votePercentage + " %");
			 
			 VotePercentageBox.add(PartyText, 0, i);
		 }

		 ElectionPoliticalParty tempObject = null;
		 int maxVote = MySQL.retrieveMaxVoteCount();
		 tempObject = MySQL.retrieveElectionWinner(maxVote);
		 
			 Text PartyText = new Text();
						 
			 PartyText.setText(tempObject.getPoliticalPartyName() + " " + tempObject.getPolticalChairman() + " " +  tempObject.getTotalVotes());
			 
			 ElectionWinnerBox.add(PartyText, 0, 0);
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
