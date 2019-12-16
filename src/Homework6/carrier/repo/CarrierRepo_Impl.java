package Homework6.carrier.repo;

import Homework6.cargo.domain.Cargo;
import Homework6.carrier.domain.Carrier;
import Homework6.common.utils.ArrayUtils;
import Homework6.storage.IdGenerator;
import Homework6.storage.Storage;

import java.util.Objects;

public class CarrierRepo_Impl extends Storage implements CarrierRepo {

    @Override
    public void addCarrier(Carrier carrier) {
        carrier.setId(IdGenerator.generateId());
        carriers[carrierIndex] = carrier;
        carrierIndex++;

        if (carrierIndex == carriers.length) {
            Carrier[] newCarriers = new Carrier[carriers.length * 2];
            ArrayUtils.copyArray(carriers, newCarriers);
            carriers = newCarriers;
        }
    }

    @Override
    public Carrier getCarrierById(long id) {
        for (Carrier carrier : carriers) {
            if (carrier != null && Long.valueOf(id).equals(carrier.getId())) {
                return carrier;
            }
        }

        return null;
    }

    @Override
    public Carrier[] getCarriersByName(String name) {
        Carrier[] result = new Carrier[carriers.length];

        int curIndex = 0;
        for (Carrier carrier : carriers) {
            if (carrier != null && Objects.equals(carrier.getName(), name)) {
                result[curIndex++] = carrier;
            }
        }

        Carrier[] resultArray;
        if (curIndex != 0) {
            resultArray = new Carrier[curIndex];
            ArrayUtils.copyArrayWithoutNulls(result, resultArray);
            return resultArray;
        } else
            return null;
    }

    @Override
    public void printAllCarriers() {
        ArrayUtils.printArray(carriers);
    }

    @Override
    public boolean removeCarrierById(long id) {
        for (int i = 0; i < carriers.length; i++) {
            if (carriers[i] != null && carriers[i].getId().equals(id)) {
                carriers[i] = null;
                return true;
            }
        }
        return false;
    }
}
