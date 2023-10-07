package com.movie.rental;

class TextStatement {

    private final String name;

    private final Rentals rentals;

    public TextStatement(Rentals rentals, String name) {
        this.name = name;
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
        for (Rental rental : rentals.getAll()) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return result;
    }

    private String footer() {
        String result = "";
        result += "Amount owed is " + rentals.getTotalAmount() + "\n";
        result += "You earned " + rentals.getTotalFrequentRenterPoints()
                + " frequent renter points";
        return result;
    }
}
