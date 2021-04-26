package id314967472_id207726563;

import java.time.Year;
import java.util.Arrays;
import java.util.Random;

import id314967472_id207726563.Party.espectrum;

public class Election extends DateForElection {
	private Citizen[] citizensList;
	private int indexCitizens = 0;
	private int maxCitizens = 5;// first value - by Arrays.copyof its endless
	private int numberOfVoters = 0;

	private Party[] partiesList;
	private int indexParties = 0;
	private int maxParties = 5;// first value - by Arrays.copyof its endless
	private int[] numOfVotePerParty;

	private BallotBox[][] BallotBoxList;// Matrix for sprating regular,covid19 and army ballotboxes
	private int maxBoxList = 5;// first value - by Arrays.copyof its endless
	private int[] typeOfBallotBoxIndex;// 'Regular'/'Covid19/'Army'

	public Election(int year, int month) {
		super(year, month);
		this.citizensList = new Citizen[maxCitizens];
		this.partiesList = new Party[maxParties];
		this.BallotBoxList = new BallotBox[3][maxBoxList];
		this.typeOfBallotBoxIndex = new int[3];

	}

	// electionMethod is doing the election process-
	// for loops that conducted election in each BallotBox and sum the number of
	// voters
	public void electionMethod() {
		setTheBallotBox(citizensList, BallotBoxList);
		for (int i = 0; i < this.BallotBoxList.length; i++) {
			for (int j = 0; j < this.BallotBoxList[i].length; j++) {
				if (BallotBoxList[i][j] != null) {
					BallotBoxList[i][j].setPartiesListBallotbox(partiesList);
					BallotBoxList[i][j].electionInBallotBox(BallotBoxList[i][j].getPartiesListBallotbox());
					numberOfVoters += BallotBoxList[i][j].getNumberOfVotersPerBallbox();
				}
			}
		}

	}

	// resetData - reset the data of the previous election if needed
	public void resetData() {
		numberOfVoters = 0;
		for (int i = 0; i < this.BallotBoxList.length; i++) {
			for (int j = 0; j < this.BallotBoxList[i].length; j++) {
				if (BallotBoxList[i][j] != null) {
					BallotBoxList[i][j].setVotersList();
					BallotBoxList[i][j].setNumberOfVotersPerBallbox();
					BallotBoxList[i][j].setCitizensNumberInArray();

				}

			}

		}

	}

	public int[] getNumOfVotePerParty() {
		return numOfVotePerParty;
	}

// An integer array the hold the number of vote per party by the same index in partiesList
	public void setNumOfVotePerParty(int[] numOfvotePerParty, int index) {
		this.numOfVotePerParty = new int[index];
	}

	public boolean addParty(String name, String date, espectrum setSpectrum) {
		if (partiesList[partiesList.length - 1] != null) {
			this.partiesList = Arrays.copyOf(partiesList, partiesList.length * 2);
		}
		Party p = new Party(name, date, setSpectrum);
		for (int index = 0; index < partiesList.length; index++) {
			if (partiesList[index] != null && partiesList[index].equals(p)) {
				System.out.println(partiesList[index].toString() + "Already exist.");
				p = null;
				return false;
			}
		}

		partiesList[indexParties++] = p;
		setNumOfVotePerParty(numOfVotePerParty, partiesList.length);

		return true;

	}

	public boolean addBallotBox(String city, String street, int number, int index) {
		if (BallotBoxList[index - 1][BallotBoxList.length - 1] != null) {
			this.BallotBoxList[index - 1] = Arrays.copyOf(BallotBoxList[index - 1],
					BallotBoxList[index - 1].length * 2);
		}

		switch (index) {// switch case necessary for choose the right BallotBox
		case 1: {
			BallotBox b = new BallotBox(city, street, number);
			if (addBallotBoxhelp(b)) {
				this.BallotBoxList[index - 1][typeOfBallotBoxIndex[index - 1]++] = b;
				return true;
			}
		}
		case 2: {
			Covid19BallotBox b = new Covid19BallotBox(city, street, number);
			if (addBallotBoxhelp(b)) {
				this.BallotBoxList[index - 1][typeOfBallotBoxIndex[index - 1]++] = b;
				return true;
			}

		}
		case 3: {
			ArmyBallotBox b = new ArmyBallotBox(city, street, number);
			if (addBallotBoxhelp(b)) {
				this.BallotBoxList[index - 1][typeOfBallotBoxIndex[index - 1]++] = b;
				return true;
			}
		}

		}
		return false;

	}

//addBallotBoxhelp - helps the addBallotBox function to check if the BallotBox already exist 
	public boolean addBallotBoxhelp(BallotBox b) {
		for (int i = 0; i < this.BallotBoxList.length; i++) {
			for (int j = 0; j < this.BallotBoxList[i].length; j++) {
				if (BallotBoxList[i][j] != null && BallotBoxList[i][j].equals(b)) {
					System.out.println(BallotBoxList[i].toString() + " -Is already exist.");
					b = null;
					return false;
				}
			}
		}
		return true;

	}

	public boolean addCandidate(String namePerson, int yearOfBrith, String id, boolean insulation,
			String partyOfCandidate) {
		if (addCitizen(namePerson, yearOfBrith, id, insulation))
			return upgradeCitizenToCandidate(id, partyOfCandidate);
		return false;
	}

