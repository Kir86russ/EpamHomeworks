package Homework6.carrier.service;

import Homework6.carrier.domain.Carrier;

public interface CarrierService {
    void addCarrier(Carrier cargo);

    Carrier getCarrierById(long id);

    Carrier[] getCarriersByName(String name);

    void printAllCarriers();

    boolean removeCarrierById(long id);
}
