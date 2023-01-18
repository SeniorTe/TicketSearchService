package ru.netology.ticketsearchservice.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.ticketsearchservice.domain.Ticket;

public class RepositoryTest {

    Repository repo = new Repository();
    Ticket ticket1 = new Ticket(
            1,
            500,
            "ALA",
            "ARH",
            300
    );
    Ticket ticket2 = new Ticket(
            2,
            500,
            "ATH",
            "BHХ",
            96
    );
    Ticket ticket3 = new Ticket(
            3,
            500,
            "NBC",
            "EGO",
            150
    );
    Ticket ticket4 = new Ticket(
            4,
            500,
            "NBC",
            "EGO",
            130
    );
    Ticket ticket5 = new Ticket(
            5,
            500,
            "NBC",
            "ARH",
            500
    );
    Ticket ticket6 = new Ticket(
            6,
            500,
            "ALA",
            "EGO",
            900
    );
    Ticket ticket7 = new Ticket(
            7,
            500,
            "NBC",
            "EGO",
            90
    );
    Ticket ticket8 = new Ticket(
            8,
            500,
            "GUW",
            "ATH",
            650
    );
    Ticket ticket9 = new Ticket(
            9,
            500,
            "UUA",
            "BHK",
            290
    );
    Ticket ticket10 = new Ticket(
            10,
            500,
            "VHV",
            "VNO",
            460
    );
    Ticket ticket11 = new Ticket(
            11,
            500,
            "GUW",
            "ATH",
            60
    );
    Ticket ticket12 = new Ticket(
            12,
            500,
            "VKT",
            "ATH",
            200
    );

    @Test

    public void shouldAddTickets() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.addTicket(ticket6);
        repo.addTicket(ticket7);
        repo.addTicket(ticket8);
        repo.addTicket(ticket9);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
