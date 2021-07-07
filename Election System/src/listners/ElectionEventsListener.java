package listners;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import model.Citizen;
import model.Election;
import model.Party;
import model.Party.espectrum;
import model.PartyException;

public interface ElectionEventsListener {

	void setElectionDate(LocalDate d);

	void addCitizenToModelEvent(String namePerson, int yearOfBrith, String id, boolean insulation);

	void addCovid19PeopleToModelEvent(String namePerson, int yearOfBrith, String id, int daysOfSickness,
			boolean insulation);

	void addSoldierToModelEvent(String namePerson, int yearOfBrith, String id, boolean insulation);

	void addBallotBoxToModelEvent(String city, String street, int number, int type);

	void addPartyToModelEvent(String name, LocalDate date, espectrum setSpectrum);

	void addCandidateToModelEvent(String namePerson, int yearOfBrith, String id, boolean insulation,
			String partyOfCandidate);

	void getVotersListStringToModelEvent(String s);

	void getPartiesListStringToModelEvent(String s);

	void getBallotBoxListStringToModelEvent(String s);

	void electionMethodToModelEvent();

	void electionToStringToModelEvent(String s);

	void saveFile() throws IOException;

	void loadFile() throws FileNotFoundException, ClassNotFoundException, IOException;
}