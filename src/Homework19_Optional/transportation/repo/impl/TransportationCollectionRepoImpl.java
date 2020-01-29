package Homework19_Optional.transportation.repo.impl;


import Homework19_Optional.storage.IdGenerator;
import Homework19_Optional.transportation.domain.Transportation;
import Homework19_Optional.transportation.repo.TransportationRepo;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static Homework19_Optional.storage.Storage.transportationCollection;

public class TransportationCollectionRepoImpl implements TransportationRepo {

    @Override
    public void save(Transportation transportation) {
        transportation.setId(IdGenerator.generateId());
        transportationCollection.add(transportation);
    }

    @Override
    public Transportation findById(Long id) {
        Transportation result = null;
        for (Transportation trans : transportationCollection) {
            if (Optional.ofNullable(trans)
                    .map(transElem -> transElem.getId().equals(id)).orElse(false)) {
                result = trans;
            }
        }
        return result;
    }


    @Override
    public List<Transportation> getAll() {
        return transportationCollection;
    }

    @Override
    public boolean update(Transportation transportation) {
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        boolean deleted = false;

        Iterator<Transportation> iter = transportationCollection.iterator();
        while (iter.hasNext()) {
            if (iter.next().getId().equals(id)) {
                iter.remove();
                deleted = true;
                break;
            }
        }
        return deleted;
    }

    @Override
    public int countAll() {
        return transportationCollection.size();
    }
}
