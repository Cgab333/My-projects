package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import controller.ElectionController;
import listners.ElectionEventsListener;
import model.Party.espectrum;

public class Election implements Serializable {
	private Set<Citizen> citizensList;
	private int numberOfVoters = 0;
	private LocalDate electionDate;
	public int counterballbox = 1000;
	private List<Party> partiesList;
	private List<List<BallotBox>> BallotBoxList;
	private int i = 0;

	public Election() {
		citizensList = new Set<Citizen>();
		partiesList = new ArrayList<Party>();
		this.BallotBoxList = new ArrayList<List<BallotBox>>();
		BallotBoxList.add(new ArrayList<BallotBox>());
		BallotBoxList.add(new ArrayList<BallotBox>());
		BallotBoxList.add(new ArrayList<BallotBox>());
		BallotBoxList.add(new ArrayList<BallotBox>());

//		citizensList.add(new Citizen("Saar Amikam", 2020, "314967672", false));
//		citizensList.add(new Soldier("Shay Gabison", 2001, "207726563", true));
//		citizensList.add(new Soldier("itay Gabison", 2001, "203726563", false));
//		citizensList.add(new Covid19People("aaa", 1996, "888726563", 13));
//		citizensList.add(new Covid19People("aaa bbb", 1996, "888736563", 14));
//		citizensList.add(new Citizen("Momo", 1980, "333123321", false));
//		citizensList.add(new Citizen("Gogo", 2019, "222432234", false));
//		citizensList.add(new Citizen("Bobo", 1990, "111123321", false));
//
//		partiesList.add(new Party("Likud", LocalDate.of(1995, 12, 12), Party.espectrum.RIGHT));
//		partiesList.add(new Party("Merez", LocalDate.of(1982, 02, 06), Party.espectrum.LEFT));
//		partiesList.add(new Party("Yesh Atid", LocalDate.of(1988, 01, 30), Party.espectrum.CENTER));
//
//		BallotBoxList.get(0).add(new BallotBox("Tel Aviv", "Ahalia", 10, 1));
//		BallotBoxList.get(1).add(new BallotBox("Tel Hai", "Ahalia", 1330, 2));
//		BallotBoxList.get(2).add(new BallotBox("Tel Amikam", "Ayerida", 1310, 3));
//		BallotBoxList.get(3).add(new BallotBox("Tel Mond", "Ayerida", 13310, 4));
//
//		citizensList.add(new Candidate("Joni Bony", 1999, "123543654", false, partiesList.get(0)));
//		citizensList.add(new Candidate(" Michal Atar", 2002, "123543654", false, partiesList.get(2)));
//		citizensList.add(new Candidate("Haim Laskov", 1956, "111222005", false, partiesList.get(0)));
//		citizensList.add(new Candidate("Lee Burshtain", 2002, "222333444", true, partiesList.get(2)));
//		citizensList.add(new Candidate("Rachmim Lo Yada", 1923, "000000015", false, partiesList.get(1)));

	}

	public void setElectionDate(LocalDate d) {
		electionDate = d;
		ElectionsList.firesetElectionDate(d);

	}

	public LocalDate getElectionDate() {
		return electionDate;
	}

	// electionMethod is doing the election process-
	// for loops that conducted election in each BallotBox and sum the number of
	// voters
	public void electionMethod() throws Exception {
		i++;
		if (i > 1) {
			throw new Exception();

		}
		for (int index = 0; index < citizensList.size(); index++) {

			setTheBallotBoxToCitizen(citizensList.get(index));

		}
		for (int i = 0; i < BallotBoxList.size(); i++) {
			for (int j = 0; j < BallotBoxList.get(i).size(); j++) {
				BallotBoxList.get(i).get(j).setPartiesListBallotbox(partiesList);
				BallotBoxList.get(i).get(j).electionInBallotBox();
				numberOfVoters += BallotBoxList.get(i).get(j).getNumberOfVotersPerBallbox();
			}
		}
	}

