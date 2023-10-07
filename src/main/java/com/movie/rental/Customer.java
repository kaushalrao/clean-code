package com.movie.rental;

public class Customer {
    private final String name;
    private final Rentals rentals;
    public Customer(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new TextStatement(rentals, name).generate();
    }

    public String htmlStatement() {
        return new HtmlStatement(rentals, name).generate();
    }
}
