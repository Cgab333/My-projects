package id314967472_id207726563;

public class Covid19BallotBox extends BallotBox {
	

	public Covid19BallotBox(String city, String street, int number) {
		super(city, street, number);
	}



	@Override
	public String toString() {
		return "Covid19 " + super.toString() ;
	}

}
