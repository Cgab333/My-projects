package id314967472_id207726563;

public class DateForElection {
	protected int month;
	protected int year;
	
	public DateForElection(int month, int year) {
		setMonth(month);
		setYear(year);
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString () {
		return "Date is : " + month + " , " + year;
		
	}
	
	public boolean equals(Object other) {
		if (!(other instanceof DateForElection))
			return false;
	
		DateForElection d = (DateForElection)other;
		return d.month == month && d.year == year;
	}
	
	
	

}
