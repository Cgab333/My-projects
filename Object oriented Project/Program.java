package id314967472_id207726563;

import java.util.Scanner;

import id314967472_id207726563.Party.espectrum;

/*
 * Name:Saar Amikam ID:314967472 HomeWorkNumber:1
 * 
 * Name:Shay Gabison ID:207726563 HomeWorkNumber:1
 *
 * Menu of 9 option representing by switch. every case have a Detailed
 * documentation. Enjoy.
 *
 */
public class Program {

	public static void main(String[] args) {
		// Hard coded
		ElectionsList elections = new ElectionsList();
		Election e1 = new Election(2020, 04);
		elections.addElection(e1);
		elections.GetLastElectionRound().addCitizen("Saar Amikam", 1998, "314967472", false);
		elections.GetLastElectionRound().addCitizen("Shay Gabison", 1996, "207726563", true);
		elections.GetLastElectionRound().addCitizen("Momo", 1980, "333123321", false);
		elections.GetLastElectionRound().addCitizen("Gogo", 1970, "222432234", false);
		elections.GetLastElectionRound().addCitizen("Bobo", 1990, "111123321", false);
		
		elections.GetLastElectionRound().addParty("Likud", ("12.12.1955"), Party.espectrum.RIGHT);
		elections.GetLastElectionRound().addParty("Merez", ("12.01.1995"), Party.espectrum.LEFT);
		elections.GetLastElectionRound().addParty("Yesh Atid", ("12.01.1995"), Party.espectrum.CENTER);

		elections.GetLastElectionRound().addBallotBox("Tel Aviv", "Ahalia", 10, 1);
		elections.GetLastElectionRound().addBallotBox("Tel Hai", "Ahalia", 1330, 1);
		elections.GetLastElectionRound().addBallotBox("Tel Amikam", "Ayerida", 1310, 2);
		elections.GetLastElectionRound().addBallotBox("Tel Mond", "Ayerida", 13310, 3);

		elections.GetLastElectionRound().addCandidate("Joni Bony", 1999, "123543654", false, "Yesh Atid");
		elections.GetLastElectionRound().addCandidate("Bracha Zfira", 1955, "123543651", false, "Merez");
		elections.GetLastElectionRound().addCandidate(" Michal Atar", 2002, "123543654", false, "Likud");
		elections.GetLastElectionRound().addCandidate("Haim Laskov", 1956, "111222005", false, "Yesh Atid");
		elections.GetLastElectionRound().addCandidate("Lee Burshtain", 2002, "222333444", true, "Likud");
		elections.GetLastElectionRound().addCandidate("Rachmim Lo Yada", 1923, "000000015", false, "Merez");
		menuForElection(elections);
	}