	public boolean addParty(String name, LocalDate date, espectrum setSpectrum) throws PartyExistException {

		Party p = new Party(name, date, setSpectrum);
		if (partiesList.indexOf(p) != -1) {
			p = null;
			throw new PartyExistException();

		}

		partiesList.add(p);
		ElectionsList.fireAddPartyEvent(p);

		return true;

	}

	public boolean addBallotBox(String city, String street, int number, int type) {
		counterballbox++;
		BallotBox b = new BallotBox(city, street, number, counterballbox);
		BallotBoxList.get(type - 1).add(b);
		ElectionsList.fireAddBallotBoxEvent(b, counterballbox);

		return true;

	}

	public boolean addCandidate(String namePerson, int yearOfBrith, String id, boolean insulation,
			String partyOfCandidate) throws Exception {
		if (addCitizen(namePerson, yearOfBrith, id, insulation))
			return upgradeCitizenToCandidate(id, partyOfCandidate);
		return false;
	}

	public boolean addCitizen(String namePerson, int yearOfBrith, String id, boolean insulation) throws Exception {

		if (id.length() != 9) {// check if id is 9 digits
			throw new IdException();
		}
		Citizen c = new Citizen(namePerson, yearOfBrith, id, insulation);

		citizensList.add(c);
		ElectionsList.fireAddCitizenEvent(c);
		return true;

	}

	public void addCovid19People(String namePerson, int yearOfBrith, String id, int daysOfSickness, boolean insulation)
			throws Exception {
		if (id.length() != 9) {// check if id is 9 digits
			throw new IdException();
		}
		if (!(insulation)) {
			throw new CovidException();
		}
		Covid19People covid19People = new Covid19People(namePerson, yearOfBrith, id, daysOfSickness);

		citizensList.add(covid19People);
		ElectionsList.fireAddCovid19Event(covid19People);
	}

	public void addSoldier(String namePerson, int yearOfBrith, String id, boolean insulation) throws Exception {
		if (id.length() != 9) {// check if id is 9 digits
			throw new IdException();
		}
		int correntYear = Year.now().getValue();
		if (!(18 <= correntYear - yearOfBrith && correntYear - yearOfBrith <= 21)) {
			throw new SoliderException();

		}
		Soldier Soldier = new Soldier(namePerson, yearOfBrith, id, insulation);

		citizensList.add(Soldier);
		ElectionsList.fireAddSoldierEvent(Soldier);

	}
	/*
	 * private void fireAddSoldierEvent(Soldier Soldier) { for
	 * (ElectionEventsListener l : listeners) { l.addSoldierToModelEvent(
	 * Soldier.getNamePerson() ,Soldier.getYearOfBrith()
	 * ,Soldier.getId(),Soldier.getInsulation()); } }
	 */

	public boolean upgradeCitizenToCandidate(String id, String party) throws PartyException {

		Party p = partiesList.get(0);
		Citizen c = citizensList.get(0);
		for (int index = 0; index < partiesList.size(); index++) {
			if (partiesList.get(index).getName().equals(party)) {// checks if party exist
				p = partiesList.get(index);
				for (int index1 = 0; index1 < citizensList.size(); index1++) {
					if (citizensList.get(index1).getId().equals(id)) {// checks if citizen exist
						c = citizensList.get(index1);
						citizensList.remove(index1);
						Candidate c1 = new Candidate(c.getNamePerson(), c.getYearOfBrith(), c.getId(),
								c.getInsulation(), p);
						citizensList.add(c1);
						p.addCandidate(c1);
						ElectionsList.fireAddCandidateEvent(c1);

						return true;

					} else if (index1 == citizensList.size() - 1) {
						System.out.println("Citizen Do not exists");
						return false;

					}
				}

			}

			if (index == partiesList.size() - 1) {
				throw new PartyException();

			}
		}
		return true;
	}

