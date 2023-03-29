package ro.pao.service;

import ro.pao.model.Client;
import ro.pao.model.Ticket;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface TicketService {

    Optional<Ticket> getById(UUID id);

    Optional<Ticket> getByEventId(UUID id);

    Map<UUID, Ticket> getAllFromMap();

    void addAllFromGivenMap(Map<UUID, Ticket> ticketMap);

    void addOnlyOne(Ticket ticket);

    void removeElementById(UUID id);

    void updateElementById(UUID id, Ticket newTicket);

}
