package application;

public class ElectionCandidate extends Citizen
{
	//Election Candidate Attributes
	private String PoliticalParty;
	private String PoliticalPosition;
	private String ElectionConstituency;
	private int VoteFrequency;

	public ElectionCandidate() 
	{
		// Citizen Parameterized Constructor
		super(null, null, null);
		
		PoliticalParty = null;
		PoliticalPosition = null;
		ElectionConstituency = null;
		VoteFrequency = 0;
	}
	
	public ElectionCandidate(String CNIC, String firstName, String lastName, String PartyName, String politicalPosition, String electionConstituency) 
	{
		// Citizen Parameterized Constructor
		super(CNIC, firstName, lastName);
		
		PoliticalParty = PartyName;
		PoliticalPosition = politicalPosition;
		ElectionConstituency = electionConstituency;
		VoteFrequency = 0;
	}

	public ElectionCandidate(String CNIC, String firstName, String lastName, String PartyName, String politicalPosition, String electionConstituency, int Votes) 
	{
		// Citizen Parameterized Constructor
		super(CNIC, firstName, lastName);
		
		PoliticalParty = PartyName;
		PoliticalPosition = politicalPosition;
		ElectionConstituency = electionConstituency;
		VoteFrequency = Votes;
	}

	public String getPoliticalParty() {
		return PoliticalParty;
	}

	public void setPoliticalParty(String politicalParty) {
		PoliticalParty = politicalParty;
	}

	public String getElectionConstituency() {
		return ElectionConstituency;
	}

	public void setElectionConstituency(String electionConstituency) {
		ElectionConstituency = electionConstituency;
	}

	public String getPoliticalPosition() {
		return PoliticalPosition;
	}

	public void setPoliticalPosition(String politicalPosition) {
		PoliticalPosition = politicalPosition;
	}

	public void increaseVoteFrequency() {
		VoteFrequency++;
	}
	
	public int getVoteFrequency() {
		return VoteFrequency;
	}
	
	public void setVoteFrequency(int voteFrequency) {
		VoteFrequency = voteFrequency;
	}
	
	public void displayCandidateDetails()
	{
		System.out.println("Election Candidate Details\n");
		
		System.out.println("CNIC: " + Citizen_ID);
		System.out.println("Name: " + FirstName + " " + LastName);
		System.out.println("Political Position: " + PoliticalPosition);
		System.out.println("Constituency: " + ElectionConstituency);
		System.out.println("Vote Frequency: " + VoteFrequency);
	}
}
