package Homework23_Database.carrier.repo.impl;


import Homework23_Database.cargo.domain.Cargo;
import Homework23_Database.carrier.domain.Carrier;
import Homework23_Database.carrier.repo.CarrierRepo;
import Homework23_Database.storage.IdGenerator;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static Homework23_Database.storage.Storage.cargoCollection;
import static Homework23_Database.storage.Storage.carrierCollection;

public class CarrierCollectionRepoImpl implements CarrierRepo {

    @Override
    public void save(Carrier carrier) {
        carrier.setId(IdGenerator.generateId());
        carrierCollection.add(carrier);
    }

    @Override
    public Optional<Carrier> findById(Long id) {
        for (Carrier carrier : carrierCollection) {
            if (carrier.getId().equals(id)) {
                return Optional.of(carrier);
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<Carrier> getByIdFetchingTransportations(long id) {
        return findById(id);
    }

    @Override
    public Carrier[] findByName(String name) {

        List<Cargo> stream = cargoCollection.stream()
                .filter(carrier -> carrier.getName().equals(name))
                .collect(Collectors.toList());

        return stream.toArray(new Carrier[0]);

    }

    @Override
    public boolean deleteById(Long id) {
        Iterator<Carrier> iter = carrierCollection.iterator();

        boolean removed = false;
        while (iter.hasNext()) {
            if (iter.next().getId().equals(id)) {
                iter.remove();
                removed = true;
                break;
            }
        }

        return removed;
    }

    @Override
    public List<Carrier> getAll() {
        return carrierCollection;
    }

    @Override
    public int countAll() {
        return carrierCollection.size();
    }

    @Override
    public boolean update(Carrier carrier) {
        return true;
    }

}
