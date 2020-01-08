package Homework13_saxParser.transportation.repo.impl;

import Homework13_saxParser.common.solutions.utils.ArrayUtils;
import Homework13_saxParser.storage.IdGenerator;
import Homework13_saxParser.transportation.domain.Transportation;
import Homework13_saxParser.transportation.repo.TransportationRepo;

import java.util.Arrays;
import java.util.List;

import static Homework13_saxParser.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static Homework13_saxParser.storage.Storage.transportationArray;
import static Homework13_saxParser.storage.Storage.transportationIndex;


public class TransportationArrayRepoImpl implements TransportationRepo {

    @Override
    public void add(Transportation transportation) {
        if (transportationIndex == transportationArray.length) {
            Transportation[] newTransportations =
                    new Transportation[transportationArray.length * 2];
            ArrayUtils.copyArray(transportationArray, newTransportations);
            transportationArray = newTransportations;
        }

        transportation.setId(IdGenerator.generateId());
        transportationArray[transportationIndex] = transportation;
        transportationIndex++;
    }

    @Override
    public Transportation getById(long id) {
        for (Transportation transportation : transportationArray) {
            if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
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
        return Arrays.asList(transportationArray);
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public void update(Transportation transportation) {

    }

    //@Override
    public boolean deleteById(long id) {
        Integer indexToDelete = findEntityIndexInArrayStorageById(transportationArray, id);

        if (indexToDelete == null) {
            return false;
        } else {
            ArrayUtils.removeElement(transportationArray, indexToDelete);
            return true;
        }
    }
}