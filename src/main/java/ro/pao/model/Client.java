package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SuperBuilder
@Getter
public class Client implements Comparable<Client> {
    private UUID id;

    private String firstName;

    private String lastName;

    private String birthLocation;

    private LocalDate birthDate;

    private List<MailInformation> mailList;

    private List<CardInformation> cardList;

    private List<Ticket> ticketList;

    @Override
    public int compareTo(Client o) {
        return Integer.compare(o.getTicketList().size(), getTicketList().size());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthLocation='" + birthLocation + '\'' +
                ", birthDate=" + birthDate +
                ", mailList=" + mailList +
                ", cardList=" + cardList +
                ", ticketList=" + ticketList +
                '}';
    }
}