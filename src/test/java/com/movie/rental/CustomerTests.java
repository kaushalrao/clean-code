package com.movie.rental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {
    @Test
    void shouldGenerateStatement() {
        Rentals rentals = new Rentals();
        rentals.add(new Rental(new Movie("Movie-1", Movie.REGULAR), 4));
        rentals.add(new Rental(new Movie("Movie-2", Movie.REGULAR), 1));
        rentals.add(new Rental(new Movie("Movie-3", Movie.CHILDRENS), 5));
        rentals.add(new Rental(new Movie("Movie-4", Movie.CHILDRENS), 2));
        rentals.add(new Rental(new Movie("Movie-5", Movie.NEW_RELEASE), 3));

        Customer customer = new Customer("ABC", rentals);

        assertEquals("Rental Record for ABC\n" +
                "\tMovie-1\t5.0\n" +
                "\tMovie-2\t2.0\n" +
                "\tMovie-3\t4.5\n" +
                "\tMovie-4\t1.5\n" +
                "\tMovie-5\t9.0\n" +
                "Amount owed is 22.0\n" +
                "You earned 6 frequent renter points", customer.statement());
    }

    @Test
    void shouldGenerateHTMLStatement() {
        Rentals rentals = new Rentals();
        rentals.add(new Rental(new Movie("Movie-1", Movie.REGULAR), 4));
        rentals.add(new Rental(new Movie("Movie-2", Movie.REGULAR), 1));
        rentals.add(new Rental(new Movie("Movie-3", Movie.CHILDRENS), 5));
        rentals.add(new Rental(new Movie("Movie-4", Movie.CHILDRENS), 2));
        rentals.add(new Rental(new Movie("Movie-5", Movie.NEW_RELEASE), 3));
        Customer customer = new Customer("ABC", rentals);


        assertEquals("<h1>Rental Record for <b>ABC</b></h1></br><ul><li>Movie-1&nbsp;5.0</li><li>Movie-2&nbsp;2.0</li><li>Movie-3&nbsp;4.5</li><li>Movie-4&nbsp;1.5</li><li>Movie-5&nbsp;9.0</li></ul>Amount owed is <b>22.0</b><br/>You earned <b>6</b> frequent renter points", customer.htmlStatement());
    }
}