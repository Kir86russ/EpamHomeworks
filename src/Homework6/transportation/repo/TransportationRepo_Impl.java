package Homework6.transportation.repo;

import Homework6.common.utils.ArrayUtils;
import Homework6.storage.IdGenerator;
import Homework6.storage.Storage;
import Homework6.transportation.domain.Transportation;

public class TransportationRepo_Impl extends Storage implements TransportationRepo {

    @Override
    public void addTransportation(Transportation transportation) {
        transportation.setId(IdGenerator.generateId());
        transportations[transportationIndex] = transportation;
        transportationIndex++;

        if (transportationIndex == transportations.length) {
            Transportation[] newTransportations = new Transportation[transportations.length * 2];
            ArrayUtils.copyArray(transportations, newTransportations);
            transportations = newTransportations;
        }
    }

    @Override
    public Transportation getTransportationById(long id) {
        for (Transportation transportation : transportations) {
            if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
                return transportation;
            }
        }

        return null;
    }

    @Override
    public void printAllTransportations() {
        ArrayUtils.printArray(transportations);
    }

    @Override
    public boolean removeTransportationById(long id) {
        for (int i = 0; i < transportations.length; i++) {
            if (transportations[i] != null && transportations[i].getId().equals(id)) {
                transportations[i] = null;
                return true;
            }
        }
        return false;
    }
}
