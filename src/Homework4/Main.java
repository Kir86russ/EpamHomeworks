package Homework4;

import Homework4.cargo.Cargo;
import Homework4.cargo.CargoType;
import Homework4.carrier.Carrier;
import Homework4.carrier.CarrierType;
import Homework4.storage.Storage;
import Homework4.transportation.Transportation;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();
        Cargo cargo1 = new Cargo();
        Cargo cargo2 = new Cargo();
        Cargo cargo3 = new Cargo();
        Carrier carrier1 = new Carrier();
        Carrier carrier2 = new Carrier();
        Carrier carrier3 = new Carrier();
        Transportation transportation1 = new Transportation();
        Transportation transportation2 = new Transportation();
        Transportation transportation3 = new Transportation();

        cargo1.setId(1L);
        cargo1.setCargoType(CargoType.FOOD);
        cargo1.setName("meat");
        cargo1.setWeight(10);
        cargo1.setTransportations(new Transportation[]{transportation1});

        cargo2.setId(2L);
        cargo2.setCargoType(CargoType.CLOTHES);
        cargo2.setName("jeans");
        cargo2.setWeight(1);
        cargo2.setTransportations(new Transportation[]{transportation2});

        cargo3.setId(3L);
        cargo3.setCargoType(CargoType.FOOD);
        cargo3.setName("fish");
        cargo3.setWeight(5);
        cargo3.setTransportations(new Transportation[]{transportation3});

        carrier1.setAddress("Medikoff");
        carrier1.setCarrierType(CarrierType.CAR);
        carrier1.setId(1L);
        carrier1.setName("deliv");
        carrier1.setTransportations(new Transportation[]{transportation1});

        carrier2.setAddress("Uralskaya");
        carrier2.setCarrierType(CarrierType.PLANE);
        carrier2.setId(2L);
        carrier2.setName("deliv2");
        carrier2.setTransportations(new Transportation[]{transportation2});

        carrier3.setAddress("Nevskii");
        carrier3.setCarrierType(CarrierType.SHIP);
        carrier3.setId(3L);
        carrier3.setName("deliv3");
        carrier3.setTransportations(new Transportation[]{transportation3});

        transportation1.setCargo(cargo1);
        transportation1.setCarrier(carrier1);
        transportation1.setDescription("safe delivery");
        transportation1.setBillTo("Smirnoff");
        transportation1.setId(1L);
        transportation1.setDate(new Date(2019, Calendar.NOVEMBER, 10));

        transportation2.setCargo(cargo2);
        transportation2.setCarrier(carrier2);
        transportation2.setDescription("nice delivery");
        transportation2.setBillTo("Petr 1");
        transportation2.setId(2L);
        transportation2.setDate(new Date(2012, Calendar.NOVEMBER, 10));

        transportation3.setCargo(cargo3);
        transportation3.setCarrier(carrier3);
        transportation3.setDescription("bad delivery");
        transportation3.setBillTo("Putin");
        transportation3.setId(3L);
        transportation3.setDate(new Date(2013, Calendar.NOVEMBER, 10));

        storage.addCargo(cargo1);
        storage.addCargo(cargo2);
        storage.addCargo(cargo3);

        storage.addCarrier(carrier1);
        storage.addCarrier(carrier2);
        storage.addCarrier(carrier3);

        storage.addTransportation(transportation1);
        storage.addTransportation(transportation2);
        storage.addTransportation(transportation3);

        storage.showCargoes();
        storage.showCarriers();
        storage.showTransportations();
    }
}
