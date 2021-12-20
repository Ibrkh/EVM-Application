package application;
public class Citizen 
{
	//Citizen Attributes
	protected String Citizen_ID;
	protected String FirstName;
	protected String LastName;
	
	// Parameterized Constructor
	public Citizen(String ID, String firstName, String lastName)
	{
		Citizen_ID = ID;
		FirstName = firstName;
		LastName = lastName;
	}

	public String getCitizen_ID() {
		return Citizen_ID;
	}

	public void setCitizen_ID(String citizen_ID) {
		Citizen_ID = citizen_ID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
}
