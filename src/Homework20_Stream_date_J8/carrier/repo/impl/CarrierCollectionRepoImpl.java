package Homework20_Stream_date_J8.carrier.repo.impl;


import Homework20_Stream_date_J8.cargo.domain.Cargo;
import Homework20_Stream_date_J8.carrier.domain.Carrier;
import Homework20_Stream_date_J8.carrier.repo.CarrierRepo;
import Homework20_Stream_date_J8.storage.IdGenerator;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static Homework20_Stream_date_J8.storage.Storage.cargoCollection;
import static Homework20_Stream_date_J8.storage.Storage.carrierCollection;

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
