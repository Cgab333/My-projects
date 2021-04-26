package p1;

import java.util.Arrays;
import java.util.Random;

public class Party {
	private String nameOfParty;
	private String dateOfFoundation;

	public enum espectrum {
		LEFT, CENTER, RIGHT
	};

	private espectrum spectrum;
	private Candidate[] candidatesList;
	private int correntMaxCandidates = 5;// first value - by Arrays.copyof its endless
	private int candidateCounter = 0;

	public Party(String name, String dateOfFoundation, espectrum spectrum) {
		setName(name);
		setDate(dateOfFoundation);
		setSpectrum(spectrum);
		this.candidatesList = new Candidate[correntMaxCandidates];

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
		if (candidatesList[candidatesList.length - 1] != null) {
			this.candidatesList = Arrays.copyOf(candidatesList, candidatesList.length * 2);
		}
		this.candidatesList[candidateCounter++] = c;
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

	public String getDate() {
		return dateOfFoundation;
	}

	public boolean setDate(String dateOfFoundation) {
		if (dateOfFoundation instanceof String) {
			this.dateOfFoundation = dateOfFoundation;
			return true;
		} else
			return false;

	}

	public Citizen[] getCandidatesList() {
		return candidatesList;
	}

//primeriz function works like the real primeriz
//Documentation in the function relevant parts
	public Candidate[] primeriz(Candidate[] candidatesList) {
		int[] primerizint = new int[candidatesList.length];
		for (int index1 = 0; index1 < candidatesList.length; index1++) {
			if (candidatesList[index1] != null) {
				Random re = new Random();// Random variable - represent the decision of the candidate if to vote
				boolean rese = re.nextBoolean();
				if (rese) {
					for (int index2 = 0; index2 < candidatesList.length; index2++) {
						if (candidatesList[index2] != null) {

							Random r = new Random();// Random variable - represent the vote of the candidate
							boolean res = r.nextBoolean();

							if (res) {
								primerizint[index2]++;
								break;
							}
						}
					}
				}
			}

		}
		return SortprimerizHelp(primerizint, candidatesList);
	}

	// SortprimerizHelp is sorting the candidates list by the primeriz results
	public static Candidate[] SortprimerizHelp(int[] primerizint, Candidate[] candidatesList) {
		int temp;

		for (int i = 0; i < primerizint.length - 1; i++) {
			if (primerizint[i + 1] > primerizint[i]) {
				temp = primerizint[i];
				candidatesList[i] = candidatesList[i + 1];
				candidatesList[i + 1] = candidatesList[temp];

			}
		}
		return candidatesList;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("Party : " + nameOfParty + ", Date of foundation: " + dateOfFoundation
				+ ", Spectrum: " + spectrum + " \n");
		Candidate[] sortedCandList = (Candidate[]) primeriz(candidatesList);
		for (int index = 0; index < sortedCandList.length; index++) {
			if (sortedCandList[index] != null) {
				str.append(sortedCandList[index].toString() + "\n");
			}

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
