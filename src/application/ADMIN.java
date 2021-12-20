package application;

import java.util.ArrayList;

public class ADMIN 
{
	// Attributes
	String FirstName;
	String LastName;
	String AdminID;
	String IDPassword;
	
	//ElectionPoliticalParty object ArrayList
	ArrayList<ElectionPoliticalParty> ElectionPoliticalParty = new ArrayList<ElectionPoliticalParty>();
		
	// Default Constructor
	public ADMIN()
	{
		FirstName = null;
		LastName = null;
		AdminID = null;
		IDPassword = null;
	}

	//Parameterized Constructor
	public ADMIN(String fname, String lname, String ID, String Password)
	{
		FirstName = fname;
		LastName = lname;
		AdminID = ID;
		IDPassword = Password;
	}

}
