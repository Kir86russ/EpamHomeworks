package Homework13_saxParser.transportation.repo.impl;

import Homework13_saxParser.storage.IdGenerator;
import Homework13_saxParser.transportation.domain.Transportation;
import Homework13_saxParser.transportation.repo.TransportationRepo;

import java.util.Iterator;
import java.util.List;

import static Homework13_saxParser.storage.Storage.transportationCollection;


public class TransportationCollectionRepoImpl implements TransportationRepo {

    @Override
    public void add(Transportation transportation) {
        transportation.setId(IdGenerator.generateId());
        transportationCollection.add(transportation);
    }

    @Override
    public Transportation getById(long id) {
        for (Transportation transportation : transportationCollection) {
            if (Long.valueOf(id).equals(transportation.getId())) {
                return transportation;
            }
        }

        return null;
    }

    @Override
    public Object findById(Object o) {
        return null;
    }

    @Override
    public void save(Object entity) {

    }

    @Override
    public boolean update(Object entity) {
        return false;
    }

    @Override
    public boolean deleteById(Object o) {
        return false;
    }

    @Override
    public List<Transportation> getAll() {
        return transportationCollection;
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public void update(Transportation transportation) {

    }

   // @Override
    public boolean deleteById(long id) {
        boolean deleted = false;

        Iterator<Transportation> iter = transportationCollection.iterator();
        while (iter.hasNext()) {
            if (Long.valueOf(id).equals(iter.next().getId())) {
                iter.remove();
                deleted = true;
                break;
            }
        }
        return deleted;
    }
}