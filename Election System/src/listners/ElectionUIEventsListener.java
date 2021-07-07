package listners;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import model.Election;
import model.Party.espectrum;

public interface ElectionUIEventsListener {

	void setElectionDateToUI(LocalDate d);

	void addCitizenToUI(String namePerson, int yearOfBrith, String id, boolean insulation);

	void addCovid19PeopleToUI(String namePerson, int yearOfBrith, String id, int daysOfSickness, boolean insulation);

	void addSoldierToUI(String namePerson, int yearOfBrith, String id, boolean insulation);

	void addBallotBoxToUI(String city, String street, int number, int type);

	void addPartyToUI(String name, LocalDate date, espectrum setSpectrum);

	void addCandidateToUI(String namePerson, int yearOfBrith, String id, boolean insulation, String partyOfCandidate);

	void getVotersListStringToUI();

	void getPartiesListStringToUI();

	void getBallotBoxListStringToUI();

	void electionMethodToUI() throws Exception;

	void electionToStringToUI();

	void saveFile() throws IOException;

	void loadFile() throws FileNotFoundException, ClassNotFoundException, IOException;

}
