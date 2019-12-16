package Homework6.transportation.service;

import Homework6.transportation.domain.Transportation;

public interface TransportationService {
    void addTransportation(Transportation cargo);

    Transportation getTransportationById(long id);

    void printAllTransportations();

    boolean removeTransportationById(long id);
}
