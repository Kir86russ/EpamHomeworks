package Homework4.storage;

import Homework4.cargo.Cargo;
import Homework4.carrier.Carrier;
import Homework4.transportation.Transportation;

import java.util.Arrays;

public class Storage {
    private Cargo[] cargoes = new Cargo[]{};
    private Carrier[] carriers = new Carrier[]{};
    private Transportation[] transportations = new Transportation[]{};

    public void showCargoes() {
        System.out.println();
        System.out.println("Cargoes:");
        System.out.println("--------------");
        for (Cargo cargo : cargoes) {
            System.out.println("id: " + cargo.getId());
            System.out.println("name: " + cargo.getName());
            System.out.println("weight: " + cargo.getWeight());
            System.out.println("type: " + cargo.getCargoType());
            System.out.println("transportations: " + Arrays.toString(cargo.getTransportations()));
            System.out.println("--------------");
        }
    }

    public void addCargo(Cargo cargo) {
        Cargo[] new_cargoes = Arrays.copyOf(cargoes, cargoes.length + 1);
        new_cargoes[cargoes.length] = cargo;
        cargoes = new_cargoes;
    }

    public void showCarriers() {
        System.out.println();
        System.out.println("Carriers:");
        System.out.println("--------------");
        for (Carrier carrier : carriers) {
            System.out.println("id: " + carrier.getId());
            System.out.println("name: " + carrier.getName());
            System.out.println("address: " + carrier.getAddress());
            System.out.println("type : " + carrier.getCarrierType());
            System.out.println("transportations: " + Arrays.toString(carrier.getTransportations()));
            System.out.println("--------------");
        }
    }

    public void addCarrier(Carrier carrier) {
        Carrier[] new_carriers = Arrays.copyOf(carriers, carriers.length + 1);
        new_carriers[carriers.length] = carrier;
        carriers = new_carriers;
    }

    public void showTransportations() {
        System.out.println();
        System.out.println("Transportations:");
        System.out.println("--------------");
        for (int i = 0; i < transportations.length; i++) {
            System.out.println("id: " + transportations[i].getId());
            System.out.println("cargo id: " + transportations[i].getCargo().getId());
            System.out.println("carrier id: " + transportations[i].getCarrier().getId());
            System.out.println("description: " + transportations[i].getDescription());
            System.out.println("bill to: " + transportations[i].getBillTo());
            System.out.println("date: " + transportations[i].getDate());
            System.out.println("--------------");
        }
    }

    public void addTransportation(Transportation transportation) {
        Transportation[] new_transportations = Arrays.copyOf(transportations, transportations.length + 1);
        new_transportations[transportations.length] = transportation;
        transportations = new_transportations;
    }
}
