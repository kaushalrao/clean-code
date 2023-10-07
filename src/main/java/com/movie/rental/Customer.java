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
        return header() + body() + footer();
    }

    private String footer() {
        String result = "";
        result += "Amount owed is " + getTotalAmount() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints()
                + " frequent renter points";
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

    private String header() {
        String result = "Rental Record for " + name + "\n";
        return result;
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

    public String htmlStatement() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlFooter() {
        return "Amount owed is <b>" + getTotalAmount() + "</b><br/>" +
                "You earned <b>" + getTotalFrequentRenterPoints()
                + "</b> frequent renter points";
    }

    private String htmlBody() {
        String body = "";
        body += "<ul>";
        for (Rental rental : rentals) {
            body +=  "<li>" + rental.getMovie().getTitle() + "&nbsp;" + rental.amount() + "</li>";
        }
        body += "</ul>";
        return body;
    }

    private String htmlHeader() {
        return "<h1>Rental Record for <b>" + name + "</b></h1></br>";
    }
}
