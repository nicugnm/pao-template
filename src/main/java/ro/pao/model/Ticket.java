package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.enums.TicketType;

import java.util.UUID;

@SuperBuilder
@Getter
public class Ticket {

    private UUID id;

    private UUID eventId;

    private String clientId;

    private String price;

    private TicketType ticketType;
}
