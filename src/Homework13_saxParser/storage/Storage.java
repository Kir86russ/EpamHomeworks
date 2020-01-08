package Homework13_saxParser.storage;

import Homework13_saxParser.cargo.domain.Cargo;
import Homework13_saxParser.carrier.domain.Carrier;
import Homework13_saxParser.transportation.domain.Transportation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {

    private static final int ARRAY_CAPACITY = 10;

    public static Cargo[] cargoArray = new Cargo[ARRAY_CAPACITY];
    public static int cargoIndex = 0;
    public static List<Cargo> cargoCollection = new ArrayList<>();

    public static Carrier[] carrierArray = new Carrier[ARRAY_CAPACITY];
    public static int carrierIndex = 0;
    public static List<Carrier> carrierCollection = new ArrayList<>();

    public static Transportation[] transportationArray = new Transportation[ARRAY_CAPACITY];
    public static int transportationIndex = 0;
    public static List<Transportation> transportationCollection = new ArrayList<>();

    public static Map<String, Cargo> cargoMap = new HashMap<>();
    public static Map<String, Carrier> carrierMap = new HashMap<>();
    public static Map<String, Transportation> transportationMap = new HashMap<>();


}

