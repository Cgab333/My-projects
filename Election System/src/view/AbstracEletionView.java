package view;

import java.time.LocalDate;

import listners.ElectionUIEventsListener;
import model.Election;
import model.Party.espectrum;

public interface AbstracEletionView {

	void setviewElectionDateToUI(LocalDate d);

	void registerListener(ElectionUIEventsListener listener);

	void addCitizenToUI(String namePerson, int yearOfBrith, String id, boolean insulation);

	void addCovid19PeopleToUI(String namePerson, int yearOfBrith, String id, int daysOfSickness, boolean insulation);

	void addSoldierToUI(String namePerson, int yearOfBrith, String id, boolean insulation);

	void addBallotBoxToUI(String city, String street, int number, int type);

	void addPartyToUI(String name, LocalDate date, espectrum setSpectrum);

	void addCandidateToUI(String namePerson, int yearOfBrith, String id, boolean insulation, String partyOfCandidate);

	void getVotersListStringToUI(String s);

	void getPartiesListStringToUI(String s);

	void getBallotBoxListStringToUI(String s);

	void electionMethodToUI();

	void electionToStringToUI(String s);

	void CitizenNotadded(String msg);

	void msgPartyAlreadyexist(String msg);

	void msgPartyDoesntExist(String msg);

	void SoldierException(String msg);

}
