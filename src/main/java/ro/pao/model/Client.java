package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SuperBuilder
@Getter
public class Client {
    private UUID id;

    private String firstName;

    private String lastName;

    private String birthLocation;

    private LocalDate birthDate;

    private List<MailInformation> mailList;

    private List<CardInformation> cardList;

    private List<Ticket> ticketList;

}
