
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BallotBox<T extends Citizen> extends AddressOfBallotBox implements Serializable {
	private int id;
	protected Set<T> citizensInBallotbox;
	protected List<Integer> numOfVotePerParty;
	private List<Party> partiesListInBallotbox;
	private int numberOfVotersPerBallotbox = 0;

	public BallotBox(String city, String street, int number, int idOfBallotBox) {
		super(city, street, number);
		this.citizensInBallotbox = new Set<>();
		id = idOfBallotBox++;

	}

	public List<Integer> getNumOfvotePerParty() {
		return numOfVotePerParty;
	}

	public List<Party> getPartiesListBallotbox() {
		return partiesListInBallotbox;
	}

	public void setNumOfVotePerParty() {
		this.numOfVotePerParty = new ArrayList<>();
		for (Party p : partiesListInBallotbox) {
			numOfVotePerParty.add(0);
		}
	}

	public void setPartiesListBallotbox(List<Party> partiesListBallotbox) {
		this.partiesListInBallotbox = partiesListBallotbox;
		setNumOfVotePerParty();
	}

	public void addCitizens(Citizen citizens) {

		citizensInBallotbox.add((T) citizens);
	}

	public Set<T> getVotersList() {
		return citizensInBallotbox;
	}

	public int getNumberOfVotersPerBallbox() {
		return numberOfVotersPerBallotbox;
	}

	public int getIdOfBallotBox() {
		return id;
	}

	public int getIndexCitizensListinBallotbox() {
		return citizensInBallotbox.size();
	}

//electionInBallotBox conducted election in the BallotBox and add the votes to the specific
//index of the party as it in the partiesList
	public void electionInBallotBox() {
		for (Citizen c : citizensInBallotbox) {
			Random r = new Random();// Random variable - represent the decision of the citizen if to vote
			boolean res = r.nextBoolean();
			if (res) {
				numberOfVotersPerBallotbox++;
				int rnd = (int) (Math.random() * (this.partiesListInBallotbox.size()));
				int numOfVotePerPartyTmp = numOfVotePerParty.get(rnd);
				numOfVotePerPartyTmp++;
				numOfVotePerParty.set(rnd, numOfVotePerPartyTmp);
			}
		}

	}

	public String getBallotBoxType() {

		if (citizensInBallotbox == null) {
			return null;
		} else
			return citizensInBallotbox.get(0).getClass().getName();
	}

	public String toStringForElection() {

		StringBuffer str = new StringBuffer(
				"The BallotBox " + id + " had "
						+ ((float) numberOfVotersPerBallotbox
								/ (citizensInBallotbox.size() != 0 ? citizensInBallotbox.size() : 1)) * 100
						+ "% of voting:\n");// calculate the turnout
		for (int index11 = 0; index11 < partiesListInBallotbox.size(); index11++) {
			str.append(partiesListInBallotbox.get(index11).getName() + " Number of votes is: "
					+ numOfVotePerParty.get(index11) + "\n");

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