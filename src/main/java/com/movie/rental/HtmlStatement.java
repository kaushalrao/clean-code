package com.movie.rental;

import java.util.List;

class HtmlStatement {
    private final String name;
    private final double totalAmount;
    private final int totalFrequentRenterPoints;
    private final List<Rental> rentals;

    public HtmlStatement(double totalAmount, int totalFrequentRenterPoints, List<Rental> rentals,String name) {
        this.name = name;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
        this.rentals = rentals;
    }

    public String generate() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        return "<h1>Rental Record for <b>" + name + "</b></h1></br>";
    }

    private String htmlBody() {
        String body = "";
        body += "<ul>";
        for (Rental rental : rentals) {
            body += "<li>" + rental.getMovie().getTitle() + "&nbsp;" + rental.amount() + "</li>";
        }
        body += "</ul>";
        return body;
    }

    private String htmlFooter() {
        return "Amount owed is <b>" + totalAmount + "</b><br/>" +
                "You earned <b>" + totalFrequentRenterPoints
                + "</b> frequent renter points";
    }
}
