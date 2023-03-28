package ro.pao.service.impl;

import ro.pao.model.Client;
import ro.pao.model.CulturalEvent;
import ro.pao.model.CulturalLocation;
import ro.pao.service.ClientService;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {

    private static Map<UUID, Client> clientMap = new HashMap<>();

    @Override
    public Optional<Client> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public Map<UUID, Client> getAllFromMap() {
        return clientMap;
    }

    @Override
    public void addAllFromGivenMap(Map<UUID, Client> clientMap) {
        ClientServiceImpl.clientMap.putAll(clientMap);
    }

    @Override
    public void addOnlyOne(Client client) {
        clientMap.put(client.getId(), client);
    }

    @Override
    public void removeElementById(UUID id) {
        clientMap = clientMap.entrySet().stream()
                .filter(element -> !id.equals(element.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public void updateElementById(UUID id, Client newClient) {
        removeElementById(id);
        addOnlyOne(newClient);
    }

    public Map<UUID, Client> sortByTickets() {

        Map<UUID, Client> clientSortedMap = new LinkedHashMap<>();
        List<Client> clientSortedList = new ArrayList<>();

        for (Map.Entry<UUID, Client> entry : getAllFromMap().entrySet()) {
            clientSortedList.add(entry.getValue());
        }

        Collections.sort(clientSortedList);

        for (Client client : clientSortedList) {
            for (Map.Entry<UUID, Client> entry : getAllFromMap().entrySet()) {
                if (entry.getValue().equals(client)) {
                    clientSortedMap.put(entry.getKey(), client);
                }
            }
        }

        return clientSortedMap;

    }

}
