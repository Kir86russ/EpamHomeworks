package Homework6.cargo.service;

import Homework6.cargo.domain.Cargo;
import Homework6.common.utils.ArrayUtils;
import Homework6.storage.IdGenerator;
import Homework6.storage.Storage;

import java.util.Objects;

public class CargoService_Impl extends Storage implements CargoService {
    @Override
    public void addCargo(Cargo cargo) {
    }

    @Override
    public Cargo getCargoById(long id) {
        return null;
    }

    @Override
    public Cargo[] getCargoesByName(String name) {
        return null;
    }

    @Override
    public void printAllCargoes() {
    }

    @Override
    public boolean removeCargoById(long id) {
        return false;
    }
}
