package com.movie.rental;

class HtmlStatement {
    private final String name;
    private final Rentals rentals;

    public HtmlStatement(Rentals rentals, String name) {
        this.name = name;
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
        for (Rental rental : rentals.getAll()) {
            body += "<li>" + rental.getMovie().getTitle() + "&nbsp;" + rental.amount() + "</li>";
        }
        body += "</ul>";
        return body;
    }

    private String htmlFooter() {
        return "Amount owed is <b>" + rentals.getTotalAmount() + "</b><br/>" +
                "You earned <b>" + rentals.getTotalFrequentRenterPoints()
                + "</b> frequent renter points";
    }
}
