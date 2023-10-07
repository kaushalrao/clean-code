package com.movie.rental;

import java.util.ArrayList;
import java.util.List;

class Rentals {
    private final List<Rental> rentals;

    Rentals() {
        this.rentals = new ArrayList<>();
    }

    public void add(Rental arg) {
        rentals.add(arg);
    }

    public List<Rental> getAll() {
        return rentals;
    }

    public int getTotalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        for (Rental rental : rentals) {
            int frequentRenterPoints = rental.frequentRenterPoints();
            totalFrequentRenterPoints += frequentRenterPoints;
        }
        return totalFrequentRenterPoints;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            double thisAmount = rental.amount();
            totalAmount += thisAmount;
        }
        return totalAmount;
    }
}
