package ro.pao.service;

import ro.pao.model.MailInformation;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface MailService {

    Optional<MailInformation> getById(UUID id);

    Optional<MailInformation> getByLastName(String lastName);

    Map<UUID, MailInformation> getAllFromMap();

    void addAllFromGivenMap(Map<UUID, MailInformation> mailInformationMap);

    void addOnlyOne(MailInformation mailInformation);

    void removeElementById(UUID id);

    void updateElementById(UUID id, MailInformation newMail);

}
