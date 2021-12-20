package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLConnection 
{
	//MySQL connection Attributes
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;
	
		//Database path
		String DatabasePath;
	
	public MySQLConnection() throws ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		//System.out.println("MySQL Server Connected !");	

		DatabasePath = "jdbc:mysql://localhost:3306/electronic_voting_system";		
	}
	
	public void openConnection() throws SQLException
	{
		connection = DriverManager.getConnection(DatabasePath, "root", "system2000");
		statement = connection.createStatement();
		
		//System.out.println("MySQL server connection opened\n");
	}

	public void insertPoliticalParty(String PartyName, String ChairmanName, int VoteFrequency) throws SQLException
	{
		openConnection();
		
		String MySQLQuery = "INSERT INTO Political_Party VALUES (? ,? ,?)";
		PreparedStatement statement = connection.prepareStatement(MySQLQuery);
		
		statement.setString(1, PartyName);
		statement.setString(2, ChairmanName);
		statement.setInt(3, VoteFrequency);
		
		int QueryUpdate = statement.executeUpdate();
		
		if (QueryUpdate > 0)
			System.out.print("Query succesfully inserted");
		else
			System.out.print("Query not succesfully inserted");
		
		closeConnection();
	}

	public void insertElectionCandidate(String CNIC, String firstName, String lastName, String PartyName, String PoliticalPosition, String Constituency, int VoteFrequency) throws SQLException
	{
		openConnection();
		
		String MySQLQuery = "INSERT INTO Election_Candidate VALUES (? ,? ,?, ?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(MySQLQuery);
		
		statement.setString(1, CNIC);
		statement.setString(2, firstName);
		statement.setString(3, lastName);
		statement.setString(4, PartyName);
		statement.setString(5, PoliticalPosition);
		statement.setString(6, Constituency);
		statement.setInt(7, VoteFrequency);
		
		int QueryUpdate=statement.executeUpdate();
		
		if (QueryUpdate > 0)
			System.out.print("Query succesfully inserted");
		else
			System.out.print("Query not succesfully inserted");

		
		closeConnection();
	}

	public void insertElectionVoter(String CNIC, String firstName, String lastName) throws SQLException
	{
		openConnection();
		
		String MySQLQuery = "INSERT INTO Election_Voter VALUES (? ,? ,?)";
		PreparedStatement statement = connection.prepareStatement(MySQLQuery);
		
		statement.setString(1, CNIC);
		statement.setString(2, firstName);
		statement.setString(3, lastName);
		
		int QueryUpdate=statement.executeUpdate();
		
		if (QueryUpdate > 0)
			System.out.print("Query succesfully inserted");
		else
			System.out.print("Query not succesfully inserted");

		
		closeConnection();
	}
	
	public int retrieveElectionTotalVoteCount() throws SQLException
	{
		int totalVotes = 0;
		
		openConnection();
		
		ResultSet result= statement.executeQuery("SELECT * FROM Political_Party");	
		
		while(result.next())
			totalVotes += result.getInt(3);
		
		closeConnection();
			
		return totalVotes;
	}

	public int retrieveMaxVoteCount() throws SQLException
	{
		int maxVote = 0;
		
		openConnection();
		
		ResultSet result= statement.executeQuery("SELECT * FROM Political_Party");	
		
		while(result.next())
		{
			if(maxVote < result.getInt(3))
				maxVote = result.getInt(3);
		}
		closeConnection();
			
		return maxVote;
	}

	
	
	public ElectionPoliticalParty retrieveElectionWinner(int maxVote) throws SQLException
	{		
		openConnection();
		
		ResultSet result= statement.executeQuery("SELECT * FROM Political_Party");	
		
		ElectionPoliticalParty Party = null;

		String partyName = null;
		String chairmanName = null;
		int voteCount = 0;
		
		while(result.next())
		{
			partyName = result.getString(1);
			chairmanName = result.getString(2);
			voteCount = result.getInt(3);
			
			if(maxVote == result.getInt(3))
				Party = new ElectionPoliticalParty(partyName, chairmanName, voteCount);

		}
				
		closeConnection();
			
		return Party;
	}
	
	public ArrayList<ElectionPoliticalParty> retrieveParties() throws SQLException
	{
		ArrayList<ElectionPoliticalParty> PoliticalParties = new ArrayList<ElectionPoliticalParty>();
		
		openConnection();
		
		ResultSet result= statement.executeQuery("SELECT * FROM Political_Party");	
		
		while(result.next())
		{
			
			ElectionPoliticalParty object = new ElectionPoliticalParty(result.getString(1), result.getString(2), result.getInt(3));
			PoliticalParties.add(object);
		}
		
		closeConnection();
		
		
		return PoliticalParties;
	}

	public ArrayList<ElectionCandidate> retrieveCandidates() throws SQLException
	{
		ArrayList<ElectionCandidate> Candidates = new ArrayList<ElectionCandidate>();
		
		openConnection();
		
		resultset= statement.executeQuery("SELECT * FROM Election_Candidate");	
		
		while(resultset.next())
		{
			ElectionCandidate object = new ElectionCandidate(resultset.getString(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getString(5), resultset.getString(6), resultset.getInt(7));
			Candidates.add(object);
		}
		
		closeConnection();
		
		
		return Candidates;
	}

	public ArrayList<ElectionVoter> retrieveVoters() throws SQLException
	{
		ArrayList<ElectionVoter> Voters = new ArrayList<ElectionVoter>();
		
		openConnection();
		
		resultset= statement.executeQuery("SELECT * FROM Election_Voter");	
		
		while(resultset.next())
		{
			
				ElectionVoter object = new ElectionVoter(resultset.getString(1), resultset.getString(2), resultset.getString(3));
				Voters.add(object);
		}
		
		closeConnection();
		
		
		return Voters;
	}

	public void updateCandidateVoteFrequency(String CNIC) throws SQLException
	{
		openConnection();
	
	    String Political_Name = null;

		ResultSet result= statement.executeQuery("SELECT * FROM Election_Candidate WHERE CNIC = " + CNIC);	
		
		int VoteFrequency = 0;
		
		while(result.next())
		{
			VoteFrequency = result.getInt(7); 
		    Political_Name = result.getString(4);
		}
				
		VoteFrequency++;
		
		String MySQLQuery = "UPDATE election_candidate SET Vote_Frequency = ? WHERE CNIC = ?";
	     PreparedStatement preparedStmt = connection.prepareStatement(MySQLQuery);		

	    preparedStmt.setInt(1, VoteFrequency);
	    preparedStmt.setString(2, CNIC);
	  	    
		int QueryUpdate=preparedStmt.executeUpdate();
		
		if (QueryUpdate > 0)
			System.out.print("Query succesfully inserted");
		else
			System.out.print("Query not succesfully inserted");

	}
	
	public void updatePartyVoteFrequency(String Political_Name) throws SQLException
	{
	 int VoteFrequency = 0;
		
	 	String MySQLQuery = "SELECT * FROM political_party";
	 
	    ResultSet resultset = statement.executeQuery(MySQLQuery);
	    
		while(resultset.next())
		{	
			if(resultset.getString(1).equals(Political_Name))
			VoteFrequency = resultset.getInt(3); 
		}
		
		VoteFrequency++;
		
	    MySQLQuery = "UPDATE political_party SET Vote_Frequency = ? WHERE Political_Name = ?";
	    
	    PreparedStatement preparedStmt = connection.prepareStatement(MySQLQuery);		

	    preparedStmt.setInt(1, VoteFrequency);
	    preparedStmt.setString(2, Political_Name);
	   
	    int QueryUpdate=preparedStmt.executeUpdate();
		
		if (QueryUpdate > 0)
			System.out.print("Query succesfully inserted");
		else
			System.out.print("Query not succesfully inserted");

		
	    closeConnection();		
	}

	public boolean uniqueVoter(String CNIC) throws SQLException
	{
		openConnection();

		boolean Flag = true;
		
		resultset= statement.executeQuery("SELECT * FROM Election_Voter WHERE CNIC = " + CNIC);	
		
		while(resultset.next())
		{
			if(CNIC.equals(resultset.getString(1)))
				Flag = false;
			else
				Flag = true;
		}

		closeConnection();
		
		return Flag;
	}
	
	public void deleteQuery(String Query) throws SQLException
	{
		openConnection();
		
		closeConnection();		
	}
	
	public void closeConnection() throws SQLException
	{
		connection.close();
		//System.out.println("MySQL server connection closed\n");
	}
}
