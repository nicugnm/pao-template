package ro.pao.service.impl;

import ro.pao.model.Location;
import ro.pao.model.Ticket;
import ro.pao.service.TicketService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class TicketServiceImpl implements TicketService {

    private static List<Ticket> ticketList = new ArrayList<>();

    @Override
    public Optional<Ticket> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Ticket> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public List<Ticket> getAllFromList() {
        return ticketList;
    }

    @Override
    public void addAllFromGivenList(List<Ticket> ticketList) {
        TicketServiceImpl.ticketList.addAll(ticketList);
    }

    @Override
    public void addOnlyOne(Ticket ticket) {
        ticketList.add(ticket);
    }

    @Override
    public void removeElementById(UUID id) {
        ticketList = ticketList.stream()
                .filter(element -> !id.equals(element.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateElementById(UUID id, Ticket newTicket) {
        removeElementById(id);
        addOnlyOne(newTicket);
    }

}
