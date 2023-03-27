package ro.pao.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Client {
    private UUID clientId;

    private String firstName;

    private String lastName;

    private String birthLocation;

    private LocalDateTime birthInformation;

    private List<MailInformation> mailList;

    private List<CardInformation> cardList;

    private List<Ticket> ticketList;

}
