package Homework6.cargo.repo;

import Homework6.cargo.domain.Cargo;
import Homework6.common.utils.ArrayUtils;
import Homework6.storage.IdGenerator;
import Homework6.storage.Storage;

import java.util.Arrays;
import java.util.Objects;

public class CargoRepo_Impl extends Storage implements CargoRepo {
    @Override
    public void addCargo(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        Storage.cargos[cargoIndex] = cargo;
        cargoIndex++;

        if (cargoIndex == cargos.length) {
            Cargo[] newCargoes = new Cargo[cargos.length * 2];
            ArrayUtils.copyArray(cargos, newCargoes);
            cargos = newCargoes;
        }
    }

    @Override
    public Cargo getCargoById(long id) {
        for (Cargo cargo : cargos) {
            if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
                return cargo;
            }
        }
        return null;
    }

    @Override
    public Cargo[] getCargoesByName(String name) {
        Cargo[] result = new Cargo[cargos.length];

        int curIndex = 0;
        for (Cargo cargo : cargos) {
            if (cargo != null && Objects.equals(cargo.getName(), name)) {
                result[curIndex++] = cargo;
            }
        }

        Cargo[] resultArray;
        if (curIndex != 0) {
            resultArray = new Cargo[curIndex];
            ArrayUtils.copyArrayWithoutNulls(result, resultArray);
            return resultArray;
        } else
            return null;
    }

    @Override
    public void printAllCargoes() {
        ArrayUtils.printArray(cargos);
    }

    @Override
    public boolean removeCargoById(long id) {
        for (int i = 0; i < cargos.length; i++) {
            if (cargos[i] != null && cargos[i].getId().equals(id)) {
                cargos[i] = null;
                return true;
            }
        }
        return false;
    }
}
