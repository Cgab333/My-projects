package p1;

public class ElectionsList{
	private Election[] ElectionsList;
	private int indexElections = 0;
	private int maxElections = 5;// first value - by Arrays.copyof its endless
	
	
	public ElectionsList() {
		ElectionsList =new Election[maxElections];
	}
	
	public void addElection(Election Election1) {
		ElectionsList[indexElections++] = Election1;

		
	}
	
	public Election GetLastElectionRound() {
		return ElectionsList[indexElections-1];
	}
	
	public String getlastElection() {
		return ElectionsList[indexElections].toString();

		
	}
	








}
