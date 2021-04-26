package id314967472_id207726563;

public class Candidate extends Citizen {
	private Party partyOfCandidate;

	public Candidate(String namePerson, int yearOfBrith, String id, boolean insulation,Party partyOfCandidate) {
		super(namePerson, yearOfBrith, id, insulation);
		setPartyCitizens(partyOfCandidate);
	}


	public Party getPartyCitizens() {
		return partyOfCandidate;
	}

	public void setPartyCitizens(Party partyCitizens) {
		this.partyOfCandidate = partyCitizens;
	}

	
	public String toString() {
		return "Candidate " + super.toString() ;
	}

}
