package model;

import java.io.Serializable;

public class Candidate extends Citizen implements Comparable<Candidate> , Serializable{
	private Party partyOfCandidate;
	private int numOfVoiters = 0;

	public Candidate(String namePerson, int yearOfBrith, String id, boolean insulation, Party partyOfCandidate) {
		super(namePerson, yearOfBrith, id, insulation);
		setPartyCitizens(partyOfCandidate);
	}

	public int getNumOfVoiters() {
		return numOfVoiters;
	}

	public void addNumOfVoiters() {
		this.numOfVoiters++;
	}

	public Party getPartyCitizens() {
		return partyOfCandidate;
	}

	public void setPartyCitizens(Party partyCitizens) {
		this.partyOfCandidate = partyCitizens;
	}

	public String toString() {
		return "Candidate " + super.toString();
	}

	@Override
	public int compareTo(Candidate candidate) {
		if(numOfVoiters < candidate.getNumOfVoiters())
			return 1;
		if(numOfVoiters > candidate.getNumOfVoiters())
			return -1;
		else
			return 0;
					
	}
	
	

}
