package ru.netology.ticketsearchservice.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.ticketsearchservice.domain.Ticket;
import ru.netology.ticketsearchservice.repository.Repository;

public class ManagerTest {
    Repository repo = new Repository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(
            1,
            10_500,
            "ALA",
            "ARH",
            300
    );
    Ticket ticket2 = new Ticket(
            2,
            12_000,
            "ATH",
            "BHХ",
            96
    );
    Ticket ticket3 = new Ticket(
            3,
            35_000,
            "NBC",
            "EGO",
            90
    );
    Ticket ticket4 = new Ticket(
            4,
            20_000,
            "NBC",
            "EGO",
            130
    );
    Ticket ticket5 = new Ticket(
            5,
            10_000,
            "NBC",
            "ARH",
            500
    );
    Ticket ticket6 = new Ticket(
            6,
            3_000,
            "ALA",
            "EGO",
            900
    );
    Ticket ticket7 = new Ticket(
            7,
            11_000,
            "NBC",
            "EGO",
            150
    );
    Ticket ticket8 = new Ticket(
            8,
            69_000,
            "GUW",
            "ATH",
            65
    );
    Ticket ticket9 = new Ticket(
            9,
            15_600,
            "NBC",
            "ARH",
            260
    );
    Ticket ticket10 = new Ticket(
            10,
            41_000,
            "VHV",
            "VNO",
            460
    );
    Ticket ticket11 = new Ticket(
            11,
            68_999,
            "GUW",
            "ATH",
            800
    );
    Ticket ticket12 = new Ticket(
            12,
            28_000,
            "NBC",
            "ARH",
            200
    );

    @BeforeEach
    public void setup() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);
        manager.addTicket(ticket9);
        manager.addTicket(ticket10);
        manager.addTicket(ticket11);
        manager.addTicket(ticket12);
    }

    @Test

    public void shouldSearchByFromToWhenOneTicket() {

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.findAllByPrice("ALA", "EGO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchByFromToWhenMultipleTicket() {

        Ticket[] expected = {ticket7, ticket4, ticket3};
        Ticket[] actual = manager.findAllByPrice("NBC", "EGO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchByFromToWhenTwoTicket() {

        Ticket[] expected = {ticket11, ticket8};
        Ticket[] actual = manager.findAllByPrice("GUW", "ATH");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchByFromToWhenMultipleTicketComparator() {

        Ticket[] expected = {ticket12, ticket9, ticket5};
        Ticket[] actual = manager.findAll("NBC", "ARH");

        Assertions.assertArrayEquals(expected, actual);
    }

}
