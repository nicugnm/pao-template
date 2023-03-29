package ro.pao.service.impl;

import ro.pao.model.CardInformation;
import ro.pao.model.CulturalEvent;
import ro.pao.model.MailInformation;
import ro.pao.service.CardService;

import java.util.*;
import java.util.stream.Collectors;

public class CardServiceImpl implements CardService {

    private static Map<String, CardInformation> cardInformationMap = new HashMap<>();

    @Override
    public Optional<CardInformation> getByCardNumber(String cardNumber) {
        return cardInformationMap.values().stream()
                .filter(element -> cardNumber.equals(element.getCardNumber()))
                .findAny();
    }

    @Override
    public Map<String, CardInformation> getAllFromMap() {
        return cardInformationMap;
    }

    @Override
    public void addAllFromGivenMap(Map<String, CardInformation> cardInformationMap) {
        CardServiceImpl.cardInformationMap.putAll(cardInformationMap);
    }

    @Override
    public void addOnlyOne(CardInformation cardInformation) {
        cardInformationMap.put(cardInformation.getCardNumber(), cardInformation);
    }

    @Override
    public void removeElementById(UUID id) {
        cardInformationMap = cardInformationMap.entrySet().stream()
                .filter(element -> !id.equals(element.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public void updateElementById(UUID id, CardInformation newCardInformation) {
        removeElementById(id);
        addOnlyOne(newCardInformation);
    }

}
