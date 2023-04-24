package ro.pao.service.impl;

import ro.pao.model.Secretary;
import ro.pao.model.Professor;
import ro.pao.model.Student;
import ro.pao.model.abstracts.Person;
import ro.pao.model.enums.PersonType;
import ro.pao.service.PersonService;

public class PersonServiceImpl implements PersonService {
    Person currentUser;

    PersonType requiredUser;

    @Override
    public void setCurrentUser(PersonType personType) {
        switch (personType) {
            case STUDENT:
                currentUser = new Student();
                break;
            case PROFESSOR:
                currentUser = new Professor();
                break;
            case SECRETARY:
                currentUser = new Secretary();
                break;
        }
    }

    @Override
    public Person getCurrentUser() {
        return currentUser;
    }

    @Override
    public PersonType getCurrentUserType() {
        if (currentUser instanceof Student) {
            return PersonType.STUDENT;
        } else if (currentUser instanceof Professor) {
            return PersonType.PROFESSOR;
        } else {
            return PersonType.SECRETARY;
        }
    }

    @Override
    public void setRequiredUser(PersonType personType) {
        requiredUser = personType;
    }

    @Override
    public PersonType getRequiredUser() {
        return requiredUser;
    }
}
