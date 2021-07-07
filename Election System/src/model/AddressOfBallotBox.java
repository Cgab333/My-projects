package model;

import java.io.Serializable;

//Helping class for defined the address of a ballotBox
public class AddressOfBallotBox implements Serializable{
	protected String city;
	protected String street;
	protected int number;

	public AddressOfBallotBox(String city, String street, int number) {
		this.city = city;
		this.street = street;
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "AddressOfBallotBox [city=" + city + ", street=" + street + ", number=" + number + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressOfBallotBox other = (AddressOfBallotBox) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (number != other.number)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

}
