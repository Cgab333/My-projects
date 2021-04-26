package p1;

import java.util.Arrays;

public class ArmyBallotBox extends BallotBox {
	
	

	public ArmyBallotBox(String city, String street, int number) {
		super(city, street, number);
	}

	@Override
	public String toString() {
		return "Army " + super.toString() ;
	}

	


}
