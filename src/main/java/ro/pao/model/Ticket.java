package ro.pao.model;

import ro.pao.model.enums.TicketType;

import java.util.UUID;

public class Ticket {

    private UUID ticketId;

    private UUID eventId;

    private String clientId;

    private String price;

    private TicketType ticketType;
}
