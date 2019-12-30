package Homework12_exampleOfParsingXML.cargo.service;

import Homework12_exampleOfParsingXML.cargo.domain.Cargo;
import Homework12_exampleOfParsingXML.cargo.exception.CargoDeleteConstraintViolationException;
import Homework12_exampleOfParsingXML.cargo.repo.CargoRepo;
import Homework12_exampleOfParsingXML.cargo.search.CargoSearchCondition;
import Homework12_exampleOfParsingXML.transportation.domain.Transportation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CargoServiceImpl implements CargoService {

    private CargoRepo cargoRepo;

    public CargoServiceImpl(CargoRepo cargoRepo) {
        this.cargoRepo = cargoRepo;
    }


    @Override
    public void add(Cargo cargo) {
    }

    @Override
    public Cargo getById(Long id) {
        return null;
    }

    @Override
    public Cargo getByIdFetchingTransportations(Long id) {
        if (id != null) {
            return cargoRepo.getByIdFetchingTransportations(id);
        }
        return null;
    }

    @Override
    public List<Cargo> getAll() {
        return cargoRepo.getAll();
    }

    @Override
    public List<Cargo> findByName(String name) {
        Cargo[] found = cargoRepo.findByName(name);
        return (found == null || found.length == 0) ? Collections.emptyList() : Arrays.asList(found);
    }

    @Override
    public boolean deleteById(Long id) {
        Cargo cargo = this.getByIdFetchingTransportations(id);

        if (cargo != null) {
            List<List<Transportation>> transportations = Arrays.asList(cargo.getTransportations());
            boolean hasTransportations = transportations != null && transportations.size() > 0;
            if (hasTransportations) {
                throw new CargoDeleteConstraintViolationException(id);
            }

            return cargoRepo.deleteById(id);
        } else {
            return false;
        }
    }

    @Override
    public void printAll() {
        List<Cargo> allCargos = cargoRepo.getAll();

        for (Cargo cargo : allCargos) {
            System.out.println(cargo);
        }
    }

    @Override
    public void update(Cargo cargo) {
        if (cargo != null) {
            cargoRepo.update(cargo);
        }
    }

    @Override
    public List<Cargo> search(CargoSearchCondition cargoSearchCondition) {
        return cargoRepo.search(cargoSearchCondition);
    }
}