	public static void menuForElection(ElectionsList e) {// function represnt the menu for elections.
		boolean runAgain = true;// boolean for the while loop
		boolean el = false;// boolean for knowing to reset the election for re-voting

		while (runAgain) {
			System.out.println("Select an option from the menu below :" + "\n" + "1 - Add Citizen" + "\n"
					+ "2 - Add Ballotbox" + "\n" + "3 - Add Party" + "\n" + "4 - Add Candidate" + "\n"
					+ "5 - View Ballotboxs List" + "\n" + "6 - View Citizens List" + "\n" + "7 - View Parties List"
					+ "\n" + "8 - Election" + "\n" + "9 - View Election Results" + "\n" + "10 - Exit" + "");
			Scanner input = new Scanner(System.in);

			System.out.println("Please enter your number below :  ");

			int selectedMenuNumber = input.nextInt();
			System.out.println();

			switch (selectedMenuNumber) {

			case 1: { // Add Citizen

				input.nextLine();
				System.out.println("Enter name: ");
				String namePerson = input.nextLine();
				System.out.println("Enter Year of birth: ");
				int yearOfBirth = input.nextInt();
				System.out.println("Enter ID: ");
				String id = input.next();
				System.out.println("Is he in insolation? ");
				boolean insulation = input.nextBoolean();
				if (e.GetLastElectionRound().addCitizen(namePerson, yearOfBirth, id, insulation))
					System.out.println("Citizen Added Succsessfully !");

				break;
			}
			case 2: { // Add Ballotbox

				input.nextLine();
				System.out.println("Enter City name: ");
				String cityName = input.nextLine();
				System.out.println("Enter Street name: ");
				String streetName = input.nextLine();
				System.out.println("Enter Number street: ");
				int numberStreet = input.nextInt();
				System.out.println(
						"Please select Ballotbox Opinion: \n" + " 1 - Regular " + " 2 - Covid19" + " 3 - Army");
				int ballotBoxType = input.nextInt();
				while (ballotBoxType != 1 && (ballotBoxType != 2 && ballotBoxType != 3)) {
					System.out.println("Invalid input");
					System.out.println(
							"Please select Ballotbox Opinion: \n" + "1 - Regular " + " 2 - Covid19" + " 3 - Army");

					ballotBoxType = input.nextInt();
				}
				e.GetLastElectionRound().addBallotBox(cityName, streetName, numberStreet, ballotBoxType);
				System.out.println("Ballotbox Added Succsessfully !");
			}

				break;

			case 3: { // Add Party

				input.nextLine();
				System.out.println("Enter Party Name: ");
				String partyName = input.nextLine();
				System.out.println("Enter Date of foundtion (DD.MM.YYYY) : ");
				String date = input.next();
				System.out.println("Please select political Opinion: \n" + " 1 - CENTER" + " 2 - RIGHT" + " 3 - LEFT");
				int politicalOpinion = input.nextInt();
				boolean inCase = false;
				while (!inCase) {
					
					switch (politicalOpinion) {// switch for choosing the political opinion of the party
					case 1: {
						e.GetLastElectionRound().addParty(partyName, date, Party.espectrum.CENTER);
						inCase = true;
						System.out.println("Party Add Succsessfully !");
						break;
					}

					case 2: {
						e.GetLastElectionRound().addParty(partyName, date, Party.espectrum.RIGHT);
						inCase = true;
						System.out.println("Party Add Succsessfully !");
						break;

					}
					case 3: {
						e.GetLastElectionRound().addParty(partyName, date, Party.espectrum.LEFT);
						inCase = true;
						System.out.println("Party Add Succsessfully !");
						break;

					}
					default:
						System.out.println("Invalid input");
						System.out.println(
								"Please select political Opinion: \n" + "1 - CENTER" + "2 - RIGHT" + "3 - LEFT");
						politicalOpinion = input.nextInt();

					}
				}
				break;
			}
			case 4: { // Add Candidate

				input.nextLine();
				System.out.println("Enter A Candidate Name: ");
				String candidateName = input.nextLine();
				System.out.println("Enter Year Of Brith");
				int yearOfBrith = input.nextInt();
				System.out.println("Enter ID: ");
				String id = input.next();
				input.nextLine();
				System.out.println("Is he in isolation? ");
				boolean insulation = input.nextBoolean();
				input.nextLine();
				System.out.println("Enter Party Name: ");
				String partyName = input.nextLine();

				if (e.GetLastElectionRound().addCandidate(candidateName, yearOfBrith, id, insulation, partyName))
					System.out.println("Candidate Added Succsessfully !");

				break;
			}
			case 5: { // View Ballotboxs List
				System.out.println(e.GetLastElectionRound().getBallotBoxListString());

				break;
			}
			case 6: { // View Citizens List
				System.out.println(e.GetLastElectionRound().getVotersListString());

				break;
			}
			case 7: { // View Parties List
				System.out.println(e.GetLastElectionRound().getPartiesListString());

				break;
			}
			case 8: { // Election
				if (!el) {
					e.GetLastElectionRound().electionMethod();
					el = true;
					System.out.println("Election completed -  press 9 for see the results");

				} else { 
					System.out.println("Enter month");
					int month = input.nextInt();
					System.out.println("Enter year");
					int year = input.nextInt();
					Election e1 = new Election(year , month); 
					e.addElection(e1);
					el = false;
					System.out.println("Election was created -  please add: ballboxes,citizens,parties and candidates \n");

				}
				break;

			}
			case 9: { // View Election Results
				System.out.println(e.GetLastElectionRound().electionToString());

				break;
			}
			case 10: { // exit:
				System.out.println("Good bye!");
				runAgain = false;

				break;
			}
			default:
				System.out.println("Invaild input");

			}
		}
	}
}
