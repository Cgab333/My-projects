package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Party implements Serializable {
	private String nameOfParty;
	private LocalDate dateOfFoundation;

	public enum espectrum {
		LEFT, CENTER, RIGHT
	};

	private espectrum spectrum;
	private Set<Candidate> candidatesList;

	public Party(String name, LocalDate dateOfFoundation, espectrum spectrum) {
		setName(name);
		this.dateOfFoundation = dateOfFoundation;
		setSpectrum(spectrum);
		this.candidatesList = new Set<Candidate>();

	}

	public espectrum getSpectrum() {
		return spectrum;
	}

	public boolean setSpectrum(espectrum spectrum) {
		if (spectrum instanceof espectrum) {
			this.spectrum = spectrum;
			return true;
		} else
			return false;

	}

	public void addCandidate(Candidate c) {

		this.candidatesList.add(c);
	}

	public String getName() {
		return nameOfParty;
	}

	public boolean setName(String nameOfParty) {
		if (nameOfParty instanceof String) {
			this.nameOfParty = nameOfParty;
			return true;
		} else
			return false;

	}

	public LocalDate getDate() {
		return dateOfFoundation;
	}

	public Set<Candidate> getCandidatesList() {
		return candidatesList;
	}

//primeriz function works like the real primeriz
//Documentation in the function relevant parts
	public Set<Candidate> primeriz(Set<Candidate> candidatesList2) {
		for (int index1 = 0; index1 < candidatesList2.size(); index1++) {
			Random re = new Random();// Random variable - represent the decision of the candidate if to vote
			boolean rese = re.nextBoolean();
			if (rese) {
				for (int index2 = 0; index2 < candidatesList2.size(); index2++) {

					Random r = new Random();// Random variable - represent the vote of the candidate
					boolean res = r.nextBoolean();
					if (res) {

						candidatesList2.get(index2).addNumOfVoiters();

						break;

					}
				}
			}
		}

		candidatesList2.sort(null);
		return candidatesList2;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("Party : " + nameOfParty + ", Date of foundation: " + dateOfFoundation
				+ ", Spectrum: " + spectrum + " \n");
		primeriz(candidatesList);
		for (int index = 0; index < candidatesList.size(); index++) {
			str.append(candidatesList.get(index).toString() + "\n");

		}

		return str.toString();

	}

	public boolean equals(Object other) {
		if (!(other instanceof Party))
			return false;

		Party p = (Party) other;
		return p.nameOfParty.equals(nameOfParty);
	}

}
