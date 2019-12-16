package Homework6.cargo.repo;

import Homework6.cargo.domain.Cargo;

public interface CargoRepo {
    void addCargo(Cargo cargo);

    Cargo getCargoById(long id);

    Cargo[] getCargoesByName(String name);

    void printAllCargoes();

    boolean removeCargoById(long id);
}
