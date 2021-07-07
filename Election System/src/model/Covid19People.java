package model;

import java.io.Serializable;

public class Covid19People extends Citizen implements Serializable {
	private int daysOfSickness;
	public Covid19People(String namePerson, int yearOfBrith, String id,int daysOfSickness) {
		super(namePerson, yearOfBrith, id,true );
		setDaysOfSickness(daysOfSickness);
	}

	public int getDaysOfSickness() {
		return daysOfSickness;
	}

	public void setDaysOfSickness(int daysOfSickness) {
		this.daysOfSickness = daysOfSickness;
	}

	@Override
	public String toString() {
		return "Covid19People " + super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Covid19People))
			return false;
		if (!super.equals(obj))
			return false;
		
		Covid19People other = (Covid19People) obj;
		if (daysOfSickness != other.daysOfSickness)
			return false;
		return true;
	}

}
