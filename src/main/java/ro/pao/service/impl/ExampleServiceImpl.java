package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.ExampleClass;
import ro.pao.repository.ExampleRepository;
import ro.pao.repository.impl.ExampleRepositoryImpl;
import ro.pao.service.ExampleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Aici implementam metodele din interfata serviciului definit.
 */
@NoArgsConstructor
@Getter
public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository exampleRepository = new ExampleRepositoryImpl();

    @Override
    public Optional<ExampleClass> getById(UUID id) {
        return exampleRepository.getObjectById(id);
    }

    @Override
    public Optional<ExampleClass> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public List<ExampleClass> getAllFromList() {
        return exampleRepository.getAll();
    }

    @Override
    public void addAllFromGivenList(List<ExampleClass> exampleClassList) {
        exampleRepository.addAllFromGivenList(exampleClassList);
    }

    @Override
    public void addOnlyOne(ExampleClass exampleClass) {
        exampleRepository.addNewObject(exampleClass);
    }

    @Override
    public void removeElementById(UUID id) {
        exampleRepository.deleteObjectById(id);
    }

    @Override
    public void modificaElementById(UUID id, ExampleClass newElement) {
        exampleRepository.updateObjectById(id, newElement);
    }
}
