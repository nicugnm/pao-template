package ro.pao.service.impl;

import ro.pao.model.CardInformation;
import ro.pao.model.MailInformation;
import ro.pao.service.MailService;

import java.util.*;
import java.util.stream.Collectors;

public class MailServiceImpl implements MailService {

    private static Map<UUID, MailInformation> mailInformationMap = new HashMap<>();

    @Override
    public Optional<MailInformation> getById(UUID id) {
        return mailInformationMap.values().stream()
                .filter(element -> id.equals(element.getId()))
                .findAny();
    }

    @Override
    public Optional<MailInformation> getByName(String lastName, String firstName) {
        return mailInformationMap.values().stream()
                .filter(element -> lastName.equals(element.getLastName()))
                .filter(element -> firstName.equals(element.getFirstName()))
                .findAny();
    }

    @Override
    public Map<UUID, MailInformation> getAllFromMap() {
        return mailInformationMap;
    }

    @Override
    public void addAllFromGivenMap(Map<UUID, MailInformation> mailInformationMap) {
        MailServiceImpl.mailInformationMap.putAll(mailInformationMap);
    }

    @Override
    public void addOnlyOne(MailInformation mailInformation) {
        mailInformationMap.put(mailInformation.getId(), mailInformation);
    }

    @Override
    public void removeElementById(UUID id) {
        mailInformationMap = mailInformationMap.entrySet().stream()
                .filter(element -> !id.equals(element.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public void updateElementById(UUID id, MailInformation newMailInformation) {
        removeElementById(id);
        addOnlyOne(newMailInformation);
    }

}
