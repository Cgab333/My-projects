package model;

public class under18Exception extends Exception {

	public under18Exception(String s) {
		super(s + "Citizen Must be over 18 for voting!");
	}

}