	public boolean addCitizen(String namePerson, int yearOfBrith, String id, boolean insulation) {
		if (citizensList[citizensList.length - 1] != null) {
			this.citizensList = Arrays.copyOf(citizensList, citizensList.length * 2);
		}
		if (id.length() == 9) {// check if id is 9 digits
			Citizen c = new Citizen(namePerson, yearOfBrith, id, insulation);
			for (int index = 0; index < citizensList.length; index++) {
				if (citizensList[index] != null && citizensList[index].equals(c)) {// checks if citizen already exist
					System.out.println(citizensList[index].toString() + " - Is already exist.");
					c = null;
					return false;
				}
			}

			citizensList[indexCitizens++] = c;
			return true;
		} else {
			System.out.println("ID must be 9 Digits.");
			return false;
		}

	}

	public boolean upgradeCitizenToCandidate(String id, String party) {
		if (citizensList[citizensList.length - 1] != null) {
			this.citizensList = Arrays.copyOf(citizensList, citizensList.length * 2);
		}
		Party p = partiesList[0];
		Citizen c = citizensList[0];
		for (int index = 0; index < partiesList.length; index++) {
			if (partiesList[index] != null && partiesList[index].getName().equals(party)) {// checks if party exist
				p = partiesList[index];
				for (int index1 = 0; index1 < citizensList.length; index1++) {
					if (citizensList[index1] != null && citizensList[index1].getId().equals(id)) {// checks if citizen
																									// exist
						c = citizensList[index1];
						Candidate c1 = new Candidate(c.getNamePerson(), c.getYearOfBrith(), c.getId(),
								c.getInsulation(), p);
						p.addCandidate(c1);

						for (int index2 = 0; index2 < citizensList.length; index2++) {
							if (citizensList[index2] != null && citizensList[index2].getId().equals(c.getId())) {
								citizensList[index2] = citizensList[citizensList.length - 1];
								citizensList[index2] = c1;
								return true;
							}

						}
					} else if (index1 == citizensList.length - 1) {
						System.out.println("Citizen Do not exists");
						return false;

					}
				}

			}

			else if (index == partiesList.length - 1) {
				System.out.println("Party Do not exists");
				return false;

			}
		}
		return false;
	}

//setTheBallotBox function is placing the citizens to the ballotBoxes
	public void setTheBallotBox(Citizen[] votersList, BallotBox[][] BallotBoxList) {
		for (int index = 0; index < votersList.length; index++) {
			if (votersList[index] == null)
				continue;
			int correntYear = Year.now().getValue();
			if (18 > correntYear - votersList[index].getYearOfBrith()) {// checks if the citizen is over 18
				System.out.println(votersList[index].toString() + " - Citizen Must be over 18 for voting!\n");
			} else if (votersList[index].getInsulation()) {
				Covid19BallotBox a = (Covid19BallotBox) getHelpBallotBox(BallotBoxList, 1);
				a.addCitizens(votersList[index]);
				votersList[index].setTheBallotBox(a);
			}

			else if (18 <= correntYear - votersList[index].getYearOfBrith()
					&& correntYear - votersList[index].getYearOfBrith() <= 21) {// checks if citizen is a soldier
																				// (18-21)
				ArmyBallotBox a = (ArmyBallotBox) getHelpBallotBox(BallotBoxList, 2);
				a.addCitizens(votersList[index]);
				votersList[index].setTheBallotBox(a);

			}

			else {

				votersList[index].setTheBallotBox(getHelpBallotBox(BallotBoxList, 0));
				votersList[index].getTheBallotBox().addCitizens(votersList[index]);
			}
		}
	}

//getHelpBallotBox is choose randomly BallotBox for setTheBallotBox function
	public BallotBox getHelpBallotBox(BallotBox[][] ballotBox, int index) {
		int rnd = new Random().nextInt(ballotBox.length);
		while (ballotBox[index][rnd] == null) {
			rnd = new Random().nextInt(ballotBox.length);
		}
		return ballotBox[index][rnd];

	}

	public String getVotersListString() {
		StringBuffer str = new StringBuffer("The Voters List is: \n");
		for (int j = 0; j < this.citizensList.length; j++) {
			if (citizensList[j] != null)
				str.append(citizensList[j].toString() + "\n");
		}

		return str.toString();

	}

	public void setCitizen(Citizen a) {
		this.citizensList[indexCitizens++] = a;
	}

	public String getPartiesListString() {
		StringBuffer str = new StringBuffer("Parties List: \n");

		for (int i = 0; i < partiesList.length; i++) {
			if (partiesList[i] != null)
				str.append(partiesList[i].toString() + "\n");
		}
		return str.toString();
	}

	public void setParty(Party p) {
		this.partiesList[indexParties++] = p;
	}

	public String electionToString() {// Represant the election result
		StringBuffer str = new StringBuffer("The Election had "
				+ ((float) numberOfVoters / (indexCitizens != 0 ? indexCitizens : 1)) * 100 + "% of voting:\n" + "\n");
		for (int i = 0; i < this.BallotBoxList.length; i++) {
			for (int j = 0; j < this.BallotBoxList[i].length; j++) {
				if (BallotBoxList[i][j] != null)
					str.append(BallotBoxList[i][j].toStringForElection() + "\n");
			}

		}

		return str.toString();
	}

	public String getBallotBoxListString() {
		StringBuffer str = new StringBuffer("The BallotBox List is: \n");
		for (int i = 0; i < this.BallotBoxList.length; i++) {
			for (int j = 0; j < this.BallotBoxList[i].length; j++) {
				if (BallotBoxList[i][j] != null)
					str.append(BallotBoxList[i][j].toString() + "\n");
			}
		}
		return str.toString();
	}
}
