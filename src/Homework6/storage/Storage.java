package Homework6.storage;

import Homework6.cargo.domain.Cargo;
import Homework6.carrier.domain.Carrier;
import Homework6.transportation.domain.Transportation;

public class Storage {

    private static final int ARRAY_CAPACITY = 10;

    protected static Cargo[] cargos = new Cargo[ARRAY_CAPACITY];
    protected int cargoIndex = 0;

    protected static Carrier[] carriers = new Carrier[ARRAY_CAPACITY];
    protected static int carrierIndex = 0;

    protected static Transportation[] transportations = new Transportation[ARRAY_CAPACITY];
    protected static int transportationIndex = 0;

}