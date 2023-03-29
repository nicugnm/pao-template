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
        return clientMap.values().stream()
                .filter(element -> id.equals(element.getId()))
                .findAny();
    }

    @Override
    public Optional<Client> getByAddress(String address) {
        return clientMap.values().stream()
                .filter(element -> address.equals(element.getAddress()))
                .findAny();
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

}