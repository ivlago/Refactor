package usantatecla.movies.v27;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {

	private String name;
	
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<Rental>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		Iterator<Rental> rentals = this.rentals.iterator();
		String result = String.format(FinalValues.RENTAL_RECORD, this.getName());
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			result += "\t" + each.getMovieTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		result += String.format(FinalValues.AMOUNT_OWED, String.valueOf(this.getTotalCharge()));
		result += String.format(FinalValues.EARNED_POINTS, String.valueOf(this.getTotalFrequentRenterPoints()));
		return result;
	}

	protected double getTotalCharge() {
		return this.rentals.stream().mapToDouble(Rental::getCharge).sum();
	}
	
	protected int getTotalFrequentRenterPoints() {
		return this.rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
	}

}
