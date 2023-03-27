package ro.pao.service;

import ro.pao.model.Client;
import ro.pao.model.Ticket;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TicketService {

    Optional<Ticket> getById(UUID id);

    Optional<Ticket> getBySomeFieldOfClass(Object someFieldFromExampleClass);

    List<Ticket> getAllFromList();

    void addAllFromGivenList(List<Ticket> ticketList);

    void addOnlyOne(Ticket ticket);

    void removeElementById(UUID id);

    void updateElementById(UUID id, Ticket newTicket);

}
