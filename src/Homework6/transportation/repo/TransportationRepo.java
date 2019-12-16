package Homework6.transportation.repo;

import Homework6.transportation.domain.Transportation;

public interface TransportationRepo {
    void addTransportation(Transportation cargo);

    Transportation getTransportationById(long id);

    void printAllTransportations();

    boolean removeTransportationById(long id);
}
