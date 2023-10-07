package com.movie.rental;

import java.util.List;

class TextStatement {

    private final String name;
    private final double totalAmount;
    private final int totalFrequentRenterPoints;
    private final List<Rental> rentals;

    public TextStatement(double totalAmount, int totalFrequentRenterPoints, List<Rental> rentals, String name) {
        this.name = name;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
        this.rentals = rentals;
    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        String result = "Rental Record for " + name + "\n";
        return result;
    }

    private String body() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return result;
    }

    private String footer() {
        String result = "";
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoints
                + " frequent renter points";
        return result;
    }
}
