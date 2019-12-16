package Homework6.carrier.repo;

import Homework6.cargo.domain.Cargo;
import Homework6.carrier.domain.Carrier;

public interface CarrierRepo {
    void addCarrier(Carrier cargo);

    Carrier getCarrierById(long id);

    Carrier[] getCarriersByName(String name);

    void printAllCarriers();

    boolean removeCarrierById(long id);
}
