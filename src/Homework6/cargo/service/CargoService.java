package Homework6.cargo.service;

import Homework6.cargo.domain.Cargo;

public interface CargoService {
    void addCargo(Cargo cargo);

    Cargo getCargoById(long id);

    Cargo[] getCargoesByName(String name);

    void printAllCargoes();

    boolean removeCargoById(long id);
}
