package ro.pao.service;

import ro.pao.model.Client;
import ro.pao.model.MailInformation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {

    Optional<Client> getById(UUID id);

    Optional<Client> getBySomeFieldOfClass(Object someFieldFromExampleClass);

    List<Client> getAllFromList();

    void addAllFromGivenList(List<Client> clientList);

    void addOnlyOne(Client client);

    void removeElementById(UUID id);

    void updateElementById(UUID id, Client newClient);

}
