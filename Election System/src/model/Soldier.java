package model;

import java.io.Serializable;
import java.util.Random;

public class Soldier extends Citizen implements Serializable {

	public Soldier(String namePerson, int yearOfBrith, String id, boolean insulation) {
		super(namePerson, yearOfBrith, id, insulation);

	}

	public boolean isCarryWeapon() {
		Random r = new Random();
		return r.nextBoolean();
	}

	@Override
	public String toString() {
		return "Soldier " + super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Soldier))
			return false;
		if (!super.equals(obj))
			return false;
		return true;
	}

}
