package p1;

import java.util.Arrays;
import java.util.Random;

public class BallotBox extends AddressOfBallotBox {
	public static int idOfBallotBox = 1000;
	private int id;
	protected Citizen[] citizensListinBallotbox;
	protected int correntMaxCitizens = 5;// first value - by Arrays.copyof its endless
	private int citizensCounter = 0;
	protected int[] numOfVotePerParty;
	private Party[] partiesListInBallotbox;
	private int numberOfVotersPerBallotbox = 0;

	public BallotBox(String city, String street, int number) {

		super(city, street, number);
		this.citizensListinBallotbox = new Citizen[correntMaxCitizens];
		id = idOfBallotBox++;

	}

	public int[] getNumOfvotePerParty() {
		return numOfVotePerParty;
	}

	// setNumOfvotePerParty1 is caring always-
	// partiesListInBallotbox.length==numOfvotePerParty.length
	public void setNumOfvotePerParty1(int[] numOfvotePerParty, int index) {
		this.numOfVotePerParty = new int[index];
	}

	public Party[] getPartiesListBallotbox() {
		return partiesListInBallotbox;
	}

	public void setNumberOfVotersPerBallbox() {// function just for resetData function in election class
		this.numberOfVotersPerBallotbox = 0;

	}

	public void setCitizensNumberInArray() {// function just for resetData function in election class
		this.citizensCounter = 0;

	}

	public void setPartiesListBallotbox(Party[] partiesListBallotbox) {
		this.partiesListInBallotbox = partiesListBallotbox;
		setNumOfvotePerParty1(numOfVotePerParty, partiesListBallotbox.length);
	}

	public void addCitizens(Citizen citizens) {
		if (citizensListinBallotbox[citizensListinBallotbox.length - 1] != null) {
			this.citizensListinBallotbox = Arrays.copyOf(citizensListinBallotbox, citizensListinBallotbox.length * 2);
		}
		this.citizensListinBallotbox[citizensCounter++] = citizens;
	}

	public Citizen[] getVotersList() {
		return citizensListinBallotbox;
	}

	public void setVotersList() {
		this.citizensListinBallotbox = new Citizen[correntMaxCitizens];
	}

	public int getNumberOfVotersPerBallbox() {
		return numberOfVotersPerBallotbox;
	}

	public static int getIdOfBallotBox() {
		return idOfBallotBox;
	}

	public int getIndexCitizensListinBallotbox() {
		return correntMaxCitizens;
	}

//electionInBallotBox conducted election in the BallotBox and add the votes to the specific
//index of the party as it in the partiesList
	public void electionInBallotBox(Party[] partiesList) {
		for (int index1 = 0; index1 < this.citizensListinBallotbox.length; index1++) {
			if (citizensListinBallotbox[index1] != null) {
				Random r = new Random();// Random variable - represent the decision of the citizen if to vote
				boolean res = r.nextBoolean();
				if (res) {
					numberOfVotersPerBallotbox++;
					for (int index2 = 0; index2 < partiesList.length; index2++) {
						Random rese11 = new Random();// Random variable - represent the vote of the citizen
						boolean rese1 = rese11.nextBoolean();
						if (rese1) {
							numOfVotePerParty[index2]++;
							break;

						}
					}

				}
			}
		}
	}

	public String toStringForElection() {

		StringBuffer str = new StringBuffer("The BallotBox " + id + " had "
				+ ((float) numberOfVotersPerBallotbox
						/ (correntMaxCitizens != 0 ? correntMaxCitizens : 1)) * 100
				+ "% of voting:\n");// calculate the turnout
		for (int index11 = 0; index11 < partiesListInBallotbox.length; index11++) {
			if (partiesListInBallotbox[index11] != null)
				str.append(partiesListInBallotbox[index11].getName() + " Number of votes is: "
						+ numOfVotePerParty[index11] + "\n");

		}

		return str.toString();

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		BallotBox other = (BallotBox) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BallotBox id:" + id + ", city:" + city + ", street:" + street + ", number:" + number;
	}

}
