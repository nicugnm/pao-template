package ro.pao.service;

import ro.pao.model.Client;
import ro.pao.model.MailInformation;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {

    Optional<Client> getById(UUID id);

    Optional<Client> getBySomeFieldOfClass(Object someFieldFromExampleClass);

    Map<UUID, Client> getAllFromMap();

    void addAllFromGivenMap(Map<UUID, Client> clientMap);

    void addOnlyOne(Client client);

    void removeElementById(UUID id);

    void updateElementById(UUID id, Client newClient);

}
