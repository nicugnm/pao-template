package ro.pao.service;

import ro.pao.model.CardInformation;
import ro.pao.model.MailInformation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CardService {

    Optional<CardInformation> getById(CardInformation id);

    Optional<CardInformation> getBySomeFieldOfClass(Object someFieldFromExampleClass);

    List<CardInformation> getAllFromList();

    void addAllFromGivenList(List<CardInformation> cardList);

    void addOnlyOne(CardInformation card);

    void removeElementById(UUID id);

    void updateElementById(UUID id, CardInformation newCard);

}
