package ro.pao.service.impl;

import ro.pao.model.CardInformation;
import ro.pao.model.CulturalEvent;
import ro.pao.model.MailInformation;
import ro.pao.service.CardService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class CardServiceImpl implements CardService {

    private static List<CardInformation> cardInformationList = new ArrayList<>();

    @Override
    public Optional<CardInformation> getById(CardInformation id) {
        return cardInformationList.stream()
                .filter(obj -> id.equals(obj.getCardNumber()))
                .findAny();
    }

    @Override
    public Optional<CardInformation> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public List<CardInformation> getAllFromList() {
        return cardInformationList;
    }

    @Override
    public void addAllFromGivenList(List<CardInformation> cardInformationList) {
        CardServiceImpl.cardInformationList.addAll(cardInformationList);
    }

    @Override
    public void addOnlyOne(CardInformation cardInformation) {
        cardInformationList.add(cardInformation);
    }

    @Override
    public void removeElementById(UUID id) {
        cardInformationList = cardInformationList.stream()
                .filter(element -> !id.equals(element.getCardNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateElementById(UUID id, CardInformation newCardInformation) {
        removeElementById(id);
        addOnlyOne(newCardInformation);
    }

}
