package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SuperBuilder
@Getter
public class Client implements Comparable<Client> {
    private UUID id;

    private String firstName;

    private String lastName;

    private String address;

    private LocalDate birthDate;

    private List<MailInformation> mailList;

    private List<CardInformation> cardList;

    private List<Ticket> ticketList;

    public void buyTickets(Event event, Integer nrRequestedTickets) {

        event.sellTickets(nrRequestedTickets);

        if (nrRequestedTickets <= event.getNrAvailableTickets()) {

            for (Integer i = 0; i < nrRequestedTickets; i++) {
                ticketList.add(Ticket.builder()
                        .id(UUID.randomUUID())
                        .eventId(event.getId())
                        .build());
            }

        }

    }

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
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", mailList=" + mailList +
                ", cardList=" + cardList +
                ", ticketList=" + ticketList +
                '}';
    }

}