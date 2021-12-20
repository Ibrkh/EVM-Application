package application;

public class ElectionVoter extends Citizen
{

	public ElectionVoter() 
	{
		super(null, null, null);
	}

	// Parameterized Constructor 
	public ElectionVoter(String ID, String firstName, String lastName) 
	{
		super(ID, firstName, lastName);
	}

	public void displayVoterDetails()
	{
		System.out.println("Election Voter Details\n");
		
		System.out.println("CNIC: " + Citizen_ID);
		System.out.println("Name: " + FirstName + " " + LastName);
	}
}
