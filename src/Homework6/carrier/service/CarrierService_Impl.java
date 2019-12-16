package Homework6.carrier.service;

import Homework6.carrier.domain.Carrier;
import Homework6.common.utils.ArrayUtils;
import Homework6.storage.IdGenerator;
import Homework6.storage.Storage;

import java.util.Objects;

public class CarrierService_Impl extends Storage implements CarrierService {

    @Override
    public void addCarrier(Carrier carrier) {
    }

    @Override
    public Carrier getCarrierById(long id) {
        return null;
    }

    @Override
    public Carrier[] getCarriersByName(String name) {
        return null;
    }

    @Override
    public void printAllCarriers() {
    }

    @Override
    public boolean removeCarrierById(long id) {
        return false;
    }
}
