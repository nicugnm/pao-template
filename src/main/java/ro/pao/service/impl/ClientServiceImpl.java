package ro.pao.service.impl;

import ro.pao.model.Client;
import ro.pao.model.CulturalEvent;
import ro.pao.service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {

    private static List<Client> clientList = new ArrayList<>();

    @Override
    public Optional<Client> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public List<Client> getAllFromList() {
        return clientList;
    }

    @Override
    public void addAllFromGivenList(List<Client> clientList) {
        ClientServiceImpl.clientList.addAll(clientList);
    }

    @Override
    public void addOnlyOne(Client client) {
        clientList.add(client);
    }

    @Override
    public void removeElementById(UUID id) {
        clientList = clientList.stream()
                .filter(element -> !id.equals(element.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateElementById(UUID id, Client newClient) {
        removeElementById(id);
        addOnlyOne(newClient);
    }

}
