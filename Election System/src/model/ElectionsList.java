package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import controller.ElectionController;
import listners.ElectionEventsListener;

public class ElectionsList implements Serializable {
	private List<Election> Elections;
	private static Vector<ElectionEventsListener> listeners;

	public ElectionsList() {
		Elections = new ArrayList<>();
		listeners = new Vector<ElectionEventsListener>();
		Elections.add(new Election());

	}

	public void addElection(Election Election1) {
		Elections.add(Election1);
	}

	public Election GetLastElectionRound() {
		return Elections.get(Elections.size() - 1);
	}

	@Override
	public String toString() {
		return "ElectionsList [Elections=" + Elections + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ElectionsList))
			return false;
		ElectionsList other = (ElectionsList) obj;

		if (!Elections.equals(other.Elections))
			return false;

		return true;
	}

	public static void firesetElectionDate(LocalDate d) {
		for (ElectionEventsListener l : listeners) {
			l.setElectionDate(d);
		}
	}

	public static void fireAddPartyEvent(Party p) {
		for (ElectionEventsListener l : listeners) {
			l.addPartyToModelEvent(p.getName(), p.getDate(), p.getSpectrum());
		}
	}

	public static void fireAddBallotBoxEvent(BallotBox b, int counterballbox) {
		for (ElectionEventsListener l : listeners) {
			l.addBallotBoxToModelEvent(b.getCity(), b.getStreet(), b.getNumber(), counterballbox);
		}
	}

	public static void fireAddCitizenEvent(Citizen c) {
		for (ElectionEventsListener l : listeners) {
			l.addCitizenToModelEvent(c.getNamePerson(), c.getYearOfBrith(), c.getId(), c.getInsulation());
		}
	}

	public static void fireAddCovid19Event(Covid19People covid19People) {
		for (ElectionEventsListener l : listeners) {
			l.addCovid19PeopleToModelEvent(covid19People.getNamePerson(), covid19People.getYearOfBrith(),
					covid19People.getId(), covid19People.getDaysOfSickness(), true);
		}
	}

	public static void fireAddSoldierEvent(Soldier Soldier) {
		for (ElectionEventsListener l : listeners) {
			l.addSoldierToModelEvent(Soldier.getNamePerson(), Soldier.getYearOfBrith(), Soldier.getId(),
					Soldier.getInsulation());
		}
	}

	public static void fireAddCandidateEvent(Candidate c1) {
		for (ElectionEventsListener l : listeners) {
			l.addCandidateToModelEvent(c1.getNamePerson(), c1.getYearOfBrith(), c1.getId(), c1.getInsulation(),
					c1.getPartyCitizens().getName());
		}
	}

	public static void firegetVotersListStringToModelEvent(String string) {
		for (ElectionEventsListener l : listeners) {
			l.getVotersListStringToModelEvent(string);
		}
	}

	public static void firegetPartiesListStringToModelEvent(String string) {
		for (ElectionEventsListener l : listeners) {
			l.getPartiesListStringToModelEvent(string);
		}
	}

	public static void fireelectionToStringToModelEvent(String string) {
		for (ElectionEventsListener l : listeners) {
			l.electionToStringToModelEvent(string);
		}
	}

	public static void firegetBallotBoxListStringToModelEvent(String string) {
		for (ElectionEventsListener l : listeners) {
			l.getBallotBoxListStringToModelEvent(string);
		}
	}

	public void registerListener(ElectionEventsListener listener) {
		listeners.add(listener);
	}

	public void saveFile() throws IOException {
		ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream("SavedFile.txt"));
		outFile.writeObject(GetLastElectionRound());

		outFile.close();
	}

	public void loadFile() throws ClassNotFoundException, IOException, FileNotFoundException {
		ObjectInputStream inFile = new ObjectInputStream(new FileInputStream("DataProgram.txt"));
		Election elections1 = (Election) inFile.readObject();
		Elections.add(elections1);

	}

}
