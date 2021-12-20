package application;

public class ElectionPoliticalParty 
{
	// Political Party Attributes
	private String PoliticalPartyName;
	private String PolticalChairman;
	private int TotalVotes;
	
	//Parameterized Constructor
	public ElectionPoliticalParty(String Chairman, String PartyName)
	{
		PoliticalPartyName = PartyName;	
		PolticalChairman = Chairman;
		
		TotalVotes = 0;
	}

	public ElectionPoliticalParty(String Chairman, String PartyName, int Votes)
	{
		PoliticalPartyName = PartyName;	
		PolticalChairman = Chairman;
		
		TotalVotes = Votes;
	}

	public String getPoliticalPartyName() {
		return PoliticalPartyName;
	}

	public void setPoliticalPartyName(String politicalPartyName) {
		PoliticalPartyName = politicalPartyName;
	}

	public String getPolticalChairman() {
		return PolticalChairman;
	}

	public void setPolticalChairman(String polticalChairman) {
		PolticalChairman = polticalChairman;
	}

	public int getTotalVotes() {
		return TotalVotes;
	}
	
	public void increaseVoteCount() {
		TotalVotes++;
	}
	
	public void setTotalVotes(int Votes) {
		TotalVotes = Votes;
	}

	public void displayPoliticalDetails()
	{
		System.out.println("Election Political Party Details\n");
		
		System.out.println("Name: " + PoliticalPartyName);
		System.out.println("Chairman: " + PolticalChairman);
		System.out.println("Total Vote Count: " + TotalVotes);
	}
}
