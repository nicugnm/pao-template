package ro.pao.service.impl;

import ro.pao.model.Ticket;
import ro.pao.service.TicketService;

import java.util.*;
import java.util.stream.Collectors;

public class TicketServiceImpl implements TicketService {

    private static Map<UUID, Ticket> ticketMap = new HashMap<>();

    @Override
    public Optional<Ticket> getById(UUID id) {
        return ticketMap.values().stream()
                .filter(element -> id.equals(element.getId()))
                .findAny();
    }

    @Override
    public Optional<Ticket> getByEventId(UUID id) {
        return ticketMap.values().stream()
                .filter(element -> id.equals(element.getEventId()))
                .findAny();
    }

    @Override
    public Map<UUID, Ticket> getAllFromMap() {
        return ticketMap;
    }

    @Override
    public void addAllFromGivenMap(Map<UUID, Ticket> ticketMap) {
        TicketServiceImpl.ticketMap.putAll(ticketMap);
    }

    @Override
    public void addOnlyOne(Ticket ticket) {
        ticketMap.put(ticket.getId(), ticket);
    }

    @Override
    public void removeElementById(UUID id) {
        ticketMap = ticketMap.entrySet().stream()
                .filter(element -> !id.equals(element.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public void updateElementById(UUID id, Ticket newTicket) {
        removeElementById(id);
        addOnlyOne(newTicket);
    }

}
