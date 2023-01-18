package ru.netology.ticketsearchservice.manager;

import ru.netology.ticketsearchservice.domain.Ticket;
import ru.netology.ticketsearchservice.repository.Repository;

import java.util.Arrays;

public class TicketManager {

    private Repository repo;

    public TicketManager(Repository repo) {
        this.repo = repo;
    }

    public void addTicket(Ticket ticket) {
        repo.addTicket(ticket);
    }

    public boolean matches(Ticket ticket, String firstSearchTerm, String secondSearchTerm) {
        if (ticket.getDepartureAirport().contains(firstSearchTerm) && ticket.getArrivalAirport().contains(secondSearchTerm)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {

                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
