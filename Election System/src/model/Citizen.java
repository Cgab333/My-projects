package model;

import java.io.Serializable;
import java.time.Year;
import java.util.Arrays;
import java.util.Date;

public class Citizen implements Serializable{

	protected String namePerson;
	protected BallotBox theBallotBox;
	protected int yearOfBirth;
	protected String id;
	protected boolean insulation;

	public Citizen(String namePerson, int yearOfBrith, String id, boolean insulation) {
		setNamePerson(namePerson);
		setYearOfBrith(yearOfBrith);
		this.id = id;
		setInsulation(insulation);
	}

	public String getNamePerson() {
		return namePerson;
	}

	public boolean setNamePerson(String namePerson) {
		if (namePerson instanceof String) {
			this.namePerson = namePerson;
			return true;
		} else
			return false;

	}

	public String getId() {
		return id;
	}

	public boolean getInsulation() {
		return insulation;
	}

	public void setInsulation(boolean insulation) {
		this.insulation = insulation;
	}

	public BallotBox getTheBallotBox() {
		return theBallotBox;
	}

	public void setTheBallotBox(BallotBox theBallotBox) {
		this.theBallotBox = theBallotBox;
	}

	public int getYearOfBrith() {
		return yearOfBirth;
	}

	public void setYearOfBrith(int yearOfBrith) {
		this.yearOfBirth = yearOfBrith;
	}

	@Override
	public boolean equals(Object Citizen1) {
		if (Citizen1 instanceof Citizen) {
			Citizen other = (Citizen) Citizen1;
			if (!(id.equals(other.id))) {
				return false;
			}
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		return "Name: " + namePerson + ", Year Of Birth: " + yearOfBirth + ", ID: " + id + ", Insulation: "
				+ insulation;
	}
}
