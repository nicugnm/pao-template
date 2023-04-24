package ro.pao.service;

import ro.pao.model.abstracts.Person;
import ro.pao.model.enums.PersonType;

public interface PersonService {
    void setCurrentUser(PersonType personType);
    Person getCurrentUser();

    PersonType getCurrentUserType();

    void setRequiredUser(PersonType personType);

    PersonType getRequiredUser();
}
