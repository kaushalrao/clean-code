package com.movie.rental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new TextStatement(getTotalAmount(), getTotalFrequentRenterPoints(), rentals, name).generate();
    }

    public String htmlStatement() {
        return new HtmlStatement(getTotalAmount(), getTotalFrequentRenterPoints(), rentals, name).generate();
    }

    private int getTotalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        for (Rental rental : rentals) {
            int frequentRenterPoints = rental.frequentRenterPoints();
            totalFrequentRenterPoints += frequentRenterPoints;
        }
        return totalFrequentRenterPoints;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            double thisAmount = rental.amount();
            totalAmount += thisAmount;
        }
        return totalAmount;
    }
}
