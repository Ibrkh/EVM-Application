package application;
public class Date
{
	// Attributes
	private int Day;
	private int Month;
	private int Year;
	
	// Default Constructor
	Date()
	{
		Day = -1;
		Month = -1;
		Year = -1;
	}
	
	//Parameterized Constructor
	Date(int day,int month, int year)
	{
		this.Day = day;
		this.Month = month;
		this.Year = year;
	}
		
	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getDate()
	{
		String date = null;
		
		date = Day + "/" + Month + "/" + Year;
	
		return date;
	}

	void DisplayDate()
	{
		System.out.println("Date: " + Day + "/" + Month + "/" + Year);
	}
}
