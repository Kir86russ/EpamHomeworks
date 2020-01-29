package Homework19_Optional.cargo.repo.impl;


import Homework19_Optional.cargo.domain.Cargo;
import Homework19_Optional.cargo.search.CargoSearchCondition;
import Homework19_Optional.common.solutions.utils.CollectionUtils;
import Homework19_Optional.storage.IdGenerator;

import java.util.*;

import static Homework19_Optional.storage.Storage.cargoCollection;

public class CargoCollectionRepoImpl extends CommonCargoRepo {

    @Override
    public Cargo getByIdFetchingTransportations(long id) {
        return findById(id);
    }

    @Override
    public Cargo[] findByName(String name) {
        List<Cargo> result = new ArrayList<>();

        for (Cargo cargo : cargoCollection) {
            if (Optional.ofNullable(cargo)
                    .map(cargoElem -> cargoElem.getName().equals(name)).orElse(false)) {
                result.add(cargo);
            }
        }
        return result.toArray(new Cargo[0]);
    }

    @Override
    public List<Cargo> search(CargoSearchCondition searchCondition) {
        List<Cargo> cargos = getAll();

        if (CollectionUtils.isNotEmpty(cargos)) {
            if (searchCondition.needSorting()) {
                Comparator<Cargo> cargoComparator = createCargoComparator(searchCondition);
                cargos.sort(searchCondition.isAscOrdering() ? cargoComparator : cargoComparator.reversed());
            }
        }

        return cargos;
    }


    @Override
    public Cargo findById(Long id) {
        Cargo result = null;
        for (Cargo cargo : cargoCollection) {
            if (Optional.ofNullable(cargo)
                    .map(cargoElem -> cargoElem.getId().equals(id)).orElse(false)) {
                result = cargo;
            }
        }
        return result;
    }

    @Override
    public void save(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        cargoCollection.add(cargo);
    }

    @Override
    public boolean update(Cargo entity) {
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        Iterator<Cargo> iter = cargoCollection.iterator();

        boolean removed = false;
        while (iter.hasNext()) {
            if (id.equals(iter.next().getId())) {
                iter.remove();
                removed = true;
                break;
            }
        }

        return removed;
    }

    @Override
    public List<Cargo> getAll() {
        return cargoCollection;
    }

    @Override
    public int countAll() {
        return cargoCollection.size();
    }


}
