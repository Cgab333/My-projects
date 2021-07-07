package model;

public class PartyExistException extends Exception {
	public PartyExistException() {
		super("Party Already exist.");
	}
}
