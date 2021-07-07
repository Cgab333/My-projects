package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

import listners.ElectionEventsListener;
import listners.ElectionUIEventsListener;
import model.Election;
import model.ElectionsList;
import model.IdException;
import model.Party.espectrum;
import view.AbstracEletionView;

public class ElectionController implements ElectionEventsListener, ElectionUIEventsListener, Serializable {
	private ElectionsList electionModel;

	private AbstracEletionView electionView;

	public ElectionController(ElectionsList model, AbstracEletionView view) {
		electionModel = model;
		electionView = view;
		electionModel.registerListener(this);
		electionView.registerListener(this);
	}

	@Override
	public void addCitizenToUI(String namePerson, int yearOfBrith, String id, boolean insulation) {

		try {
			electionModel.GetLastElectionRound().addCitizen(namePerson, yearOfBrith, id, insulation);

		} catch (Exception e) {
			electionView.CitizenNotadded(e.getMessage());
		}

	}

	@Override
	public void addCovid19PeopleToUI(String namePerson, int yearOfBrith, String id, int daysOfSickness,
			boolean insulation) {
		try {
			electionModel.GetLastElectionRound().addCovid19People(namePerson, yearOfBrith, id, daysOfSickness,
					insulation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			electionView.CitizenNotadded(e.getMessage());
		}
	}

	@Override
	public void addSoldierToUI(String namePerson, int yearOfBrith, String id, boolean insulation) {
		try {
			electionModel.GetLastElectionRound().addSoldier(namePerson, yearOfBrith, id, insulation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			electionView.SoldierException(e.getMessage());
		}
	}

	@Override
	public void addBallotBoxToUI(String city, String street, int number, int type) {
		electionModel.GetLastElectionRound().addBallotBox(city, street, number, type);

	}

	@Override
	public void addPartyToUI(String name, LocalDate date, espectrum setSpectrum) {

		try {
			electionModel.GetLastElectionRound().addParty(name, date, setSpectrum);

		} catch (Exception e) {
			electionView.msgPartyAlreadyexist(e.getMessage());
		}
	}

	@Override
	public void addCandidateToUI(String namePerson, int yearOfBrith, String id, boolean insulation,
			String partyOfCandidate) {
		try {
			electionModel.GetLastElectionRound().addCandidate(namePerson, yearOfBrith, id, insulation,
					partyOfCandidate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			electionView.msgPartyDoesntExist(e.getMessage());
		}
	}

	@Override
	public void getVotersListStringToUI() {

		electionModel.GetLastElectionRound().getVotersListString();
	}

	@Override
	public void getPartiesListStringToUI() {
		electionModel.GetLastElectionRound().getPartiesListString();
	}

	@Override
	public void getBallotBoxListStringToUI() {
		electionModel.GetLastElectionRound().getBallotBoxListString();
	}

	@Override
	public void electionMethodToUI() throws Exception {
		electionModel.GetLastElectionRound().electionMethod();
	}

	@Override
	public void electionToStringToUI() {
		electionModel.GetLastElectionRound().electionToString();
	}

	@Override
	public void addCitizenToModelEvent(String namePerson, int yearOfBrith, String id, boolean insulation) {
		electionView.addCitizenToUI(namePerson, yearOfBrith, id, insulation);
	}

	@Override
	public void addCovid19PeopleToModelEvent(String namePerson, int yearOfBrith, String id, int daysOfSickness,
			boolean insulation) {
		electionView.addCovid19PeopleToUI(namePerson, yearOfBrith, id, daysOfSickness, true);
	}

	@Override
	public void addSoldierToModelEvent(String namePerson, int yearOfBrith, String id, boolean insulation) {
		electionView.addSoldierToUI(namePerson, yearOfBrith, id, insulation);
	}

	@Override
	public void addBallotBoxToModelEvent(String city, String street, int number, int type) {
		electionView.addBallotBoxToUI(city, street, number, type);
	}

	@Override
	public void addPartyToModelEvent(String name, LocalDate date, espectrum setSpectrum) {
		electionView.addPartyToUI(name, date, setSpectrum);

	}

	@Override
	public void addCandidateToModelEvent(String namePerson, int yearOfBrith, String id, boolean insulation,
			String partyOfCandidate) {
		electionView.addCandidateToUI(namePerson, yearOfBrith, id, insulation, partyOfCandidate);
	}

	@Override
	public void getVotersListStringToModelEvent(String s) {
		electionView.getVotersListStringToUI(s);
	}

	@Override
	public void getPartiesListStringToModelEvent(String s) {
		electionView.getPartiesListStringToUI(s);
	}

	@Override
	public void getBallotBoxListStringToModelEvent(String s) {
		electionView.getBallotBoxListStringToUI(s);
	}

	@Override
	public void electionMethodToModelEvent() {
		electionView.electionMethodToUI();
	}

	@Override
	public void electionToStringToModelEvent(String s) {
		electionView.electionToStringToUI(s);
	}

	@Override
	public void setElectionDateToUI(LocalDate d) {
		electionModel.GetLastElectionRound().setElectionDate(d);
	}

	@Override
	public void setElectionDate(LocalDate d) {
		electionView.setviewElectionDateToUI(d);

	}

	@Override
	public void saveFile() throws IOException {
		electionModel.saveFile();
	}

	@Override
	public void loadFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		electionModel.loadFile();

	}

}