	/*
	 * private void fireAddCandidateEvent(Candidate c1) { for
	 * (ElectionEventsListener l : listeners) { l.addCandidateToModelEvent(
	 * c1.getNamePerson() ,c1.getYearOfBrith()
	 * ,c1.getId(),c1.getInsulation(),c1.getPartyCitizens().getName()); } }
	 */

	// setTheBallotBox function is placing the citizens to the ballotBoxes
	public void setTheBallotBoxToCitizen(Citizen c) {

		int correntYear = Year.now().getValue();
		if (18 > correntYear - c.getYearOfBrith()) {// checks if the citizen is over 18
			return;
		}
		if (c instanceof Soldier) {
			if (c.getInsulation()) {
				getHelpBallotBox(c, 4);
			} else
				getHelpBallotBox(c, 3);

		} else if (c.getInsulation()) {
			getHelpBallotBox(c, 2);

		} else {
			getHelpBallotBox(c, 1);
		}
	}

//getHelpBallotBox is choose randomly BallotBox for setTheBallotBox function
	public void getHelpBallotBox(Citizen c, int type) {
		type--;
		int rnd = (int) (Math.random() * (BallotBoxList.get(type).size()));

		while (BallotBoxList.get(type).get(rnd) == null) {
			rnd = (int) (Math.random() * (BallotBoxList.get(type).size()));
		}
		BallotBoxList.get(type).get(rnd).addCitizens(c);
	}

	public String getVotersListString() {
		StringBuffer str = new StringBuffer("The Voters List is: \n");
		for (int j = 0; j < this.citizensList.size(); j++) {
			str.append(citizensList.get(j).toString() + "\n");
		}
		ElectionsList.firegetVotersListStringToModelEvent(str.toString());
		return str.toString();

	}

	/*
	 * private void firegetVotersListStringToModelEvent(String string) { for
	 * (ElectionEventsListener l : listeners) {
	 * l.getVotersListStringToModelEvent(string); } }
	 * 
	 */

	public void setCitizen(Citizen a) {
		this.citizensList.add(a);
	}

	public String getPartiesListString() {
		StringBuffer str = new StringBuffer("Parties List: \n");

		for (int i = 0; i < partiesList.size(); i++) {
			str.append(partiesList.get(i).toString() + "\n");
		}
		ElectionsList.firegetPartiesListStringToModelEvent(str.toString());

		return str.toString();
	}

	/*
	 * private void firegetPartiesListStringToModelEvent(String string) { for
	 * (ElectionEventsListener l : listeners) {
	 * l.getPartiesListStringToModelEvent(string); } }
	 */

	public void setParty(Party p) {
		this.partiesList.add(p);
	}

	public String electionToString() {// Represant the election result
		StringBuffer str = new StringBuffer("The Election (" + this.getElectionDate() + ") had: "
				+ ((float) numberOfVoters / (citizensList.size() != 0 ? citizensList.size() : 1)) * 100
				+ "% of voting:\n" + "\n");
		for (int i = 0; i < this.BallotBoxList.size(); i++) {
			for (int j = 0; j < this.BallotBoxList.get(i).size(); j++) {

				str.append(BallotBoxList.get(i).get(j).toStringForElection() + "\n");
			}
		}

		ElectionsList.fireelectionToStringToModelEvent(str.toString());
		return str.toString();
	}

	public String getBallotBoxListString() {
		StringBuffer str = new StringBuffer("The BallotBox List is: \n");
		for (int i = 0; i < this.BallotBoxList.size(); i++) {
			str.append((i + 1) + ") ");
			for (int j = 0; j < this.BallotBoxList.get(i).size(); j++) {
				str.append(BallotBoxList.get(i).get(j).toString() + " , \t");
			}
			str.append("\n");
			str.append("\n");

		}

		ElectionsList.firegetBallotBoxListStringToModelEvent(str.toString());
		return str.toString();
	}

}
