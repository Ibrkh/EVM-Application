package application;
import java.sql.SQLException;

public class DrivingInterface
{	
	public static ADMIN Admin = new ADMIN("Ibrahim", "Khan", "k190312", "ahmdibrkhn");

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{		
		InstructionsManual object = new InstructionsManual();
		
		// This displays the start screen
		object.showInstructionsManual(args);
	}

}
